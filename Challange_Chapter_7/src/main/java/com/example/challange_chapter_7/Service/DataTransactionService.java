package com.example.challange_chapter_7.Service;

import com.example.challange_chapter_7.Model.DataTransactionEntity;
import com.example.challange_chapter_7.Model.TransactionEntity;
import com.example.challange_chapter_7.Repository.DataTransactionInterface;
import com.example.challange_chapter_7.Repository.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataTransactionService {
    @Autowired
    DataTransactionInterface dataTransactionInterface;
    @Autowired
    TransactionInterface transactionInterface;

    public DataTransactionEntity saveDataTransaction(DataTransactionEntity dataTransactionEntity){
        TransactionEntity transaction = transactionInterface.getReferenceById(dataTransactionEntity.getUid_transaction());
        DataTransactionEntity transactionData = new DataTransactionEntity();
        transactionData.setUid_transaction(transaction.getUid_transaction()); // Menetapkan ID dari TransactionEntity

        transactionData.setFilm_code(transaction.getFilm_code());
        transactionData.setId_user(transaction.getId_user());
        transactionData.setId_jadwal(transaction.getId_jadwal());
        transactionData.setHarga_tiket(transaction.getHarga_tiket());
        transactionData.setTanggal_tayang(transaction.getTanggal_tayang());
        transactionData.setFilm_name(transaction.getFilm_name());

        return dataTransactionInterface.save(transactionData);
    }
}


//@Service
//public class DataTransactionService {
//    @Autowired
//    DataTransactionInterface dataTransactionInterface;
//    @Autowired
//    TransactionInterface transactionInterface;
//
//    public DataTransactionEntity saveDataTransaction(DataTransactionEntity dataTransactionEntity){
//        DataTransactionEntity transactionData = new DataTransactionEntity();
//        transactionData.setUid_transaction(dataTransactionEntity.getUid_transaction());
//
//        // Mengambil data TransactionEntity berdasarkan ID
//        TransactionEntity transaction = transactionInterface.findById(dataTransactionEntity.getUid_transaction()).orElse(null);
//        if (transaction != null) {
//            transactionData.setFilm_code(transaction.getFilm_code());
//            transactionData.setId_user(transaction.getId_user());
//            transactionData.setId_jadwal(transaction.getId_jadwal());
//            transactionData.setHarga_tiket(transaction.getHarga_tiket());
//            transactionData.setTanggal_tayang(transaction.getTanggal_tayang());
//            transactionData.setFilm_name(transaction.getFilm_name());
//        }
//
//        return dataTransactionInterface.save(transactionData);
//    }
//}

//@Service
//public class DataTransactionService {
//    @Autowired
//    DataTransactionInterface dataTransactionInterface;
//    @Autowired
//    TransactionInterface transactionInterface;
//
//    public DataTransactionEntity saveDataTransaction(DataTransactionEntity dataTransactionEntity){
//        TransactionEntity transaction = transactionInterface.getReferenceById(dataTransactionEntity.getUid_transaction());
//
//        //TransactionEntity transactionExist = transactionInterface.findById(transaction.getUid_transaction()).orElse(null);
//        DataTransactionEntity transactionData = new DataTransactionEntity();
//        DataTransactionEntity transactionExist = dataTransactionInterface.findById(dataTransactionEntity.getUid_transaction()).orElse(null);
//        if (transactionExist == null) {
//            transactionExist = new DataTransactionEntity();
//            transactionExist.setUid_transaction(transaction.getUid_transaction());
//            //transactionData.setUid_transaction(transactionExist.getUid_transaction()); // Menetapkan UUID baru
//            //System.out.println(transactionData);
//
//            transactionData.setFilm_code(transaction.getFilm_code());
//            transactionData.setId_user(transaction.getId_user());
//            transactionData.setId_jadwal(transaction.getId_jadwal());
//            transactionData.setHarga_tiket(transaction.getHarga_tiket());
//            transactionData.setTanggal_tayang(transaction.getTanggal_tayang());
//            transactionData.setFilm_name(transaction.getFilm_name());
//
//
//        }
//        return dataTransactionInterface.save(transactionData);
//    }
//}



//@Service
//public class DataTransactionService {
//    @Autowired
//    DataTransactionInterface dataTransactionInterface;
//    @Autowired
//    TransactionInterface transactionInterface;
//
//    public DataTransactionEntity saveDataTransaction() {
//        // Mendapatkan data dari database atau sumber data lainnya
//        TransactionEntity transaction = transactionInterface.getReferenceById(/* ID transaksi yang diinginkan */);
//
//        // Membuat objek DataTransactionEntity baru
//        DataTransactionEntity dataTransactionEntity = new DataTransactionEntity();
//
//        // Menetapkan nilai properti dari objek TransactionEntity ke objek DataTransactionEntity
//        dataTransactionEntity.setUid_transaction(transaction.getUid_transaction());
//        dataTransactionEntity.setFilm_code(transaction.getFilm_code());
//        dataTransactionEntity.setId_user(transaction.getId_user());
//        dataTransactionEntity.setId_jadwal(transaction.getId_jadwal());
//        dataTransactionEntity.setHarga_tiket(transaction.getHarga_tiket());
//        dataTransactionEntity.setTanggal_tayang(transaction.getTanggal_tayang());
//        dataTransactionEntity.setFilm_name(transaction.getFilm_name());
//
//        // Menyimpan objek DataTransactionEntity ke database
//        return dataTransactionInterface.save(dataTransactionEntity);
//    }
//}

//@Service
//public class DataTransactionService {
//    @Autowired
//    DataTransactionInterface dataTransactionInterface;
//    @Autowired
//    TransactionInterface transactionInterface;
//    public List<DataTransactionEntity> saveDataTransaction(List<TransactionEntity> transactions) {
//        List<DataTransactionEntity> dataTransactions = new ArrayList<>();
//
//        for (TransactionEntity transaction : transactions) {
//            DataTransactionEntity dataTransaction = new DataTransactionEntity();
//
//            // Menetapkan nilai properti dari objek TransactionEntity ke objek DataTransactionEntity
//            dataTransaction.setUid_transaction(transaction.getUid_transaction());
//            dataTransaction.setFilm_code(transaction.getFilm_code());
//            dataTransaction.setId_user(transaction.getId_user());
//            dataTransaction.setId_jadwal(transaction.getId_jadwal());
//            dataTransaction.setHarga_tiket(transaction.getHarga_tiket());
//            dataTransaction.setTanggal_tayang(transaction.getTanggal_tayang());
//            dataTransaction.setFilm_name(transaction.getFilm_name());
//
//            dataTransactions.add(dataTransaction);
//
//        }
//
//        // Menyimpan semua objek DataTransactionEntity ke database
//        return dataTransactionInterface.saveAll(dataTransactions);
//
//    }
//}