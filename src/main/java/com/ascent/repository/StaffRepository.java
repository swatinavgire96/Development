package com.ascent.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ascent.entity.Staff_Details;


public interface StaffRepository extends JpaRepository<Staff_Details, Serializable> {

}
