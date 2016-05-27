<%@ page session="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<tiles:importAttribute name="javascripts"/>
<c:forEach var="javascript" items="${javascripts}">
    <script type="text/javascript" src="<c:url value="${javascript}"/>"></script>
</c:forEach>
<tiles:importAttribute name="stylesheets"/>
<c:forEach var="css" items="${stylesheets}">
    <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>" />
</c:forEach>
	</head>
<title><tiles:getAsString name="title" /></title>
</head>
<script>
		$(document).ready(function () {
			$("#datepicker").datepicker();
		});
	</script>
<script type="text/javascript">
if (typeof jQuery != 'undefined') {

    alert("jQuery library is loaded!");

}else{

    alert("jQuery library is not found!");

}
</script>

<body>
    <nav class="navbar navbar-inverse" role="navigation">
    	<div class="container">
    		<p class="navbar-text">Teste Bootstrap</p>
    	</div>
    </nav>
    <p>Date: <input id="datepicker" type="text"></p>
   <table width="100%">
       <tr>
           <td colspan="2"><tiles:insertAttribute name="header" /></td>
       </tr>
       <tr>
           <td width="20%" nowrap="nowrap"><tiles:insertAttribute name="menu" /></td>
           <td width="80%"><tiles:insertAttribute name="body" /></td>
       </tr>
       <tr>
           <td colspan="2"><tiles:insertAttribute name="footer" /></td>
       </tr>
   </table>
</body>
</html>