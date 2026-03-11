package com.bridge.ecosystem.bridge_bank.domain.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository <Account, Long> {
}
