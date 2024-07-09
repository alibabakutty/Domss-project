package com.example.imperio.repository;

import com.example.imperio.entity.VoucherTypeCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherTypeDAO extends JpaRepository<VoucherTypeCreate,String> {

    boolean existsByVoucherType(String voucherType);
}
