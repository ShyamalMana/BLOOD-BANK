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
	Donerdao dao = new Donerdao();
	List<Doner> list = dao.findal();
	%>
	<center>
		<h1>Availble Blood</h1>
		<br> <br>
		<table border="1px">
			<tr>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>Password</th>
				<th>Phone</th>
				<th>Blood Group</th>
				<th>Age</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th>Status</th>
				<th>ACTIVE</th>
				<th>Delete</th>
			</tr>
			<%
			for (Doner d : list) {
			%>
			<tr>
				<td><%=d.getName()%></td>
				<td><%=d.getEmail()%></td>
				<td><%=d.getPassword()%></td>
				<td><%=d.getPhone()%></td>
				<td><%=d.getBlood_group()%></td>
				<td><%=d.getAge()%></td>
				<td><%=d.getQuantity()%></td>
				<td><%=d.getAmount()%></td>
				<td><%=d.getStatus()%></td>
				<td><a href="Status?id=<%=d.getId()%>"<%-- Status=<%= d.getStatus()--%>><button
							style="background-color: Green">
							<%--if("Active".equals(d.getStatus())){
	--%>
							<%--}else --%>
							Activate
						</button></a></td>
				<td><a href="delete?id=<%=d.getId()%>"><button
							style="background-color: red">Delete</button></a></td>
			</tr>
			<%} %>
		</table>

	</center>
</body>
</html>