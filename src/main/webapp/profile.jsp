<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Books</title>
</head>
<body>
    <h1>Book List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Name</th>
                <th>Author</th>
                 <th>Publisher</th>
                  <th>Pub Date</th>
                   <th>Subject</th>
                  
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.publisher}</td>
                    <td>${book.pub_date}</td>
                    <td>${book.subject}</td>
            
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
