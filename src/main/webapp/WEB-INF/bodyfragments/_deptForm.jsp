
	<form:form method="post" modelAttribute="deptForm" action="${userActionUrl}">

	    <spring:bind path="deptName">
		    <form:input path="deptName" type="text" /> <!-- bind to department.deptName-->
		    <form:errors path="deptName" />
        </spring:bind>

        <button type="submit" class="btn-lg btn-primary pull-right">Add
                                     </button>
	</form:form>