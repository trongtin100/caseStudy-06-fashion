package com.fashion.model.repository;
import com.fashion.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Optional<Customer> findById(Long aLong);
}
