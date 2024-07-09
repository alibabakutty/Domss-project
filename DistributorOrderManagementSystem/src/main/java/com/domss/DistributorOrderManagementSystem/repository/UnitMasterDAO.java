package com.example.imperio.repository;

import com.example.imperio.entity.UnitMasterCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMasterDAO extends JpaRepository<UnitMasterCreate,String> {

    boolean existsByProductUom(String productUom);
}
