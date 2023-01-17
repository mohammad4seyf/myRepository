package com.example.springbootexample.Repository;

import com.example.springbootexample.Repository.Entity.FactoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FactoryRepository extends JpaRepository<FactoryEntity,Integer> {
}
