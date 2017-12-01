<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8"/>
    <title>zheng-oss-web AliyunOSS demo</title>
</head>
<body>

<form id="form" th:action="${policy.action}" method="post" enctype="multipart/form-data">

    <input id="dir" type="hidden" name="dir" th:value="${policy.dir}"/>
    <p>key : <input id="key" type="text" name="key"/></p>
    <p>policy : <input type="text" name="policy" th:value="${policy.policy}"/></p>
    <p>OSSAccessKeyId : <input type="text" name="OSSAccessKeyId" th:value="${policy.OSSAccessKeyId}"/></p>
    <p>success_action_status : <input type="text" name="success_action_status" value="200"/></p>
    <p>callback : <input type="text" name="callback" th:value="${policy.callback}"/></p>
    <p>signature : <input type="text" name="signature" th:value="${policy.signature}"/></p>
    <p>file : <input id="file" type="file" name="file"/></p>
    <p><input id="submit" type="submit" value="上传"/></p>
</form>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>
    $(function() {
        // 选择文件后，随机文件名
        $('#file').change(function() {
            var suffix = get_suffix($(this).val());
            var random_name = random_string();
            $('#key').val($('#dir').val() + '/' + random_name + suffix);
        });
        // 提交校验
        $('#form').submit(function() {
            if ($('#key').val() == '') {
                return false;
            }
        });
    });

    oss_policy_url = "http://188968ee02.51mypc.cn/aliyun/oss/ky_policy";

    $.ajax({
        url: oss_policy_url,
        type: "GET",
        dataType: "jsonp", //指定服务器返回的数据类型
        jsonp: "ky",
        success: function (data) {
            // var result = JSON.stringify(data); //json对象转成字符串
            $("#form").attr("action", data.callback);
            $('#dir').val(data.dir);
            $('#callback').val(data.callback);
            $('#OSSAccessKeyId').val(data.OSSAccessKeyId);
            $('#policy').val(data.policy);
            $('#signature').val(data.signature);

//        uploader.options.server=data.action;
//        uploader.options.formData.dir=data.dir;
//        uploader.options.formData.callback=data.callback;
//        uploader.options.formData.OSSAccessKeyId=data.OSSAccessKeyId;
//        uploader.options.formData.policy=data.policy;
//        uploader.options.formData.signature=data.signature;
        }
    });



    // 根据路径获取后缀
    function get_suffix(filename) {
        var pos = filename.lastIndexOf('.');
        var suffix = '';
        if (pos != -1) {
            suffix = filename.substring(pos);
        }
        return suffix;
    }
    // 随机字符串
    function random_string(len) {
        len = len || 32;
        var chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var maxPos = chars.length;
        var pwd = '';
        for (i = 0; i < len; i++) {
            pwd += chars.charAt(Math.floor(Math.random() * maxPos));
        }
        return pwd;
    }
</script>
</body>
</html>