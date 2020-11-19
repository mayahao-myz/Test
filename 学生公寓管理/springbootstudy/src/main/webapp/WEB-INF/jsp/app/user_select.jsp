<%--
  Created by IntelliJ IDEA.
  User: SongYandi
  Date: 2020/4/7
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户查询界面</title>
    <!--2.1 引入 element ui-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<div id="app">
    <div class="mx-main-content">
        <div class="mx-table-content">
            <h1>尊敬的住户，您好！您当前的状况如下：</h1>
            <el-table
                    v-if="tableData.length > 0"
                    :data='tableData'
                    :stripe="true"
                    style="width: 100%">
                <el-table-column
                        type="index"
                        label=""
                        width="50">
                </el-table-column>
                <el-table-column
                        prop="householdNo"
                        label="房间编号" width="100">
                </el-table-column>
                <el-table-column
                        prop="householdName"
                        label="姓名" width="100">
                </el-table-column>
                <el-table-column
                        prop="waterAmount"
                        label="用水量(/吨)" width="120">
                </el-table-column>
                <el-table-column
                        prop="waterPriceSum"
                        label="水费" width="100">
                </el-table-column>
                <el-table-column
                        prop="electricAmount"
                        label="用电量(/千瓦)" width="140">
                </el-table-column>
                <el-table-column
                        prop="electricPriceSum"
                        label="电费">
                </el-table-column>
            </el-table>
        </div>
    </div>

    <!--1 引入vue-->
    <script src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
    <!--2.2 引入 element ui-->
    <script src="${pageContext.request.contextPath}/static/element-ui/index.js"></script>
    <!--3 引入axios-->
    <script src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
    <script src="${pageContext.request.contextPath}/static/mx-config.js"></script>

    <script>
        var app = new Vue(
            {
                el: "#app",
                data: function () {
                    return {
                        //表格数据
                        tableData: [
                            {
                                householdNo: '',
                                householdName: '456',
                                waterAmount: '',
                                waterPriceSum:'',
                                electricAmount:'',
                                electricPriceSum:''
                            }
                        ],

                        //模型数据是与表单进行绑定,通过:model="form"与表单绑定
                        mymodel:{
                            householdNo: '',
                            householdName: '',
                            waterAmount: '',
                            waterPriceSum:'',
                            electricAmount:'',
                            electricPriceSum:''
                        },
                        //定义一个变量，保存表格的哪行数据被选中
                        selectItemIndex:-1
                    }
                },
                mounted: function () {
                    //初始化表格
                    this.initTable();
                },
                methods: {


                    //初始化表格数据
                    initTable:function () {
                        //从后台获得数据库数据
                        axios.get("/hr/user_select1").then(res => {
                            this.tableData= res.data;
                    });
                    }
                }
            }
        )
    </script>

</div>
</body>
</html>
