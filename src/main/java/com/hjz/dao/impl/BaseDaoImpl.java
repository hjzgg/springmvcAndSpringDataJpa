package com.hjz.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hjz.dao.BaseDao;
import com.hjz.entity.AbsIdEntity;
@Transactional
public class BaseDaoImpl<T extends AbsIdEntity> extends SimpleJpaRepository<T, Serializable> implements BaseDao<T> {

    private final EntityManager entityManager;
    
    public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public BaseDaoImpl(JpaEntityInformation<T, Serializable> information, EntityManager entityManager){
    	super(information, entityManager);
    	this.entityManager = entityManager;
    }
    
    @Override
    public <S extends T> S save(S entity) {
        entity.setModificationTimestamp(new Timestamp(System.currentTimeMillis()));
        return super.save(entity);
    }
    
    //½øÐÐÂß¼­É¾³ý
	@Override
	public void delete(T entity) {
		entity.setDr(1);
		save(entity);
	}

	@Override
	public void delete(Serializable id) {
		T entity = findOne(id);
		entity.setDr(1);
		this.save(entity);
	}
	
}
