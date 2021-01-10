package exceptionmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import exceptionmanagement.entities.UserProfile;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long>{

}
