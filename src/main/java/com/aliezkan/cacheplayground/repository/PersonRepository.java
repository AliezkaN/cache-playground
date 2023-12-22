package com.aliezkan.cacheplayground.repository;

import com.aliezkan.cacheplayground.persistence.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
