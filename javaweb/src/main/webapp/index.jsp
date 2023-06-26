<html>
<head>
<title>form</title>

</head>
<body>

<div class="container" style="width:60%;margin-left:auto">
    <h1>My Form</h1>
    <form action="RegisterServlet" method="post">
        <table>
            <tr>
                <td>Enter your name : </td>
                <td><input name="name" type="text" placeholder="enter your name" /></td>
            </tr>
            <tr>
                <td>Enter your email : </td>
                <td><input name="email" type="email" placeholder="enter your email" /></td>
            </tr>
            <tr>
                <td>Enter your password : </td>
                <td><input name="password" type="password" placeholder="enter your password" /></td>
            </tr>
           <tr>
               <td>Select Gender : </td>
               <td><input name="gender" type="radio" value="male"/>Male &nbsp&nbsp&nbsp
               <input name="gender" type="radio" value="female"/>Female</td>
           </tr>
           <tr>
              <td>Select Your Course : </td>
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
</div>
</body>
</html>
