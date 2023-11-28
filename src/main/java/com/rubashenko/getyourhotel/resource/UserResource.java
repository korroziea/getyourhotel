package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.User;
import com.rubashenko.getyourhotel.dto.UserDTO;
import com.rubashenko.getyourhotel.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

import static java.time.LocalDateTime.now;

@Controller
@RequestMapping(path = "/user")
@RequiredArgsConstructor
//@Slf4j
public class UserResource {
    private final UserService userService;

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user) {
        UserDTO userDTO = userService.createUser(user);
        return "redirect:/user/auth";
    }

    @GetMapping("/auth")
    public String auth(@ModelAttribute("user") User user) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        UserDTO userDTO = userService.findUser(user);
        return "redirect:/user/hello";
    }

    @GetMapping("/hello")
    public String greeting() {
        return "hello";
    }

    private URI getUri() {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/get/<userId>").toUriString());
    }
}