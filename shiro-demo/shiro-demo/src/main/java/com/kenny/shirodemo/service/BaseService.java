package com.kenny.shirodemo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.kenny.shirodemo.repository.BaseRepo;

public abstract class BaseService<T> {

	public abstract BaseRepo<T> getRepo();
	
	public T get(Integer id) {
		return getRepo().getOne(id);
	}
	
//	public T getByProperty(Class<?> clz, String property, Object value) {
//		List<T> list = listByProperty(clz, property, value);
//		return list.isEmpty()? null : list.get(0);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<T> listByProperty(Class<?> clz, String property, Object value) {
//		DetachedCriteria dc = DetachedCriteria.forClass(clz);
//		return (List<T>) getRepo().listByDetachedCritiaria(dc);
//	}
	
//	public void update(T t) {
//		getRepo().update(t);
//	}
//	
//	public Integer add(T t) {
//		return getRepo().add(t);
//	}
//	
//	public List<T> list(Class<T> clz) {
//		return getRepo().list(clz);
//	}
	
	public void delete(T t) {
		getRepo().delete(t);
	}
}
