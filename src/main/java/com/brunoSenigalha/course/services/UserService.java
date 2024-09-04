package com.brunoSenigalha.course.services;

import com.brunoSenigalha.course.entities.User;
import com.brunoSenigalha.course.repositories.UserRepository;
import com.brunoSenigalha.course.services.exceptions.DatabaseException;
import com.brunoSenigalha.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public User update(Long id, User obj) {
        return repository.findById(id)
                .map(entity -> {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        try {
            repository.delete(entity);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
