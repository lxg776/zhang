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
    <a class="aui-pull-left aui-btn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">生活状况</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 2.5rem;">
    <ul class="aui-list aui-form-list">

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    是否喝酒
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>不喝</option>
                        <option>偶尔喝</option>
                        <option>经常喝</option>
                    </select>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    是否抽烟
                </div>

                <div class="aui-list-item-input">
                    <select>

                        <option>不抽</option>
                        <option>偶尔抽</option>
                        <option>经常抽</option>
                    </select>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    厨艺
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>不下厨</option>
                        <option>厨艺有待提高</option>
                        <option>上的了厅堂</option>
                        <option>饭店大厨</option>
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
                    <select>
                        <option>不与父母同住</option>
                        <option>与父母同住</option>
                    </select>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label" style="width: 220px;">
                    喜欢怎么样的约会
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>公园散步/爬山</option>
                        <option>电影院</option>
                        <option>奶茶/咖啡厅</option>
                        <option>酒吧</option>
                        <option>电影院</option>
                    </select>
                </div>
            </div>
        </li>


    </ul>

</div>


<div class="aui-content-padded">

    <div class="aui-btn aui-btn-info  aui-btn-block" style="margin-top: 1rem;">下一步</div>


</div>








<%@ include file="/common/h5/js.jsp" %>


</body>


</html>
