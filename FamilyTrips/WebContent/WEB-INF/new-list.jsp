<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type ="text" name = "listName"><br />
Trip Date: <input type ="text" name = "month" placeholder="mm" size="4"><input type ="text" name = "day" placeholder="dd" size="4">,<input type ="text" name = "year" placeholder="yyyy" size="4">
Traveler Name: <input type ="text" travelerName = "travelerName"><br />
Available Items : <br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
<option value = "${currentitem.id}">${currentitem.store} | ${currentitem.item}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>