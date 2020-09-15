package com.irfan.SpringBootWithJpa.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.irfan.SpringBootWithJpa.Modals.Survey;
import com.irfan.SpringBootWithJpa.Modals.User;
import com.irfan.SpringBootWithJpa.dao.SurveyDao;
import com.irfan.SpringBootWithJpa.dao.UserDao;

@Controller
public class MainController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/signup")
	private String signUpPage(Model m) {

		// to bind data with the form

		User obj = new User();
		m.addAttribute("userCommand", obj);

		return "signup";
	}

	// when submit button got clicked

	@RequestMapping(value = "/user/register-user")
	private String registerUser(Model m, @ModelAttribute("userCommand") User user) {

		if (user != null) {
			user.setRegDate(new Date());
			User registeredUser = userDao.registerUser(user);
			if (registeredUser != null) {
				return "redirect:/signup?msg=User registered!";
			}
			return "redirect:/signup?err=User couldn't registered!";
		}
		return "redirect:/signup?msg=Fill the form!";

	}

	// controller for survey page

// below line is implemented because the method to add survey is present in this class
	@Autowired
	private SurveyDao surveyDao;

	// below line to map survey page

	@RequestMapping(value = "/survey")
	private String surveyPage(Model s) {

		// to bind data with form

		Survey obj = new Survey();
		s.addAttribute("surveyCommand", obj);

		return "survey";
	}

	// when submit button got clicked

	// below value is survey page action url
	@RequestMapping(value = "/survey/registerSurvey")
	private String registerSurvey(Model m, @ModelAttribute("surveyCommand") Survey survey) {

		if (survey != null) {
			Survey s = surveyDao.addSurvey(survey);

			if (s == null) {
				return "redirect:/survey?msg=No Data Added";
			}
			return "redirect:/survey?msg=Data Added !";

		}

		return "redirect:/survey?msg=No Data Added";

	}

	// controller for survey result page
	@RequestMapping(value = "/survey-result")
	private String surveyResult(Model m) {
		List<Survey> results = surveyDao.surveyResult();
		if (results.size() == 0)
			m.addAttribute("SURVEY_RESULT", null);
		else
			m.addAttribute("SURVEY_RESULT", results);
		return "surveyresult";

	}

	// update or submit data from survey page

	@RequestMapping(value = "/survey/update-servey")
	private String updateSurvey(@RequestParam("surveyId") Long surveyId) {
	//	System.out.println("------ surveyId : " + surveyId);
		return "";
	}

	// controller for searching survey
	// calling from Ajax on surveyresult.jsp page
	//RequestParam method  is used to pass search text value in url
	
	@RequestMapping(value = "/search-survey")
//	@ResponseBody
	private String surveySearch(Model m, @RequestParam(required = false, value = "searchText") String searchText) {
		//System.out.println("search : " + searchText);

		List<Survey> surveyResults = surveyDao.surveySearch(searchText);
		if (surveyResults.size() == 0)
			m.addAttribute("SEARCHED_SURVEY_RESULTS", null);

		else
			m.addAttribute("SEARCHED_SURVEY_RESULTS", surveyResults);
		return "search-result";

	}

//	controller for login page 
	
	@RequestMapping(value="/login-user")
	private String loginUserPage(Model m) {
		User obj = new User();
		m.addAttribute("userCommand", obj);
		return "login";
	}
	
	// Now when user click Login Button to login
	// i.e when when action url(/user/login-user) would call then loginUser function will perform
	// we have used HttpSession to store user session when he get logged in 
	
	@RequestMapping(value="/user/login-user")
	private String loginUser(@ModelAttribute("userCommand") User cmd, HttpSession session) {
		if(cmd != null) {
			User u = userDao.loginUser(cmd);
			if(u!=null) {
				//setting user in session
				session.setAttribute("USER", u);
				session.setAttribute("USER_ID", u.getId());
				session.setAttribute("USER_NAME", u.getName());
				System.out.println("--------" + u);
				return "redirect:/survey-result" ;
			}
	
		}
		
		return "redirect:/login-user?msg=Retry Again !" ;
	}
	
//	Controller to delete a survey
//	userId is variable to store survey primary key which is user_id
	
	@RequestMapping(value="/delete-survey")
	private String deleteSurvey(@RequestParam("userId")Long sid) {
		if(surveyDao.deleteSurvey(sid)) {
			return "redirect:/survey-result?msg=Deleted !";
		}
		return "redirect:/survey-result?msg=Couldn't Deleted !";
	}
	
//	controller to edit the survey form 
	
	@RequestMapping(value="/edit-survey")
	private String editSurvey(@RequestParam("userId") Long id, Model m) {
	Survey obj = surveyDao.getSurveyById(id);
	if(obj == null) {
		return "redirect:/survey-result?msg=Survey not found";
	}
	
	m.addAttribute("surveyCommand", obj);
	m.addAttribute("Edit_Survey", "Edit_Survey");
	return "survey";
	}
	
//	
	
	@RequestMapping(value="/survey/updateSurvey")
	private String updateSurvey(@ModelAttribute("surveyCommand")Survey s, @RequestParam("userId") Long id) {
		
		if(s != null && id != null) {
			
			s.setId(id);
			Survey survey = surveyDao.addSurvey(s);
			if(survey != null) {
				return "redirect:/survey-result?msg=Updated!";
			}
			
		}
		
		return "redirect:/survey-result?msg=Survey not found";
		
	}
	
	
}
