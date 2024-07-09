package com.example.imperio.service.impl;

import com.example.imperio.dto.VoucherTypeMasterCreateDto;
import com.example.imperio.entity.VoucherTypeMasterCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.VoucherTypeMasterCreateMapper;
import com.example.imperio.repository.VoucherTypeMasterDAO;
import com.example.imperio.service.VoucherTypeMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoucherTypeMasterServiceImpl implements VoucherTypeMasterService {

    @Autowired
    private VoucherTypeMasterDAO voucherTypeMasterDAO;

    @Override
    public VoucherTypeMasterCreateDto createVoucherTypeMaster(VoucherTypeMasterCreateDto voucherTypeMasterCreateDto){

        // validate voucher type name object
        validateVoucherTypeMaster(voucherTypeMasterCreateDto);

        // check for duplicate entry
        if(voucherTypeMasterDAO.existsByVoucherTypeName(voucherTypeMasterCreateDto.getVoucherTypeName())){

            throw new DuplicateKeyException("Duplicate entry for unique field:" + voucherTypeMasterCreateDto.getVoucherTypeName());


        }

        VoucherTypeMasterCreate voucherTypeMasterCreate = VoucherTypeMasterCreateMapper.mapToVoucherTypeMasterCreate(voucherTypeMasterCreateDto);

        VoucherTypeMasterCreate savedVoucherTypeMasterCreate = voucherTypeMasterDAO.save(voucherTypeMasterCreate);

        return VoucherTypeMasterCreateMapper.mapToVoucherTypeMasterCreateDto(savedVoucherTypeMasterCreate);


    }

    private void validateVoucherTypeMaster(VoucherTypeMasterCreateDto voucherTypeMasterCreateDto){

        if(voucherTypeMasterCreateDto.getVoucherTypeName() == null || voucherTypeMasterCreateDto.getVoucherTypeName().isEmpty()){

            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }

    @Override
    public VoucherTypeMasterCreateDto getVoucherTypeName(String voucherTypeName){
        VoucherTypeMasterCreate voucherTypeMasterCreate = voucherTypeMasterDAO.findById(voucherTypeName).orElseThrow(()->

                new ResourceNotFoundException("Voucher type name is not found with this name:" + voucherTypeName));

        return VoucherTypeMasterCreateMapper.mapToVoucherTypeMasterCreateDto(voucherTypeMasterCreate);
    }

    @Override
    public List<VoucherTypeMasterCreateDto> getAllVoucherTypeMasters(){

        List<VoucherTypeMasterCreate> voucherTypeMasterCreate = voucherTypeMasterDAO.findAll();

        return voucherTypeMasterCreate.stream().map(VoucherTypeMasterCreateMapper::mapToVoucherTypeMasterCreateDto).toList();

    }

    @Override
    public VoucherTypeMasterCreateDto updateVoucherTypeMaster(String voucherTypeName, VoucherTypeMasterCreateDto updatedVoucherTypeMaster){


        VoucherTypeMasterCreate voucherTypeMasterCreate = voucherTypeMasterDAO.findById(voucherTypeName).orElseThrow(() ->

                new ResourceNotFoundException("Voucher type name is not found with this name:" + voucherTypeName));

        voucherTypeMasterCreate.setVoucherTypeName(updatedVoucherTypeMaster.getVoucherTypeName());
        voucherTypeMasterCreate.setVoucherType(updatedVoucherTypeMaster.getVoucherType());
        voucherTypeMasterCreate.setMethodOfVoucherNumbering(updatedVoucherTypeMaster.getMethodOfVoucherNumbering());
        voucherTypeMasterCreate.setAlterAdditionalNumberingDetails(updatedVoucherTypeMaster.getAlterAdditionalNumberingDetails());
        voucherTypeMasterCreate.setStartingNumber(updatedVoucherTypeMaster.getStartingNumber());
        voucherTypeMasterCreate.setWidthOfNumericalPart(updatedVoucherTypeMaster.getWidthOfNumericalPart());
        voucherTypeMasterCreate.setPrefillWithZero(updatedVoucherTypeMaster.getPrefillWithZero());
        voucherTypeMasterCreate.setRestartNumberingApplicationForm(updatedVoucherTypeMaster.getRestartNumberingApplicationForm());
        voucherTypeMasterCreate.setRestartNumberingStartingNumber(updatedVoucherTypeMaster.getRestartNumberingStartingNumber());
        voucherTypeMasterCreate.setRestartNumberingPeriodicity(updatedVoucherTypeMaster.getRestartNumberingPeriodicity());
        voucherTypeMasterCreate.setPrefixDetailsApplicationForm(updatedVoucherTypeMaster.getPrefixDetailsApplicationForm());
        voucherTypeMasterCreate.setPrefixDetailsParticulars(updatedVoucherTypeMaster.getPrefixDetailsParticulars());
        voucherTypeMasterCreate.setSuffixDetailsApplicationForm(updatedVoucherTypeMaster.getSuffixDetailsApplicationForm());
        voucherTypeMasterCreate.setSuffixDetailsParticulars(updatedVoucherTypeMaster.getSuffixDetailsParticulars());
        voucherTypeMasterCreate.setPrintingVoucherAfterSaving(updatedVoucherTypeMaster.getPrintingVoucherAfterSaving());
        voucherTypeMasterCreate.setNameOfClass(updatedVoucherTypeMaster.getNameOfClass());

        VoucherTypeMasterCreate voucherTypeMasterCreateObj = voucherTypeMasterDAO.save(voucherTypeMasterCreate);

        return VoucherTypeMasterCreateMapper.mapToVoucherTypeMasterCreateDto(voucherTypeMasterCreateObj);

    }


    @Override
    public void deleteVoucherTypeMaster(String voucherTypeName){

        VoucherTypeMasterCreate voucherTypeMasterCreate = voucherTypeMasterDAO.findById(voucherTypeName).orElseThrow(()->

                new ResourceNotFoundException("Voucher type name is not found with the given name:" + voucherTypeName));

        voucherTypeMasterDAO.deleteById(voucherTypeName);

    }
}
