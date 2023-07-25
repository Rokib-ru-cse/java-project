package com.bitspondon.rokibspringboot.repo;

import com.bitspondon.rokibspringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
