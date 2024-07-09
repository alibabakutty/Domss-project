package com.domss.DistributorOrderManagementSystem.repository;

import com.domss.DistributorOrderManagementSystem.dto.ReportDto;
import com.domss.DistributorOrderManagementSystem.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT new com.domss.DistributorOrderManagementSystem.dto.ReportDto( o.voucherType, o.voucherNo, o.voucherDate, " +
            "o.distributorName, o.distributorCode, i.category, i.code, i.description, i.orderQty, i.uom," +
            "i.approvedQuantity, i.rate, i.discount, i.amount, o.createdBy, o.createdDateTime, o.approvedBy," +
            "o.approvedDateTime, o.narration) FROM Orders o JOIN o.items i")
    public List<ReportDto> getJoinInformation();
}
