package com.example.sectorselect.repository;

import com.example.sectorselect.model.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectorRepository extends JpaRepository<Sector, UUID> {
}