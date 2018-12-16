<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

<form cmethod = "post" action="${pageContext.request.contextPath}/docreate">
	<table class="formtable">
		<tr> <td class="label"> semester: </td> <td><input class="control" type="text" name="semester"/> </td> </tr>
		<tr> <td class="label"> name: </td> <td><input class="control" type="text" name="name"/> </td> </tr>
		<tr> <td class="label"> classify: </td> <td><input class="control" type="text" name="classify"/> </td> </tr>
		<tr> <td class="label"> code: </td> <td><input class="control" type="text" name="code"/> </td> </tr>
		<tr> <td class="label"> credit: </td> <td><input class="control" type="text" name="credit"/> </td> </tr>
		<tr> <td class="label"> year: </td> <td><input class="control" type="text" name="year"/> </td> </tr>
		<tr> <td class="label"> </td> <td> <input class="control" type="submit" value="수강과목 추가"/></td> </tr>
	</table>
</form>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

</body>
</html>