package com.nikita.klimkin.testTaskJarSoft.service;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import com.nikita.klimkin.testTaskJarSoft.model.User;
import com.nikita.klimkin.testTaskJarSoft.repository.UserRepository;
import com.nikita.klimkin.testTaskJarSoft.util.ValidationUtil;
import com.nikita.klimkin.testTaskJarSoft.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User banner) {
        ValidationUtil.isNew(banner);
        return userRepository.save(banner);
    }

    public void update(User banner) {
        ValidationUtil.isUpdated(banner);
        userRepository.save(banner);
    }

    public boolean delete(int id) {
        return userRepository.delete(id) != 0;
    }

    public User get(int id) {
        return userRepository.getOne(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("user with email = " + email + "doesnt exist"));
    }
}
