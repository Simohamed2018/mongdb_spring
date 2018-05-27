<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Person List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<@spring.url '/css/monStyle.css'/>"/>
</head>
<body>
<h3>Person List</h3>
<a href="addStudent">Add Student</a>
<br><br>
<div>

    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>City</th>
        </tr>
    <#list students as student>
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.city}</td>
        </tr>
    </#list>
    </table>
</div>
</body>
</html>