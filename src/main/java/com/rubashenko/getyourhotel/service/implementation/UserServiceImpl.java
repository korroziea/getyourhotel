package com.rubashenko.getyourhotel.service.implementation;

import com.rubashenko.getyourhotel.domain.User;
import com.rubashenko.getyourhotel.dto.UserDTO;
import com.rubashenko.getyourhotel.dtomapper.UserDTOMapper;
import com.rubashenko.getyourhotel.repository.UserRepository;
import com.rubashenko.getyourhotel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.save(user));
    }

    @Override
    public UserDTO findUser(User user) {
        return UserDTOMapper.fromUser(userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword()));
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return UserDTOMapper.fromUser(userRepository.findUserByEmail(email));
    }

    @Override
    public UserDTO showOneUser(Long id) {
        return UserDTOMapper.fromUser(userRepository.findUserById(id));
    }

    @Override
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        userRepository.updateUserById(id, updatedUser.getFirstName(), updatedUser.getLastName());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
