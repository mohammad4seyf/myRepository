package com.example.springbootexample.Repository;

import com.example.springbootexample.Repository.Entity.FsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FsRepository extends JpaRepository<FsEntity,Integer> {
}
