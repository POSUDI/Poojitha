package com.VehicleProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VehicleProject.entity.QueryText;

import com.VehicleProject.service.QueryTextService;

@RestController
public class QueryTextController {
	
	@Autowired
	private QueryTextService querytextService;
	
//	@PostMapping("/querytext/save")
//	public ResponseEntity<QueryText> addQueryText(@RequestBody QueryText querytext)
//	{
//	QueryText newQueryText = querytextService.saveQueryText(querytext);
//	ResponseEntity<QueryText> responseEntity = new ResponseEntity<>(newQueryText,HttpStatus.CREATED);//respentity..refvar
//	return responseEntity;
//	}
	
	 @GetMapping("/querytext/all")
	 public List<QueryText> fetchAllProducts()
	 {
		 List<QueryText> querytextList = querytextService.getAllQueryText();
	
	return querytextList;
	 }
	 
	 @GetMapping("/querytext/find/{qId}")
		public ResponseEntity<Object> fetchUserById(@PathVariable("qId") int querytextId) {
			
			ResponseEntity<Object> responseEntity = null;		
			QueryText querytext = querytextService.getQueryTextById(querytextId);	
			responseEntity = new ResponseEntity<>(querytext,HttpStatus.OK);				
			return responseEntity;
		}
}
