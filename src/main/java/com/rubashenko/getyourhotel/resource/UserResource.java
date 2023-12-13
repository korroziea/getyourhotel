package com.rubashenko.getyourhotel.resource;

import com.rubashenko.getyourhotel.domain.Hotel;
import com.rubashenko.getyourhotel.domain.HotelRoom;
import com.rubashenko.getyourhotel.domain.User;
import com.rubashenko.getyourhotel.dto.UserDTO;
import com.rubashenko.getyourhotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
@RequiredArgsConstructor
//@Slf4j
public class UserResource {
    private final UserService userService;

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user) {
        UserDTO userDTO = userService.createUser(user);
        return "redirect:/user/auth";
    }

    @GetMapping("/auth")
    public String auth(@ModelAttribute("user") User user) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        UserDTO userDTO = userService.findUser(user);
        return "redirect:/hotel";
    }

    @GetMapping()
    public String showUsers(Model model) {
        List<User> users = userService.showAllUsers();
        model.addAttribute("users", users);
        return "user/showAll";
    }

    @GetMapping("/{id}")
    public String searchUserById(@PathVariable("id") Long id, Model model, @ModelAttribute("User") User user) {
        UserDTO userDTO = userService.showOneUser(id);
        model.addAttribute("userDTO", userDTO);
        return "user/showOne";
    }

    @GetMapping("/search/{email}")
    public String searchUserByEmail(@PathVariable("email") String email, Model model) {
        UserDTO userDTO = userService.findUserByEmail(email);
        Long id = userDTO.getId();
        model.addAttribute("userDTO", userDTO);
        return "redirect:/user/" + id;
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        UserDTO userDTO = userService.showOneUser(id);
        model.addAttribute("userDTO", userDTO);
        return "user/edit";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("User") User updatedUser) {
        userService.updateUser(id, updatedUser);
        return "redirect:/user/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}