package com.example.spring.test.bts.repo;

import com.example.spring.test.bts.pojo.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepo extends JpaRepository<Checklist, String> {
}
