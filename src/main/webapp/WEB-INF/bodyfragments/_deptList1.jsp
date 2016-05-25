<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">
    <h1>Department List</h1>
         <table border="1">
             <th>No</th>
             <th>Dept No</th>
             <th>Dept Name</th>
             <th>Location</th>
             <th></th>
             <th></th>

             <c:forEach var="dept" items="${departments}" varStatus="status">
             <tr>
                 <td>${status.index + 1}</td>
                 <td>${dept.deptNo}</td>
                 <td>${dept.deptName}</td>
                 <td>${dept.location}</td>
                 <td><a href="${pageContext.request.contextPath}/dept/edit/id=${dept.deptId}">Edit</td>
                 <td><a href="${pageContext.request.contextPath}/dept/delete/id=${dept.deptId}">Delete</td>
                 <td>${dept.location}</td>
             </tr>
             </c:forEach>
        </table>
</div>