package com.bridge.ecosystem.bridge_bank.repository;
import com.bridge.ecosystem.bridge_bank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

