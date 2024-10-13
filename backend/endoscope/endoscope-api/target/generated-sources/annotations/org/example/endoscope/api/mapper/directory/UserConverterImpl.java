package org.example.endoscope.api.mapper.directory;

import javax.annotation.processing.Generated;
import org.example.endoscope.api.openapi.model.UserEntity;
import org.example.endoscope.core.domain.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-13T19:02:57+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserEntity domainToDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( (int) user.getUserId() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setSalutation( user.getSalutation() );
        userEntity.setGender( user.getGender() );
        userEntity.setFullName( user.getFullName() );
        userEntity.setAge( user.getAge() );
        userEntity.setDateOfBirth( user.getDateOfBirth() );
        userEntity.setCountryOfOrigin( user.getCountryOfOrigin() );
        userEntity.setWorkLocation( user.getWorkLocation() );
        userEntity.setWorkPlaceSetting( user.getWorkPlaceSetting() );
        userEntity.setMedicalId( user.getMedicalId() );
        userEntity.setMedicalSpeciality( user.getMedicalSpeciality() );
        userEntity.setEducation( user.getEducation() );
        userEntity.setRole( user.getRole() );

        return userEntity;
    }

    @Override
    public User dtoToDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( userEntity.getEmail() );
        user.password( userEntity.getPassword() );
        user.salutation( userEntity.getSalutation() );
        user.gender( userEntity.getGender() );
        user.fullName( userEntity.getFullName() );
        user.age( userEntity.getAge() );
        user.dateOfBirth( userEntity.getDateOfBirth() );
        user.countryOfOrigin( userEntity.getCountryOfOrigin() );
        user.workLocation( userEntity.getWorkLocation() );
        user.workPlaceSetting( userEntity.getWorkPlaceSetting() );
        user.medicalId( userEntity.getMedicalId() );
        user.medicalSpeciality( userEntity.getMedicalSpeciality() );
        user.education( userEntity.getEducation() );
        user.role( userEntity.getRole() );

        return user.build();
    }
}
