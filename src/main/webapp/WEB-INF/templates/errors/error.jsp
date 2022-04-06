<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>
</head>
<body class='w3-light-grey'>
<div class='w3-container w3-blue-grey w3-opacity w3-right-align'>
    <h1>Course Project</h1>
</div>
<div class='w3-container w3-center w3-margin-bottom w3-padding'>
    <div class='w3-card-4'>
        <div class='w3-container w3-red'>
            <h2>Error</h2>
        </div>
        <p>Something wrong... don't do that again</p>
        <%
            Object error = request.getAttribute("error");
            out.println("<p>"+error+"</p>");
        %>
    </br>
    </div>
</div>
<div style='text-align: center;'>
    <button class='w3-btn w3-green w3-hover-teal w3-round-xlarge' style='width:150px' onclick='location.href="/"'>To main</button>
</div>
</br>
</body>
</html>