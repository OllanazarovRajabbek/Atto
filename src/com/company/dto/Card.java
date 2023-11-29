package com.company.dto;

import com.company.status.CardStatus;

import java.time.LocalDateTime;

public class Card {
    private int id;
    private  String number;
    private String ex_date;
    private Double balance;
    private CardStatus status;
    private String phone;
    private LocalDateTime localDateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEx_date() {
        return ex_date;
    }

    public void setEx_date(String ex_date) {
        this.ex_date = ex_date;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
