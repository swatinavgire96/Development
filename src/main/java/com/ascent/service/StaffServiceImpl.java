package com.ascent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ascent.entity.Staff_Details;
import com.ascent.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	
	private StaffRepository repository;
	
	public StaffServiceImpl(StaffRepository repository) {
		this.repository = repository;
	}
	

	@Override
	public boolean saveStaff(Staff_Details staff) { 
//		System.out.println(staff.getStaffName());
//		System.out.println(staff.getStaffId());
//		System.out.println(staff.getEmailId());
//		System.out.println(staff.getMobileNo());
		Staff_Details savedObj = repository.save(staff);
		return true;

//	return savedObj.getStaffId() !=null;
	
	}

	@Override
	public List<Staff_Details> getAllStaff() {
		List<Staff_Details> findAll = repository.findAll();
		return findAll;
		
		//return repository.findAll();
	}
	
	
	

	@Override
	public Staff_Details getStaffById(int staffId) {
		
		Staff_Details staff = repository.findById(staffId).get();
		return staff;
		/*if(findById.isPresnet()) {
			Staff staff = findById.get();
			return staff;
		}*/
		
	}

	
	
	@Override
	public boolean deleteStaffById(int staffId) {
		boolean isDeleted = false;
		try{
		repository.deleteById(staffId);
		isDeleted = true;
		}catch(Exception e) {
			e.printStackTrace();
		
		
	}
		return isDeleted;

 }


	@Override
	public boolean saveOrUpdateStaff(Staff_Details staff) {

		getStaffById(staff.getStaffId());
		
		Staff_Details savedObj = repository.save(staff);
		return true;
	}
	
	
}
