<%@ page import="entities.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="utils.Util" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Course Project</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Courses</h2>
        </div>
        <form method="post">
            <input type="hidden" id="hAction" name="action">
            <table class="w3-table w3-bordered w3-centered">
                <tr class="w3-green">
                    <th></th>
                    <th>Name</th>
                    <th>Subject area</th>
                    <th>Start date</th>
                    <th>Duration in days</th>
                </tr>
                <% List<Course> courses = (List<Course>) request.getAttribute("courses");
                    for(Course course : courses) {
                        long id = course.getId();
                        out.println("<tr class='w3-hover-pale-blue'>");
                        out.println("<td><input type='radio' id='number' name='id' value='"+id+"'></td>");
                        out.println("<td>"+course.getDescription()+"</td>");
                        out.println("<td>"+course.getSubjectArea()+"</td>");
                        SimpleDateFormat sdf = Util.getDefaultSimpleDateFormat();
                        out.println("<td>"+sdf.format(course.getStartDate())+"</td>");
                        out.println("<td>"+course.getDurationInDays()+"</td></tr>");
                    }
                %>
            </table>
            </br>
            <div style="text-align: center;">
                <button type="submit" id="update"class="w3-btn w3-green w3-hover-teal w3-round-xlarge" style="width:150px"onclick=buttonClick(this)>Update</button>
                <button type="submit"id="delete"class="w3-btn w3-green w3-hover-teal w3-round-xlarge" style="width:150px"onclick=buttonClick(this)>Delete</button>
            </div>
            </br>
        </form>
    </div>
</div>
<div style="text-align: center;">
    <button class="w3-btn w3-green w3-hover-teal w3-round-xlarge" style="width:150px"onclick="location.href='/course/add'">Add</button>
</div>
</br>
<div style="text-align: center;">
    <button class="w3-btn w3-green w3-hover-teal w3-round-xlarge"style="width:150px"onclick="location.href='/'">To main</button>
</div>
</br>
</body>
<script type="text/javascript">   function buttonClick(x) {        document.getElementById("hAction").value = x.id;        document.forms[0].submit();    }</script>
</html>
























































