<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SongYandi
  Date: 2020/4/7
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理人员查询界面</title>
    <!--2.1 引入 element ui-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">

</head>
<body>
<div id="app">

    <h1>欢迎您，尊敬的管理员：</h1>
    <div class="mx-main-content">
        <div class="mx-table-title">
                <input prop="householdName" v-model="mymodel.householdTime" type="text"
                         value="199" placeholder="请输入要查询的用户姓名" />&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button type="submit" size="mini" @click="onSelect()">查询</el-button>
        </div>

        <div class="mx-table-content">
            <h2>用户的信息如下：</h2>
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
                        label="住户编号" width="100">
                </el-table-column>
                <el-table-column
                        prop="householdName"
                        label="住户姓名" width="100">
                </el-table-column>
                <el-table-column
                        prop="waterAmount"
                        label="用水量" width="100">
                </el-table-column>
                <el-table-column
                        prop="waterPriceSum"
                        label="水费" width="100">
                </el-table-column>
                <el-table-column
                        prop="electricAmount"
                        label="用电量" width="100">
                </el-table-column>
                <el-table-column
                        prop="electricPriceSum"
                        label="电费" width="100">
                </el-table-column>

            </el-table>
        </div>
    </div>

</div>
<!--1 引入vue-->
<script src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
<!--2.2 引入 element ui-->
<script src="${pageContext.request.contextPath}/static/element-ui/index.js"></script>
<!--3 引入axios-->
<script src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
<script src="${pageContext.request.contextPath}/static/mx-config.js"></script>

<script language="JavaScript">
    //定义vue实例
    var app = new Vue({
        el: "#app",
        data: function () {
            return {
                //表格数据
                tableData: [
                    {
                        householdNo: '',
                        householdName: '12',
                        waterAmount: '',
                        waterPriceSum:'',
                        electricAmount:'',
                        electricPriceSum:'',
                        householdTime:'',
                        leaveTime:''
                    }
                ],
                //模型数据是与表单进行绑定,通过:model="form"与表单绑定
                mymodel:{
                    householdNo: '',
                    householdName: '',
                    waterAmount: '',
                    waterPriceSum:'',
                    electricAmount:'',
                    electricPriceSum:'',
                    householdTime:'',
                    leaveTime:''
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
            initTable:function(){
                //从后台获得数据库数据
                axios.get("/hr/manager_select1").then(res => {
                    this.tableData = res.data;
            });
            },
            onSelect:function () {

                axios.get("/hr/manager_select2/"+ this.mymodel.householdTime).then(res =>{
                    this.tableData = res.data;
                });
            }
        }
    });

</script>

</body>
</html>
