package com.rubashenko.getyourhotel.service;

import com.rubashenko.getyourhotel.domain.Users;
import com.rubashenko.getyourhotel.dto.UserDTO;

public interface UserService {
    UserDTO createUser(Users user);
    UserDTO findUser(Users user);
}