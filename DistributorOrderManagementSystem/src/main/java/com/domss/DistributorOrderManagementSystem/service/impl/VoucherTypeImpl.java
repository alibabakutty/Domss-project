package com.example.imperio.service.impl;

import com.example.imperio.dto.VoucherTypeCreateDto;
import com.example.imperio.entity.VoucherTypeCreate;
import com.example.imperio.exception.ResourceNotFoundException;
import com.example.imperio.mapper.VoucherTypeMapper;
import com.example.imperio.repository.VoucherTypeDAO;
import com.example.imperio.service.VoucherTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoucherTypeImpl implements VoucherTypeService {

    @Autowired
    private VoucherTypeDAO voucherTypeDAO;

    @Override
    public VoucherTypeCreateDto createVoucherType(VoucherTypeCreateDto voucherTypeCreateDto){

        // Validate voucher type object
        validateVoucher(new VoucherTypeCreateDto());

        // check for duplicate entry
        if(voucherTypeDAO.existsByVoucherType(voucherTypeCreateDto.getVoucherType())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + voucherTypeCreateDto.getVoucherType());
        }

        VoucherTypeCreate voucherTypeCreate = VoucherTypeMapper.mapToVoucherTypeMasterCreate(voucherTypeCreateDto);

        VoucherTypeCreate savedVoucherTypeCreate = voucherTypeDAO.save(voucherTypeCreate);

        return VoucherTypeMapper.mapToVoucherTypeMasterCreateDto(savedVoucherTypeCreate);

    }

    private void validateVoucher(VoucherTypeCreateDto voucherTypeCreateDto){

        if(voucherTypeCreateDto.getVoucherType() == null || voucherTypeCreateDto.getVoucherType().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }

    @Override
    public VoucherTypeCreateDto getVoucherType(String voucherType){

        VoucherTypeCreate voucherTypeCreate = voucherTypeDAO.findById(voucherType).orElseThrow(() ->

                new ResourceNotFoundException("Voucher Type is not found with this name:" + voucherType));

        return VoucherTypeMapper.mapToVoucherTypeMasterCreateDto(voucherTypeCreate);
    }

    @Override
    public List<VoucherTypeCreateDto> getAllVoucherTypes(){

        List<VoucherTypeCreate> voucherTypeCreate = voucherTypeDAO.findAll();

        return voucherTypeCreate.stream().map(VoucherTypeMapper::mapToVoucherTypeMasterCreateDto).toList();
    }

    @Override
    public void deleteVoucherType(String voucherType){
        VoucherTypeCreate voucherTypeCreate = voucherTypeDAO.findById(voucherType).orElseThrow(()->

                new ResourceNotFoundException("Voucher Type is not found with this name:" + voucherType));

        voucherTypeDAO.deleteById(voucherType);
    }
}
