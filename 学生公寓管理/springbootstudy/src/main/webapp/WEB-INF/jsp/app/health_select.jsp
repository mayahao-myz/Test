<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/1
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>卫生信息查询</title>
    <!--2.1 引入 element ui-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">

</head>
<body>
<div id="app">

    <h1>欢迎您使用卫生信息查询功能：</h1>
    <div class="mx-main-content">
        <div class="mx-table-title">
            <input prop="dormNo" v-model="mymodel.dromNo" type="text"
                   value="199" placeholder="请输入要查询的宿舍号" />&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button type="submit" size="mini" @click="onSelect()">查询</el-button>
        </div>

        <div class="mx-table-content">
            <h2>卫生信息如下：</h2>
            <el-table
                    v-if="tableData.length > 0"
                    :data='tableData'
                    :stripe="true"
                    style="width: 100%">
                <el-table-column
                        type="index"
                        label=""
                        >
                </el-table-column>
                <el-table-column
                        prop="healthId"
                        label="编号"
                        align="center"
                        >
                </el-table-column>
                <el-table-column
                        prop="dormNo"
                        label="宿舍号"
                        align="center"
                       >
                </el-table-column>
                <el-table-column
                        prop="healthData"
                        label="检查日期"
                        align="center"
                        width="260"
                        >
                </el-table-column>
                <el-table-column
                        prop="healthGrade"
                        label="分数"
                        align="center"
                        >
                </el-table-column>
                <el-table-column
                        prop="healthRemark"
                        label="备注"
                        width="300"
                        align="center">
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
                        healthId:'',
                        dormNo:'',
                        healthData:'',
                        healthGrade:'',
                        healthRemark:''
                    }
                ],

                //模型数据是与表单进行绑定,通过:model="form"与表单绑定
                mymodel:{
                    healthId:'',
                    dormNo:'',
                    healthData:'',
                    healthGrade:'',
                    healthRemark:''
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
                axios.get("/app/healthselect1").then(res => {
                    this.tableData = res.data;
                })
            },
            onSelect:function () {

                axios.get("app/healthselect2/"+ this.mymodel.dromNo).then(res =>{
                    this.tableData = res.data;
                });
            }
        }
    });

</script>

</body>
</html>

