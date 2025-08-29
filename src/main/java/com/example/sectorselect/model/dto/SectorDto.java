package com.example.sectorselect.model.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class SectorDto implements Serializable {
    UUID id;
    @Size(max = 255)
    String name;
    UUID parentId;

}