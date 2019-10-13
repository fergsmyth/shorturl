package com.ferg.url;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class URLEntity {

    public URLEntity(String base64, String url) {
        this.base64 = base64;
        this.url = url;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String base64;

    @Column
    private String url;

}
