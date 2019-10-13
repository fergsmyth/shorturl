package com.ferg.url;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLRepository extends CrudRepository<URLEntity, Long> {

    @Cacheable("urls")
    Optional<URLEntity> getURLByBase64(String base64);

}
