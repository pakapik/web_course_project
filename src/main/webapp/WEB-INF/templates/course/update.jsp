<%@ page import="entities.Course" %>
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
            <h2>Update course</h2>
        </div>
        <form method="post" action="/course/update" class="w3-selection w3-light-grey w3-padding">
            <table class="w3-table w3-bordered w3-centered">
                <tr class="w3-green">
                    <th>Field</th>
                    <th>Value</th>
                </tr>
                <%Course course = (Course)request.getAttribute("course");
                  out.println("<input type='text' name='Id' value='"+course.getId()+"' hidden>");
                %>
                </td>
                <tr>
                    <td>Name</td>
                    <%
                        out.println("<td><input required name='Name' class='w3-input w3-border w3-round'" +
                                " type='text' value='"+course.getDescription()+"'></td>");
                    %>
                </tr>
                <tr>
                    <td>Subject area</td>
                    <%
                        out.println("<td><input required name='Subject area' " +
                                "class='w3-input w3-border w3-round' type='text' " +
                                "value='"+course.getSubjectArea()+"'></td>");
                    %>
                </tr>
                <tr>
                    <td>Start date</td>
                    <%
                        SimpleDateFormat sdf = Util.getDefaultSimpleDateFormat();
                        out.println("<td><input required type='date' name='Start date' " +
                                "class='w3-input w3-border w3-round' " +
                                "value='"+sdf.format(course.getStartDate())+"'></td>");
                    %>

                </tr>
                <tr>
                    <td>Duration in days</td>
                    <%
                        out.println("<td><input required name='Duration in days'" +
                                " class='w3-input w3-border w3-round' " +
                                "type='text' value='"+course.getDurationInDays()+"'></td>");
                    %>
                </tr>
            </table>
            </br>
            <div style="text-align: center;">
                <button class="w3-btn w3-green w3-hover-teal w3-round-xlarge" style="width:150px" >Save</button>
            </div>
        </form>
    </div>
</div>
<div style="text-align: center;" class="w3-margin">
    <button class="w3-btn w3-green w3-hover-teal w3-round-xlarge"style="width:150px"onclick="location.href='/course/list'">Back</button>
    <button class="w3-btn w3-green w3-hover-teal w3-round-xlarge"style="width:150px"onclick="location.href='/'">To main</button>
</div>
</br>
</body>
</html>













































