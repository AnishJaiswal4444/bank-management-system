package com.detagenix.bank_management_system.repository;

import com.detagenix.bank_management_system.entity.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
}
