package com.domss.DistributorOrderManagementSystem.entity;


import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "region_master")
public class RegionMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;



    @Column(name = "region_master_id", nullable = false, unique = true)
    private String regionMasterId;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "region_state")
    private String regionState;

    @Column(name = "country")
    private String country;


}
