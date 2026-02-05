package com.examly.springapp.service.impl;

import java.util.List;
import com.examly.springapp.model.User;

public interface UserService {
    User create(User user);
    List<User> getAll();
    User getById(Long id);
    User update(Long id, User user);
    void delete(Long id);
}
