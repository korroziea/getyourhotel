package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.Users;
import com.rubashenko.getyourhotel.dto.UserDTO;
import com.rubashenko.getyourhotel.dtomapper.UserDTOMapper;
import com.rubashenko.getyourhotel.repository.UserRepository;
import com.rubashenko.getyourhotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(Users user) {
        return UserDTOMapper.fromUser(userRepository.save(user));
    }

    @Override
    public UserDTO findUser(Users user) {
        return UserDTOMapper.fromUser(userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword()));
    }
}
