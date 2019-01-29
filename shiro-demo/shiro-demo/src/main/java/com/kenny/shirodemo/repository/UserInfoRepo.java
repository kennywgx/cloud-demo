package com.kenny.shirodemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kenny.shirodemo.entity.UserInfo;

@Repository
public interface UserInfoRepo extends BaseRepo<UserInfo> {

	@Query("from UserInfo")
	public List<UserInfo> list();
	
	public UserInfo getByUsername(String username);
}
