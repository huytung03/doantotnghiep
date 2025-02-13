package com.example.doantotnghiep_tranhuytung.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Revenue")
public class RevenueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp createdAt;
    private int totaloders;
    private int getTotalRevenue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getTotaloders() {
        return totaloders;
    }

    public void setTotaloders(int totaloders) {
        this.totaloders = totaloders;
    }

    public int getGetTotalRevenue() {
        return getTotalRevenue;
    }

    public void setGetTotalRevenue(int getTotalRevenue) {
        this.getTotalRevenue = getTotalRevenue;
    }
}
