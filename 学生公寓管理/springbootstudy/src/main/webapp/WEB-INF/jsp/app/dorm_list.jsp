<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/6
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍信息管理</title>
<%--    2.1 引入element ui --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <!--引入自定义样式el-custom.css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<%--挂载vue实例--%>
<div id="app">
    <!--页面内容区域-->
    <div class="mx-main-content">
        <div class="mx-table-title">
            <span>宿舍信息</span>
            <el-button
                    type="primary"
                    size="mini"
                    @click="onAdd()">添加
            </el-button>
    </div>
<%--    水平分割线--%>
<%--    <div class="el-divider">--%>
        <el-divider></el-divider>
<%--    </div>--%>

<%--        表格内容--%>
    <div class="mx-table-content">
        <!--使用element-ui table组件-->
        <el-table
                    v-if="tableData.length > 0"
                    :data='tableData'
                    :stripe="true"
                    style="width:100%">
            <el-table-column
                    type="index"
                    label="序列"
                    align="center"
                    width="200">
            </el-table-column>

            <el-table-column
                    prop="dormNo"
                    label="宿舍号"
                    align="center">
            </el-table-column>

            <!--操作按钮-->
        <el-table-column
                    prop=""
                    label="操作"
                    align="center">
           <%--已经封装好一个组件,预留了插槽,使用 的插槽--%>
        <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" circle @click="onEdit(scope.$index)"></el-button>
            <el-button type="danger" icon="el-icon-delete" circle @click="onDelete(scope.$index)"></el-button>
        </template>
        </el-table-column>
        </el-table>
    </div>
</div>

    <%--响应页面上的添加按钮弹出 添加宿舍/修改宿舍 对话框--%>
    <!--使用el-dialog组件显示添加/修改表单-->
    <%--        title="添加宿舍号（楼号-房间号）" --%>
<el-dialog
        width="60%"
        title="dialog.title"
        :visible.sync="dialog.show"
        :close-on-click-modal='false'
        :close-on-press-escape='false'
        :modal-append-to-body='false'
        >

<%--    form表单，显示填数据的组件--%>
    <div class="form">
        <!--使用el-form组件进行数据添加和修改-->
        <el-form
                ref="myform"
                :model="mymodel"
                :rules="myrules"
                label-width="150px"
                style="margin: 10px;
                width: auto;">

            <el-form-item label="宿舍号" required>
                <el-col :span="15">
                    <el-form-item prop="dormNo">
                        <el-input type="string" v-model="mymodel.dormNo"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item class="text_right">
                    <el-button @click="dialog.show = false">取 消</el-button>
                    <el-button type="primary" @click='onSubmit("myform")'>保存</el-button>
            </el-form-item>

        </el-form>
    </div>
</el-dialog>

</div>

<%--&lt;%&ndash;修改宿舍对话框&ndash;%&gt;--%>
<%--<el-dialog--%>
<%--&lt;%&ndash;        title="添加宿舍号（楼号-房间号）" &ndash;%&gt;--%>
<%--        width="80%"--%>
<%--        title="dialogEdit.title"--%>
<%--        :visible.sync="dialogEdit.show"--%>
<%--        :close-on-click-modal='false'--%>
<%--        :close-on-press-escape='false'--%>
<%--        :modal-append-to-body='false'--%>
<%-->--%>

<%--    <!--使用el-form组件进行数据修改-->--%>
<%--    <!--:rules="myrulesEdit" 这是表单校验规则-->--%>
<%--    <el-form--%>
<%--            ref="myformedit"--%>
<%--            :model="mymodel"--%>
<%--            label-width="150px"--%>
<%--            style="margin: 10px;--%>
<%--            width: auto;">--%>
<%--        <el-form-item label="宿舍号" required>--%>
<%--            <el-col :span="20">--%>
<%--                <el-form-item prop="dormno">--%>
<%--                    <el-input type="string" v-model="mymodel.dormno"></el-input>--%>
<%--                </el-form-item>--%>
<%--            </el-col>--%>
<%--        </el-form-item>--%>
<%--        <el-form-item>--%>
<%--            <div  class="text-right">--%>
<%--                <el-button @click="dialogEdit.show= false">取 消</el-button>--%>
<%--                <el-button type="primary" @click='onSubmitEdit("myformedit")'>保存</el-button>--%>
<%--            </div>--%>
<%--        </el-form-item>--%>

<%--    </el-form>--%>

<%--</el-dialog>--%>

<%--1 引入vue.js--%>
<script src="${pageContext.request.contextPath}/static/vue/vue.js"></script>
<%--2.2引入element ui.js --%>
<script src="${pageContext.request.contextPath}/static/element-ui/index.js"></script>
<%--3. 引入axios  axios 是一个基于 promise 的 HTTP 库,可以用在浏览器和 node.js 中--%>
<script src="${pageContext.request.contextPath}/static/axios/axios.js"></script>
<%--4.引入配置js--%>
<script src="${pageContext.request.contextPath}/static/mx-config.js"></script>

<script>
<%-- Vue: html标签与js--%>
    //定义一个vue实例
    var app=new Vue({
        //模板名称,在html中引用的组件名称
        el:"#app",
        //定义数据，可以在html中使用
        data:function(){
            return{
                //定义表格要的数据，数据库中？
                tableData:[
                    {
                        dormNo:'',
                    }
                ],

                //定义一个变量,存放哪行数据被选中,数据库从0开始
                selectItemIndex: -1,

                //定义对话框:如果对话框有自定义的数据需要通过变量控制,需要先定义
                //添加/修改对话框共用一个，需获取或设置对话框的属性：add edit
                // 用法：.dialog(  'option'  , optionName , [value] )
                dialog:{
                    show:false,
                    title:'',
                    option: "",
                },

                //模型数据是与表单进行绑定,通过:model="form"与表单绑定
                mymodel:{
                    //index???
                    dormNo:'',
                },

                //表单校验规则
                myrules: {
                    dormNo: [
                        {required: true, message: '请输入宿舍号', trigger: 'blur'},
                        {min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur'}
                    ]
                },

            }
        },
        //生命周期函数:mounted--是加载模板后
        //一般初始化的数据都可在这执行
        mounted:function () {
            //初始化表格
            this.initTable();
        },
        methods:{
            //初始化表格数据
            initTable:function () {
                //通过axios调用服务器json服务
                //从后台获得数据库数据
                axios.get("/app/dorm").then(res=>{
                    //把返回结果赋给data里定义的变量this.tableData
                    this.tableData=res.data;
                });
            },

            //响应添加按钮
            onAdd:function () {
                //添加宿舍号对话框
                this.dialog = {
                    title:"添加宿舍号",
                    show:true,//显示对话框
                    option: "add",//对话框的属性
                };
                this.mymode={
                    dormNo:'',
                };
            },

            //修改按钮
            onEdit:function(index){
                //
                this.dialog = {
                    show:true,
                    title:"修改宿舍号",
                    option:'edit'//获取或设置对话框的属性
                };
                // 清除校验,需要延迟,否则会由于还未渲染完form,报错
                //效验会下面有提示
                this.$nextTick(()=>{
                    this.$refs['myform'].clearValidate();
                });

                //更新model数据
                this.mymodel={
                    dormNo:this.tableData[index].dormNo,
                };

                //设置哪行被选中了,与数据库对应
                this.selectItemIndex=index;
            },
            //查
            //响应删除按钮，提示框
            onDelete:function (index) {
                this.$confirm('确定删除该数据吗?','提示',{
                    confirmButtonText:'确定',
                    cancelButtonText:'取消',
                    type:'warning'
                }) .then(()=>{
                    // 删除
                    axios.delete("/app/dorm/"+this.tableData[index].dormNo).then(res => {
                        this.$message("删除成功");
                        //删除table起始下标为1，长度为1的一个值
                        this.tableData.splice(index,1);
                    });//异常处理
                }).catch(()=>{

                });
            },

            //表单上的 保存按钮，针对不同的操作:添加/修改
                //添加,调用post方法，对应的是添加表单的保存按钮，mymodel,form数据改，tableData服务器数据改
                // axios.post默认是application/json方式提交数据，
                //添加对话框的
            onSubmit(myform){
                if(this.dialog.option == "add"){
                    axios.post("/app/dorm",this.mymodel).then(res => {
                        //操作成功
                        this.$message({
                            message:"保存成功！",
                            type:"success"
                        });
                        //方法1:更新table，服务器数据
                        this.tableData.push(res.data);
                        //保存后，关闭对话框
                        this.dialog.show=false;
                    })
                }//修改的,调用put方法，对应的是修改中的保存按钮
                //修改对话框的
                else if (this.dialog.option=='edit'){
                    axios.put("/app/dorm",this.mymodel).then(res => {
                        //操作成功
                        this.$message({
                            message:"保存成功！",
                            type:"success"
                        });
                        //方法1:更新指定索引的元素
                        this.tableData.splice(this.selectItemIndex,1,res.data)

                        this.dialog.show=false;
                    })
                }
            }

        }

    });


            // //响应添加用户对话框 保存 按钮
            // onSubmitAdd:function () {
            //     //把表单数据提交给 后台数据库
            //     axios.post("/app/dorm",this.mymodel).then(res=>{
            //         //操作成功
            //         this.$message({
            //             message:"保存成功！",
            //             type:"success"
            //         });
            //         //方法1:更新table
            //         this.tableData.push(res.data);
            //
            //         //关闭对话框
            //         this.dialog.show=false;
            //
            //     })
            // },
            //
            // //响应修改按钮
            // onEdit:function (index) {
            //     //表单数据回填----给模型赋值：选中的行 数据
            //     this.mymodel.dormno=this.tableData[index].dormno;
            //
            //     //哪行数据被选中
            //     this.selectItemIndex=index;
            //
            //     this.dialogEdit.title='修改宿舍信息';
            //     this.dialogEdit.show=true;
            // },
            // //响应修改对话框 保存按钮
            // onSubmitEdit:function (form) {
            //     //把表单数据 保存到数据库put
            //     axios.put("/app/dorm",this.mymodel).then(res=>{
            //         //操作成功
            //         this.$message({
            //             message: "保存成功！",
            //             type:"success"
            //         });
            //         //方法1:更新指定索引的元素
            //         this.tableData.splice(this.selectItemIndex,1,res.data)
            //
            //         //关闭对话框
            //         this.dialogEdit.show=false;
            //     })
            // },


</script>

</body>
</html>
