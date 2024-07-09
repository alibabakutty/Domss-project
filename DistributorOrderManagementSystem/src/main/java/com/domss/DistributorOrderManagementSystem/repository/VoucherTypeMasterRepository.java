package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.VoucherTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherTypeMasterRepository extends JpaRepository<VoucherTypeMaster,String> {

    boolean existsByVoucherTypeName(String voucherTypeName);
}
