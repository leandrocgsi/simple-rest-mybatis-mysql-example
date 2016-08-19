package br.com.erudio.services;

import java.util.List;

import br.com.erudio.models.User;

public interface UserService {
    
    User create(User user);
    User findById(String userId);
    List<User> findAll();
    User update(User user);
    void delete(User user);

}
