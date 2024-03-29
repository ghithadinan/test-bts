package com.example.spring.test.bts.service;

import com.example.spring.test.bts.helpers.Response;
import com.example.spring.test.bts.model.ResponseModel;
import com.example.spring.test.bts.pojo.Checklist;
import com.example.spring.test.bts.pojo.ChecklistItem;
import com.example.spring.test.bts.repo.ChecklistItemRepo;
import com.example.spring.test.bts.repo.ChecklistRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepo repo;

    @Autowired
    private ChecklistItemRepo repoItem;

    public ResponseEntity<ResponseModel> all() {
        return Response.success(repo.findAll());
    }

    public ResponseEntity<ResponseModel> create(Checklist req) {
        return Response.created(repo.save(req));
    }

    public ResponseEntity<ResponseModel> delete(String id) {
        repo.deleteById(id);
        return Response.success();
    }

    public ResponseEntity<ResponseModel> itemsById(String id) {
        return Response.success(repoItem.findByChecklistId(id));
    }

    public ResponseEntity<ResponseModel> itemsCreate(String id, @Valid ChecklistItem req) {
        ChecklistItem checklistItem = new ChecklistItem();
        checklistItem.setChecklistId(id);
        checklistItem.setItemName(req.getItemName());
        return Response.created(repoItem.save(checklistItem));
    }

    public ResponseEntity<ResponseModel> getItem(String id, String itemId) {
        Optional<ChecklistItem> checklistItem = repoItem.findByChecklistIdAndId(id, itemId);
        return checklistItem.map(Response::success).orElseGet(Response::notFound);
    }

    public ResponseEntity<ResponseModel> updateStatus(String id, String itemId) {
        Optional<ChecklistItem> checklistItem = repoItem.findByChecklistIdAndId(id, itemId);
        if (checklistItem.isPresent()) {
            checklistItem.get().setIsChecked(!checklistItem.get().getIsChecked());
            repoItem.save(checklistItem.get());
            return Response.success(checklistItem.get());
        }
        return Response.notFound();
    }

    public ResponseEntity<ResponseModel> deleteItem(String id, String itemId) {
        Optional<ChecklistItem> checklistItem = repoItem.findByChecklistIdAndId(id, itemId);
        if (checklistItem.isPresent()) {
            repoItem.delete(checklistItem.get());
            return Response.success();
        }
        return Response.notFound();
    }

    public ResponseEntity<ResponseModel> updateItemName(String id, String itemId, String itemName) {
        Optional<ChecklistItem> checklistItem = repoItem.findByChecklistIdAndId(id, itemId);
        if (checklistItem.isPresent()) {
            checklistItem.get().setItemName(itemName);
            repoItem.save(checklistItem.get());
            return Response.success(checklistItem.get());
        }
        return Response.notFound();
    }
}
