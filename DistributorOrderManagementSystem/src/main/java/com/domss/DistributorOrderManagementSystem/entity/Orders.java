package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @SequenceGenerator(
            name = "order_seq",
            sequenceName = "order_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_seq"
    )
    private Long orderId;

    @Column(name = "voucher_type")
    private String voucherType;

    @Column(name = "voucher_no", nullable = false, unique = true)
    private String voucherNo;

    @Column(name = "distributor_name")
    private String distributorName;

    @Column(name = "distributor_code")
    private String distributorCode;

    @Column(name = "order_date")
    private LocalDate voucherDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date_time", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    @Column(name = "approved_by")
    private String approvedBy;

    @Column(name = "approved_date_time")
    private LocalDateTime approvedDateTime;

    @Column(name = "narration")
    private String narration;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "item_id", referencedColumnName = "orderId")
    private List<OrderItems> items;


    public void setApprovedDateOnce(LocalDateTime approvedDate) {
        if (approvedDateTime == null) {
            approvedDateTime = approvedDate;
        }

    }
}
