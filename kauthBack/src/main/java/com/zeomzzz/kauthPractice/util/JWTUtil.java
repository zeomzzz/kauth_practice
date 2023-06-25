package com.zeomzzz.kauthPractice.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	private static final String SALT = "zeomzzz";

	// 토큰 생성
	// 인자로 키와 밸류가 넘어왔다라고만 처리 (지금은 한가지 정보만 넣는다고 가정)
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder()
				/* 헤더  */
				.setHeaderParam("alg", "HS256") // 알고리즘 종류
				.setHeaderParam("typ", "JWT")
				/* payload(내용) */
				// 정보가 여러개 되면 이 바구니를 여러개 만들어야 함
				.claim(claimId, data).setExpiration(new Date(System.currentTimeMillis() + 1800000)) // 유효시간 30분
				/* signature(디지털서명) */
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명 완료
				.compact();
	}

	// 유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey("zeomzzz".getBytes("UTF-8")).parseClaimsJws(token);
	}
}