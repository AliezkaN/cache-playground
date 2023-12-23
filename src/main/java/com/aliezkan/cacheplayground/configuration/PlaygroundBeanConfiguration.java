package com.aliezkan.cacheplayground.configuration;

import com.aliezkan.cacheplayground.repository.PersonRepository;
import com.aliezkan.cacheplayground.selma.PlaygroundSelma;
import com.aliezkan.cacheplayground.service.PersonService;
import com.aliezkan.cacheplayground.service.impl.cache.CachePersonService;
import com.aliezkan.cacheplayground.service.impl.plain.PlainPersonService;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(PersonService.class)
@EnableConfigurationProperties(PlaygroundProperties.class)
@Slf4j
public class PlaygroundBeanConfiguration {

    @Bean
    @ConditionalOnProperty(name = "playground.cache.enabled", havingValue = "true")
    public CaffeineCache caffeineCache(PlaygroundProperties playgroundProperties) {
        PlaygroundProperties.Cache cacheProperties = playgroundProperties.getCache();
        log.info("Configuring Cache with properties {}...", cacheProperties);
        return new CaffeineCache("caches.person-info", Caffeine.newBuilder()
                .initialCapacity(cacheProperties.getInitialSize())
                .maximumSize(cacheProperties.getMaxSize())
                .expireAfterWrite(cacheProperties.getExpireTime(), cacheProperties.getTimeUnit())
                .build());
    }

    @Bean
    @ConditionalOnBean(CaffeineCache.class)
    public PersonService cacheBookService(CaffeineCache cache, PersonRepository personRepository, PlaygroundSelma selma){
        log.info("Configuring app to use cache service...");
        return new CachePersonService(cache, personRepository, selma);
    }

    @Bean
    @ConditionalOnMissingBean
    public PersonService plainBookService(PersonRepository personRepository, PlaygroundSelma selma) {
        log.info("Configuring app to use plain service...");
        return new PlainPersonService(personRepository, selma);
    }
}
