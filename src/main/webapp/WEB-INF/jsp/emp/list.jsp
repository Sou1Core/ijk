<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css" rel="stylesheet">

<shiro:hasPermission name="emp:add">
    <h2><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/emp/preAdd" >员工添加</a></h2>
</shiro:hasPermission>
<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>#</th>
            <th>编号</th>
            <th>姓名</th>
            <th>工种</th>
            <th>上级</th>
            <th>入职日期</th>
            <th>工资</th>
            <th>奖金</th>
            <th>部门</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${emps}" var="emp" varStatus="vs">
           <tr>
                <td>${vs.count}</td>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.mgr}</td>
                <td><fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.dept.dname}</td>
                <td>
                    <shiro:hasPermission name="emp:update">
                    <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/emp/${emp.empno}">编辑</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="emp:delete">
                    <button class="btn btn-sm btn-danger" onclick="del(${emp.empno})">删除</button>
                    </shiro:hasPermission>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="post" name="deleteForm">
        <input type="hidden" value="delete" name="_method">
    </form>
    <script>
        function del(empno){
            console.log(empno);
            if(confirm("是否确定要删除该数据?")){
                let deleteForm = document.deleteForm;
                deleteForm.action = "${pageContext.request.contextPath}/emp/"+empno;

                deleteForm.submit();
            }
        }
    </script>
</div>
