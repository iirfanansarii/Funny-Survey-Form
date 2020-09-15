package com.irfan.SpringBootWithJpa.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.irfan.SpringBootWithJpa.Modals.Survey;

public interface SurveyRepository  extends JpaRepository<Survey, Long>{
	
	// below is customize query to find many data form survey table
	
	@Query(value = 
			"SELECT s FROM survey s WHERE facebook_id LIKE %:searchText% "
			+ " OR instagram_id LIKE %:searchText%  OR age LIKE %:searchText% OR feature LIKE %:searchText% OR recomodation LIKE %:searchText% "
			+ "OR situation LIKE %:searchText%" )
	List<Survey> searchServey(@Param("searchText") String searchText);
	
}
