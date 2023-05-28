//package com.example.challange_chapter_7.Scheduler;
//
//import com.example.challange_chapter_7.Model.JadwalEntity;
//import com.example.challange_chapter_7.Model.TransactionEntity;
//import com.example.challange_chapter_7.Repository.JadwalInterface;
//import com.example.challange_chapter_7.Repository.TransactionInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.sql.Time;
//import java.util.List;
//
//@Service
//public class ScheduleService {
//    @Autowired
//    TransactionInterface R;
//
////    public Time getJamSelesai(){
////        List<Time> jadwalExsist = R.findAllJamSelesai();
////        if (!jadwalExsist.isEmpty()) {
////            Time jadwal = jadwalExsist.get(1); // Mengambil jadwal pertama atau sesuai logika bisnis Anda
////            return jadwal; // Mengembalikan waktu target (Time)
////        }
////
////        return null;
////    }
//
//    public Time truncateData(){
//
//    }
//
////    public Page<JadwalEntity> getAll(int pageNumber, int pageSize) {
////        Pageable pageable = PageRequest.of(pageNumber, pageSize);
////
////        return R.findAll(pageable);
////    }
//}
