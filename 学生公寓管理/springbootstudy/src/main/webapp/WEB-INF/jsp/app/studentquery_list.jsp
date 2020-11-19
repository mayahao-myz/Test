<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/25
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生查询信息</title>
    <%--    2.1 引入element ui --%>
    <%--   .css样式--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--开始使用vue模板-->
<%--挂载vue实例--%>
<div id="ap">
    <!--页面内容区域-->
    <div class="mx-main-content">
            <h4>当前位置--学生查询宿舍情况</h4>
            <div class="mx-table-title">
<%--                <h4>请输入学号：</h4>--%>
                <input prop="stuNo" v-model="mymodel.stuNo" type="text" width="80" placeholder="请输入学号：">
<%--                <input type="submit" onclick="onQuery()" value="查询">--%>
                <el-button type="submit" size="mini" @click="onQuery()">查询</el-button>
            </div>
        <%--        分割线--%>
        <el-divider></el-divider>

<%--        内容--%>
        <div class="mx-table-content">
            <!--使用element-ui table组件-->
            <el-table
            v-if="tableData.length>0"
            :data="tableData"
            style="width: 100%">
            <el-table-column
            type="index"
            label=""
            align="center"
            >
            </el-table-column>

                <el-table-column
                prop="stuNo"
                label="学号"
                align="center"
                >
                </el-table-column>

                <el-table-column
                        prop="stuName"
                        label="姓名"
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
                    prop="stuSex"
                    label="性别"
                    align="center">
                </el-table-column>

                <el-table-column
                    prop="stuMajor"
                    label="专业班级"
                    align="center">
                </el-table-column>
                <el-table-column
                        prop="stuPhone"
                        label="水电缴费情况"
                        align="center"
                >
                </el-table-column>

                <el-table-column
                        prop="healthGrade"
                        label="卫生评分"
                        align="center"
                >
                </el-table-column>
            </el-table>

        </div>
    </div>
</div>

<%--1 引入vue--%>
<script src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
<%--2.2引入element ui --%>
<script src="${pageContext.request.contextPath}/static/element-ui/index.js"></script>
<%--3. 引入axios  axios 是一个基于 promise 的 HTTP 库,可以用在浏览器和 node.js 中--%>
<script src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
<script src="${pageContext.request.contextPath}/static/mx-config.js"></script>

<script>
    // 响应的查询按钮
    // function onQuery(){
    //     //查询
    //     // alert("成功点击！");
    //         //发送请求
    //         axios.get("/app/studentquery/"+this.stuNo.value).then(res=>{
    //         //把返回结果赋给data里定义的变量this.tableData
    //         this.tableData = res.data;
    //         });
    //     this.mymodel={
    //         stuNo: this.tableData[stuNo].stuNo,
    //         stuName:this.tableData[stuNo].stuName,
    //         dormNo: this.tableData[stuNo].dormNo,
    //         stuPhone: this.tableData[stuNo].stuPhone,
    //         healthGrade: this.tableData[stuNo].healthGrade,
    //     }
    // }

    //定义vue实例
    var app=new Vue({
        //模板名称,在html中引用的组件名称
        el:'#ap',
        //定义数据
        //可以在html中使用
        data:function () {
            return {
                //定义表格要的数据
                //把数据传到表格
                tableData: [
                    {
                        stuNo: '',
                        stuName: '',
                        dormNo: '',
                        stuSex:'',
                        stuMajor:'',
                        stuPhone: '',
                        healthGrade: '',
                    }
                ],
                options: [{
                    value: '已缴纳',
                    label: '已缴纳'
                }, {
                    value: '未缴纳',
                    label: '未缴纳',
                }],

                //删掉
                // data() {
                //     return {
                //         pickerOptions: {
                //             disabledDate(time) {
                //                 return time.getTime() > Date.now();
                //             },
                //         },
                //     };
                // },
                //删掉
                //控制对话框的一个对象
                // dialog:{
                //     title:'',
                //     show:false
                // },
                //控制对话框的一个对象
                // dialogEdit:{
                //     title:'',
                //     show:false
                // },

                //定义模型,通过模型数据:model="form"与表单绑定
                mymodel: {
                    stuNo: '',
                    stuName: '',
                    dormNo: '',
                    stuSex:'',
                    stuMajor:'',
                    stuPhone: '',
                    healthGrade: '',

                },
                //定义一个变量，保存表格的哪行数据被选中
                // selectItemIndex:-1
            }
        },

                //生命周期函数:mounted--是加载模板后
                //一般初始化的数据都可在这执行
                mounted: function () {
                    // this.searchData();
                    this.initTable();
                },

                methods: {
                    //从服务器获得数据
                    //初始化表格数据
                    initTable: function () {
                        //从后台获得数据表数据
                        //通过axios调用服务器json服务
                        axios.get("/app/studentquery").then(res => {
                            //把返回结果赋给data里定义的变量this.tableData
                            this.tableData = res.data;
                        });
                    },
                    //
                    //响应查询按钮
                    onQuery:function () {
                        //发送请求，把输入的学号发送到controller
                        axios.get("/app/studentquery/"+this.mymodel.stuNo).then(res=>{
                            //把返回结果赋给data里定义的变量this.tableData
                            this.tableData = res.data;

                        });
                        // this.mymodel={
                        //     stuNo: this.tableData[stuNo].stuNo,
                        //     stuName:this.tableData[stuNo].stuName,
                        //     dormNo: this.tableData[stuNo].dormNo,
                        //     stuPhone: this.tableData[stuNo].stuPhone,
                        //     healthGrade: this.tableData[stuNo].healthGrade,
                        // }
                    }
                },
    });
</script>
</body>
</html>
