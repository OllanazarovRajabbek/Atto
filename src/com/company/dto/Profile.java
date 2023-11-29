package com.company.dto;

import com.company.status.ProfileRole;
import com.company.status.ProfileStatus;

import java.time.LocalDateTime;

public class Profile {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private ProfileStatus status;
    private ProfileRole role;
    private LocalDateTime created_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileRole getRole() {
        return role;
    }

    public void setRole(ProfileRole role) {
        this.role = role;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public ProfileStatus getStatus() {
        return status;
    }

    public void setStatus(ProfileStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", role=" + role +
                ", created_date=" + created_date +
                '}';
    }
}
