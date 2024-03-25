package com.example.seekingsystem.Repository;

import com.example.seekingsystem.Model.JopApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JopApplicationRepository extends JpaRepository<JopApplication, Integer> {
}
