<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="cp1251" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>
    <p>
        ${message}!
    </p>

    <form action="logout">
        <button>Exit</button>
    </form>
</body>
</html>



