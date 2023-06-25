package com.zeomzzz.kauthPractice.model.dao;


import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zeomzzz.kauthPractice.model.dto.User;

public interface OAuthDao {
	
	User selectById(String kakaoId);

	int insert(User user);
	
}
