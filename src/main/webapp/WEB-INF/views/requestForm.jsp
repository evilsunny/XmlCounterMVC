<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Request Details</h3>
<form:form method="POST" action="/addRequest">
    <table>
        <tr>
            <td><form:label path = "name">Name</form:label></td>
            <td><form:input path = "name" /></td>
        </tr>
        <tr>
            <td><form:label path = "count">Count</form:label></td>
            <td><form:input path = "count"/>     </td>
        </tr>

        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>