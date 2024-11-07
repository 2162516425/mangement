<!DOCTYPE html>
<html>
<head>
    <title>排班管理</title>
</head>
<body>
<h2>排班管理</h2>
<table border="1">
    <tr>
        <th>员工姓名</th>
        <th>排班日期</th>
        <th>排班时间</th>
        <th>排班地点</th>
        <th>操作</th>
    </tr>
    <c:forEach var="schedule" items="${schedules}">
        <tr>
            <td>${schedule.employeeName}</td>
            <td>${schedule.date}</td>
            <td>${schedule.time}</td>
            <td>${schedule.location}</td>
            <td>
                <a href="approve-schedule?id=${schedule.scheduleID}">批准</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
