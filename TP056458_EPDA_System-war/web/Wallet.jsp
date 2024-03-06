<%-- 
    Document   : Wallet
    Created on : Aug 12, 2023, 3:27:15 AM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Account Wallet</title>
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
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
            color: #f0f0f0;
        }

        form {
            margin: 20px auto;
            text-align: left;
            width: 70%;
        }

        input[type="text"] {
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
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #138496;
        }
    </style>
</head>
<body>
<div id="container">
    <form action="ReturnHome" method="POST"><input type=Submit value="Back"></form>
    <h1>Account Wallet</h1>
    <form action="Deposit" method="POST">
        <h3>Deposit</h3>
        Add Deposit Amount: <input type="text" name="amount" size="20" required>
        <input type="submit" value="Deposit">
    </form>
    <form action="Withdraw" method="POST">
        <h3>Withdraw</h3>
        Add Withdraw Amount: <input type="text" name="amount" size="20" required>
        <input type="submit" value="Withdraw">
    </form>
    <form action="ViewBalance" method="POST">
        <h3>View Balance</h3>
        <input type="submit" value="View">
    </form>
</div>
</body>
</html>

