<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/common/h5/taglibs.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
    <!-- start: Meta -->
    <%@include file="/common/h5/meta.jsp"%>
    <!-- end: Mobile Specific -->

    <%@include file="/common/h5/css-link.jsp"%>

    <title>首页</title>
    <!-- start: CSS -->
    <style type="text/css">
        #demo {
            background-color: #e0e0e0;
        }
    </style>

</head>

<body>
<header class="aui-bar aui-bar-nav" style="position: fixed">
    <a class="aui-pull-left aui-btn" id="backBtn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">生活状况</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;">
    <form id="regForm" action="/u/txShzk" method="post">
    <ul class="aui-list aui-form-list">

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    抽烟状况
                </div>
                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="smokingStatus" value="0" <c:if test="${modle.smokingStatus =='0' }">checked</c:if> >不抽</label>
                    <label><input class="aui-radio" type="radio" name="smokingStatus" value="1" <c:if test="${modle.smokingStatus =='1' }">checked</c:if> >偶尔抽</label>
                    <label><input class="aui-radio" type="radio" name="smokingStatus" value="2" <c:if test="${modle.smokingStatus =='2' }">checked</c:if>  >经常抽</label>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    饮酒状况
                </div>
                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" value="0" name="drinkingStatus" <c:if test="${modle.drinkingStatus =='0' }">checked</c:if> >不喝</label>
                    <label><input class="aui-radio" type="radio" value="1" name="drinkingStatus" <c:if test="${modle.drinkingStatus =='1' }">checked</c:if> >偶尔喝</label>
                    <label><input class="aui-radio" type="radio" value="2" name="drinkingStatus" <c:if test="${modle.drinkingStatus =='2' }">checked</c:if>  >经常喝</label>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    厨艺
                </div>
                <div class="aui-list-item-input">
                    <select name="cooking">
                        <option value="0" <c:if test="${modle.cooking =='0' }"> selected="selected" </c:if> >不下厨</option>
                        <option value="1" <c:if test="${modle.cooking =='1' }"> selected="selected" </c:if> >厨艺有待提高</option>
                        <option value="2" <c:if test="${modle.cooking =='2' }"> selected="selected" </c:if> >上得了厅堂</option>
                        <option value="3" <c:if test="${modle.cooking =='3' }"> selected="selected" </c:if> >饭店大厨级别</option>
                    </select>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    与父母同住
                </div>
                <div class="aui-list-item-input">
                    <select name="liveWithParents">
                                        <option value="不与父母同住"  <c:if test="${modle.liveWithParents =='不与父母同住' }"> selected="selected" </c:if>  >不与父母同住</option>
                    <option value="与父母同住"  <c:if test="${modle.liveWithParents =='与父母同住' }"> selected="selected" </c:if>  >与父母同住</option>
                    <option value="看情况"  <c:if test="${modle.liveWithParents =='看情况' }"> selected="selected" </c:if>  >看情况</option>
                    </select>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    喜欢的约会
                </div>
                <div class="aui-list-item-input">
                    <select name="favoriteDate">
                        <option value="公园散步/爬山"  <c:if test="${modle.favoriteDate =='公园散步' }"> selected="selected" </c:if> >公园散步</option>
                        <option value="奶茶/咖啡厅"  <c:if test="${modle.favoriteDate =='奶茶/咖啡厅' }"> selected="selected" </c:if> >奶茶/咖啡厅</option>
                        <option value="电影院" <c:if test="${modle.favoriteDate =='电影院' }"> selected="selected" </c:if> >电影院</option>
                        <option value="酒吧" <c:if test="${modle.favoriteDate =='酒吧' }"> selected="selected" </c:if> >酒吧</option>
                    </select>
                </div>
            </div>
        </li>

    </ul>
    </form>
</div>


<div class="aui-content-padded">

    <div class="aui-btn aui-btn-info  aui-btn-block" style="margin-top: 1rem;" id="regBtn">下一步</div>


</div>

<%@ include file="/common/h5/js.jsp" %>

<script src="${ctx}/aui/script/aui-dialog.js"></script>

<script language="JavaScript">


    var dialog = new auiDialog();


    $("#backBtn").click(function(){
        window.history.back();
    });
    $("#regBtn").click(function(){
        tijiao();
    });


    function tijiao() {

        $("#regForm").submit();
    }

    function msg(msg) {
        dialog.alert({
            title:"提示",
            msg:msg,
            buttons:['确定']
        },function(ret){
            // console.log(ret)
        })
    }
</script>




</body>


</html>
