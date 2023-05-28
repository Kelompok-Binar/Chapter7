package com.example.challange_chapter_7.Repository;

import com.example.challange_chapter_7.Model.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportInterface extends JpaRepository<ReportEntity, Integer> {
    @Query("SELECT r FROM ReportEntity r WHERE r.id_report =:id_report")
    List<ReportEntity> findByIdJadwal(@Param("id_report") Integer id_report);
}
