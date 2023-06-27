<%--page directives --%>
<%@page contentType="text/html; ISO-8859-1" %>
<%@page import="java.util.Random,java.util.ArrayList" %>
<%@page isErrorPage="true" %>
<%@page session="false" %>
<%--<%@page extends="" %>--%>

<html>
<head>
    <title>form</title>

</head>
<body>

<%--include directive--%>
<%@include file="header.jsp"%>

<div class="container" style="width:60%;margin-left:auto">
    <h1>My Form</h1>
    <form action="RegisterServlet" method="post">
        <table>
            <tr>
                <td>Enter your name :</td>
                <td><input name="name" type="text" placeholder="enter your name"/></td>
            </tr>
            <tr>
                <td>Enter your email :</td>
                <td><input name="email" type="email" placeholder="enter your email"/></td>
            </tr>
            <tr>
                <td>Enter your password :</td>
                <td><input name="password" type="password" placeholder="enter your password"/></td>
            </tr>
            <tr>
                <td>Select Gender :</td>
                <td><input name="gender" type="radio" value="male"/>Male &nbsp&nbsp&nbsp
                    <input name="gender" type="radio" value="female"/>Female
                </td>
            </tr>
            <tr>
                <td>Select Your Course :</td>
                <td>
                    <select name="course">
                        <option value="java">Java</option>
                        <option value="php">php</option>
                        <option value="js">js</option>
                        <option value="c#">c#</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="checkbox" value="checked" name="condition"/></td>
                <td>Agree Terms And Condition</td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Register</button>
                    <button type="reset">Reset</button>
                </td>
            </tr>
        </table>
    </form>

    <%-- declarative tag --%>
    <%!
        int var1 = 100;
        int var2 = 200;

        public int sum() {
            return var1 + var2;
        }

    %>
    <h1> sum = <% out.println(sum()); %></h1> <%--     scriplet tag --%>
    <h1> sum = <%= sum()%>
    </h1> <%-- expression tag --%>
</div>
</body>
</html>
