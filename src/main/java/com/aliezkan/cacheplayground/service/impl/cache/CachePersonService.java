package com.aliezkan.cacheplayground.service.impl.cache;

import com.aliezkan.cacheplayground.domain.Person;
import com.aliezkan.cacheplayground.repository.PersonRepository;
import com.aliezkan.cacheplayground.selma.PlaygroundSelma;
import com.aliezkan.cacheplayground.service.impl.plain.PlainPersonService;
import org.springframework.cache.Cache;

public class CachePersonService extends PlainPersonService {

    private final Cache cache;

    public CachePersonService(Cache cache,
                              PersonRepository repository,
                              PlaygroundSelma selma) {
        super(repository, selma);
        this.cache = cache;
    }

    @Override
    public Person getPersonById(Long bookId) {
        return cache.get(bookId, () -> super.getPersonById(bookId));
    }
}
