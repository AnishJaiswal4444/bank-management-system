package com.detagenix.bank_management_system.repository;

import com.detagenix.bank_management_system.entity.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {
}
