package com.hjz.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hjz.dao.PersonDao;
import com.hjz.entity.PersonEntity;
import com.hjz.vo.PersonVO;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public List<PersonVO> findAllPersons(){
		List<PersonVO> listVO = new ArrayList<>();
		List<PersonEntity> listEntity = personDao.findAllPersons();
		for(PersonEntity entity : listEntity) {
			PersonVO vo = new PersonVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		}
		return listVO;
	}
	
	public List<PersonVO> findPageablePersons(Pageable pageable){
		
		List<PersonVO> listVO = new ArrayList<>();
		
		Page<PersonEntity> pageEntity = personDao.findAll(new Specification<PersonEntity>() {
			@Override
			public Predicate toPredicate(Root<PersonEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		        return cb.equal(root.get("dr").as(Integer.class), 0);
			}
		}, pageable);
		
		for (PersonEntity entity : pageEntity) {
			PersonVO personVO = new PersonVO();
			BeanUtils.copyProperties(entity, personVO);
			listVO.add(personVO);
		}
		
		return listVO;
	}
	
	public long count() {
		return personDao.count(new Specification<PersonEntity>() {
			@Override
			public Predicate toPredicate(Root<PersonEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		        return cb.equal(root.get("dr").as(Integer.class), 0);
			}
		});
	}
	
	public PersonVO findOnePerson(String id){
		PersonVO vo = new PersonVO();
		PersonEntity entity = personDao.findOneById(id);
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
	
	public void deleteOnePerson(String id) {
		personDao.delete(id);
	}
	
	public PersonVO save(PersonVO vo){
		PersonEntity entity = new PersonEntity();
		BeanUtils.copyProperties(vo, entity);
		personDao.save(entity);
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}

	public void deletePersons(List<String> ids) {
		personDao.deletePersons(ids);
	}
}
