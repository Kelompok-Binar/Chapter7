package com.example.challange_chapter_7.Repository;

import com.example.challange_chapter_7.Model.JadwalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalInterface extends JpaRepository<JadwalEntity, Integer> {
    Page<JadwalEntity> findAll(Pageable pageable);
}
