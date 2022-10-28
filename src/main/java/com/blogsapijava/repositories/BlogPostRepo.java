package com.blogsapijava.repositories;

import com.blogsapijava.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {

    @Override
    @Query("select b from BlogPost as b where b.id = ?1")
    Optional<BlogPost> findById(Long id);

}
