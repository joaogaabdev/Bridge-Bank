package com.bridge.ecosystem.bridge_bank.repository;
import com.bridge.ecosystem.bridge_bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
}
