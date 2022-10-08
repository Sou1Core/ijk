<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="${pageContext.request.contextPath}/asserts/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/asserts/css/dashboard.css" rel="stylesheet">
<form  method="post" action="${pageContext.request.contextPath}/emp">
    <input type="hidden" name="_method" value="put">
    <div class="form-group">
        <label>编号</label>
        <input name="empno" type="text" class="form-control" placeholder="编号" value="${emp.empno}" readonly>
    </div>
    <div class="form-group">
        <label>姓名</label>
        <input name="ename" type="text" class="form-control" placeholder="zhangsan"  value="${emp.ename}">
    </div>
    <div class="form-group">
        <label>工种</label>
        <input name="job" type="text" class="form-control" placeholder="工种" value="${emp.job}" >
    </div>
    <div class="form-group">
        <label>入职日期</label>
        <input name="hiredate" type="date" class="form-control" value='<fmt:formatDate value="${emp.hiredate}" pattern="yyyy-MM-dd"></fmt:formatDate>'>

    </div>
    <div class="form-group">
        <label>工资</label>
        <input name="sal" type="text" class="form-control" placeholder="工资" value="${emp.sal}" >
    </div>
    <div class="form-group">
        <label>奖金</label>
        <input name="comm" type="text" class="form-control" placeholder="奖金" value="${emp.comm}">
    </div>

    <div class="form-group">
        <label>部门</label>

        <select class="form-control" name="dept.deptno">
            <c:forEach items="${depts}" var="dept">
                <option value="${dept.deptno}">${dept.dname}</option>
            </c:forEach>

        </select>
    </div>
    <script>
        //用户之前选择的部门
        var selectedDetpno = "${emp.dept.deptno}";
        //定位
        document.getElementsByTagName("select")[0].value = selectedDetpno;
    </script>

    <button type="submit" class="btn btn-primary" >保存</button>
</form>
