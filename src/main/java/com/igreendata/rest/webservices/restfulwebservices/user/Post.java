package com.igreendata.rest.webservices.restfulwebservices.user;

import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Integer getId() {
        return id;
    }

    public Post() {
    }
    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
