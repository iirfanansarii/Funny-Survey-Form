package com.irfan.SpringBootWithJpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irfan.SpringBootWithJpa.Modals.Survey;
import com.irfan.SpringBootWithJpa.Repositories.SurveyRepository;

//import com.irfan.SpringBootWithJpa.Modals.Survey;

//here below line we are implementing SurveyDao class because we're going to write body this class

@Repository
public class SurveyDaoImplementation implements SurveyDao {

	// at below line creating object of repository where our sql methods are
	// presents

	@Autowired
	private SurveyRepository surveyRepo;

	// below we've used surveyRepo to give it value to apply save method

	@Override
	public Survey addSurvey(Survey s) {

		return surveyRepo.save(s);
	}

	@Override
	public List<Survey> surveyResult() {
		return surveyRepo.findAll();
	}

	// below method is to get

	@Override
	public List<Survey> surveySearch(String searchText) {
		return surveyRepo.searchServey(searchText);
	}

	
//	below code is deleteSurvey method implementation where we are giving user_id as a parameter
	
	@Override
	public boolean deleteSurvey(Long user_id) {
		
		surveyRepo.deleteById(user_id);
		return true;
	}

	@Override
	public Survey editSurvey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Survey getSurveyById(Long id) {
		Optional<Survey> s = surveyRepo.findById(id);
		if(s.isPresent()) {
			return s.get();
		}
		return null;
	}

	
	
	
}
