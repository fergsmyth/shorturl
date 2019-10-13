package com.ferg.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    public String shortenUrl(String longURL){
        String base64 = Base64.getEncoder().withoutPadding().encodeToString(longURL.getBytes());
        if(!urlRepository.getURLByBase64(base64).isPresent()){
            urlRepository.save(new URLEntity(base64, longURL));
        }
        return base64;
    }
}
