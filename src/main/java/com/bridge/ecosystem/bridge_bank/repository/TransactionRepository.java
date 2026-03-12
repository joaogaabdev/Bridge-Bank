package com.bridge.ecosystem.bridge_bank.repository;
import com.bridge.ecosystem.bridge_bank.domain.Account;
import com.bridge.ecosystem.bridge_bank.domain.Transaction;
import com.bridge.ecosystem.bridge_bank.domain.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySenderAccount(Account senderAccount);
    List<Transaction> findByReceiverAccount(Account receiverAccount);
    List<Transaction> findByStatus(TransactionStatus status);
}
