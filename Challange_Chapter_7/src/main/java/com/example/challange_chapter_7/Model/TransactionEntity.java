package com.example.challange_chapter_7.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
@Data
@Table(name = "transaction")
@Getter
@Setter
public class TransactionEntity {
    @Id
    private UUID uid_transaction;
    private int id_user;
    private int id_jadwal;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String film_name;
    private String film_code;
    private int nomor_kursi;
    private char studio_name;
    @JsonIgnore
    private Date tanggal_tayang;
    @JsonIgnore
    private Time jam_mulai;
    @JsonIgnore
    private Time jam_selesai;
    @JsonIgnore
    private int harga_tiket;
}
