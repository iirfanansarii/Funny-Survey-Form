<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<s:url value="/static/survey.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />


</head>

<body>
	<h1 id="title">Girlfriend Funny Survey Form</h1>
	<p id="description">Your Openion Matters ! Give Funy Openion Only !</p>

   <!-- below s:url line is action url line -->

	<s:url value="/survey/registerSurvey" var="registerSurvey"></s:url> 
	<c:if test="${Edit_Survey ne null }">
		<s:url value="/survey/updateSurvey" var="registerSurvey">
			<s:param name="userId" value="${surveyCommand.id }"/>
		</s:url> 
	</c:if>
	
	<!-- model attribute is use to bind form with entity -->
	<f:form id="survey-form" modelAttribute="surveyCommand"
		action="${registerSurvey}" method="post">

		<p>Facebook</p>
		<f:input class="details" path="facebook" type="text" name="facebook"
			placeholder="Enter Your Facebook ID " />
		<br>

		<p>Instagram</p>
		<f:input class="details" path="instagram" type="text" name="instagram"
			placeholder="Enter Your Insatgram ID" />
		<br>

		<p>Age</p>
		<f:input class="details" path="age" type="text" name="user_age"
			placeholder="Enter Your Age" />
		<br>

		<p>Which option best describes your current situation?</p>
		<f:select vid="situation" path="situation">
			<f:option value="In Love">In Love </f:option>
			<f:option value="Broke">Broke</f:option>
			<f:option value="First Time Lover">First Time Lover</f:option>
			<f:option value="First Time Broke">First Time Broke</f:option>
			<f:option value="Not to Say">Not To Say</f:option>
			<f:option value="Its's complecated">It'sComplecated</f:option>
		</f:select>

		<p>Would you recommend Girlfriend to a friend?</p>
		<f:radiobutton name="recomodation" id="yes" path="recomodation"
			value="Definately" />
		<label for="recomodation">Definately</label>
		<br>

		<f:radiobutton name="Maybe" id="no" path="recomodation" value="Maybe" />
		<label for="recomodation">Maybe</label>
		<br>

		<f:radiobutton name="notsure" id="other" path="recomodation"
			value="Not Sure" />
		<label for="recomodation">Not Sure</label>
		<br>

		<p>What is your favorite feature of your Girlfriend?</p>
		<f:select id="feature" path="feature">
			<f:option value="Loving">Loving</f:option>
			<f:option value="Cheating">Cheating</f:option>
			<f:option value="Talking">Talking</f:option>
			<f:option value="Hang-Out">Hang-Out</f:option>
			<f:option value="Open Minded">Open Minded</f:option>
		</f:select>

		<p>What would you like to see improved? (Check all that apply)</p>
		<f:checkbox id="improvement" path="improvement" name="improvement"
			value="Doubt" />
		<label for="improvement">Doubt</label>
		<br>

		<f:checkbox id="improvement" path="improvement" name="improvement"
			value="Talk-Less Habits" />
		<label for="improvement">Talk-Less Habits</label>
		<br>

		<f:checkbox id="improvement" path="improvement" name="improvement"
			value="Others Visualization" />
		<label for="improvement">Others Visualization</label>
		<br>

		<f:checkbox id="improvement" path="improvement" name="challenges"
			value="Challenges" />
		<label for="improvement">Challenges</label>
		<br>

		<f:checkbox id="improvement" path="improvement" name="improvement"
			value="Open Source Community" />
		<label for="improvement">Open Source Community</label>
		<br>


		<p>Any comments or suggestions?</p>

		<f:textarea name="text" id="Suggestions" path="Suggestions" cols="110"
			rows="10" placeholder="Type Your Message Here"></f:textarea>
		<br>
		<br>
		<br>

		<button id="button" name="button">Submit</button>
	</f:form>
</body>
</html>