<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Student</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/monStyle.css'/>"/>
</head>
<body>
<#if errorMessage??>
<div style="color:red;font-style:italic;">
${errorMessage}
</div>
</#if>

<div>
    <fieldset>
        <legend>Add Student</legend>
        <form name="student" action="" method="POST">
            First Name: <@spring.formInput "student.name" "" "text"/>    <br/>
            Email: <@spring.formInput "student.email" "" "text"/>    <br/>
            City: <@spring.formInput "student.city" "" "text"/>    <br/>
            <input type="submit" value="Create" />
        </form>
    </fieldset>
</div>


</body>

</html>