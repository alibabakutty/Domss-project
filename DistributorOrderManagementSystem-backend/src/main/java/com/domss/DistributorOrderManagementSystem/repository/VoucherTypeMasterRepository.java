package com.domss.DistributorOrderManagementSystem.repository;


import com.domss.DistributorOrderManagementSystem.entity.VoucherTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoucherTypeMasterRepository extends JpaRepository<VoucherTypeMaster,Long> {

    boolean existsByVoucherTypeName(String voucherTypeName);

    Optional<VoucherTypeMaster> findByVoucherTypeName(String voucherTypeName);

}
