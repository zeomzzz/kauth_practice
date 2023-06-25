package com.zeomzzz.kauthPractice.model.service;

import com.google.gson.JsonParser;
import com.zeomzzz.kauthPractice.model.dao.OAuthDao;
import com.zeomzzz.kauthPractice.model.dto.User;
import com.google.gson.JsonElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class OAuthService{
	
	@Autowired
	OAuthDao oauthDao;

	//Access Token 받아오기
    public String getKakaoAccessToken (String code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {

			/* 1. Connection 생성 */
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 setDoOutput을 true (기본값 false)
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

			/* 2. POST를 보낼 Body 생성 */
            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=56ee308c9dcd70214759634d00cf825a"); // REST_API_KEY 입력
            sb.append("&redirect_uri=http://localhost:8080/oauth/kakao"); // 인가코드 받은 redirect_uri 입력
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공 -> 200 확인하는 코드? 에러 없으면 진행. 있으면 catch
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

			/* 3. 받아온 결과 JSON 파싱 */
            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_Token;
    }
    
    // access token 이용하여 사용자 정보 받아오기
    public User createKakaoUser(String token) {

    	String reqURL = "https://kapi.kakao.com/v2/user/me";
    	String id = "";
    	String nickname = "";
    	User kakaoUser = new User();

        try {

        	/* 1. Connection 생성 */
           URL url = new URL(reqURL);
           HttpURLConnection conn = (HttpURLConnection) url.openConnection();

           conn.setRequestMethod("POST");
           conn.setDoOutput(true);
           conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, access_token전송

           //결과 코드가 200이라면 성공(에러는 catch로 ..)
           int responseCode = conn.getResponseCode();
           System.out.println("responseCode : " + responseCode);

           //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
           BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           String line = "";
           String result = "";

           while ((line = br.readLine()) != null) {
               result += line;
           }
           System.out.println("response body : " + result);

           /* 2. 받아온 결과 JSON 파싱 */
           //Gson 라이브러리로 JSON파싱
           JsonParser parser = new JsonParser();
           JsonElement element = parser.parse(result);
           
           System.out.println("element : " + element);

           id = element.getAsJsonObject().get("id").getAsString(); // string으로 받기 위해서 수정
           nickname = element.getAsJsonObject().get("properties").getAsJsonObject().get("nickname").getAsString();
           
           // email은 안받는거로 체크해서 주석 처리
//           boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
//           String email = "";
//           if(hasEmail){
//               email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
//           }

//           System.out.println("email : " + email);
           kakaoUser.setKakaoId(id);
           kakaoUser.setKakaoNickname(nickname);
           
           br.close();

           } catch (IOException e) {
                e.printStackTrace();
           }
        
        return kakaoUser;
     }
    
    /* 카카오 아이디로 회원가입 했는지 체크 */
    public User checkRegist(String kakaoId) {
    	
    	User loginUser = new User();
    	
    	try {
    		loginUser = oauthDao.selectById(kakaoId);
    		if(loginUser == null) {
    			loginUser = new User();
    			loginUser.setKakaoId(kakaoId);
    			loginUser.setKakaoNickname("");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return loginUser;
    }
    
    /* 회원가입 */
    public int doRegist(User user) {
    	return oauthDao.insert(user);
    }
    
}