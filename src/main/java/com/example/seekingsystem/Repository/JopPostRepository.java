package com.example.seekingsystem.Repository;

import com.example.seekingsystem.Model.JopPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JopPostRepository extends JpaRepository<JopPost, Integer> {
}
