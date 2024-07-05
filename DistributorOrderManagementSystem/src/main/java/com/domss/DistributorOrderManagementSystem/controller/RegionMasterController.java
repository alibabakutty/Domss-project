package com.domss.DistributorOrderManagementSystem.controller;

import com.domss.DistributorOrderManagementSystem.entity.RegionMaster;
import com.domss.DistributorOrderManagementSystem.service.RegionMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/regionMaster")
    @CrossOrigin(origins = "http://localhost:5173")
    public class RegionMasterController {

        @Autowired
        private RegionMasterService regionMasterService;

        @GetMapping("/getRegion")
        public ResponseEntity<List<RegionMaster>> getRegionMaster() {
            return regionMasterService.getMasterList();
        }
    }
