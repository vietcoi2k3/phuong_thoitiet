package com.example.weatheradvice.repository;

import com.example.weatheradvice.entity.CodeEntity;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository extends JpaRepository<CodeEntity,Integer> {
    List<CodeEntity> findByCode(String code);
}
