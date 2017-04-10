<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="header.jsp"/>


<!-- Embed your GitHub calendar. -->
<script src="${pageContext.request.contextPath }/resources/js/github-calendar.min.js"> </script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/github-calendar.css"/>
<div class="calendar">
    Loading the data just for you.
</div>

<script>
    GitHubCalendar(".calendar", "yrojha4ever");
</script>

<!-- GoogleMap for Nepal -->
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3054906.032253146!2d82.31158460325668!3d28.478945808165218!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3995e8c77d2e68cf%3A0x34a29abcd0cc86de!2sNepal!5e0!3m2!1sen!2snp!4v1491823581126" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>



<c:import url="footer.jsp"/>