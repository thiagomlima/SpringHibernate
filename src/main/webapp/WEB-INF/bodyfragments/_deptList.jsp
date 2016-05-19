<div align="center">
    <h1>Department List</h1>
         <table border="1">
             <th>No</th>
             <th>Dept No</th>
             <th>Dept Name</th>
             <th>Location</th>

             <c:forEach var="dept" items="${departments}" varStatus="status">
             <tr>
                 <td>${status.index + 1}</td>
                 <td>${dept.deptNo}</td>
                 <td>${dept.deptName}</td>
                 <td>${dept.location}</td>
             </tr>
             </c:forEach>
        </table>
</div>