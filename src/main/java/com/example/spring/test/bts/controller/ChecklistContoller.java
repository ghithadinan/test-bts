package com.example.spring.test.bts.controller;

import com.example.spring.test.bts.model.ResponseModel;
import com.example.spring.test.bts.pojo.Checklist;
import com.example.spring.test.bts.pojo.ChecklistItem;
import com.example.spring.test.bts.service.ChecklistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("checklist")
public class ChecklistContoller {

    @Autowired
    ChecklistService service;

    @GetMapping
    public ResponseEntity<ResponseModel> all() {
        return service.all();
    }

    @PostMapping
    public ResponseEntity<ResponseModel> post(@Valid @RequestBody Checklist req) {
        return service.create(req);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @GetMapping("{id}/item")
    public ResponseEntity<ResponseModel> itemsById(@PathVariable("id") String id) {
        return service.itemsById(id);
    }

    @PostMapping("{id}/item")
    public ResponseEntity<ResponseModel> itemsCreate(@PathVariable("id") String id, @Valid @RequestBody ChecklistItem req) {
        return service.itemsCreate(id, req);
    }

    @PostMapping("{id}/item/{itemId}")
    public ResponseEntity<ResponseModel> getItem(@PathVariable("id") String id, @PathVariable("itemId") String itemId) {
        return service.getItem(id, itemId);
    }

    @PutMapping("{id}/item/{itemId}")
    public ResponseEntity<ResponseModel> updateItemStatus(@PathVariable("id") String id, @PathVariable("itemId") String itemId) {
        return service.updateStatus(id, itemId);
    }

    @DeleteMapping("{id}/item/{itemId}")
    public ResponseEntity<ResponseModel> deleteItem(@PathVariable("id") String id, @PathVariable("itemId") String itemId) {
        return service.deleteItem(id, itemId);
    }

    @PutMapping("{id}/item/rename/{itemId}")
    public ResponseEntity<ResponseModel> updateItemName(@PathVariable("id") String id, @PathVariable("itemId") String itemId, @RequestBody String itemName) {
        return service.updateItemName(id, itemId, itemName);
    }
}
