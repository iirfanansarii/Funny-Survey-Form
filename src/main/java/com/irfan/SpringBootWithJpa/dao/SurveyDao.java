package com.irfan.SpringBootWithJpa.dao;

import java.util.List;

import com.irfan.SpringBootWithJpa.Modals.Survey;


public interface SurveyDao {
	
public Survey addSurvey(Survey s);
	
	
public List<Survey> surveyResult();

// At below code we are storing search value on serchText variable 

public List<Survey> surveySearch(String searchText);

//below we are writing code to delete survey data through its primary key which is user_id of Long type
boolean deleteSurvey(Long user_id);

// method for survey edit 

public Survey editSurvey();

public Survey getSurveyById(Long id);

}
