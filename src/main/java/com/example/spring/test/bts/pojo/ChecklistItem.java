package com.example.spring.test.bts.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "checklist_item", schema = "public")
public class ChecklistItem {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "item_name")
    @NotEmpty(message = "Item Name required")
    private String itemName;

    @Column(name = "checklist_id")
    private String checklistId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "checklist_id", insertable = false, updatable = false)
    private Checklist checklist;

    @Column(name = "checked")
    private Boolean isChecked;
}
