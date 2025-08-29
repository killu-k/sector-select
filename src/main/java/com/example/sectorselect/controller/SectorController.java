package com.example.sectorselect.controller;

import com.example.sectorselect.model.dto.SectorDto;
import com.example.sectorselect.service.SectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping
    public List<SectorDto> getAllSectors() {
        return sectorService.getAllSectors();
    }
}
