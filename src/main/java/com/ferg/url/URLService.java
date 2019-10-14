package com.ferg.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    public String shortenUrl(String longURL) throws NoSuchAlgorithmException {
        MessageDigest.getInstance("MD5").update(longURL.getBytes());
        String base64 = Base64.getEncoder().withoutPadding().encodeToString(longURL.getBytes());
        if(!urlRepository.getURLByBase64(base64).isPresent()){
            urlRepository.save(new URLEntity(base64, longURL));
        }
        return base64;
    }
}
