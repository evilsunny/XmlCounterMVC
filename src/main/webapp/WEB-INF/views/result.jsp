<%@page contentType = "text/html;charset = UTF-8" language = "java"  import="java.io.*, java.net.*" %>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html>
<head>
    <title>XML parser</title>
</head>

<body>
<h2>First ${count} tags with name ${name}</h2>
<table>
    <tr>
        <td>Node name: </td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Count: </td>
        <td>${count}</td>
    </tr>
    <tr>
        <td>Result: </td>
        <td>${result}</td>
    </tr>
    <tr>
        <td>Content: </td>
        <td>${content}</td>
    </tr>
</table>

</body>

</html>