<%@ page session="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/saveOrUpdateDept" var="url" />
	<form:form method="post" modelAttribute="department" action="${url}">

	    <spring:bind path="deptName">
		    <form:input path="deptName" type="text" /> <!-- bind to department.deptName-->
		    <form:errors path="deptName" />
        </spring:bind>

        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
	</form:form>