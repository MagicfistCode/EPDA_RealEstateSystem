<%-- 
    Document   : Login
    Created on : Aug 9, 2023, 12:39:10 AM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        #container {
            width: 400px;
            margin: 100px auto;
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

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: none;
            border-radius: 5px;
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
    <h1>Login</h1>
    <form action="Login" method="POST">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <p><input type="submit" value="Login"></p>
    </form>
    <a href="Register.jsp">Don't have an account? Click here to register!</a>
</div>
</body>
</html>

