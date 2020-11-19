<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/10
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息表</title>
    <%--    2.1 引入element ui --%>
    <%--   .css样式--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
<%--    element组件的样式--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--开始使用vue模板-->
<%--挂载vue实例--%>
<div id="ap">
    <!--页面内容区域-->
    <div class="mx-main-content">
        <div class="mx-table-title">
            <span>学生信息列表</span>
        <el-button
        size="mini"
        type="primary"
        @click="onAdd()">添加</el-button>
        </div>
        <%--        分割线--%>
        <el-divider></el-divider>

        <div class="mx-table-content">
            <!--使用element-ui table组件-->
            <el-table
            v-if="tableData.length > 0"
            :data='tableData'
            :stripe="true"
            style="width: 100%"
            >
                <el-table-column
                        type="index"
                        label=""
                        align='center'
                        width="50">
                </el-table-column>

                <el-table-column
                        prop="stuNo"
                        label="学号"
                        align='center'
                        width="100"
                >
                </el-table-column>
                <el-table-column
                        prop="stuName"
                        label="姓名"
                        align='center'
                >
                </el-table-column>
                <el-table-column
                        prop="stuMajor"
                        label="专业"
                        width="180"
                        align="center"
                >
                </el-table-column>

                <el-table-column
                        prop="dormNo"
                        label="宿舍号"
                        align='center'
                >
                </el-table-column>
                <el-table-column
                        prop="stuPhone"
                        label="水电缴纳情况"
                        width="150"
                        align='center'
                >
                </el-table-column>

                <el-table-column
                        prop="stuSex"
                        label="性别"
                        align='center'
                >
                </el-table-column>

                <el-table-column
                        prop="healthGrade"
                        label="卫生评分"
                        align="center">

                </el-table-column>

                <!--操作按钮：修改 删除-->
                <el-table-column
                        label="操作"
                        align="center"
                        width="150"
                        align='center'
                >
                    <%--template已经封装好一个组件,预留了插槽,使用 的插槽--%>
                    <template slot-scope="scope">
                        <el-button type="primary" icon="el-icon-edit" circle @click="onEdit(scope.$index)"></el-button>
                        <el-button type="danger" icon="el-icon-delete" circle @click="onDelete(scope.$index)"></el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>

    <!--使用el-dialog组件显示添加/修改表单-->
    <el-dialog
            width="60%"
            :title="dialog.title"
            :visible.sync="dialog.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>

<div class="form">
    <!--使用el-form组件进行数据添加和修改-->
        <%--表单的数据通过下面定义的模型 mymodel 绑定   --%>
    <el-form
            :model="mymodel"
            :rules="myrules"
            ref="myform"
            label-width="100px">

        <el-form-item label="学号" required>
            <el-col :span="10">
                <el-form-item prop='stuNo'>
                    <%-- 数据项   每一个输入域与mymodel的属性绑定 --%>
                    <el-input type="string" v-model="mymodel.stuNo"></el-input>
                </el-form-item>
            </el-col>
        </el-form-item>

        <el-form-item label="姓名" required>
            <el-col :span="10">
                <el-form-item prop="stuName">
                    <el-input type="string" v-model="mymodel.stuName"></el-input>
                </el-form-item>
            </el-col>
        </el-form-item>

        <el-form-item label="专业班级"  prop="stuMajor">
            <el-select v-model="mymodel.stuMajor" placeholder="请选择专业班级">
                <el-option label="软件工程-1701" value="软件工程-1701"></el-option>
                <el-option label="软件工程-1702" value="软件工程-1702"></el-option>
                <el-option label="软件工程-1703" value="软件工程-1703"></el-option>
                <el-option label="软件工程-1704" value="软件工程-1704"></el-option>
                <el-option label="软件工程-1705" value="软件工程-1705"></el-option>
                <el-option label="计科-1701"     value="计科-1701"></el-option>
                <el-option label="物联-1701"     value="物联-1701"></el-option>
                <el-option label="电商-1701"     value="电商-1701"></el-option>
            <%--                <el-option label="计算机与信息技术学院-软件工程-1701" value="计算机与信息技术学院-软件工程-1701"></el-option>--%>
<%--                <el-option label="计算机与信息技术学院-软件工程-1702" value="计算机与信息技术学院-软件工程-1702"></el-option>--%>
<%--                <el-option label="计算机与信息技术学院-软件工程-1703" value="计算机与信息技术学院-软件工程-1703"></el-option>--%>
<%--                <el-option label="计算机与信息技术学院-软件工程-1704" value="计算机与信息技术学院-软件工程-1704"></el-option>--%>
<%--                <el-option label="计算机与信息技术学院-软件工程-1705" value="计算机与信息技术学院-软件工程-1705"></el-option>--%>

<%--                <el-option label="计算机与信息技术学院-计科-1701" value="计算机与信息技术学院-计科-1701"></el-option>--%>
<%--                <el-option label="计算机与信息技术学院-计科-1702" value="计算机与信息技术学院-计科-1702"></el-option>--%>
<%--                <el-option label="计算机与信息技术学院-计科-1703" value="计算机与信息技术学院-计科-1703"></el-option>--%>
<%--                <el-option label="计算机与信息技术学院-计科-1704" value="计算机与信息技术学院-计科-1704"></el-option>--%>
            </el-select>
        </el-form-item>

        <el-form-item label="宿舍号" prop="dormNo" required>
<%--            <c:forEach items="${list}" var="dormno">--%>
<%--                <td>${dormno.dormNo}</td>--%>
<%--            </c:forEach>--%>
            <el-select v-model="mymodel.dormNo" placeholder="请选择宿舍号">
                <el-option label="1-102" value="1-102"></el-option>
                <el-option label="2-202" value="2-202"></el-option>
                <el-option label="3-301" value="3-301"></el-option>
                <el-option label="3-303" value="3-303"></el-option>
                <el-option label="9-620" value="9-620"></el-option>
                <el-option label="10-520" value="10-520"></el-option>
<%--                <el-option value="mymodel.dormNo"></el-option>--%>
            </el-select>
        </el-form-item>

        <el-form-item  label="水电缴纳" prop="stuPhone" required>
            <el-select v-model="mymodel.stuPhone" placeholder="请选择缴纳情况">
                <el-option label="未缴纳" value="未缴纳"></el-option>
                <el-option label="已缴纳" value="已缴纳"></el-option>
            </el-select>
        </el-form-item>

        <el-form-item label="卫生评分" required>
            <el-col :span="10">
                <el-form-item prop="healthGrade">
                    <el-input type="string" v-model="mymodel.healthGrade"></el-input>
                </el-form-item>
            </el-col>
        </el-form-item>

        <el-form-item label="性别" prop="stuSex" required>
            <el-radio-group v-model="mymodel.stuSex">
                <el-radio label="男"></el-radio>
                <el-radio label="女"></el-radio>
            </el-radio-group>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="onSubmit('myform')">保存</el-button>
<%--            <el-button @click="resetForm('myform')">重置</el-button>--%>
            <el-button @click="dialog.show=false">取消</el-button>
        </el-form-item>
    </el-form>
</div>
    </el-dialog>
</div>

<%--1 引入vue--%>
<script src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
<%--2.2引入element ui --%>
<script src="${pageContext.request.contextPath}/static/element-ui/index.js"></script>
<%--3. 引入axios  axios 是一个基于 promise 的 HTTP 库,可以用在浏览器和 node.js 中--%>
<script src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
<script src="${pageContext.request.contextPath}/static/mx-config.js"></script>

<script>
    //
    var app=new Vue({
    //模板名称,在html中引用的组件名称
        el:'#ap',
        //定义数据
        //可以在html中使用
        data:function () {
            return{
                //定义表格要的数据
                //初始是从后台获取的
                tableData:[],
                //定义一个变量,存放哪行数据被选中,数据库是从0开始的，保存选中的这行数据
                selectItemIndex:-1,

                //定义对话框:如果对话框有自定义的数据需要通过变量控制,需要先定义
                //option获取或设置对话框的属性。用法：.dialog(  'option'  , optionName , [value] )
                dialog:{
                    title:'',
                    option:'',
                    show:false
                },
                //定义模型,通过模型数据:model="form"与表单绑定
                mymodel:{
                            stuNo:'',//学号
                            stuMajor:'',//专业
                            stuName:'',//姓名
                            stuSex:'',//性别
                            dormNo:'',//宿舍号
                            stuPhone:'',//水电缴纳情况
                            healthGrade:'',//宿舍卫生评分
                },
                //表单校验规则
                myrules: {
                    stuNo: [
                        { required: true, message: '请输入学号', trigger: 'blur' },
                        { min: 8, max: 8, message: '长度是8个字符', trigger: 'blur' }
                    ],
                    stuName: [
                        { required: true, message: '请输入姓名', trigger: 'blur' },
                        { min: 3, max: 8, message: '长度是3-8个字符', trigger: 'blur' }
                    ],
                    // stuMajor: [
                    //     { required: true, message: '请选择专业', trigger: 'change' }
                    // ],
                    dormNo: [
                        { required: true, message: '请选择宿舍号', trigger: 'change' }
                    ],
                    stuPhone: [
                        { required: true, message: '请选择水电缴纳情况', trigger: 'change' }
                    ],
                    stuSex: [
                        { required: true, message: '请选择性别', trigger: 'change' }
                    ],

                },

            }
        },

        //生命周期函数:mounted--是加载模板后
        //一般初始化的数据都可在这执行
        mounted: function () {
            this.searchData();
        },

        //
        methods:{
            //从服务器获得数据
            searchData:function () {
                //通过axios调用服务器json服务
                axios.get("/app/student").then(res => {
                    //把返回结果赋给data里定义的变量this.tableData
                    this.tableData=res.data;
                });
            },
             //主列表上的
            //响应添加按钮
            onAdd:function () {
                //对话框
                this.dialog = {
                    show: true,//显示对话框
                    title: "添加学生信息",
                    option: "add"//对话框的属性
                };
                this.mymodel={
                    stuNo:'',//学号
                    stuMajor:'',//专业
                    stuName:'',//姓名
                    stuSex:'',//性别
                    dormNo:'',//宿舍号
                    stuPhone:'',//水电缴纳情况
                    healthGrade:''//卫生评分
                };
            },

            //修改按钮
            onEdit: function (index) {
                // 编辑
                this.dialog = {
                    show: true,
                    title: "修改学生信息",
                    option: "edit"//获取或设置对话框的属性
                };
                // 清除校验,需要延迟,否则会由于还未渲染完form,报错
                //效验会下面有提示
                this.$nextTick(() => {
                    this.$refs['myform'].clearValidate();
                });
                //更新model数据
                this.mymodel = {
                    stuNo: this.tableData[index].stuNo,
                    stuMajor: this.tableData[index].stuMajor,
                    stuName: this.tableData[index].stuName,
                    stuSex: this.tableData[index].stuSex,
                    dormNo: this.tableData[index].dormNo,
                    stuPhone: this.tableData[index].stuPhone,
                    healthGrade:this.tableData[index].healthGrade,
                };
                //设置哪行被选中了
                this.selectItemIndex = index;
            },

            //删除按钮，提示框
            onDelete: function (index) {
                this.$confirm('确认删除该数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 删除
                    axios.delete("/app/student/" + this.tableData[index].stuNo).then(res => {
                        this.$message("删除成功");
                        // 删除table起始下标为1，长度为1的一个值
                        this.tableData.splice(index, 1);
                    });//异常处理
                }).catch(() => {

                });
            },

            //添加表单上的
            //表单上的 保存按钮，针对不同的操作
            onSubmit(myform) {
                //添加,调用post方法，对应的是添加表单的保存按钮，mymodel,form数据改，tableData服务器数据改
                // axios.post默认是application/json方式提交数据，
                //添加对话框的
                if (this.dialog.option == "add") {
                    axios.post("/app/student", this.mymodel).then(res => {
                        // 操作成功
                        this.$message({
                            message: "保存成功！",
                            type: "success"
                        });
                        //方法1:更新table，服务器数据
                        this.tableData.push(res.data);
                        //方法2:更新table:在最后添加一个元素,0表示添加
                        //this.tableData.splice(this.tableData.length,0,res.data);

                        //保存后，关闭对话框
                        this.dialog.show = false;
                    })

                }

                //修改的,调用put方法，对应的是修改中的保存按钮
                //修改对话框的
                else if (this.dialog.option == "edit") {
                    axios.put("/app/student", this.mymodel).then(res => {
                        // 操作成功
                        this.$message({
                            message: "保存成功！",
                            type: "success"
                        });

                        // 方法1:更新指定索引的元素
                        this.tableData.splice(this.selectItemIndex, 1, res.data)
                        // 方法2:数据重新从服务器加载table数据,这种方法效率差
                        // this.getData();
                        // 修改后，关闭对话框
                        this.dialog.show = false;
                    })
                }
            }
        }
    })
</script>

</body>
</html>
