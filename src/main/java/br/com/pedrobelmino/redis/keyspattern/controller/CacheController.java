package br.com.pedrobelmino.redis.keyspattern.controller;

import br.com.pedrobelmino.redis.keyspattern.model.CacheRepresentation;
import br.com.pedrobelmino.redis.keyspattern.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/cache/{key}/keys", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findKeysByChave(@PathVariable("key") String key) {
        return ResponseEntity.ok(cacheService.findKeysByChave(key));
    }

    @RequestMapping(value = "/cache", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody CacheRepresentation cacheRepresentation) {
        cacheService.save(cacheRepresentation);
        return new ResponseEntity(CREATED);
    }

    @RequestMapping(value = "/cache/{key}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CacheRepresentation> findByKey(@PathVariable("key") String key) {
        return cacheService.findByKey(key).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
