<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<c:if test="${SEARCHED_SURVEY_RESULTS eq null }">
	<table id="table">
		<tr>
			<th>No record found!</th>
		</tr>
	</table>
</c:if>
<c:if test="${SEARCHED_SURVEY_RESULTS ne null }">

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

		<c:forEach items="${SEARCHED_SURVEY_RESULTS }" var="search">
			<tr>
				<td>${search.facebook }</td>
				<td>${search.instagram }</td>
				<td>12</td>
				<td>Broke@example</td>
				<td>Not Selected</td>
				<td>Not Selected</td>
				<td>Not Selected</td>
				<td>example</td>

				<td><button>Update</button></td>
				<td><button>Edit</button></td>
				
				<s:url var="deleteSurvey" value="/delete-survey" >
				<s:param name="userId" value="${search.id}" />
				</s:url>
				<td><a href="${deleteSurvey}">Delete</a></td>
					</tr>


		</c:forEach>
	</table>

</c:if>


