package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entities.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

}
