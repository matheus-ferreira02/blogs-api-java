package com.blogsapijava.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String displayName, password;

    @Column(length = 200, unique = true, nullable = false)
    private String email;

    private String image;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Set<BlogPost> blogPosts;

    // verificando se o valor setado não é nulo
    public void setEmail(String email) {
        if (email != null) this.email = email;
    }
}
