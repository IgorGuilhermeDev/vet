package org.com.vet.usecase;

import lombok.AllArgsConstructor;
import org.com.vet.model.User;
import org.com.vet.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UseCaseCreateUser {

    private final UserRepository repository;

    @Transactional
    public User save(User user) {
        return repository.save(user);
    }
}
