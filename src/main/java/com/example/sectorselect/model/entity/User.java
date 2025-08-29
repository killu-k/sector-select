package com.example.sectorselect.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;


    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;


    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;


    @ColumnDefault("false")
    private Boolean consent;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;


    @Column(name = "deleted_at")
    private Instant deletedAt;


    @ManyToMany
    @JoinTable(name = "user_sector",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "sector_id"))

    private List<Sector> sectors = new ArrayList<>();


}