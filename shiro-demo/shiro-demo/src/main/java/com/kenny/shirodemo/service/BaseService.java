package com.kenny.shirodemo.service;

import java.util.List;

import com.kenny.shirodemo.repository.BaseRepo;

public abstract class BaseService<T> {

	public abstract BaseRepo<T> getRepo();
	
	public T get(T t) {
		return getRepo().get(t);
	}
	
	public void update(T t) {
		getRepo().update(t);
	}
	
	public Integer add(T t) {
		return getRepo().add(t);
	}
	
	public List<T> list(Class<T> clz) {
		return getRepo().list(clz);
	}
	
	
	public void delete(T t) {
		getRepo().delete(t);
	}
}
