package com.aliezkan.cacheplayground.configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.concurrent.TimeUnit;

@Data
@Validated
@ConfigurationProperties(value = "playground", ignoreUnknownFields = false)
public class PlaygroundProperties {

    @Valid
    private Cache cache = new Cache();

    @Data
    public static class Cache {
        private boolean enabled = false;
        @Min(1) private Integer initialSize = 100;
        @Min(1) private Integer maxSize = 1000;
        @Min(1) private Integer expireTime = 60;
        @NotNull private TimeUnit timeUnit = TimeUnit.SECONDS;
    }
}
