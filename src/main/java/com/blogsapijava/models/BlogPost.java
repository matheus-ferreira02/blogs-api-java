package com.blogsapijava.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BlogPosts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime published;

    @Column
    private LocalDateTime updated;

    @ManyToOne
    @JsonIgnoreProperties("blogPosts")
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToMany
    @JsonIgnoreProperties("blogPosts")
    @JoinTable(
            name = "PostCategories",
            joinColumns = @JoinColumn(name = "blogPostId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")
    )
    private Set<Category> categories;
}
