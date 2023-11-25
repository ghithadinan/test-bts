package com.example.spring.test.bts.repo;

import com.example.spring.test.bts.pojo.ChecklistItem;
import com.example.spring.test.bts.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChecklistItemRepo extends JpaRepository<ChecklistItem, String> {

    List<ChecklistItem> findByChecklistId(String checklistid);

    Optional<ChecklistItem> findByChecklistIdAndId(String checklistid, String id);

}
