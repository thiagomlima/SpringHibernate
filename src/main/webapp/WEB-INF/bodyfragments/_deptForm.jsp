<%@ page session="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <spring:url value="/saveOrUpdateDept" var="url" />
	<form:form method="post" modelAttribute="department" action="${url}">
	    <table>
	    department
	        <spring:bind path="deptId">
	            <form:hidden path="deptId" />
            </spring:bind>

	        <spring:bind path="deptName">
                <tr>
                    <td>Department name</td>
                    <td> <form:input path="deptName" type="text" /></td>
                    <td> <form:errors path="deptName" /></td>
                </tr>
	        </spring:bind>

	        <spring:bind path="deptNo">
                <tr>
                    <td>Department numero</td>
                    <td> <form:input path="deptNo" type="text" /></td>
                    <td> <form:errors path="deptNo" /></td>
                </tr>
	        </spring:bind>

	        <spring:bind path="location">
                <tr>
                    <td>Department location</td>

                    <td> <form:input path="location" type="text" /></td>
                    <td> <form:errors path="location" /></td>
                </tr>
            </spring:bind>

             <tr>
                <td colspan=3><button type="submit" class="btn-lg btn-primary pull-right">Add</button></td>
            </tr>
	    </table>

	</form:form>