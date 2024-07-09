package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.VoucherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherTypeRepository extends JpaRepository<VoucherType,String> {

    boolean existsByVoucherType(String voucherType);
}
