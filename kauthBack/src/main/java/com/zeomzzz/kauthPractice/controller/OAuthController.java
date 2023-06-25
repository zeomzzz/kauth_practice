package com.zeomzzz.kauthPractice.controller;

import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

import com.zeomzzz.kauthPractice.model.dto.User;

import com.zeomzzz.kauthPractice.model.service.OAuthService;
import com.zeomzzz.kauthPractice.util.JWTUtil;

@RestController
//@AllArgsConstructor
@RequestMapping("/oauth")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class OAuthController {
	
	static String sessionId = "";
	
	@Autowired
	HttpSession httpsession;

	@Autowired
	OAuthService oauthService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@ResponseBody
	@GetMapping("/authorize")
	public RedirectView toKakaoLogin() {
		
		RedirectView redirectView = new RedirectView();
		
		String clientId = "56ee308c9dcd70214759634d00cf825a";
		String redirectUri = "http://localhost:8080/oauth/kakao";
		
		StringBuilder url = new StringBuilder();
		url.append("https://kauth.kakao.com/oauth/authorize");
		url.append("?client_id=" + clientId);
		url.append("&redirect_uri=" + redirectUri);
		url.append("&response_type=code");
		
		String redirectUrl = url.toString();
		
		redirectView.setUrl(redirectUrl);
		
		return redirectView;
	}
	
	
    /**
     * Redirect URI로 인가 코드를 전달받음
     * @throws Exception 
     */
    @ResponseBody
    @GetMapping("/kakao")
    public void kakaoCallback(String code) throws Exception {
    	
        System.out.println(code); // 인가 코드
        getToken(code);

    }
    
//    @ResponseBody
//    @PostMapping("/token")
    public void getToken(String code) throws UnsupportedEncodingException {
    	System.out.println("여기오나");
    	String token = oauthService.getKakaoAccessToken(code);
    	doKakaoLogin(token);
    }
    
    public void doKakaoLogin(String token) throws UnsupportedEncodingException {
    
    	try {
    		User kakaoUser = oauthService.createKakaoUser(token);
    	      String kakaoId = kakaoUser.getKakaoId();
    	      String kakaoNickname = kakaoUser.getKakaoNickname();
    	      
    	      System.out.println("kakaoId = " + kakaoId);
    	      
    	      User loginUser = oauthService.checkRegist(kakaoId); // 회원인지 확인
    	      String loginNickname = loginUser.getKakaoNickname();
    	      System.out.println("kakaoNickname = " + kakaoNickname);
    	      
    	      /* 로그인 */
    	      // 회원이 아니면 회원가입 후 로그인
    	      if(loginNickname.length() == 0) {
    	      	User newUser = new User();
    	      	newUser.setKakaoId(kakaoId);
    	      	newUser.setKakaoNickname(kakaoNickname);
    	      	oauthService.doRegist(newUser);
    	      	loginUser = newUser;
    	      }
    	      
    	      // jwt 토큰 만들어서 세션에 넣기        
    	      httpsession.setAttribute("kakaoNickname", loginUser.getKakaoNickname());
    	      httpsession.setAttribute("kakaoId", loginUser.getKakaoId());
    	      httpsession.setAttribute("jwt-token", jwtUtil.createToken("kakaoId", loginUser.getKakaoId()));

    	      System.out.println("여기세션값");
    	      System.out.println((String) httpsession.getAttribute("kakaoNickname"));
    	      
    	      System.out.println("여기오나??");
    	      
    	      System.out.println(httpsession.getId());
    	      sessionId = httpsession.getId();
    	      
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    @ResponseBody
    @GetMapping("/getknick")
    public ResponseEntity<?> getKakaoNickname() {
    	
//    	System.out.println(httpsession.)
//    	httpsession.
    	
    	System.out.println((String) httpsession.getAttribute("kakaoNickname"));
    	
    	Map<String, String> res = new HashMap<>();
    	res.put("kakaoNickname", (String) httpsession.getAttribute("kakaoNickname"));
    	
    	System.out.println(res);
    	
    	System.out.println(httpsession.getId());
    	
    	return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    
}