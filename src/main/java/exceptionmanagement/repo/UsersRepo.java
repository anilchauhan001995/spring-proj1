package exceptionmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import exceptionmanagement.entities.Users;

public interface UsersRepo extends JpaRepository<Users, Long> {

}
