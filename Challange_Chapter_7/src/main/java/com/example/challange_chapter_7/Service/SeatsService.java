package com.example.challange_chapter_7.Service;

import com.example.challange_chapter_7.Model.SeatsEntity;
import com.example.challange_chapter_7.Repository.SeatsInterface;
import com.example.challange_chapter_7.Repository.StudioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SeatsService {
    @Autowired
    SeatsInterface R;
    @Autowired
    StudioInterface R1;
    public Page<SeatsEntity> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return R.findAll(pageable);
    }

    public SeatsEntity getByStudioSeats(char studio, int seats) {
        return R.getByStudioSeat(studio,seats);
        //return R1.getByStudioSeat(studio,seats);
    }

//    public List<SeatsEntity> getByStudioSeat(int nomorKursi) {
//        return si.findBySeat(nomorKursi);
//    }


}
