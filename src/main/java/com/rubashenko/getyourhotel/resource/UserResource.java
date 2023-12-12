package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Users;
import com.rubashenko.getyourhotel.dto.UserDTO;
import com.rubashenko.getyourhotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping(path = "/user")
@RequiredArgsConstructor
//@Slf4j
public class UserResource {
    private final UserService userService;

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") Users user) {
        return "user/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") Users user) {
        UserDTO userDTO = userService.createUser(user);
        return "redirect:/user/auth";
    }

    @GetMapping("/auth")
    public String auth(@ModelAttribute("user") Users user) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Users user) {
        UserDTO userDTO = userService.findUser(user);
        return "redirect:/hotel";
    }

    @GetMapping("/hello")
    public String greeting() {
        return "hello";
    }
}