<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/6/1
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询维修信息</title>
    <!--引入element-ui.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <!--引入自定义样式el-custom.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--开始使用vue模板-->
<div id="app">
    <!--页面内容区域-->
    <div class="mx-main-content">
        <div class="mx-table-title">
            <input prop="dormNo" v-model="mymodel.dormNo" type="text" placeholder="请输入宿舍号"/>&nbsp;&nbsp;
            <el-button
                    size="mini"
                    type="submit"
                    @click="onSelect()">查询
            </el-button>
            <el-divider></el-divider>
            <div class="mx-table-content">
                <!--使用element-ui table组件-->
                <el-table
                        v-if="tableData.length > 0"
                        :data='tableData'
                        :stripe="true"
                        style="width: 100%">
                    <el-table-column
                            type="index"
                            label=""
                            align='center'
                            width="50">
                    </el-table-column>
                    <el-table-column
                            prop="repairId"
                            label="报修编号"
                            align='center'>
                    </el-table-column>
                    <el-table-column
                            prop="dormNo"
                            label="宿舍号"
                            align='center'>
                    </el-table-column>
                    <el-table-column
                            prop="drepairData"
                            label="日期"
                            align='center'>
                    </el-table-column>
                    <el-table-column
                            prop="repairContent"
                            label="报修内容"
                            align='center'>
                    </el-table-column>
                    <el-table-column
                            prop="drepairState"
                            label="报修状态"
                            align='center'>
                    </el-table-column>
                </el-table>
            </div>
        </div>
    </div>
</div>
<!--引入vue.js-->
<script src="${pageContext.request.contextPath}/static/vue/vue.min.js"></script>
<!--引入element-ui.js-->
<script src="${pageContext.request.contextPath}/static/element-ui/index.js"></script>
<!--引入axios-->
<script src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
<!--引入配置js-->
<script src="${pageContext.request.contextPath}/static/mx-config.js"></script>
<script>
    var app = new Vue({
        //模板名称,在html中引用的组件名称
        el: '#app',
        //定义数据
        //可以在html中使用
        data: function () {
            return {
                //定义表格要的数据
                tableData: [{
                    drepairId:'',
                    repairId: '',
                    dormNo:'',
                    drepairData: '',
                    repairContent: '',
                    drepairState:''
                }],

                //定义一个变量,存放哪行数据被选中
                selectItemIdex: -1,
                //定义模型,通过:model="form"与表单绑定
                mymodel: {
                    drepairId:'',
                    repairId: '',
                    dormNo:'',
                    drepairData: '',
                    repairContent: '',
                    drepairState:''
                },
            }
        },
        //生命周期函数:mounted--是加载模板后
        //一般初始化的数据都可在这执行
        mounted: function () {
            this.selectData();
        },

        //定义方法,多个方法用逗号(,)分割
        //定义的方法可以在html中通过@xxx使用
        methods: {
            //从服务器获得数据
            selectData:function(){
                //通过axios调用服务器json服务
                axios.get("/hr/drepair").then(res => {
                    this.tableData = res.data;
                });
            },
            //响应查询按钮
            onSelect:function () {
                axios.get("/app/query/"+this.mymodel.dormNo).then(res=>{
                    this.tableData=res.data;
                });
            }
        }
    })
</script>
</body>
</html>

