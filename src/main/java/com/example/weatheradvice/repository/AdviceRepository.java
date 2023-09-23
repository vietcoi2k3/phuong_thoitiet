package com.example.weatheradvice.repository;

import com.example.weatheradvice.entity.AdviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends JpaRepository<AdviceEntity,Integer> {
}
