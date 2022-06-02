package com.VehicleProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VehicleProject.entity.QueryText;
import com.VehicleProject.exception.QueryTextNotFoundException;
import com.VehicleProject.repository.QueryTextRepository;

@Service
public class QueryTextServiceImpl implements QueryTextService
{
	
	@Autowired
	private QueryTextRepository querytextRepository;

	@Override
	public QueryText saveQueryText(QueryText querytext) {
		QueryText savedquerytext = querytextRepository.save(querytext);
				return savedquerytext;
	}

	@Override
	public List<QueryText> getAllQueryText() {
		List<QueryText> queries = querytextRepository.findAll();
		return queries;
	}

	@Override
	public QueryText getQueryTextById(int querytextId) {
		
		Optional<QueryText> optionalQueryText = querytextRepository.findById(querytextId);

		if (optionalQueryText.isEmpty()) {

			throw new QueryTextNotFoundException("querytext Not found with id: " + querytextId);
		}

		QueryText querytext = optionalQueryText.get();
		return querytext;
	
	}
	}
	




