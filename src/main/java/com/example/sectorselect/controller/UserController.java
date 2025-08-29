package com.example.sectorselect.controller;

import com.example.sectorselect.model.dto.UserDto;
import com.example.sectorselect.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(HttpServletRequest request) {

        UUID userId = (UUID) request.getSession().getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDto userDto = userService.getUserAndSectorsById(userId);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> addNewUser(@Valid @RequestBody UserDto request, HttpServletRequest servletRequest) {

        UUID userID = (UUID) servletRequest.getSession().getAttribute("userId");
        if (userID != null) {
            UserDto updated = userService.updateUser(userID, request);
            return ResponseEntity.ok(updated);

        }

        UserDto userDto = userService.addUser(request);
        servletRequest.getSession().setAttribute("userId", userDto.getId());
        System.out.println("Saving user: " + userDto.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PutMapping("/me")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto request, HttpServletRequest servletRequest) {

        UUID userId = (UUID) servletRequest.getSession().getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDto userDto = userService.updateUser(userId, request);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }
}
