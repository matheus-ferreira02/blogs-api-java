package com.blogsapijava.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BlogPosts")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String title;

    @Column
    private String content;

    @Column
    private long userId;

    @Column
    private LocalDateTime published;

    @Column
    private LocalDateTime updated;
}
