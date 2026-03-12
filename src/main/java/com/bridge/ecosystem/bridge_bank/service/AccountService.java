package com.bridge.ecosystem.bridge_bank.service;
import com.bridge.ecosystem.bridge_bank.domain.Account;
import com.bridge.ecosystem.bridge_bank.repository.AccountRepository;
import com.bridge.ecosystem.bridge_bank.domain.User;
import com.bridge.ecosystem.bridge_bank.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Account createAccount(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setUser(user);

        return accountRepository.save(account);
    }

    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
