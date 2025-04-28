package com.bony.user_management.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "idNo")
    private Long idNo;

    @Column(name = "phoneNo")
    private Long phoneNo;

    @Column(name = "county")
    private String county;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "created",nullable = false)
    private LocalDateTime created;

    @Column(name = "updated",nullable = false)
    private LocalDateTime updated;

    public User(Object o, String name, Long idNo, Long phoneNo, LocalDate dob, String county, Gender gender) {
    }

    public User(UUID id, String name, Long idNo, Long phoneNo, String county, LocalDate dob, Gender gender, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.idNo = idNo;
        this.phoneNo = phoneNo;
        this.county = county;
        this.dob = dob;
        this.gender = gender;
        this.created = created;
        this.updated = updated;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(idNo, user.idNo) && Objects.equals(phoneNo, user.phoneNo) && Objects.equals(county, user.county) && Objects.equals(dob, user.dob) && gender == user.gender && Objects.equals(created, user.created) && Objects.equals(updated, user.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idNo, phoneNo, county, dob, gender, created, updated);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNo=" + idNo +
                ", phoneNo=" + phoneNo +
                ", county='" + county + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
