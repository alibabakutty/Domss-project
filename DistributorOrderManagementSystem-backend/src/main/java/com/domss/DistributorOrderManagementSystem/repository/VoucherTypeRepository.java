package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.VoucherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoucherTypeRepository extends JpaRepository<VoucherType,Long> {

    boolean existsByVoucherType(String voucherType);

    Optional<VoucherType> findByVoucherType(String voucherType);
}
