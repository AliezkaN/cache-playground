package com.aliezkan.cacheplayground.service.impl.plain;

import com.aliezkan.cacheplayground.domain.Person;
import com.aliezkan.cacheplayground.repository.PersonRepository;
import com.aliezkan.cacheplayground.selma.PlaygroundSelma;
import com.aliezkan.cacheplayground.service.PersonService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlainPersonService implements PersonService {

    private final PersonRepository repository;
    private final PlaygroundSelma selma;
    @Override
    public Person getPersonById(Long bookId) {
        return repository.findById(bookId)
                .map(selma::toDomain)
                .orElseThrow(RuntimeException::new);
    }
}
