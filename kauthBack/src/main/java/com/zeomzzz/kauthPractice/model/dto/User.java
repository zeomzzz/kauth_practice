package com.zeomzzz.kauthPractice.model.dto;

public class User {

	private int nId = 0;
	private String kakaoId;
	private String kakaoNickname;
	
	public User() {}
	
	public User(int nId, String kakaoId, String kakaoNickname) {
		super();
		this.nId = nId;
		this.kakaoId = kakaoId;
		this.kakaoNickname = kakaoNickname;
	}
	
	public int getNId() {
		return nId;
	}
	
	public void setNId(int nId) {
		this.nId = nId;
	}

	public String getKakaoId() {
		return kakaoId;
	}

	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}

	public String getKakaoNickname() {
		return kakaoNickname;
	}

	public void setKakaoNickname(String kakaoNickname) {
		this.kakaoNickname = kakaoNickname;
	}

}