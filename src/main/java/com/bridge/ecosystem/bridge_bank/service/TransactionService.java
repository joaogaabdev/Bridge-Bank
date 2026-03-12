package com.bridge.ecosystem.bridge_bank.service;

import com.bridge.ecosystem.bridge_bank.domain.Account;
import com.bridge.ecosystem.bridge_bank.repository.AccountRepository;
import com.bridge.ecosystem.bridge_bank.domain.Transaction;
import com.bridge.ecosystem.bridge_bank.repository.TransactionRepository;
import com.bridge.ecosystem.bridge_bank.domain.TransactionStatus;
import com.bridge.ecosystem.bridge_bank.domain.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public Transaction transfer(Long senderId, Long receiverId, BigDecimal amount) {

        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient Balance");
        }

        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = new Transaction(
                sender,
                receiver,
                amount,
                TransactionType.TRANSFER,
                TransactionStatus.COMPLETED
        );

        return  transactionRepository.save(transaction);
    }
}
