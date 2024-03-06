<%-- 
    Document   : ViewProfile
    Created on : Aug 10, 2023, 1:14:36 AM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <style>
            body {
                background-color: #f0f0f0;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            #container {
                width: 800px;
                margin: 50px auto;
                padding: 20px;
                background-color: #233240;
                border-radius: 10px;
                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
                color: white;
                text-align: center;
            }

            h1 {
                margin-bottom: 20px;
                color: #f0f0f0;
            }

            button {
                background-color: #17a2b8;
                color: white;
                border: none;
                border-radius: 5px;
                padding: 10px 20px;
                cursor: pointer;
                transition: background-color 0.3s;
                display: block;
                margin: 20px auto;
                text-align: center;
            }

            button:hover {
                background-color: #138496;
            }
            table {
                width: 100%;
            }
            a {
                color: #f0f0f0;
                text-decoration: none;
                transition: color 0.3s;
            }

            a:hover {
                color: #17a2b8;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <h1>Your Profile</h1>
            <button><a href="ReturnHome">Back</a></button><button><a href='EditProfile.jsp'>Edit Profile</a></button><br><br>
        </div>
    </body>
</html>

