package org.example.endoscope.output.adapter;

import org.example.endoscope.core.domain.User;
import org.example.endoscope.core.driven.UserRepositoryPort;
import org.example.endoscope.output.dbo.UserEntity;
import org.example.endoscope.output.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    public UserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userEntity = userJpaRepository.findByEmail(email);

        return userEntity.map(this::dboToDomain);
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = domainToDbo(user);
        userJpaRepository.save(userEntity);
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream()
                .map(this::dboToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<User> users) {
        List<UserEntity> userEntities = users.stream()
                .map(this::domainToDbo)
                .collect(Collectors.toList());
        userJpaRepository.saveAll(userEntities);
    }

    private User dboToDomain(UserEntity userEntity) {
        return User.builder()
                .userId(userEntity.getUserId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .salutation(userEntity.getSalutation())
                .gender(userEntity.getGender())
                .fullName(userEntity.getFullName())
                .age(userEntity.getAge())
                .dateOfBirth(userEntity.getDateOfBirth())
                .countryOfOrigin(userEntity.getCountryOfOrigin())
                .workLocation(userEntity.getWorkLocation())
                .workPlaceSetting(userEntity.getWorkPlaceSetting())
                .medicalId(userEntity.getMedicalId())
                .medicalSpeciality(userEntity.getMedicalSpeciality())
                .education(userEntity.getEducation())
                .role(userEntity.getRole()) // Mapping to User.role which serves as authorities
                .build();
    }


    private UserEntity domainToDbo(User user) {
        return UserEntity.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(user.getPassword())
                .salutation(user.getSalutation())
                .gender(user.getGender())
                .fullName(user.getUsername())
                .age(user.getAge())
                .dateOfBirth(user.getDateOfBirth())
                .countryOfOrigin(user.getCountryOfOrigin())
                .workLocation(user.getWorkLocation())
                .workPlaceSetting(user.getWorkPlaceSetting())
                .medicalId(user.getMedicalId())
                .medicalSpeciality(user.getMedicalSpeciality())
                .education(user.getEducation())
                .role(user.getRole())
                .build();
    }
}
