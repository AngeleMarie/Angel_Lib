<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Signup</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="style/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="style/css/style.css">
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Book Registration</h2>
					
						<form method="POST" action="BookController" enctype="multipart/form-data" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Book Name" />
							</div>
								<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="file" name="cover" id="name" placeholder="Book Cover" />
							</div>
								<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="author" id="name" placeholder="Author Name" />
							</div>
								<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="publisher" id="name" placeholder="Publisher Name" />
							</div>
							<div class="form-group">
								 <input type="date" name="date" id="name" placeholder="Publication date" />
							</div>
					
								<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="subject" id="name" placeholder="Subject Name" />
							</div>
								<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
							</div>						
						
						</form>
					</div>
				</div>
			</div>
		</section>


	</div>
		
	<script src="style/js/main.js"></script>



</body>
</html>