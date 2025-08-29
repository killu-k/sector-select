package com.example.sectorselect.service;

import com.example.sectorselect.mapper.SectorMapper;
import com.example.sectorselect.model.dto.SectorDto;
import com.example.sectorselect.model.entity.Sector;
import com.example.sectorselect.repository.SectorRepository;
import com.example.sectorselect.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    public SectorService(SectorRepository sectorRepository, SectorMapper sectorMapper) {
        this.sectorRepository = sectorRepository;
        this.sectorMapper = sectorMapper;
    }

    public List<SectorDto> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();

        List<SectorDto> sectorDtos = new ArrayList<>();
        for (Sector sector : sectors) {
            SectorDto sectorDto = sectorMapper.toDto(sector);
            sectorDtos.add(sectorDto);
        }
        return sectorDtos;
    }
}
