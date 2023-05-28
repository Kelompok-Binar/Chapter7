package com.example.challange_chapter_7.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "seats")
@Getter
@Setter
public class SeatsEntity {
    @Id
    private int nomor_kursi;

}
