<%--
  Created by IntelliJ IDEA.
  User: raunakraj
  Date: 21/07/23
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Project</title>
</head>
<body>
<div class="container">
<form action="Login" method="post">
    <h4>User form </h4>
    <table>
        <tr>
            <td>Enter the user name </td>
            <td><input type="text" name="userName" placeholder="Enter here"/></td>
        </tr>
        <tr>
            <td>Enter the user password</td>
            <td><input type="password" name="userPassword" placeholder="Enter here"/></td>
        </tr>
        <tr>
            <td>

            </td>

            <td>
                <button type="submit">Register</button>
                <button type="reset">Reset</button>
            </td>
        </tr>
    </table>



    <p>
        <%if(request.getAttribute("invalidUser") != null){%>
            <%=request.getAttribute("invalidUser")%>
        <%}%>
    </p>
</form>
</div>
</body>
</html>
