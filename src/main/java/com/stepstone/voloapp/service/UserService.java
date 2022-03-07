package com.stepstone.voloapp.service;

import com.stepstone.voloapp.domain.User;
import com.stepstone.voloapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

/*    public User getUserByName(String name) {
        userRepository.getUserByPersonalInformationEmail("");
    }*/

    public User getUserByEmail(String email) {
        return userRepository.getUserByPersonalInformationEmail(email);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAll (){
        return userRepository.findAll();
    }
}