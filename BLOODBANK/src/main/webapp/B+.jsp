<%@page import="com.shyam.dto.Doner"%>
<%@page import="java.util.List"%>
<%@page import="com.shyam.dao.Donerdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String O = "B+";
	String status = "Active";

	Donerdao d = new Donerdao();
	List<Doner> list = d.FindbyBgroup(O, status);
	if (list != null) {
	%>
	<center>
		<h1 style="color: Green">Avillable Blood</h1>
		<br>
		<table border="1px">
			<tr>
				<th>Blood Group</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th>buy</th>
			</tr>

			<%
			for (Doner f : list) {
			%>
			<tr>
				<td><%=f.getBlood_group()%></td>
				<td><%=f.getQuantity()%></td>
				<td><%=f.getAmount()%></td>
				<td><a href="Byu?id=<%=f.getId()%>"><button>Buy</button></a></td>
			</tr>

			<%
			}
			} else {
			%>
			<h1 Style="color: red">No Blood Availlable</h1>
			<%
			}
			%>
		</table>
		<br>
		<button>
			<a href="Mainpage.html">Home Page</a>
		</button>
		<button>
			<a href="BloodDetails.jsp">Blood Details</a>
		</button>
	</center>
</body>
</html>