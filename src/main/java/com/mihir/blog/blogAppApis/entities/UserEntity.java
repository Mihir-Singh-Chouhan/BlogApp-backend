package com.mihir.blog.blogAppApis.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name",nullable = false,length = 100)
    private String name;
    private String email;
    private String password;
    private String about;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PostEntity> postEntities = new ArrayList<>();

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<CommentEntity> commentEntitySet = new HashSet<>();

    public UserEntity(Integer id, String name, String email, String password, String about, List<PostEntity> postEntities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
        this.postEntities = postEntities;

    }

    public UserEntity() {
    }
}
