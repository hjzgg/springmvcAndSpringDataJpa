package com.hjz.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hjz.entity.PersonEntity;

public interface PersonDao extends BaseDao<PersonEntity>{
	@Query(value = "select * from person where dr = 0", nativeQuery = true)
	List<PersonEntity> findAllPersons();
	
	@Query(value = "select * from person where dr = 0 and id = ?1", nativeQuery = true)
	PersonEntity findOneById(String id);
	
	@Transactional
	@Modifying
	@Query(value = "update PersonEntity set dr = 1 where id in (?1)")
	int deletePersons(List<String> ids);
}
