<%-- 
    Document   : AdminHome
    Created on : Aug 9, 2023, 2:04:45 AM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Home</title>
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

        a {
            color: #f0f0f0;
            text-decoration: none;
            transition: color 0.3s;
        }

        a:hover {
            color: #17a2b8;
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
        }

        button:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>PropertyAPU: Admin Home Page</h1>
    <a href="ViewProfile">View Profile</a> || <a href="ManageStaff.jsp">Manage Staff</a> || <a href="ManageCustomers.jsp">Manage Customers</a> || <a href="ManageOwners.jsp">Manage Owners</a> || <a href="AdminSaleHistory.jsp">Users Sale History</a>
    <button type="button"><a href="Logout">Logout</a></button>
</div>
</body>
</html>

