package com.dov.banking.repository;

import com.dov.banking.model.Account;
import com.dov.banking.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJpaRepository extends JpaRepository<Cart, Integer> {
}

