<%--
  Created by IntelliJ IDEA.
  User: 日升
  Date: 2020/3/17
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <!--2.1 引入 element ui-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--挂载vue实例-->
<div id="app">
    <div class="mx-main-content">
        <div class="mx-table-title">
            用户列表&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button type="primary" size="mini" @click="onAdd()">添加</el-button>
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
                <el-table-column
                        type="index"
                        label=""
                        width="50">
                </el-table-column>
                <el-table-column
                        prop="userLoginId"
                        label="账号"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="userName"
                        label="姓名" width="100">
                </el-table-column>
                <el-table-column
                        prop="isSystem"
                        label="账号类型" width="100">
                    <template slot-scope="scope">
                        <span v-if="scope.row.isSystem=='0'">普通账号</span>
                        <span v-if="scope.row.isSystem=='1'">系统管理员</span>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="email"
                        label="邮箱" width="150">
                </el-table-column>
                <el-table-column
                        prop="mobile"
                        label="电话" width="150">
                </el-table-column>
                <el-table-column
                        prop="currentStatus"
                        label="状态" width="100">
                    <template slot-scope="scope">
                        <span v-if="scope.row.currentStatus=='0'">正常</span>
                        <span v-if="scope.row.currentStatus=='1'">禁用</span>
                    </template>
                </el-table-column>
                <el-table-column
                        prop=""
                        label="操作" width="220">
                    <template slot-scope="scope">
                        <el-button size="mini" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
                        <el-button size="mini" plain type="danger" @click="onDelete(scope.$index)">删除</el-button>
                        <el-button size="mini" plain type="info" @click="onResetPwd(scope.$index)">密码</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
    <!--注册用户 对话框-->
    <el-dialog
            width="80%"
            :title="dialog.title"
            :visible.sync="dialog.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>
        <!--使用el-form组件进行数据添加和修改-->
        <el-form
                ref="myform"
                :model="mymodel"
                label-width="150px"
                style="margin:10px;width:auto;">
            <el-form-item hidden prop='userId' label="ID:">
                <el-input type="string" v-model="mymodel.userId"></el-input>
            </el-form-item>
            <el-form-item label="登录账号" required>
                <el-col :span="15">
                    <el-form-item prop='userLoginId'>
                        <el-input type="string" v-model="mymodel.userLoginId"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="登录密码" required>
                <el-col :span="15">
                    <el-form-item prop='currentPassword'>
                        <el-input type="password" v-model="mymodel.currentPassword"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item prop='currentPassword2' label="重复密码">
                <el-col :span="15">
                    <el-input type="password" v-model="mymodel.currentPassword2"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='isSystem' label="账号类型:">
                <!--使用label表示值-->
                <el-radio-group v-model="mymodel.isSystem">
                    <el-radio-button label="0">普通账号</el-radio-button>
                    <el-radio-button label="1">系统管理员</el-radio-button>
                </el-radio-group>
            </el-form-item>

            <el-form-item label="姓名" required>
                <el-col :span="15">
                    <el-form-item prop='userName'>
                        <el-input type="string" v-model="mymodel.userName"></el-input>
                    </el-form-item>
                </el-col>

            </el-form-item>

            <el-form-item prop='mobile' label="手机号码:">
                <el-col :span="15">
                    <el-input type="string" v-model="mymodel.mobile"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='email' label="电子邮箱:">
                <el-col :span="15">
                    <el-input type="string" v-model="mymodel.email"></el-input>
                </el-col>
            </el-form-item>

            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitAdd("myform")'>保 存</el-button>
                <el-button @click="dialog.show = false">取 消</el-button>
            </el-form-item>

        </el-form>

    </el-dialog>

    <!--修改用户信息 对话框-->
    <el-dialog
            width="80%"
            :title="dialogEdit.title"
            :visible.sync="dialogEdit.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>
        <!--使用el-form组件进行数据添加和修改-->
        <!--:rules="myrulesEdit" 这是表单校验规则-->

        <el-form
                ref="myformedit"
                :model="mymodel"
                label-width="150px"
                style="margin:10px;width:auto;">
            <el-form-item hidden prop='userId' label="ID:">
                <el-input type="string" v-model="mymodel.userId"></el-input>
            </el-form-item>
            <!--如果是修改,则账号为只读-->
            <el-form-item label="登录账号">
                <el-col :span="15">
                    <el-form-item prop='userLoginId'>
                        <el-input type="string" readonly v-model="mymodel.userLoginId"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item prop='isSystem' label="账号类型:">
                <!--使用label表示值-->
                <el-radio-group v-model="mymodel.isSystem">
                    <el-radio-button label="0">普通账号</el-radio-button>
                    <el-radio-button label="1">系统管理员</el-radio-button>
                </el-radio-group>
            </el-form-item>

            <el-form-item label="姓名" required>
                <el-col :span="15">
                    <el-form-item prop='userName'>
                        <el-input type="string" v-model="mymodel.userName"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item prop='mobile' label="手机号码:">
                <el-col :span="15">
                    <el-input type="string" v-model="mymodel.mobile"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item prop='email' label="电子邮箱:">
                <el-col :span="15">
                    <el-input type="string" v-model="mymodel.email"></el-input>
                </el-col>
            </el-form-item>

            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitEdit("myformedit")'>保 存</el-button>
                <el-button @click="dialogEdit.show = false">取 消</el-button>
            </el-form-item>

        </el-form>
    </el-dialog>
    <!--修改密码对话框-->
    <el-dialog
            width="80%"
            :title="dialogPwd.title"
            :visible.sync="dialogPwd.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>
        <div class="form">
            <el-form
                    ref="myformpwd"
                    :model="mymodel"

                    label-width="150px"
                    style="margin:10px;width:auto;">
                <el-form-item hidden prop='userId' label="ID:">
                    <el-input type="string" v-model="mymodel.userId"></el-input>
                </el-form-item>
                <el-form-item label="登录账号">
                    <el-col :span="15">
                        <el-form-item prop='userLoginId'>
                            <el-input type="string" readonly v-model="mymodel.userLoginId"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item label="登录密码" required>
                    <el-col :span="15">
                        <el-form-item prop='currentPassword'>
                            <el-input type="password" v-model="mymodel.currentPassword"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item prop='currentPassword2' label="重复密码">
                    <el-col :span="15">
                        <el-input type="password" v-model="mymodel.currentPassword2"></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item class="text_right">
                    <el-button type="primary" @click='onSubmitPwd("myformpwd")'>保 存</el-button>
                    <el-button @click="dialogPwd.show = false">取 消</el-button>
                </el-form-item>
            </el-form>

        </div>
    </el-dialog>
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
                        userLoginId: 'admin',
                        currentPassword: '',
                        userName:'王大虎',
                        email:'admin@hbxy.cn',
                        mobile:'18088888888',
                        isSystem:'1',
                        currentStatus:'0'
                    }
                ],
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
                dialogPwd:{
                    title:"",
                    show:false
                },

                //模型数据是与表单进行绑定,通过:model="form"与表单绑定
                mymodel:{
                    userId: '',
                    userLoginId: '',
                    currentPassword: '',
                    currentPassword2:'',
                    userName:'',
                    email:'',
                    mobile:'',
                    isSystem:'0',
                    currentStatus:'0'
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
                axios.get("/admin/user").then(res => {
                    this.tableData = res.data;
            })
            },
            //响应添加按钮
            onAdd:function () {
                //清空模型数据
                this.mymodel.userId = '';
                this.mymodel.userLoginId = '';
                this.mymodel.currentPassword = '';
                this.mymodel.currentPassword2='';
                this.mymodel.userName='';
                this.mymodel.email='';
                this.mymodel.mobile='';
                this.mymodel.isSystem='0';
                this.mymodel.currentStatus='0';

                this.dialog.title = '注册用户';
                this.dialog.show = true;
            },
            //响应添加用户对话框 保存 按钮
            onSubmitAdd:function (form) {
                //把表单数据提交给 后台数据库
                axios.post("/admin/user",this.mymodel).then(res =>{
                    // 操作成功
                    this.$message({
                        message: "保存成功！",
                        type: "success"
                    });
                //方法1:更新table
                this.tableData.push(res.data);
                //方法2:更新table:在最后添加一个元素,0表示添加
                //this.tableData.splice(this.tableData.length,0,res.data);
                //方法3：直接更新全部表格
                //this.initTable();

                //关闭对话框
                this.dialog.show = false;
            })
            },

            //响应修改按钮
            onEdit:function (index) {

                //表单数据回填----给模型赋值：选中的行 数据
                this.mymodel.userId = this.tableData[index].userId;
                this.mymodel.userLoginId =this.tableData[index].userLoginId;
                this.mymodel.currentPassword = '';
                this.mymodel.currentPassword2='';
                this.mymodel.userName=this.tableData[index].userName;
                this.mymodel.email=this.tableData[index].email;
                this.mymodel.mobile=this.tableData[index].mobile;
                this.mymodel.isSystem=this.tableData[index].isSystem;

                //哪行数据被选中
                this.selectItemIndex = index;

                this.dialogEdit.title='修改用户信息';
                this.dialogEdit.show = true;
            },
            //响应修改对话框 保存按钮
            onSubmitEdit:function (form) {
                //把表单数据 保存到数据库
                axios.put("/admin/user",this.mymodel).then( res =>{

                    // 操作成功
                    this.$message({
                        message: "保存成功！",
                        type: "success"
                    });

                // 方法1:更新指定索引的元素
                this.tableData.splice(this.selectItemIndex, 1, res.data)
                // 方法2:数据重新从服务器加载table数据,这种方法效率差
                // this.initTable();
                // 关闭对话框
                this.dialogEdit.show = false;
            })
            },

            //修改密码
            onResetPwd:function(index){
                this.mymodel.userId = this.tableData[index].userId;
                this.mymodel.userLoginId =this.tableData[index].userLoginId;
                this.mymodel.currentPassword = '';
                this.mymodel.currentPassword2='';
                this.mymodel.userName=this.tableData[index].userName;
                this.mymodel.email=this.tableData[index].email;
                this.mymodel.mobile=this.tableData[index].mobile;
                this.mymodel.isSystem=this.tableData[index].isSystem;

                //哪行数据被选中
                this.selectItemIndex = index;

                this.dialogPwd.title='重置密码';
                this.dialogPwd.show = true;
            },
            //响应重置密码对话框 保存按钮
            onSubmitPwd:function(form){
                //把表单数据 保存到数据库
                axios.put("/admin/user",this.mymodel).then( res =>{

                    // 操作成功
                    this.$message({
                        message: "保存成功！",
                        type: "success"
                    });

                // 方法1:更新指定索引的元素
                this.tableData.splice(this.selectItemIndex, 1, res.data)
                // 方法2:数据重新从服务器加载table数据,这种方法效率差
                // this.initTable();
                // 关闭对话框
                this.dialogPwd.show = false;
            })
            },
            //响应删除按钮
            onDelete:function (index) {
                this.$confirm('确认删除该数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 删除
                    axios.delete("/admin/user/" + this.tableData[index].userId).then(res => {
                        this.$message("删除成功");
                // 删除table起始下标为1，长度为1的一个值
                this.tableData.splice(index, 1);
            });
            }).catch(() => {

                });
            }


        }
    });
</script>
</body>
</html>
