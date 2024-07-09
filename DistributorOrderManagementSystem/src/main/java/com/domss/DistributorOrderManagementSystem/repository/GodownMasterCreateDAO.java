package com.example.imperio.repository;

import com.example.imperio.entity.GodownMasterCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GodownMasterCreateDAO extends JpaRepository<GodownMasterCreate,String> {

    boolean existsByGodownCode(String godownCode);

}
