package com.example.spring.test.bts.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "checklist", schema = "public")
public class Checklist {
    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "name")
    @NotEmpty(message = "Name required")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "checklist")
    private List<ChecklistItem> items = new ArrayList<>();
}
