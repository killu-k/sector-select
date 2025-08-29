package com.example.sectorselect.service;

import com.example.sectorselect.model.dto.UserDto;
import com.example.sectorselect.model.entity.Sector;
import com.example.sectorselect.model.entity.User;
import com.example.sectorselect.repository.SectorRepository;
import com.example.sectorselect.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SectorRepository sectorRepository;

    public UserService(UserRepository userRepository, SectorRepository sectorRepository) {
        this.userRepository = userRepository;
        this.sectorRepository = sectorRepository;
    }

    public UserDto addUser(UserDto request) {
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setConsent(request.getConsent());

        List<Sector> sectors = new ArrayList<>();
        for (UUID sectorId : request.getSectorIds()) {
            Sector sector = sectorRepository.findById(sectorId)
                    .orElseThrow(() -> new RuntimeException("Sector not found: " + sectorId));
            sectors.add(sector);
        }
        user.setSectors(sectors);

        User saved = userRepository.save(user);

        return mapUserToDto(saved);
    }

    public UserDto updateUser(UUID userId, UserDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setConsent(request.getConsent());

        List<Sector> sectors = new ArrayList<>();
        for (UUID sectorId : request.getSectorIds()) {
            Sector sector = sectorRepository.findById(sectorId)
                    .orElseThrow(() -> new RuntimeException("Sector not found: " + sectorId));
            sectors.add(sector);
        }
        user.setSectors(sectors);

        User saved = userRepository.save(user);

        return mapUserToDto(saved);
    }

    public UserDto getUserAndSectorsById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));
        return mapUserToDto(user);
    }

    private UserDto mapUserToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setConsent(user.getConsent());

        List<UUID> sectorIds = new ArrayList<>();
        for (Sector sector : user.getSectors()) {
            sectorIds.add(sector.getId());
        }
        userDto.setSectorIds(sectorIds);
        return userDto;
    }
}
