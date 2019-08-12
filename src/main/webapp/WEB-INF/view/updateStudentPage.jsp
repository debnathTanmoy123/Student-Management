
<html>
<head>
</head>

<body>

	<h1>Update your Details</h1>
<form action="update" method="post" >
	<table>
		<tr>
			<td>first name</td>
			<td><input type="text" name="firstName" value="${stdObj.firstName }"></td>
		</tr>
		<tr>
			<td>last name</td>
			<td><input type="text" name="lastName" value="${stdObj.lastName }"></td>
		</tr>
		<tr>
			<td>Mobile no</td>
			<td><input type="text" name="mobileNo" value="${stdObj.mobileNo }"></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="text" name="email" value="${stdObj.email }"></td>
		</tr>
		<tr>
			<td>is married</td>
			<td><input type="text" name="isMarried" ></td>
		</tr>
		<tr>
			<td>father name</td>
			<td><input type="text" name="fatherName" value="${stdObj.fatherName }"></td>
		</tr>
		<tr>
			<td>mother name</td>
			<td><input type="text" name="motherName" value="${stdObj.motherName }"></td>
		</tr>
		<tr>
			<td>street</td>
			<td><input type="text" name="address.street" value="${stdObj.address.street }"></td>
		</tr>
		<tr>
			<td>city</td>
			<td><input type="text" name="address.city" value="${stdObj.address.city }"></td>
		</tr>
		<tr>
			<td>state</td>
			<td><input type="text" name="address.state" value="${stdObj.address.state }"></td>
		</tr>
		<tr>
			<td>pincode</td>
			<td><input type="text" name="address.pincode" value="${stdObj.address.pincode }"></td>
		</tr>
	
		<tr>
			
			<td><input type="submit" value="submit"></td>
		</tr>

	</table>
	</form>
</body>


</html>

