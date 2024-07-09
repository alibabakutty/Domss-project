package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeMasterDto;
import com.domss.DistributorOrderManagementSystem.entity.VoucherTypeMaster;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.VoucherTypeMasterMapper;
import com.domss.DistributorOrderManagementSystem.repository.VoucherTypeMasterRepository;
import com.domss.DistributorOrderManagementSystem.service.VoucherTypeMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoucherTypeMasterServiceImpl implements VoucherTypeMasterService {

    @Autowired
    private VoucherTypeMasterRepository voucherTypeMasterRepository;

    @Override
    public VoucherTypeMasterDto createVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto){

        // validate voucher type name object
        validateVoucherTypeMaster(voucherTypeMasterDto);

        // check for duplicate entry
        if(voucherTypeMasterRepository.existsByVoucherTypeName(voucherTypeMasterDto.getVoucherTypeName())){

            throw new DuplicateKeyException("Duplicate entry for unique field:" + voucherTypeMasterDto.getVoucherTypeName());


        }

        VoucherTypeMaster voucherTypeMaster = VoucherTypeMasterMapper.mapToVoucherTypeMaster(voucherTypeMasterDto);

        VoucherTypeMaster savedVoucherTypeMaster = voucherTypeMasterRepository.save(voucherTypeMaster);

        return VoucherTypeMasterMapper.mapToVoucherTypeMasterDto(savedVoucherTypeMaster);


    }

    private void validateVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto){

        if(voucherTypeMasterDto.getVoucherTypeName() == null || voucherTypeMasterDto.getVoucherTypeName().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }

    @Override
    public VoucherTypeMasterDto getVoucherTypeName(String voucherTypeName){
        VoucherTypeMaster voucherTypeMaster = voucherTypeMasterRepository.findById(voucherTypeName).orElseThrow(()->

                new ResourceNotFoundException("Voucher type name is not found with this name:" + voucherTypeName));

        return VoucherTypeMasterMapper.mapToVoucherTypeMasterDto(voucherTypeMaster);
    }

    @Override
    public List<VoucherTypeMasterDto> getAllVoucherTypeMasters(){

        List<VoucherTypeMaster> voucherTypeMaster = voucherTypeMasterRepository.findAll();

        return voucherTypeMaster.stream().map(VoucherTypeMasterMapper::mapToVoucherTypeMasterDto).toList();

    }

    @Override
    public VoucherTypeMasterDto updateVoucherTypeMaster(String voucherTypeName, VoucherTypeMasterDto updatedVoucherTypeMaster){


        VoucherTypeMaster voucherTypeMaster = voucherTypeMasterRepository.findById(voucherTypeName).orElseThrow(() ->

                new ResourceNotFoundException("Voucher type name is not found with this name:" + voucherTypeName));

        voucherTypeMaster.setVoucherTypeName(updatedVoucherTypeMaster.getVoucherTypeName());
        voucherTypeMaster.setVoucherType(updatedVoucherTypeMaster.getVoucherType());
        voucherTypeMaster.setMethodOfVoucherNumbering(updatedVoucherTypeMaster.getMethodOfVoucherNumbering());
        voucherTypeMaster.setAlterAdditionalNumberingDetails(updatedVoucherTypeMaster.getAlterAdditionalNumberingDetails());
        voucherTypeMaster.setStartingNumber(updatedVoucherTypeMaster.getStartingNumber());
        voucherTypeMaster.setWidthOfNumericalPart(updatedVoucherTypeMaster.getWidthOfNumericalPart());
        voucherTypeMaster.setPrefillWithZero(updatedVoucherTypeMaster.getPrefillWithZero());
        voucherTypeMaster.setRestartNumberingApplicationForm(updatedVoucherTypeMaster.getRestartNumberingApplicationForm());
        voucherTypeMaster.setRestartNumberingStartingNumber(updatedVoucherTypeMaster.getRestartNumberingStartingNumber());
        voucherTypeMaster.setRestartNumberingPeriodicity(updatedVoucherTypeMaster.getRestartNumberingPeriodicity());
        voucherTypeMaster.setPrefixDetailsApplicationForm(updatedVoucherTypeMaster.getPrefixDetailsApplicationForm());
        voucherTypeMaster.setPrefixDetailsParticulars(updatedVoucherTypeMaster.getPrefixDetailsParticulars());
        voucherTypeMaster.setSuffixDetailsApplicationForm(updatedVoucherTypeMaster.getSuffixDetailsApplicationForm());
        voucherTypeMaster.setSuffixDetailsParticulars(updatedVoucherTypeMaster.getSuffixDetailsParticulars());
        voucherTypeMaster.setPrintingVoucherAfterSaving(updatedVoucherTypeMaster.getPrintingVoucherAfterSaving());
        voucherTypeMaster.setNameOfClass(updatedVoucherTypeMaster.getNameOfClass());

        VoucherTypeMaster voucherTypeMasterObj = voucherTypeMasterRepository.save(voucherTypeMaster);

        return VoucherTypeMasterMapper.mapToVoucherTypeMasterDto(voucherTypeMasterObj);

    }


    @Override
    public void deleteVoucherTypeMaster(String voucherTypeName){

        VoucherTypeMaster voucherTypeMaster = voucherTypeMasterRepository.findById(voucherTypeName).orElseThrow(()->

                new ResourceNotFoundException("Voucher type name is not found with the given name:" + voucherTypeName));

        voucherTypeMasterRepository.deleteById(voucherTypeName);

    }
}
