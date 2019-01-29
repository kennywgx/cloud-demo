package com.kenny.shirodemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepo<T> extends JpaRepository<T, Integer> {
	
	
}



//package com.kenny.shirodemo.repository;
//
//import java.util.List;
//
//import org.hibernate.criterion.DetachedCriteria;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//
//import com.kenny.shirodemo.exception.CRUDException;
//
////@NoRepositoryBean
//public abstract class BaseRepo<T> implements JpaRepository<T, Integer> {
//
//	@Autowired
//	HibernateTemplate hibernateTemplate;
//	
//	public Integer add(T t) {
//		return (Integer) hibernateTemplate.save(t);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public T get(T t) {
//		Class<?> clz = t.getClass();
//		try {
//			Integer id = (Integer) clz.getDeclaredMethod("getId").invoke(t);
//			return (T) hibernateTemplate.get(t.getClass(), id);
//		} catch (Exception e) {
//			throw new CRUDException(e);
//		}
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<T> list(Class<T> clz) {
//		DetachedCriteria dc =DetachedCriteria.forClass(clz);
//		return (List<T>) hibernateTemplate.findByCriteria(dc);
//	}
//	
//	public void update(T t) {
//		hibernateTemplate.update(t);
//	}
//	
//	public void delete(T t) {
//		hibernateTemplate.delete(t);
//	}
//	
//	public List<?> listByDetachedCritiaria(DetachedCriteria dc) {
//		if (dc == null)
//			throw new CRUDException("detachedCritiria不能为null");
//		return hibernateTemplate.findByCriteria(dc);
//		
//	}
//}
