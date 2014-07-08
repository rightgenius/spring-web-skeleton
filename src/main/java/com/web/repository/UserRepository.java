package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findById(Long id);
}
