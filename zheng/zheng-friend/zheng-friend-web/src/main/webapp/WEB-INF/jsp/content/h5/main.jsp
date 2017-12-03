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
<header class="aui-bar aui-bar-nav">
    <a class="aui-pull-left aui-btn">
        <span class="aui-iconfont aui-icon-left"></span>返回
    </a>
    <div class="aui-title">择偶条件</div>

</header>


<div class="aui-content aui-margin-b-15" style="margin-top: 0.5rem;">
    <ul class="aui-list aui-form-list">

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    性别
                </div>
                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="demo1" checked>男</label>
                    <label><input class="aui-radio" type="radio" name="demo1">女</label>
                </div>
            </div>
        </li>
        <li class="aui-list-item">   <div class="aui-list-item-label" style="font-size: 18px;color: #212121;">年龄（岁） </label></li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label" style="color: #757575; font-size: 12px; width: 110px;">
                    年龄（以上）
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>不限</option>
                        <option>20</option>
                        <option>21</option>
                        <option>22</option>
                        <option>23</option>
                        <option>24</option>
                        <option>25</option>
                        <option>26</option>
                        <option>27</option>
                        <option>28</option>
                        <option>29</option>
                        <option>30</option>
                        <option>31</option>
                        <option>32</option>
                        <option>33</option>
                        <option>34</option>
                        <option>35</option>
                        <option>36</option>
                        <option>37</option>
                        <option>38</option>
                        <option>39</option>
                        <option>40</option>
                        <option>40以上</option>
                    </select>
                </div>
            </div>

            <div class="aui-list-item-inner">
                <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 110px;">
                    年龄（以下）
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>不限</option>
                        <option>20</option>
                        <option>21</option>
                        <option>22</option>
                        <option>23</option>
                        <option>24</option>
                        <option>25</option>
                        <option>26</option>
                        <option>27</option>
                        <option>28</option>
                        <option>29</option>
                        <option>30</option>
                        <option>31</option>
                        <option>32</option>
                        <option>33</option>
                        <option>34</option>
                        <option>35</option>
                        <option>36</option>
                        <option>37</option>
                        <option>38</option>
                        <option>39</option>
                        <option>40</option>
                        <option>40以上</option>
                    </select>
                </div>
            </div>
        </li>



        <li class="aui-list-item">   <div class="aui-list-item-label" style="font-size: 18px;color: #212121;">身高（cm） </label></li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label" style="color: #757575; font-size: 12px; width: 110px;">
                    身高（以上）
                </div>

                <div class="aui-list-item-input">
                    <input type="number" placeholder="不限">
                </div>
            </div>

            <div class="aui-list-item-inner">
                <div class="aui-list-item-label" style="color: #757575; font-size: 12px;width: 110px;">
                    身高（以下）
                </div>

                <div class="aui-list-item-input">
                    <input type="number" placeholder="不限">
                </div>
            </div>
        </li>
        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    婚姻
                </div>

                <div class="aui-list-item-input">
                    <label><input class="aui-radio" type="radio" name="demo1" checked>未婚</label>
                    <label><input class="aui-radio" type="radio" name="demo1">离异</label>
                    <label><input class="aui-radio" type="radio" name="demo1">丧偶</label>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    体型
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>不限</option>
                        <option>一般</option>
                        <option>强壮</option>
                        <option>偏瘦</option>
                        <option>偏胖</option>
                    </select>
                </div>
            </div>
        </li>

        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    学历
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>不限</option>
                        <option>大专以上</option>
                        <option>本科以上</option>
                        <option>研究生以上</option>
                        <option>高中以上</option>
                    </select>
                </div>
            </div>
        </li>



        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    月收入（元）
                </div>

                <div class="aui-list-item-input">
                    <select>
                        <option>3000以下</option>
                        <option>3000~5000</option>
                        <option>5000~8000</option>
                        <option>8000~12000</option>
                        <option>12000~20000</option>
                        <option>20000以上</option>
                    </select>
                </div>
            </div>
        </li>


        <li class="aui-list-item">
            <div class="aui-list-item-inner">
                <div class="aui-list-item-label">
                    职业性质
                </div>
                <div class="aui-list-item-input">
                    <select>
                        <option>不限</option>
                        <option>事业单位</option>
                        <option>国有企业</option>
                        <option>公务员/政府机关</option>
                        <option>个体经营</option>
                    </select>
                </div>
            </div>
        </li>



        <div class="aui-card-list">
            <div class="aui-card-list-header" style="color: #757575; font-size: 14px;">
                相册
            </div>
            <div class="aui-card-list-content-padded aui-border-b aui-border-t">
                <div class="aui-row aui-row-padded">
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l1.png" />
                    </div>
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l2.png" />
                    </div>
                    <div class="aui-col-xs-4">
                        <img src="${ctx}/aui/image/l3.png" />
                    </div>
                </div>
            </div>

        </div>



    </ul>

</div>


<div class="aui-content-padded">

    <div class="aui-btn aui-btn-info  aui-btn-block" style="margin-top: 1rem;">下一步</div>


</div>








<%@ include file="/common/h5/js.jsp" %>


</body>


</html>
