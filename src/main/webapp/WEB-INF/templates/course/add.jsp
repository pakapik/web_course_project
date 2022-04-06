<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Course</title>
    <link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>
    <script src="../webapp/WEB-INF/scripts.js"></script>
</head>
<body class='w3-light-grey'>
<div class='w3-container w3-blue-grey w3-opacity w3-right-align'>
    <h1>Course Project</h1>
</div>
<div class='w3-container w3-center w3-margin-bottom w3-padding'>
    <div class='w3-card-4'>
        <div class='w3-container w3-light-blue'>
            <h2>Adding course</h2>
        </div>
        <form method='post' class='w3-selection w3-light-grey w3-padding'>
            <table class='w3-table w3-bordered w3-centered'>
                <tr class='w3-green'>
                    <th>Field</th>
                    <th>Value</th>
                </tr>
                <tr class='w3-hover-pale-blue'>
                    <td>Name</td>
                    <td><input required name='Name' class='w3-input w3-border w3-round' type='text'/></td>
                </tr>
                <tr class='w3-hover-pale-blue'>
                    <td>Subject area</td>
                    <td><input required name='Subject area' class='w3-input w3-border w3-round' type='text'/></td>
                </tr>
                <tr class='w3-hover-pale-blue'>
                    <td>Start date</td>
                    <td><input required type='date' name='Start date'class='w3-input w3-border w3-round'></td>
                </tr>
                <tr class='w3-hover-pale-blue'>
                    <td>Duration in days</td>
                    <td><input required name='Duration in days' class='w3-input w3-border w3-round' type='text'/></td>
                </tr>
            </table>
            </br>
            <div style='text-align: center;'>
                <button type ='submit' class='w3-btn w3-green w3-hover-teal w3-round-xlarge' style='width:150px'>Save</button>
            </div>
        </form>
    </div></div>
<div style='text-align: center;'>
    <button class='w3-btn w3-green w3-hover-teal w3-round-xlarge' style='width:150px' onclick='location.href="/course/list"'>Back</button>
    <button class='w3-btn w3-green w3-hover-teal w3-round-xlarge' style='width:150px' onclick='location.href="/"'>To main</button>
</div>
</br>
</body>
</html>













































