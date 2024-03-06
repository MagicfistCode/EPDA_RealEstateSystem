<%-- 
    Document   : Register
    Created on : Aug 9, 2023, 12:24:45 AM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        #container {
            width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #233240;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            color: white;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #f0f0f0;
        }

        form {
            text-align: center;
        }

        table {
            margin: 0 auto;
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
        }

        input[type="submit"]:hover {
            background-color: #138496;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #f0f0f0;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>Register</h1>
    <form action="Register" method="POST">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required></td>
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
            <tr>
                <td>Balance:</td>
                <td><input type="text" name="balance" required></td>
            </tr>
            <tr>
                <td>User Role:</td>
                <td><input type="radio" name="userrole" value="Owner" required>Owner
                    <input type="radio" name="userrole" value="Customer" required>Customer</td>
            </tr>
        </table>
        <p><input type="submit" value="Register"></p>
    </form>
    <a href="Login.jsp">Already have an account? Click here to login!</a>
</div>
</body>
</html>

