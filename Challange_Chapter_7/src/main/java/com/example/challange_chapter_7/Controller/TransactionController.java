package com.example.challange_chapter_7.Controller;


import com.example.challange_chapter_7.Model.*;
import com.example.challange_chapter_7.Response.CommonResponse;
import com.example.challange_chapter_7.Response.CommonResponseGenerator;
import com.example.challange_chapter_7.Service.DataTransactionService;
import com.example.challange_chapter_7.Service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
//@RestController
//@RequestMapping(value ="/Transaction")
//@Api(value = "Transaction")
//public class TransactionController {
//    @Autowired
//    TransactionService transactionService;
//    @Autowired
//    DataTransactionService dataTransactionService;
//    @Autowired
//    CommonResponseGenerator crg;
//
//    @PostMapping(value = "/Buy")
//    @Operation(description = "Membeli Tiket")
//    @PreAuthorize("hasAuthority('ROLE_USERS')")
//    public CommonResponse<TransactionEntity> Buy(@RequestBody TransactionEntity transaction){
//        try {
//            TransactionEntity buyTransaction = transactionService.buyTicket(transaction);
//            DataTransactionEntity dataTransaction = transaction;
//            DataTransactionEntity saveTransaction = dataTransactionService.saveDataTransaction(dataTransaction);
//            //DataTransactionEntity saveTransaction = dataTransactionService.saveDataTransaction(transaction2);
//            log.info(String.valueOf(buyTransaction), "Sukses Menambahkan Data " + saveTransaction.getUid_transaction());
//            return crg.succsesResponse(buyTransaction, "Sukses Menambahkan Data " + saveTransaction.getId_user());
//        }
//        catch (Exception e){
//            log.warn(String.valueOf(e));
//            return crg.failedResponse(e.getMessage());
//        }
//
//    }
//}

@Slf4j
@RestController
@RequestMapping(value = "/Transaction")
@Api(value = "Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    DataTransactionService dataTransactionService;
    @Autowired
    CommonResponseGenerator crg;

    @PostMapping(value = "/Buy")
    @Operation(description = "Membeli Tiket")
    @PreAuthorize("hasAuthority('ROLE_USERS')")
    public CommonResponse<TransactionEntity> Buy(@RequestBody TransactionEntity transaction) {
        try {
            TransactionEntity buyTransaction = transactionService.buyTicket(transaction);

            // Buat objek DataTransactionEntity baru dan salin nilai-nilai yang relevan dari objek TransactionEntity
            DataTransactionEntity dataTransaction = new DataTransactionEntity();
            dataTransaction.setUid_transaction(buyTransaction.getUid_transaction());

            // Simpan objek DataTransactionEntity
            DataTransactionEntity saveTransaction = dataTransactionService.saveDataTransaction(dataTransaction);

            log.info("Sukses Menambahkan Data " + saveTransaction.getUid_transaction());
            return crg.succsesResponse(buyTransaction, "Sukses Menambahkan Data " + saveTransaction.getId_user());
        } catch (Exception e) {
            log.warn(String.valueOf(e));
            return crg.failedResponse(e.getMessage());
        }
    }
}