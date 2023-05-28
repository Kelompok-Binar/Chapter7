package com.example.challange_chapter_7.Repository;

import com.example.challange_chapter_7.Model.DataTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DataTransactionInterface extends JpaRepository<DataTransactionEntity, UUID> {
}
