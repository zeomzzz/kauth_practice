package com.zeomzzz.kauthPractice.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zeomzzz.kauthPractice.model.dto.User;

public interface UserDao {
	
	int insert(User user);
	
	int delete(int userNumId);

	User selectLoginUser(@Param("userLoginId") String userLoginId, @Param("userPw") String userPw);

	User selectByLoginId(String userLoginId);

	User selectByNickname(String userNickname);

	int updateCalendarStatus(@Param("userNumId") int userNumId, @Param("userIsPublic") int userIsPublic);

	User selectUser(@Param("userNumId") int userNumId, @Param("userPw") String userPw);

	List<User> selectUsers(String word);

	int updateUserInfo(User user);
	
	int updateWeight(@Param("userNumId") int userNumId, @Param("userWeight") int userWeight);

	User selectUserPw(String userLoginId);
}
