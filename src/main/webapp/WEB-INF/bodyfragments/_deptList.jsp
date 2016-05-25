<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="firstUrl" value="/dept/list/1" />
<c:url var="lastUrl" value="/dept/list/${departmentPage.totalPages}" />
<c:url var="prevUrl" value="/dept/list/${currentIndex - 1}" />
<c:url var="nextUrl" value="/dept/list/${currentIndex + 1}" />
<div align="center">
    <h1>Department List</h1>
         <table border="1">
            <th>#</th>
             <th>Id</th>
             <th>No</th>
             <th>Dept No</th>
             <th>Dept Name</th>
             <th>Location</th>
             <th></th>
             <th></th>

             <c:forEach var="dept" items="${departments}" varStatus="status">
             <tr>
                 <td>${(status.index + 1)* currentIndex}</td>
                 <td>${dept.deptId}</td>
                 <td>${dept.deptNo}</td>
                 <td>${dept.deptName}</td>
                 <td>${dept.location}</td>
                 <td><a href="${pageContext.request.contextPath}/dept/edit/id=${dept.deptId}">Edit</td>
                 <td><a href="${pageContext.request.contextPath}/dept/delete/page=${currentIndex}&id=${dept.deptId}">Delete</td>
                 <td>${dept.location}</td>
             </tr>
             </c:forEach>
        </table>
</div>
<div class="pagination">
    <ul>
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/dept/list/${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == departmentPage.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>