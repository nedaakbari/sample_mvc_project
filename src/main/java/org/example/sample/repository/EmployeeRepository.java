package org.example.sample.repository;

import org.example.sample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findPersonByFirstName(String firstName);

    @Query("SELECT e FROM Employee e WHERE e.users.username = :username")
    Optional<Employee> findByUsername(@Param("username") String username);

}
