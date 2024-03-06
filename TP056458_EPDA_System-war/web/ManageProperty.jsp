<%-- 
    Document   : ManageProperty
    Created on : Aug 11, 2023, 1:19:03 AM
    Author     : dzaky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Property Management</title>
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

        input[type="number"], input[type="text"], select, input[type="textarea"] {
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

        select {
            padding: 8px;
        }

        textarea {
            padding: 10px;
            border: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>Manage Property</h1>
    <button><a href="OwnerHome.jsp">Back</a></button> | <button><a href="AddProperty.jsp">Add Property</a></button>
    <form action="DeleteProperty" method="POST">
        <h3>Remove Listing</h3>
        Enter Listing ID: <input type="number" name="listingID" size="20" required>
        <p><input type="submit" value="Delete"></p>
    </form>
    <form action="UpdateProperty" method="POST">
        <h3>Update A Listing</h3>
        Enter Listing ID: <input type="number" name="listingID" size="20" required>
        <h4>Information to be Updated:</h4>
        <table>
            <tr>
                <td>Property Name:</td>
                <td><input type="text" name="name" size="20"></td>
            </tr>
            <tr>
                <td>Location:</td>
                <td><input type="text" name="location" size="20"></td>
            </tr>
            <tr>
                <td>Type:</td>
                <td><select name="type" id="type">
                        <option value=""></option>
                        <option value="Apartment">Apartment</option>
                        <option value="House">House</option>
                        <option value="Villa">Villa</option>
                        <option value="Condominium">Condominium</option>
                    </select></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><textarea name="description"></textarea></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" size="20"></td>
            </tr>
        </table>
        <p><input type="submit" value="Save"></p>
    </form>
    <form action="EvictTenant" method="POST">
        <h3>Evict a Tenant from Property</h3>
        Enter Listing ID: <input type="number" name="listingID" size="20" required>
        <p><input type="submit" value="Evict"></p>
    </form>
    <form action="ViewOwnProperty" method="POST">
        <h3>View My Property Listings</h3>
        <p><input type="submit" value="View Property"></p>
    </form>
</div>
</body>
</html>

