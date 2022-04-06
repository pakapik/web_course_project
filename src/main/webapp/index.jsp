<%@ page import="htmlBuilders.IndexBuilder" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Course Project</title>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
  <h1>Course Project</h1>
</div>

<div class="w3-container w3-center">
  <%
    // discount course lesson userbase userstudent userteacher lessonMeeting userteacher_course price
    out.println(IndexBuilder.build("Discount"));
    out.println(IndexBuilder.build("Course"));
    out.println(IndexBuilder.build("Lesson"));
    out.println(IndexBuilder.build("Student"));
    out.println(IndexBuilder.build("Teacher"));
    out.println(IndexBuilder.build("LessonMeeting"));
    out.println(IndexBuilder.build("TeacherCourse"));
    out.println(IndexBuilder.build("Price"));
  %>
</div>
</body>
</html>