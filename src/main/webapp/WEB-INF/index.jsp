<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/myscript.js"></script>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>


	<div class="container">
		<h4 class="t-al mg-bt10">
			Your Gold:
			<c:out value="${gold}"></c:out>
		</h4>
		<div class="row mg-bt5">
			<div class="col-md boxing brown">
				<h4>Farm</h4>
				<p class="center">(earns 10-20 golds)</p>
				<form action="/process-money" method="POST">

					<input type="hidden" name="building" value="farm" />
					<button name="find_gold" type="submit"
						class="btn btn-warning mg-top5 ">Find Gold</button>
				</form>
			</div>

			<div class="col-md boxing gray">
				<h4>Cave</h4>
				<p class="center">(earns 5-10 golds)</p>
				<form action="/process-money" method="POST">

					<input type="hidden" name="building" value="cave" />
					<button name="find_gold" type="submit"
						class="btn btn-warning mg-top5 ">Find Gold</button>
				</form>
			</div>

			<div class="col-md boxing blue">
				<h4>House</h4>
				<p class="center">(earns 2-5 golds)</p>
				<form action="/process-money" method="POST">
					<input type="hidden" name="building" value="house" />
					<button name="find_gold" type="submit"
						class="btn btn-warning mg-top5 ">Find Gold</button>
				</form>
			</div>

			<div class="col-md boxing red">
				<h4>Casino</h4>
				<p class="center">(earns/takes 0-50 golds)</p>
				<form action="/process-money" method="POST">

					<input type="hidden" name="building" value="casino" />
					<button name="find_gold" type="submit"
						class="btn btn-warning mg-top5 ">Find Gold</button>
				</form>
			</div>
		</div>
		<p class="t-al">Activities:</p>
		<div id="activities" class="overflow-auto">
			<c:forEach items="${dates}" var="item">
    			<p class = "space">${item}</p>
			</c:forEach>
		</div>
		<form action="/reset" method="POST">
			<input type="hidden" name="building" value="cave" />
			<button name="find_gold" type="submit"
				class="btn btn-warning mg-top5 ">Reset</button>
		</form>
	</div>
</body>

</body>
</html>

