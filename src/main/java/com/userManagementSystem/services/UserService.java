package com.userManagementSystem.services;

import com.userManagementSystem.dto.UserRequestDTO;
import com.userManagementSystem.dto.UserResponseDTO;
import com.userManagementSystem.entity.User;
import com.userManagementSystem.mapper.UserMapper;
import com.userManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserMapper userMapper;

    public List<UserResponseDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO findById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    public UserResponseDTO save(UserRequestDTO userRequest) {
        if (repo.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("Email already exists: " + userRequest.getEmail());
        }

        User user = userMapper.toEntity(userRequest);
        User savedUser = repo.save(user);
        return userMapper.toDTO(savedUser);
    }

    public UserResponseDTO update(Long id, UserRequestDTO userRequest) {
        User existingUser = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (!existingUser.getEmail().equals(userRequest.getEmail()) &&
                repo.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("Email already exists: " + userRequest.getEmail());
        }

        userMapper.updateEntityFromDTO(userRequest, existingUser);
        User updatedUser = repo.save(existingUser);
        return userMapper.toDTO(updatedUser);
    }

    public void delete(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        repo.delete(user);
    }
}