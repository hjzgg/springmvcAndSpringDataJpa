package com.hjz.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.hjz.entity.AbsIdEntity;

/**
 * Data Access Object基类，已经包含了常用的增删改查操作�??<br>
 * 使用时只�?要继承接口，不需要实现类，spring自动通过cglib生成实现�?
 * @param <T> 实体类型
 */
@NoRepositoryBean
public interface BaseDao<T extends AbsIdEntity> extends CrudRepository<T, Serializable>/*JpaRepository<T, Serializable>*/, JpaSpecificationExecutor<T> {
}