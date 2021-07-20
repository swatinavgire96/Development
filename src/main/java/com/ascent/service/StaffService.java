package com.ascent.service;

import java.util.List;

import com.ascent.entity.Staff_Details;

public interface StaffService {

	public boolean saveStaff(Staff_Details staff);

	public boolean saveOrUpdateStaff(Staff_Details staff);

	// public boolean saveOrUpdateStaff(Integer staffId);
	public List<Staff_Details> getAllStaff();

	public Staff_Details getStaffById(int staffId);

	public boolean deleteStaffById(int staffId);

}
