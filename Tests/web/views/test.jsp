<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<h3>Example</h3>
<form action="${pageContext.request.contextPath}/test1?op=test2" method="post">
    <table>
        <tr>
            <td>String 1:</td>
            <td>
                <input name="str1" type="text"/>
            </td>
        </tr>
        <tr>
            <td>String 2:</td>
            <td>
                <input type="password" name="str2"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>