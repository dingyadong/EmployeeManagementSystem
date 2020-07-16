<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
session.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<h3>选择文件</h3>
<form enctype="multipart/form-data" method="post" action="${basePath }doupload.do">
	<input type="file" name="mulFile">
	<button type="submit">上传</button>
</form>

<script src="../../lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;
	
        //监听提交
        form.on('submit(saveBtn)', function (data) {
        	var foldername = $('input[name="foldername"]').val();
        	var content = $("#content").val();
        	 $.ajax({
                 url:"../../doupload.do",
                 type:"GET",
                 //注意序列化的值一定要放在最前面,并且不需要头部变量,不然获取的值得格式会有问题
                 data:"folderName="+foldername+"&content="+content,
                 /* data:hobby+"&name="+name+"&age="+age+"&sex="+sex+"&address="+address,    */ 
                 dataType:"json",
                 success:function (data) {
                     alert(data.msg);
                 }
        	 
             });
            return false;
        }
        );

    });
</script>
</body>
</html>