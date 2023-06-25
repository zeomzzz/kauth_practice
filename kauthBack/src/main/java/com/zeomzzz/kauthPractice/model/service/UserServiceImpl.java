package com.zeomzzz.kauthPractice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeomzzz.kauthPractice.model.dao.UserDao;
import com.zeomzzz.kauthPractice.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public int signup(User user) {
		return userDao.insert(user);
	}

	@Override
	public int signout(int userNumId) {
		return userDao.delete(userNumId);
	}

	@Override
	public User login(String userLoginId, String userPw) {
		return userDao.selectLoginUser(userLoginId, userPw);
	}

	@Override
	public User searchByLoginId(String userLoginId) {
		return userDao.selectByLoginId(userLoginId);
	}

	@Override
	public User searchByNickname(String userNickname) {
		return userDao.selectByNickname(userNickname);
	}

	@Override
	public int setCalendarStatus(int userNumId, int userIsPublic) {
		return userDao.updateCalendarStatus(userNumId, userIsPublic);
	}

	@Override
	public User identifyUser(int userNumId, String userPw) {
		return userDao.selectUser(userNumId, userPw);
	}

	@Override
	public List<User> searchUser(String word) {
		return userDao.selectUsers(word);
	}

	@Override
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}

	@Override
	public User findUser(String userLoginId) {
		return userDao.selectUserPw(userLoginId);
	}
}
