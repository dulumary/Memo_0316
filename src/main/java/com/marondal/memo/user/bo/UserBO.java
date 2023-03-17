package com.marondal.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.memo.common.EncryptService;
import com.marondal.memo.user.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int addUser(
			String loginId
			, String password
			, String name
			, String email) {
		
		String ecryptPassword = EncryptService.md5(password);
		
		return userDAO.insertUser(loginId, ecryptPassword, name, email);
		
	}

}
