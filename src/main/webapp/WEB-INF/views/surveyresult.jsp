<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Survey Result</title>
<head>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<s:url value="/static/surveyresult.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />


</head>
<body>
	<h1>Girlfriend! Funny Survey Result</h1>
	<p id="description">Have Fun! Stay Awesome Man</p>
	
	<div class="top-button">
	
	<!-- Go For Survey button   -->
	
		<s:url var="surveyPage" value="/survey"/>
			<a href="${surveyPage}" class="survey"> Go For Survey</a>
		
		<!-- sign up button on survey result page -->
		<s:url var="signupPage" value="/signup"/>
		<a href="${signupPage}" class="survey" >Sign Up</a>
		
		
		<!-- login button on survey result page -->
		<s:url var="loginUser" value="/login-user"/>
		<a href="${loginUser}" class="survey" >Sign In</a>
		
		
	</div>
	<hr>


	<c:choose>
		<c:when test="${SURVEY_RESULT eq null }">

		</c:when>

		<c:otherwise>

			<table id="table">
				<tr>
					<th>Facebook</th>
					<th>Instagram</th>
					<th>Age</th>
					<th>Situation</th>
					<th>Recomodation</th>
					<th>Features</th>
					<th>Improvement</th>
					<th>Suggestion</th>
					<th>Update</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${SURVEY_RESULT}" var="survey">
					<tr>
						<td>${survey.facebook }</td>
						<td>${survey.instagram }</td>
						<td>${survey.age}</td>
						<td>${survey.situation}</td>
						<td>${survey.recomodation}</td>
						<td>${survey.feature}</td>
						<td>${survey.improvement}</td>
						<td>${survey.suggestions}</td>
						<s:url var="surveyUpdate" value="/survey/update-servey">
							<s:param name="surveyId" value="${survey.id }" />
						</s:url>
						<td><button>Update</button></td>
						
						<%-- method for edit survey --%>
						
						<s:url var="editSurvey" value="/edit-survey" >
						<s:param name="userId" value="${survey.id}" />
						</s:url>
						<td><a href="${editSurvey }">Edit</a></td>
						
						
				<%-- value is to map with controller to get called --%>
				<%-- value stores at var i.e variable  --%>
				<%-- s:param is use to get id at variable survey(line 61 ) which is going to use to delete particular value --%>
				<%-- eg: localhost:8080/deleteSurvey?userId=1  ( we got 1 by ${survey.id} ) --%>
				
						<s:url var="deleteSurvey" value="/delete-survey" >
						<s:param name="userId" value="${survey.id}" />
						</s:url>
						<td><a href="${deleteSurvey}">Delete</a></td>
					</tr>
					
					<%--  --%>

				</c:forEach>

			</table>

		</c:otherwise>
	</c:choose>



	<div class="search-button">

		<button id="button" onclick="searchSurvey()">Search</button>
		<input id="search" class="searchSurveyText" type="text" placeholder="Search By Name">

	</div>

	<div class="search-survey-result" style="margin-bottom: 200px"></div>

  <%--***********  below script code is for making **********--%>

   <script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
	<script type="text/javascript">
	
   <%-- ******below ajax code is to set search table on survey result page******* --%>
	
	<s:url var="searchSurvey" value="/search-survey"/>
	function searchSurvey() {
			var searchText = $(".searchSurveyText").val();
			if(searchText !== "") {

				$.ajax({

					url: "${searchSurvey}",
					method: "post",
					data:{searchText: searchText},
					success: function(reponse) {
						$(".search-survey-result").html(reponse);
					},
					error: function(err) {
						$(".search-survey-result").html(err);
					}
					
				});

				
			}

		}
	</script>

</body>
</html>
