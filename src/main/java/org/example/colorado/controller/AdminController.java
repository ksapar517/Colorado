package org.example.colorado.controller;

import lombok.RequiredArgsConstructor;
import org.example.colorado.dto.UsersDto;
import org.example.colorado.service.adminService.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("frond")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/create")
    public String create(Model model) {
        return "add/createUser"; // Возвращает текстовый ответ "add/createUser"
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("registrationRequest") UsersDto registrationRequest, Model model) {
        String signUpResponse = adminService.signUp(registrationRequest);
        model.addAttribute("signUpResponse", signUpResponse); // Optional: Add response to the model
        return "registrationRequest";
    }
}
