package com.example.challange_chapter_7.Repository;

import com.example.challange_chapter_7.Model.SeatsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsInterface extends JpaRepository<SeatsEntity, Integer>{ //masih binggung
    Page<SeatsEntity> findAll(Pageable pageable);
    @Query("SELECT s,t FROM SeatsEntity s JOIN StudioEntity t WHERE t.studio_name = :studio_name AND s.nomor_kursi = :nomor_kursi")
    SeatsEntity getByStudioSeat(@Param("studio_name") char studio_name, @Param("nomor_kursi") int nomor_kursi);
//    @Query("SELECT s FROM SeatsEntity s WHERE s.nomor_kursi =:nomor_kursi")
//    List<SeatsEntity> findBySeat(@Param("nomor_kursi") int nomor_kursi);
}
