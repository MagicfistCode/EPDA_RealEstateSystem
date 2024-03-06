<%-- 
    Document   : ManageCustomers
    Created on : Aug 9, 2023, 11:29:20 PM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Manage Customers</title>
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

        h3, h4 {
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

        table {
            width: 100%;
        }

        input[type="text"], input[type="password"], input[type="email"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: none;
            border-radius: 5px;
        }

        input[type="radio"] {
            margin-right: 5px;
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
    <h1>Manage Customers</h1>
    <button><a href="AdminHome.jsp">Back</a></button>
    <form action="DeleteCustomer" method="POST">
        <h3>Delete A Customer</h3>
        Enter Username: <input type="text" name="username" size="20" required>
        <p><input type="submit" value="Delete"></p>
    </form>
    <form action="UpdateCustomer" method="POST">
        <h3>Update Customer Information</h3>
        Enter Customer Username: <input type="text" name="username" size="20">
        <h4>Information to be Updated:</h4>
        <table>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" size="20"></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="name" size="20"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" size="20"></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><input type="radio" name="gender" value="Male">Male
                    <input type="radio" name="gender" value="Female">Female</td>
            </tr>
            <tr>
                <td>Phone No.:</td>
                <td><input type="tel" pattern="[0-9]{10}" name="phone"></td>
            </tr>
            <tr>
                <td>Balance:</td>
                <td><input type="text" name="balance" size="20"></td>
            </tr>
        </table>
        <p><input type="submit" value="Save"></p>
    </form>
    <form action="ViewCustomers" method="POST">
        <h3>View All Customers</h3>
        <p><input type="submit" value="View Customers"></p>
    </form>
</div>
</body>
</html>

