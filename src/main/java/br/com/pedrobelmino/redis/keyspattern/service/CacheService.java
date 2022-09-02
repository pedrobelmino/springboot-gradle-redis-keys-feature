package br.com.pedrobelmino.redis.keyspattern.service;

import br.com.pedrobelmino.redis.keyspattern.model.CacheRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@Service
public class CacheService {

    @Autowired
    private RedisTemplate redisTemplate;

    public Set<String>  findKeysByChave(String chave) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        Set<String> redisKeys = redisTemplate.keys(chave);
        return redisKeys;
    }

    public void save(CacheRepresentation cacheRepresentation) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().append(cacheRepresentation.getKey(), cacheRepresentation.getValue());
    }

    public Optional<CacheRepresentation> findByKey(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return ofNullable( redisTemplate.opsForValue().get(key))
                .map(value->of(new CacheRepresentation(key, String.valueOf(value))))
                .orElse(Optional.empty());
    }
}
