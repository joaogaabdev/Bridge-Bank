package com.bridge.ecosystem.bridge_bank.controller;
import com.bridge.ecosystem.bridge_bank.domain.Account;
import com.bridge.ecosystem.bridge_bank.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestParam Long userId) {
        return accountService.createAccount(userId);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
