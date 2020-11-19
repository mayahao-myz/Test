<%--
  Created by IntelliJ IDEA.
  User: 日升
  Date: 2020/5/7
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>水电信息管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
</head>
<body>
<!--挂载vue实例-->
<div id="app">
    <div class="mx-main-content">
        <div class="mx-table-title">
            水电信息表&nbsp;&nbsp;&nbsp;
            <el-button type="primary" size="mini" @click="onAdd()">添加</el-button>
        </div>

        <div class="el-divider">
            <el-divider></el-divider>
        </div>

        <%-- <input placeholder="请输入要查询的宿舍号" clearable name="dromSelect" id="dormSelect">
         <el-button type="select" size="mini" @click="onSelect()" round>查询</el-button>--%>
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
                        prop="hydrId"
                        label="编号"
                        width="90">
                </el-table-column>
                <el-table-column
                        prop="dromNo"
                        label="宿舍号" width="90">
                </el-table-column>
                <el-table-column
                        prop="hydrData"
                        label="日期" width="270">
                </el-table-column>

                <el-table-column
                        prop="hydrFree"
                        label="水电费" width="140">
                </el-table-column>

                <el-table-column
                        prop="hydrFreeState"
                        label="缴费状态" width="140">
                </el-table-column>

                <el-table-column
                        prop=""
                        label="操作" >
                    <template slot-scope="scope">
                        <el-button size="mini" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
                        <el-button size="mini" plain type="danger" @click="onDelete(scope.$index)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
    </div>
    <!--添加水电信息记录 对话框-->
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

            <el-form-item label="编号" required>
                <el-col :span="15">
                    <el-form-item prop='hydrId'>
                        <el-input type="string" v-model="mymodel.hydrId"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>


            <el-form-item label="宿舍号" required>
                <el-col :span="15">
                    <el-form-item prop='dromNo'>
                        <el-input type="string" v-model="mymodel.dromNo"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <%--<el-form-item label="宿舍号" required>
            <el-select id="dromNo" v-model="mymodel.dromNo" placeholder="请选择">
                <el-option>

                </el-option>
            </el-select>
            </el-form-item>--%>
            <%--<select id="dromNo" class="selectSJ" style="width: 200px">
                <option value="0">--请选择宿舍--</option>
            </select>--%>

            <el-form-item label="日期" required>
                <el-date-picker
                        v-model="mymodel.hydrData"
                        type="datetime"
                        value-format="yyyy-MM-dd'T'HH:mm:ss"
                        placeholder="选择日期时间">
                </el-date-picker>

                </el-date-picker>
            </el-form-item>

            <el-form-item label="水电费" required>
                <el-col :span="15">
                    <el-form-item prop='hydrFree'>
                        <el-input type="string" v-model="mymodel.hydrFree"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            </el-form-item>
            <el-form-item label="缴费状态" required>
                <el-select v-model="mymodel.hydrFreeState" placeholder="请选择">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>

            <el-form-item class="text_right">
                <el-button type="primary" @click='onSubmitAdd("myform")'>保 存</el-button>
                <el-button @click="dialog.show = false">取 消</el-button>
            </el-form-item>

        </el-form>

    </el-dialog>

    <!--修改水电记录信息 对话框-->
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
            <el-form-item label="编号">
                <el-col :span="15">
                    <el-form-item prop='hydrId'>
                        <el-input type="string" readonly v-model="mymodel.hydrId"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item label="宿舍号" required>
                <el-col :span="15">
                    <el-form-item prop='dromNo'>
                        <el-input type="string" v-model="mymodel.dromNo"></el-input>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item label="日期" required>
                <el-date-picker
                        v-model="mymodel.hydrData"
                        type="datetime"
                        value-format="yyyy-MM-dd'T'HH:mm:ss"
                        placeholder="选择日期时间">
                </el-date-picker>

            </el-form-item>

            <el-form-item prop='hydrFree' label="水电费">
                <el-col :span="15">
                    <el-input type="string" v-model="mymodel.hydrFree"></el-input>
                </el-col>
            </el-form-item>

            <el-form-item label="缴费状态" required>
                <el-select v-model="mymodel.hydrFreeState" placeholder="请选择">
                    <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                    </el-option>
                </el-select>
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
                        userId: '',
                        hydrId: '1',
                        dromNo:'10#520',
                        hydrData:'2020-05-07',
                        hydrFree:'100',
                        hydrFreeState:'已缴费',
                    }
                ],
                options: [{
                    value: '已缴费',
                    label: '已缴费'
                }, {
                    value: '未缴费',
                    label: '未缴费'

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
                axios.get("/app/hydr").then(res => {
                    this.tableData = res.data;
                })
            },
            //响应添加按钮
            onAdd:function () {
                //清空模型数据
                this.mymodel.userId='';
                this.mymodel.hydrId= '';
                this.mymodel.dromNo='';
                this.mymodel. hydrData='';
                this.mymodel.hydrFree='';
                this.mymodel.hydrFreeState='';

                this.dialog.title = '添加水电信息';
                this.dialog.show = true;
            },
            //响应添加用户对话框 保存 按钮
            onSubmitAdd:function (form) {
                //把表单数据提交给 后台数据库
                axios.post("/app/hydr",this.mymodel).then(res =>{
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
                this.mymodel.userId=this.tableData[index].userId;
                this.mymodel.hydrId= this.tableData[index].hydrId;
                this.mymodel.dromNo=this.tableData[index].dromNo;
                this.mymodel.hydrData=this.tableData[index].hydrData;
                this.mymodel.hydrFree=this.tableData[index].hydrFree;
                this.mymodel.hydrFreeState=this.tableData[index].hydrFreeState;
                //哪行数据被选中
                this.selectItemIndex = index;

                this.dialogEdit.title='修改水电信息';
                this.dialogEdit.show = true;
            },
            //响应修改对话框 保存按钮
            onSubmitEdit:function (form) {
                //把表单数据 保存到数据库
                axios.put("/app/hydr",this.mymodel).then( res =>{

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
                    axios.delete("/app/hydr/" + this.tableData[index].hydrId).then(res => {
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
