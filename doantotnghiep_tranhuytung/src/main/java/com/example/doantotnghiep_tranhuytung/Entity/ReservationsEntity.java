package com.example.doantotnghiep_tranhuytung.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reservations")

public class ReservationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;
    private Timestamp reservationDate;
    private int reservationNumber;
    private String status;
    private Timestamp createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public Timestamp getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
