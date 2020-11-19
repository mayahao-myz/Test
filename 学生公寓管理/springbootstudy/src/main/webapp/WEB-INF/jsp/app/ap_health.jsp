<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/17
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>卫生检查管理</title>
    <!--2.1 引入 element ui-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--挂载vue实例-->
<div id="app">
    <div class="mx-main-content">
        <div class="mx-table-title">
            卫生情况列表&nbsp;&nbsp;&nbsp;&nbsp;
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
                        label="序列"
                        width="80"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="healthId"
                        label="编号"
                        width="100"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="dormNo"
                        label="宿舍号"
                        width="120"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="healthData"
                        label="检查日期"
                        width="270"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="healthGrade"
                        label="分数"
                        width="100"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="healthRemark"
                        label="备注"
                        width="150"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop=""
                        label="操作" width="150"
                        align="center">
                    <template slot-scope="scope">
                        <el-button size="mini" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
                        <el-button size="mini" plain type="danger" @click="onDelete(scope.$index)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
    <!--注册 对话框-->
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
            <el-form-item label="编号" required>
                <el-col :span="15" >
                    <el-form-item prop='healthId'>
                        <el-input type="string" v-model="mymodel.healthId"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

<%--            <el-form-item label="宿舍号" required>--%>
<%--                <el-col :span="15">--%>
<%--                    <el-form-item prop='dormNo'>--%>
<%--                        <el-input type="string" v-model="mymodel.dormNo"></el-input>--%>
<%--                    </el-form-item>--%>
<%--                </el-col>--%>
<%--            </el-form-item>--%>

            <el-form-item label="宿舍号" prop="dormNo" required>
                <el-select v-model="mymodel.dormNo" placeholder="请选择宿舍号">
                    <el-option label="1-102" value="1-102"></el-option>
                    <el-option label="2-202" value="2-202"></el-option>
                    <el-option label="3-301" value="3-301"></el-option>
                    <el-option label="3-303" value="3-303"></el-option>
                    <el-option label="9-620" value="9-620"></el-option>
                    <el-option label="10-520" value="10-520"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item label="分数" required>
                <el-col :span="15">
                    <el-form-item prop='healthGrade'>
                        <el-input type="string" v-model="mymodel.healthGrade"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="备注" required>
                <el-col :span="15">
                    <el-form-item prop='healthRemark'>
                        <el-input type="string" v-model="mymodel.healthRemark"></el-input>
                    </el-form-item>
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
            <el-form-item label="编号">
                <el-col :span="15">
                    <el-form-item prop='healthId'>
                        <el-input type="string" readonly v-model="mymodel.healthId"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

<%--            <el-form-item label="宿舍号">--%>
<%--                <el-col :span="15">--%>
<%--                    <el-form-item prop='dormNo'>--%>
<%--                        <el-input type="string" v-model="mymodel.dormNo"></el-input>--%>
<%--                    </el-form-item>--%>
<%--                </el-col>--%>
<%--            </el-form-item>--%>

            <el-form-item label="宿舍号" prop="dormNo" required>
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

            <el-form-item label="检查日期">
                <el-col :span="15">
                    <el-form-item prop='healthData'>
                        <el-input type="string" v-model="mymodel.healthData"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item label="分数">
                <el-col :span="15">
                    <el-form-item prop='healthGrade'>
                        <el-input type="string" v-model="mymodel.healthGrade"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item label="备注">
                <el-col :span="15">
                    <el-form-item prop='healthRemark'>
                        <el-input type="string" v-model="mymodel.healthRemark"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitEdit("myformedit")'>保 存</el-button>
                <el-button @click="dialogEdit.show = false">取 消</el-button>
            </el-form-item>

        </el-form>
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
                        healthId:'',
                        dormNo:'',
                        healthData:'',
                        healthGrade:'',
                        healthRemark:''
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
                axios.get("/app/health").then(res => {
                    this.tableData = res.data;
                })
            },
            //响应添加按钮
            onAdd:function () {
                //清空模型数据
                this.mymodel.healthId = '';
                this.mymodel.dormNo = '';
                this.mymodel.healthData = '';
                this.mymodel.healthGrade ='';
                this.mymodel.healthRemark ='';

                this.dialog.title = '添加卫生信息';
                this.dialog.show = true;
            },
            //响应添加用户对话框 保存 按钮
            onSubmitAdd:function (form) {
                //把表单数据提交给 后台数据库
                axios.post("/app/health",this.mymodel).then(res =>{
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
                this.mymodel.healthId = this.tableData[index].healthId;
                this.mymodel.dormNo =this.tableData[index].dormNo;
                this.mymodel.healthData=this.tableData[index].healthData;
                this.mymodel.healthGrade=this.tableData[index].healthGrade;
                this.mymodel.healthRemark=this.tableData[index].healthRemark;

                //哪行数据被选中
                this.selectItemIndex = index;

                this.dialogEdit.title='修改卫生信息';
                this.dialogEdit.show = true;
            },
            //响应修改对话框 保存按钮
            onSubmitEdit:function (form) {
                //把表单数据 保存到数据库
                axios.put("/app/health",this.mymodel).then( res =>{

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

            //响应删除按钮
            onDelete:function (index) {
                this.$confirm('确认删除该数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    // 删除
                    axios.delete("/app/health/" + this.tableData[index].healthId).then(res => {
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

