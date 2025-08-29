package com.example.sectorselect.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.time.Instant;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "sectors")
public class Sector {
    @Setter
    @Getter
    @Id
    @Column(nullable = false)
    private UUID id;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String code;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "parent_id")
    private Sector parent;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @ManyToMany(mappedBy = "sectors")
    private List<User> users = new ArrayList<>();

}