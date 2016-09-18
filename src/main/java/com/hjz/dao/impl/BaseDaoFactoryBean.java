package com.hjz.dao.impl;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.hjz.entity.AbsIdEntity;

public class BaseDaoFactoryBean<R extends JpaRepository<T, Serializable>, T extends AbsIdEntity> extends JpaRepositoryFactoryBean<R, T, Serializable> {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(final EntityManager entityManager) {
        return new JpaRepositoryFactory(entityManager) {

			protected SimpleJpaRepository<T, Serializable> getTargetRepository(
					RepositoryInformation information,	EntityManager entityManager) {
				return new BaseDaoImpl((Class<T>) information.getDomainType(), entityManager);
			}

            @Override
            protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
                return BaseDaoImpl.class;
            }
        };
    }
}
