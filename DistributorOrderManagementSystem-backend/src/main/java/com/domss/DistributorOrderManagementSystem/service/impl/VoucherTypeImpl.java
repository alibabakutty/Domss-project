package com.domss.DistributorOrderManagementSystem.service.impl;

import com.domss.DistributorOrderManagementSystem.dto.VoucherTypeDto;
import com.domss.DistributorOrderManagementSystem.entity.VoucherType;
import com.domss.DistributorOrderManagementSystem.exception.ResourceNotFoundException;
import com.domss.DistributorOrderManagementSystem.mapper.VoucherTypeMapper;
import com.domss.DistributorOrderManagementSystem.repository.VoucherTypeRepository;
import com.domss.DistributorOrderManagementSystem.service.VoucherTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoucherTypeImpl implements VoucherTypeService {

    @Autowired
    private VoucherTypeRepository voucherTypeRepository;

    @Override
    public VoucherTypeDto createVoucherType(VoucherTypeDto voucherTypeDto){

        // Validate voucher type object
        validateVoucher(voucherTypeDto);

        // check for duplicate entry
        if(voucherTypeRepository.existsByVoucherType(voucherTypeDto.getVoucherType())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + voucherTypeDto.getVoucherType());
        }

        VoucherType voucherType = VoucherTypeMapper.mapToVoucherType(voucherTypeDto);

        VoucherType savedVoucherType = voucherTypeRepository.save(voucherType);

        return VoucherTypeMapper.mapToVoucherTypeDto(savedVoucherType);

    }

    private void validateVoucher(VoucherTypeDto voucherTypeDto){

        if(voucherTypeDto.getVoucherType() == null || voucherTypeDto.getVoucherType().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty");
        }
    }

    @Override
    public VoucherTypeDto getVoucherType(String voucherType){

        VoucherType voucherTypeCreate = voucherTypeRepository.findByVoucherType(voucherType).orElseThrow(() ->

                new ResourceNotFoundException("Voucher Type is not found with this name:" + voucherType));

        return VoucherTypeMapper.mapToVoucherTypeDto(voucherTypeCreate);
    }

    @Override
    public List<VoucherTypeDto> getAllVoucherTypes(){

        List<VoucherType> voucherType = voucherTypeRepository.findAll();

        return voucherType.stream().map(VoucherTypeMapper::mapToVoucherTypeDto).toList();
    }

    @Override
    public void deleteVoucherType(String voucherType){
        VoucherType voucherTypeCreate = voucherTypeRepository.findByVoucherType(voucherType).orElseThrow(()->

                new ResourceNotFoundException("Voucher Type is not found with this name:" + voucherType));

        voucherTypeRepository.deleteById(Long.valueOf(voucherType));
    }
}
