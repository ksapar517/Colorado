package org.example.colorado.controller;

import lombok.RequiredArgsConstructor;
import org.example.colorado.dto.UsersDto;

import org.example.colorado.service.userService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/frond")
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UsersDto usersDto){
        try {
            String jwt = (String) userService.signIn(usersDto.getName(), usersDto.getPassword());
            return ResponseEntity.ok(jwt);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
   }
}

