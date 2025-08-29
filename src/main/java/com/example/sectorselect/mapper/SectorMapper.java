package com.example.sectorselect.mapper;

import com.example.sectorselect.model.dto.SectorDto;
import com.example.sectorselect.model.entity.Sector;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SectorMapper {

    @Mapping(target = "parentId", source = "parent.id")
    SectorDto toDto(Sector sector);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Sector partialUpdate(SectorDto sectorDto, @MappingTarget Sector sector);
}