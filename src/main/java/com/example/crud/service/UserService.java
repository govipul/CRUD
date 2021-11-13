package com.example.crud.service;

import com.example.crud.model.User;
import com.example.crud.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        public User addUsers(final User user) throws Exception {
            final User existingUser = this.getUser(user.getEmail());
            if(existingUser != null ){
                throw new Exception("User exists with provided email id");
            }
            final User saved = userRepository.save(user);
            return saved;
        }

        public List<User> getAllUsers(){
            return userRepository.findAll();
        }

        public User getUser(final String email) throws NotFoundException {
            final User user = userRepository.getUserByEmail(email);
            if(user == null) {
                throw new NotFoundException("User doesnt exists");
            }
            return user;
        }

        public boolean deleteUser(final String email) throws Exception {
            final User user = this.getUser(email);
            if(user == null) {
                throw new NotFoundException("User doesnt exists");
            }
            userRepository.deleteById(user.getId());
            return true;
        }

        public boolean updateUser(final User updateUser) throws NotFoundException {
            final User user = this.getUser(updateUser.getEmail());
            if(user == null) {
                throw new NotFoundException("User doesnt exists");
            }
            userRepository.save(updateUser);
            return true;
        }


}
