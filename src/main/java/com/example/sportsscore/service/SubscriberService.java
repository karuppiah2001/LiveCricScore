package com.example.sportsscore.service;

import com.example.sportsscore.model.User;
import com.example.sportsscore.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriberService {
    @Autowired
    SubscriberRepository subscribersRepo;

    public User addUser(User user){
        User saved = subscribersRepo.save(user);
        return saved;
    }

    public User deleteUser(int id) {
        Optional<User> byId = subscribersRepo.findById(id);
        if(!byId.isEmpty()){
            subscribersRepo.deleteById(id);
            return byId.get();
        }

        return null;
    }
}
