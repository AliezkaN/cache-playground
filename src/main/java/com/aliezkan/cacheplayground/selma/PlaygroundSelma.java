package com.aliezkan.cacheplayground.selma;

import com.aliezkan.cacheplayground.domain.Person;
import com.aliezkan.cacheplayground.persistence.PersonEntity;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIoC = IoC.SPRING)
public interface PlaygroundSelma {
    Person toDomain(PersonEntity entity);
}
