package com.example.imperio.repository;

import com.example.imperio.entity.VoucherTypeMasterCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherTypeMasterDAO extends JpaRepository<VoucherTypeMasterCreate,String> {

    boolean existsByVoucherTypeName(String voucherTypeName);
}
