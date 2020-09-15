package com.irfan.SpringBootWithJpa.Modals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

    
	
	@Entity(name="survey")
	@Table(name="survey")

	public class Survey {
		
		@Id                                             
		@Column(name="user_id")                           // attribute name in database
		@GeneratedValue(strategy=GenerationType.IDENTITY)  // making user_id as primary key
		
		private Long id;
		
		@Column(name="facebook_id")
		private String facebook;
		
		@Column(name="instagram_id")  
		private String instagram;        
		
		
	   @Column(name="age")
		private String age ;
		
		@Column(name="situation")
		private String situation;

		@Column(name="recomodation")
		private String recomodation;
		
		@Column(name="feature")
		private String feature;
		
		@Column(name="improvement")
        private String improvement;	
		
		@Column(name="suggestions")
		private String suggestions;

		

		public String getImprovement() {
			return improvement;
		}



		public void setImprovement(String improvement) {
			this.improvement = improvement;
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getFacebook() {
			return facebook;
		}



		public void setFacebook(String facebook) {
			this.facebook = facebook;
		}



		public String getInstagram() {
			return instagram;
		}



		public void setInstagram(String instagram) {
			this.instagram = instagram;
		}



		public String getAge() {
			return age;
		}



		public void setAge(String age) {
			this.age = age;
		}



		public String getSituation() {
			return situation;
		}



		public void setSituation(String situation) {
			this.situation = situation;
		}



		public String getRecomodation() {
			return recomodation;
		}



		public void setRecomodation(String recomodation) {
			this.recomodation = recomodation;
		}



		public String getFeature() {
			return feature;
		}



		public void setFeature(String feature) {
			this.feature = feature;
		}



		public String getSuggestions() {
			return suggestions;
		}



		public void setSuggestions(String suggestions) {
			this.suggestions = suggestions;
		}



		@Override
		public String toString() {
			return "Survey [id=" + id + ", facebook=" + facebook + ", instagram=" + instagram + ", age=" + age
					+ ", situation=" + situation + ", recomodation=" + recomodation + ", feature=" + feature
					+ ", improvement=" + improvement + ", Suggestions=" + suggestions + "]";
		}

		
		

	}
	
	

