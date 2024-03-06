<%-- 
    Document   : AdminSaleHistory
    Created on : Aug 12, 2023, 6:46:27 PM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users Sale History</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        #container {
            width: 1000px;
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
        
        h3 {
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
            text-align: center;
        }

        button a {
            color: white;
            text-decoration: none;
            transition: color 0.3s;
        }

        button:hover, button a:hover {
            background-color: #138496;
            color: #fff;
        }

        form {
            margin: 20px auto;
            text-align: left;
            width: 70%;
        }

        input[type="submit"] {
            background-color: #17a2b8;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>All Users Sale History</h1>
    <form action="ReturnHome" method="POST"><input type="Submit" value="Back"></form>
    <form action="ViewUserSaleHistory" method="POST">
        <h3>View All Users Sale History</h3>
        <p><input type="submit" value="View History"></p>
    </form>
</div>
</body>
</html>

