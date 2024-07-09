package com.domss.DistributorOrderManagementSystem.mapper;

import com.domss.DistributorOrderManagementSystem.dto.ExecutiveMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.ExecutiveMaster;

public class ExecutiveMasterMapper {



    public static ExecutiveMasterDto mapToExecutiveMasterDto(ExecutiveMaster executiveMaster){
        return new ExecutiveMasterDto(

                executiveMaster.getExecutiveCode(),
                executiveMaster.getExecutiveMaster(),
                executiveMaster.getDateOfJoin(),
                executiveMaster.getMobileNo(),
                executiveMaster.getEmailId(),
                executiveMaster.getStatus()
        );
    }

    public static ExecutiveMaster mapToExecutiveMaster(ExecutiveMasterDto executiveMasterDto){

        return new ExecutiveMaster(
                executiveMasterDto.getExecutiveCode(),
                executiveMasterDto.getExecutiveMaster(),
                executiveMasterDto.getDateOfJoin(),
                executiveMasterDto.getMobileNo(),
                executiveMasterDto.getEmailId(),
                executiveMasterDto.getStatus()
        );
    }
}
