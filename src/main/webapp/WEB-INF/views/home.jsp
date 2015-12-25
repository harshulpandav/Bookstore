<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<BR>
Testing done using Advanced REST Client extension for chrome
<BR>
https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=en-US
<BR><BR>
*** SAMPLE TEST DATA ***
<BR><BR>
For createUser:
<BR>
URL: http://localhost:8080/bookstore/createUser
<BR>
Payload: {"firstName":"Harshul","lastName":"Pandav","middleName":null,"age":26,"gender":"M","phone":4045284633,"zip":0}
<BR><BR>
For getAllUsers:<BR>
URL: http://localhost:8080/bookstore/getAllUsers<BR>
<BR>
For updateUser:<BR>
URL: http://localhost:8080/bookstore/createUser<BR>
Payload: {"id":1,"firstName":"Harshul","lastName":"Pandav","middleName":null,"age":26,"gender":"M","phone":4044044044,"zip":0}
<BR><BR>
For getAllBooks:<BR>
URL: http://localhost:8080/bookstore/getAllBooks<BR>
<BR>
For addBook:<BR>
URL: http://localhost:8080/bookstore/addBook<BR>
Payload: {"name":"Alpha","authors":"Greg,Steve"}<BR>
<BR>
For findBookByName: <BR>
URL: http://localhost:8080/bookstore/findBookByName/Alpha<BR>
<BR>
For checkOutBook:<BR>
URL: http://localhost:8080/bookstore/checkOutBook/1/1<BR>
<BR>

</body>
</html>
