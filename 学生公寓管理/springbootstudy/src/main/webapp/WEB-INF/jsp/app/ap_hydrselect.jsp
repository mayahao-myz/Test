<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/1
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>水电信息查询</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--挂载vue实例-->
<div id="app">
    <div class="mx-main-content">
        <div class="mx-table-title">
            <input prop="dromNo" v-model="mymodel.dromNo" type="text"
                   placeholder="请输入要查询的宿舍" />&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button type="submit" size="mini" @click="onSelect()">查询</el-button>
        </div>

        <div class="el-divider">
            <el-divider></el-divider>
        </div>

        <div class="mx-table-content">
            <el-table
                    v-if="tableData.length > 0"
                    :data='tableData'
                    :stripe="true"
                    style="width: 100%">
                <%-- <el-table-column
                         type="index"
                         label=""
                         width="50">
                 </el-table-column>--%>
                <el-table-column
                        prop="hydrId"
                        label="编号"
                        align="center"
                        >
                </el-table-column>
                <el-table-column
                        prop="dromNo"
                        label="宿舍号"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="hydrData"
                        label="日期"
                        width="300"
                        align="center">
                </el-table-column>

                <el-table-column
                        prop="hydrFree"
                        label="水电费"
                        align="center">
                </el-table-column>

                <el-table-column
                        prop="hydrFreeState"
                        label="缴费状态"
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

<script>
    //定义vue实例
    var app = new Vue({
        el: "#app",
        data: function () {
            return {

                //表格数据
                tableData: [
                    {
                        userId: '',
                        hydrId: '',
                        dromNo:'',
                        hydrData:'',
                        hydrFree:'',
                        hydrFreeState:'',
                    }
                ],
                options: [{
                    value: '已缴费',
                    label: '已缴费'
                }, {
                    value: '未缴费',
                    label: '未缴费',


                }],

                data() {
                    return {
                        pickerOptions: {
                            disabledDate(time) {
                                return time.getTime() > Date.now();
                            },
                        },
                    };
                },


                //控制对话框的一个对象
                dialog:{
                    title:'',
                    show:false
                },
                //控制对话框的一个对象
                dialogEdit:{
                    title:'',
                    show:false
                },
                //模型数据是与表单进行绑定,通过:model="form"与表单绑定
                mymodel:{
                    userId: '',
                    hydrId: '',
                    dromNo:'',
                    hydrData:'',
                    hydrFree:'',
                    hydrFreeState:'',
                    hydrTime:'',
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
            /* //初始化表格数据
             initTable:function(){
                 //从后台获得数据库数据
                 axios.get("/app/hydrselect1").then(res => {
                     this.tableData = res.data;
                 })
             },*/
            onSelect:function () {

                axios.get("/app/hydrselect1/" +this.mymodel.dromNo).then(res =>{
                    this.tableData = res.data;
                });
            }

        },

    });



</script>
</body>
</html>

