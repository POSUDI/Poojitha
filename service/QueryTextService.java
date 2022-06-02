package com.VehicleProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.VehicleProject.entity.QueryText;


@Service
public interface QueryTextService {
	
	public QueryText saveQueryText(QueryText querytext);
	
	public QueryText getQueryTextById(int querytextId);
	
	public List<QueryText> getAllQueryText();

}
