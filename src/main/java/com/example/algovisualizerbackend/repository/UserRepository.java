package com.example.algovisualizerbackend.repository;

import com.example.algovisualizerbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,value="Select * from customer where customer.email=?1 and customer.password=?2 limit 1")
    User findByEmailAndPassword(String email, String password);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="Insert into customer (name, password, email) values (?1,?2,?3)")
    void createByNameAndPasswordAndEmail(String name, String password, String email);
}
