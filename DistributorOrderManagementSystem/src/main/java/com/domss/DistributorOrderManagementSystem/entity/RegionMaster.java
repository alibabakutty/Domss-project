package com.domss.DistributorOrderManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "region_masters")
public class RegionMaster {

    @Id
    @Column(name = "region_master_id")
    private String regionMasterId;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "region_state")
    private String regionState;

    @Column(name = "country")
    private String country;
}
