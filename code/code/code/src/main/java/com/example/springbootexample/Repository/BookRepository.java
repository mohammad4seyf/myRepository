package com.example.springbootexample.Repository;

import com.example.springbootexample.Repository.Entity.bookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<bookEntity,Integer> {
}
