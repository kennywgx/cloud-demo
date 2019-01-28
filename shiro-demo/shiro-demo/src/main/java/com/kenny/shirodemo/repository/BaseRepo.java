package com.kenny.shirodemo.repository;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.kenny.shirodemo.exception.CRUDException;

public abstract class BaseRepo<T> {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public Integer add(T t) {
		return (Integer) hibernateTemplate.save(t);
	}
	
	@SuppressWarnings("unchecked")
	public T get(T t) {
		Class<?> clz = t.getClass();
		try {
			Integer id = (Integer) clz.getDeclaredMethod("getId").invoke(t);
			return (T) hibernateTemplate.get(t.getClass(), id);
		} catch (Exception e) {
			throw new CRUDException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> clz) {
		DetachedCriteria dc =DetachedCriteria.forClass(clz);
		return (List<T>) hibernateTemplate.findByCriteria(dc);
	}
	
	public void update(T t) {
		hibernateTemplate.update(t);
	}
	
	public void delete(T t) {
		hibernateTemplate.delete(t);
	}
}
