
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>


<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head></head>




<body>
<h1>Message : ${message}</h1>

<br><br><br>


<h2>Spring MVC file upload example</h2>

<form method="POST" action="<c:url value='/upload' />"


    enctype="multipart/form-data">

    Please select a file to upload : <input type="file" name="file" />
    <input type="submit" value="upload" />

</form>
</body>
</html>