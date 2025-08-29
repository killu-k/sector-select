package com.example.sectorselect.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserDto implements Serializable {

    private UUID id;

    @NotBlank(message = "Please enter first name")
    @Size(min = 3, max = 255)
    private String firstName;

    @NotBlank(message = "Please enter last name")
    @Size(min = 3, max = 255)
    private String lastName;

    @NotNull(message = "Consent is required")
    @AssertTrue(message = "Agreement is required")
    private Boolean consent;

    @NotEmpty(message = "Please enter at least one sector")
    private List<UUID> sectorIds;

    public void setSectorIds(List<UUID> sectorIds) {
        this.sectorIds = (List<UUID>) sectorIds;
    }
}