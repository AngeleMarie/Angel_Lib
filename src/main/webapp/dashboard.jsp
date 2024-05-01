<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

   <%
String username = request.getParameter("username");
%>
   
    <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Library Dashboard</title>



<style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f7f7f7;
}

.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-bottom: 20px;
    border-bottom: 1px solid #ddd;
}

nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

nav ul li {
    display: inline-block;
    margin-right: 20px;
}

nav ul li a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
}

main {
    padding: 20px 0;
}

section {
    margin-bottom: 20px;
}

.welcome {
    text-align: center;
}

.books {
    text-align: center;
}

.book-list {
    display: flex;
    justify-content: center;
    gap: 20px;
    padding:20px;
    margin:20px;
}

.book img {
    max-width: 100%;
    height: auto;
    padding:20px;
border-radius:10px;
     transform: translateZ(0);
      -moz-transform: translateZ(0);
      -webkit-transform: translateZ(0);
      -o-transform: translateZ(0);
      -ms-transform: translateZ(0);
      -webkit-transition-duration: 0.3s;
      transition-duration: 0.3s;
      -webkit-transition-property: transform;
      transition-property: transform;
      -webkit-transition-timing-function: ease-out;
      transition-timing-function: ease-out; }
  .book img:hover  {
    -webkit-transform: scale(1.3) translateZ(0);
    transform: scale(1.3) translateZ(0); 
    cursor:pointer;
    padding:40px
}

footer {
    text-align: center;
    margin-top: 20px;
    padding-top: 20px;
    border-top: 1px solid #ddd;
}
</style>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}
%>
<div class="container">
    <header>
        <h1>Dashboard📚</h1>
        <nav>
            <ul>
                <li><a href="#home">Home</a></li>
                 <li><a href="#profile">Profile</a></li>
                <li><a href="./add.jsp">Add</a></li>
                <li><a href="LogoutServlet">Logout</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="welcome">
           <h3>Welcome</h3>
    <p>Explore our collection of novels and manage your profile.</p>
	 <input type="search" name="search" id="pass" placeholder="Search For a book" />          
        </section>

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
            <c:forEach var="book" items="${book}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.age}</td>
                      <td>${book.publisher}</td>
                        <td>${book.pub_date}</td>
                          <td>${book.subject}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
    </main>
    <footer>
        <p>&copy; 2024 Library Dashboard. All rights reserved.</p>
    </footer>
</div>
</body>
</html>
    
    