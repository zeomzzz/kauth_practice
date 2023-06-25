package com.zeomzzz.kauthPractice.model.service;

import java.util.List;

import com.zeomzzz.kauthPractice.model.dto.User;

public interface UserService {
	// 메서드명 사용자 친화적으로 ..!
	int signup(User user);

	int signout(int userNumId);
	
	User login(String userLoginId, String userPw);

	User searchByLoginId(String userLoginId);

	User searchByNickname(String userNickname);

	int setCalendarStatus(int userNumId, int userIsPublic);

	User identifyUser(int userNumId, String userPw);

	List<User> searchUser(String word);

	int updateUserInfo(User user);

	User findUser(String userLoginId);
}
