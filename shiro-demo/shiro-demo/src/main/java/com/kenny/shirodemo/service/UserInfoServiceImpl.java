package com.kenny.shirodemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenny.shirodemo.entity.UserInfo;
import com.kenny.shirodemo.repository.BaseRepo;
import com.kenny.shirodemo.repository.UserInfoRepo;

@Service
public class UserInfoServiceImpl extends BaseService<UserInfo> {

	@Autowired
	private UserInfoRepo repo;
	
	@Override
	public BaseRepo<UserInfo> getRepo() {
		return repo;
	}
	
	public List<UserInfo> list() {
		return repo.list();
	}
	
	public UserInfo getByUsername(String username) {
		return repo.getByUsername(username);
	}

}
