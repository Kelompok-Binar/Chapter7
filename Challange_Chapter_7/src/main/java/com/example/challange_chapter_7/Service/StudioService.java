package com.example.challange_chapter_7.Service;

import com.example.challange_chapter_7.Model.StudioEntity;
import com.example.challange_chapter_7.Repository.StudioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudioService {
    @Autowired
    StudioInterface R;


    public Page<StudioEntity> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return R.findAll(pageable);
    }

//    public StudioEntity getByStudio(char studio, int seats){
//        return R.getByStudio(studio,seats);
//    }
}
