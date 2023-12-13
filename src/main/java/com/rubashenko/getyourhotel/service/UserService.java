package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.User;
import com.rubashenko.getyourhotel.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(User user);
    UserDTO findUser(User user);
    UserDTO findUserByEmail(String email);
    UserDTO showOneUser(Long id);
    List<User> showAllUsers();
    void updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}