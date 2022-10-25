package com.blogsapijava.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String displayName, password;

    @Column(length = 200, unique = true, nullable = false)
    private String email;

    private String image;

    @OneToMany(mappedBy = "user")
    private Set<BlogPost> blogPosts;
}
