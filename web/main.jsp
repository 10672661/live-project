<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>出入校园登记</title>
    <style type="text/css">
        /*magnum*/
        * {
            margin: 0px;
            padding: 0px;
        }

        #form {
            /* padding-top: 2%; */
            background: linear-gradient(to right, #A4F4DC, #B9EBF3);
            height: 960px;
            width: 35%;
            float: left;
            text-align: center;
        }

        .text {
            padding-left: 125px;
            text-align: right;
            width: 66%;
        }

        .sort {
            width: 200px;
            height: 25px;
            font-family: 黑体;
            text-indent: 8px;
            font-size: 15px;
        }

        h2 {
            margin-bottom: 20px;
        }

        #table {
            background: linear-gradient(to right, #B9EBF3, lightskyblue);
            /* padding-top: 2%; */
            /* border:1px solid; */
            height: 960px;
            width: 64%;
            float: right;
        }

        #table1 {
            text-align: center;
            padding-top: 1%;
            padding-left: 5%;
        }

        .a {
            border: 1px dodgerblue;
            background-color: dodgerblue;
            color: #ffffff;
            height: 25px;
            width: 50px;
        }

        .btn {
            padding-top: 20px;
        }

        .pic {
            padding-top: 20px;
            width: 300px;
            height: 300px;
            opacity: 0.6;
        }
    </style>

</head>
<body>
<div id="container">
    <div id="bg">
        <div id="form">
            <h2>进出校园登记</h2>
            <form action=" ${ctx }/StudentServlet?action=addStudent" method="post" name="stuform" id="stuform">
                <div class="text">
                    <table>
                        <tr>
                            <td>真实姓名:</td>
                            <td><input name="name" type="text" required pattern="^[\u4e00-\u9fa5]{0,}$"
                                       placeholder="必须填写，只能输入汉字" class="sort"></td>
                        </tr>
                        <tr>
                            <td>学号:</td>
                            <td><input name="id" type="text" size="20" required pattern="^([0-9]*$" maxlength="9"
                                       placeholder="必须填写，九位学号" class="sort"></td>
                        </tr>
                    </table>
                </div>
                <div class="btn">
                    <td><input type="submit" value="入校" class="a">
                        <input type="button" value="离校" id="leave" class="a">
                        <input type="reset" value="重置" class="a">
                    </td>
                </div>


            </form>
        </div>
        <div id="table">
            <div id="table1">
                <table border="1" align="center" width="750px">
                    <tr>
                        <th>姓名</th>
                        <th>学号</th>
                        <th>进入时间</th>
                        <th>离校时间</th>
                    </tr>
                    <c:forEach items="${allStudents}" var="student" varStatus="status">
                        <tr class="list">

                            <th>${student.name }</th>
                            <th>${student.id }</th>
                            <th>${student.entry_time}</th>
                            <th>${student.leave_time}</th>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="${ctx }/js/jquery.min.js"></script>

<script>
    
    $(function () {
        $("#leave").click(function () {

            var newUrl = '${ctx}/StudentServlet?action=updateStudent';    //设置新提交地址
            $("#stuform").attr('action', newUrl);    //通过jquery为action属性赋值
            $("#stuform").submit();    //提交ID为myform的表单
        })
    })
</script>
</body>
</html>
