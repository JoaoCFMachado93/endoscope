package org.example.endoscope.core.driven;

import org.example.endoscope.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    Optional<User> findByEmail(String email);

    void save(User user);

    List<User> findAll();

    void saveAll(List<User> users);
}
