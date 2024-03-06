<%-- 
    Document   : CustomerSaleHistory
    Created on : Aug 12, 2023, 5:36:33 PM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Sale History</title>
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

        form {
            margin: 20px auto;
            text-align: left;
            width: 70%;
        }

        input[type="number"],
        select,
        input[type="textarea"] {
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
    <h1>Sale History</h1>
    <form action="RateReviewSale" method="POST">
        <h3>Add a Rating & Feedback</h3>
        Enter Sale ID: <input type="number" name="saleID" size="20" required>
        <table>
            <tr>
                <td>Sale Rating (1 to 5): </td>
                <td>
                    <select name="rating" id="rating">
                        <option value=""></option>
                        <option value=1>1</option>
                        <option value=2>2</option>
                        <option value=3>3</option>
                        <option value=4>4</option>
                        <option value=5>5</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Sale Feedback: </td>
                <td><input type="textarea" name="feedback" size="20"></td>
            </tr>
        </table>
        <p><input type="submit" value="Save"></p>
    </form>
    <form action="ViewUserSaleHistory" method="POST">
        <h3>View My Sale History</h3>
        <p><input type="submit" value="View History"></p>
    </form>
</div>
</body>
</html>
