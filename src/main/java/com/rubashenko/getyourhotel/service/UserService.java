package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.User;
import com.rubashenko.getyourhotel.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
    UserDTO findUser(User user);
}