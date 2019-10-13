package com.ferg.url;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("url")
public class URLController {

    @Autowired
    private URLService urlService;

    @PostMapping(value = "/shorten", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody ResponseEntity<String> shortenUrl(@RequestBody String url){
        String shortUrl = urlService.shortenUrl(url);
        return ResponseEntity.created(URI.create("http://oneshortyboi.com/" + shortUrl)).body(shortUrl);
    }
}
