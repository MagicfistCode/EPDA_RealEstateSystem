<%-- 
    Document   : AddStaff
    Created on : Aug 10, 2023, 7:40:42 PM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Staff</title>
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

        button a {
            color: white;
            text-decoration: none;
            transition: color 0.3s;
        }

        button:hover, button a:hover {
            background-color: #138496;
            color: #fff;
        }

        table {
            margin: 0 auto;
            width: 70%;
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
    <h1>Add Staff</h1>
    <form action="AddStaff" method="POST">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" size="20" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" size="20" required></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="name" size="20" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" size="20" required></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td><input type="radio" name="gender" value="Male" required>Male
                    <input type="radio" name="gender" value="Female" required>Female</td>
            </tr>
            <tr>
                <td>Phone No.:</td>
                <td><input type="tel" pattern="[0-9]{10}" name="phone" required></td>
            </tr>
        </table>
        <p><input type="submit" value="Add Staff"></p>
    </form>
    <button><a href="ManageStaff.jsp">Back</a></button>
</div>
</body>
</html>

