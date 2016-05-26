<%@ page session="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel='stylesheet' href='/webjars/bootstrap/css/bootstrap.min.css'>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
</head>

<body>
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