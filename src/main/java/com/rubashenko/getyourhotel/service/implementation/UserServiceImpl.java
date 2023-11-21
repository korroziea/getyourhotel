package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.User;
import com.rubashenko.getyourhotel.dto.UserDTO;
import com.rubashenko.getyourhotel.dtomapper.UserDTOMapper;
import com.rubashenko.getyourhotel.repository.UserRepository;
import com.rubashenko.getyourhotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }

    @Override
    public UserDTO findUser(User user) {
        return UserDTOMapper.fromUser(userRepository.get(user));
    }
}
