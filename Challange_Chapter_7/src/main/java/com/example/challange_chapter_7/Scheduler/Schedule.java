package com.example.challange_chapter_7.Scheduler;

import com.example.challange_chapter_7.Model.DataTransactionEntity;
import com.example.challange_chapter_7.Model.TransactionEntity;
import com.example.challange_chapter_7.Service.DataTransactionService;
import com.example.challange_chapter_7.Service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
//@Slf4j
//@Component
//public class Schedule {
//    //digunakan untuk mengingatkan film yang akan mulai
//    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
//    public void Schedule(){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("Executed at : " +sdf.format(System.currentTimeMillis()));
//        //log.info("Executed at : " +sdf.format(System.currentTimeMillis()));
//    }
//}

@Slf4j
@Component
public class Schedule {
    @Autowired
    TransactionService transactionService;
    @Autowired
    DataTransactionService dataTransactionService;
    @Transactional
    //digunakan untuk mengingatkan film yang akan mulai
    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
    public void Schedule() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String resetData = "17:32:10";
        //String date2String = "00:00:00";
        Time currentTime = new Time(System.currentTimeMillis());
        System.out.println(currentTime);

        try {
            java.util.Date reset = sdf.parse(resetData);
            java.util.Date current = sdf.parse(String.valueOf(currentTime));

            // Mengubah tipe data menjadi java.sql.Date
            Date resetDate = new Date(reset.getTime());
            Date currentDate = new Date(current.getTime());
            //date 1 = reset
            //date 2 = current

            // Membandingkan tanggal menggunakan metode compareTo()
            int result = resetDate.compareTo(currentDate);
            if (result < 0) {
                System.out.println("resetDate is before currentDate");
                boolean isBefore = resetDate.before(currentDate);
                System.out.println("Is resetDate before currentDate? " + isBefore);

            } else if (result > 0) {
                System.out.println("resetDate is after currentDate");
                boolean isAfter = resetDate.after(currentDate);
                System.out.println("Is resetDate after currentDate? " + isAfter);

            } else {
                System.out.println("resetDate is equal to currentDate");
                boolean isEqual = resetDate.equals(currentDate);
                System.out.println("Is resetDate equal to currentDate? " + isEqual);
                transactionService.truncate();

            }

            // Membandingkan tanggal menggunakan operasi boolean

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


//        // DateTimeFormatter class Object
//        DateTimeFormatter dtobj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        // Dates
//        String da = "15/03/2022";
//        String db = "15/03/2022";
//        // Parsing the dates
//        LocalDate lda = LocalDate.parse(da, dtobj);
//        LocalDate ldb = LocalDate.parse(db, dtobj);
//        // Printing the dates
//        System.out.println("Date a is " + dtobj.format(lda));
//        System.out.println("Date b is " + dtobj.format(ldb));
//        // Checking for equal case
//        if (lda.isEqual(ldb))
//            System.out.println("Both dates are of same day");
//            // Checking for after case
//        else if (lda.isAfter(ldb))
//            System.out.println("Date a comes after Date b");
//            // Checking for before case
//        else if (lda.isBefore(ldb))
//            System.out.println("Date a comes before Date b");


//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        String now = sdf.format(System.currentTimeMillis());
//        String reset = "00:00:00";
//        Date a = sdf.parse(now);
//        Date b = sdf.parse(reset);
//        System.out.println("Executed at : " +sdf.format(System.currentTimeMillis()));
//        if(now.equals(reset)){
//            System.out.println("Waktu sama");
//        }
//        else if(now.before(reset)){
//
//        }
//        if(sdf.equals(reset)){
//            //scheduleService.truncateData();
//            System.out.println("sama");
//        }
////        else if (sdf >= reset) {
////            System.out.println("sdf lebih besar");
////        }
//        else {
//            System.out.println("reset lebih besar");
//        }
//        log.info("Executed at : " +sdf.format(System.currentTimeMillis()));



//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;

//@Slf4j
//@Component
//public class Schedule {
//    @Autowired
//    ScheduleService scheduleService;
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    // Digunakan untuk mengingatkan film yang akan mulai
//    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
//    public void schedule() {
//        Time currentTime = new Time(); // Mendapatkan waktu saat ini
//
//        // Waktu target yang ingin Anda cocokkan
//        Time targetTime = scheduleService.getJamSelesai();/* Isi dengan waktu target yang diinginkan */;
//
//        // Membandingkan waktu saat ini dengan waktu target menggunakan if statement
//        if (currentTime.before(targetTime)) {
//            log.info("Waktu saat ini sebelum waktu target.");
//        } else if (currentTime.after(targetTime)) {
//            log.info("Waktu saat ini setelah waktu target.");
//        } else {
//            log.info("Waktu saat ini sama dengan waktu target.");
//        }
//    }
//}

//@Slf4j
//@Component
//public class Schedule {
//    @Autowired
//    ScheduleService scheduleService;
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    // Digunakan untuk mengingatkan film yang akan mulai
//    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
//    public void schedule() {
//        Time currentTime = new Time(System.currentTimeMillis()); // Mendapatkan waktu saat ini
//
//        // Waktu target yang ingin Anda cocokkan
//        Time targetTime = (Time) scheduleService.getJamSelesai(); /* Isi dengan waktu target yang diinginkan */;
//
//        // Membandingkan waktu saat ini dengan waktu target menggunakan if statement
//        if (currentTime.before(targetTime)) {
//            log.info("Waktu saat ini sebelum waktu target.");
//        } else if (currentTime.after(targetTime)) {
//            log.info("Waktu saat ini setelah waktu target.");
//        } else {
//            log.info("Waktu saat ini sama dengan waktu target.");
//        }
//    }
//}

//@Slf4j
//@Component
//public class Schedule {
//    @Autowired
//    ScheduleService scheduleService;
//    //private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    // Digunakan untuk mengingatkan film yang akan mulai
//    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
//    public void schedule() {
//        Time currentTime = new Time(System.currentTimeMillis()); // Mendapatkan waktu saat ini
//
//        // Waktu target yang ingin Anda cocokkan
//        Time targetTime = scheduleService.getJamSelesai();
//
//        System.out.println(scheduleService.getJamSelesai());
//        System.out.println(currentTime);
//        // Mengubah waktu saat ini dan waktu target menjadi nilai long
//        long currentTimeMillis = currentTime.getTime();
//        long targetTimeMillis = targetTime.getTime();
//
//        // Membandingkan nilai long waktu saat ini dan waktu target menggunakan if statement
//        if (currentTimeMillis < targetTimeMillis) {
//            log.info("Waktu saat ini sebelum waktu target.");
//            System.out.println("Waktu saat ini sebelum waktu target.");
//        } else if (currentTimeMillis > targetTimeMillis) {
//            log.info("Waktu saat ini setelah waktu target.");
//            System.out.println("Waktu saat ini setelah waktu target.");
//        } else {
//            log.info("Waktu saat ini sama dengan waktu target.");
//            System.out.println("Waktu saat ini sama dengan waktu target.");
//        }
//    }
//}

//    @Autowired
//    ScheduleService scheduleService;
//    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    // Digunakan untuk mengingatkan film yang akan mulai
//    @Scheduled(fixedDelay = 1000, initialDelay = 2000)
//    public void schedule() {
//        Time currentTime = new Time(System.currentTimeMillis()); // Mendapatkan waktu saat ini
//
//        // Waktu target yang ingin Anda cocokkan
//        Time targetTime = scheduleService.getJamSelesai(); /* Isi dengan waktu target yang diinginkan */;
//
//        System.out.println(scheduleService.getJamSelesai());
//        System.out.println(currentTime);
//        // Membandingkan waktu saat ini dengan waktu target menggunakan if statement
//        if (targetTime.before(currentTime)) {
//            log.info("Waktu saat ini sebelum waktu target.");
//            System.out.println("Waktu saat ini sebelum waktu target.");
//        } else if (targetTime.after(currentTime)) {
//            log.info("Waktu saat ini setelah waktu target.");
//            System.out.println("Waktu saat ini setelah waktu target.");
//        } else {
//            log.info("Waktu saat ini sama dengan waktu target.");
//            System.out.println("Waktu saat ini sama dengan waktu target.");
//        }
//    }