package com.domss.DistributorOrderManagementSystem.service;

import com.domss.DistributorOrderManagementSystem.entity.RegionMaster;
import com.domss.DistributorOrderManagementSystem.repository.RegionMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionMasterService {

    @Autowired
    private RegionMasterRepository regionMasterRepository;


    public ResponseEntity<List<RegionMaster>> getMasterList() {
        try {
            return new ResponseEntity<>(regionMasterRepository.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
