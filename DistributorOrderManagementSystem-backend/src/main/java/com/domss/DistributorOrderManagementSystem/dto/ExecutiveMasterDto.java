package com.domss.DistributorOrderManagementSystem.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutiveMasterDto {

    private Long id;

    private String executiveCode;


    private  String executiveMaster;


    private String dateOfJoin;


    private  String mobileNo;


    private String emailId;

    private String status;
}
