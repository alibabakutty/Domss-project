package com.example.imperio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "godown_master")
public class GodownMasterCreate {

    @Id
    @Column(name = "godown_code")
    private String godownCode;

    @Column(name = "godown_name")
    private String godownName;


}
