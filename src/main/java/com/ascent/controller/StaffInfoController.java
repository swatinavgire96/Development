package com.ascent.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//@RestController
//@CrossOrigin("http://localhost:4200/")
/*public class StaffInfoController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
}
*/

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ascent.entity.Staff_Details;
import com.ascent.service.StaffService;

//@Controller
@RestController
@CrossOrigin("http://localhost:4200")
public class StaffInfoController {
	
	private StaffService service;
	
	//private StaffProperties props;
	@Autowired
	public StaffInfoController(StaffService service) {
		this.service =service;
		//this.props = props;
	}
	
	
//	@GetMapping("/load-form")
	public  String loadForm(Model model) {
		Staff_Details cobj = new Staff_Details();
		
		//sending data from controller to ui
		model.addAttribute("staff", cobj);
		
		//returning logical view name 
		return "staff";
	}

	
	@PostMapping("/saveStaff")
	public ResponseEntity<Map<String,Object>> handleSubmitBtn(@RequestBody Staff_Details staff) {
		boolean isSaved = service.saveStaff(staff);
		System.out.println("added"+isSaved);
		//Map<String,Object> messages = new HashMap<String,Object>();
		Map<String,Object> messages =  new HashMap<String, Object>();
		if(isSaved) {
			messages.put("result", "staff added successfully");
			//model.addAttribute("succMsg", "StaffDetails Svaed");
		}else {
			messages.put("result", "Fail to Save StaffDetails");
			//model.addAttribute("FaiMsg", "Fail to Save StaffDetails");
		}
		
		return new ResponseEntity<Map<String, Object>> (messages, HttpStatus.OK);
	}
			
	
	
	@GetMapping("/view-staff")
	public List<Staff_Details> handleViewsStaffHyperlink(Model model) {
		
		List<Staff_Details> allStaff =service.getAllStaff();
		
	    model.addAttribute("staff", allStaff);
	    
	return allStaff ;
	}
	
	
	
	@GetMapping("/getStaffById/{id}")
	public ResponseEntity<Staff_Details> getStaffById(@PathVariable("id") int satffId) {
		
		
		Staff_Details staff_Details = service.getStaffById(satffId);

		return new ResponseEntity<Staff_Details>(staff_Details,HttpStatus.OK);
	}
	

	@PutMapping("/edit")
	public ResponseEntity<Staff_Details> editStaff(@RequestBody Staff_Details staffObj) {
		service.saveOrUpdateStaff(staffObj);
		return new ResponseEntity<Staff_Details>(staffObj,HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStaff(@PathVariable("id") int satffId) {
		boolean isDeleted = service.deleteStaffById(satffId);

      String result=null;
if (isDeleted) {
	result="staff whos id "+satffId+" deleted"; 
	} else {
		result="error while deleting staff";
	}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	
}
