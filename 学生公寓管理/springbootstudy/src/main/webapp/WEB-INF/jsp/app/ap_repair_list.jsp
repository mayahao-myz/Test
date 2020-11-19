<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/17
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>报修信息</title>
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
            <span>报修信息列表</span>&nbsp;&nbsp;
            <el-button
                    size="mini"
                    type="primary"
                    @click='onAdd()'>添加
            </el-button>
        </div>
        <el-divider></el-divider>
        <div class="mx-table-content">
            <!--使用element-ui table组件-->
            <el-table
                    v-if="tableData.length > 0"
                    :data='tableData'
                    :stripe="true"
                    style="width: 100%">
<%--                表格的每一行--%>
                <el-table-column
                        type="index"
                        label=""
                        align='center'
                        width="50">
                </el-table-column>
<%--                手动输入，不要使用自动生成的，会乱码--%>
                <el-table-column
                    prop="repairId"
                    label="报修编号"
                    align="center">
                </el-table-column>

                <el-table-column
                        prop="dormNo"
                        label="宿舍号"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="repairData"
                        label="日期"
                        align="center">
                </el-table-column>
                <el-table-column
                        prop="repairContent"
                        label="报修内容"
                        align="center">
                </el-table-column>
                <!--操作按钮-->
                <el-table-column
                        label="操作"
                        align='center'
                        width="200"
                        align="center">
                    <template slot-scope="scope">
                        <el-tooltip class="item" effect="light" content="修改报修信息">
                            <el-button size="mini" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
                        </el-tooltip>
                        <el-tooltip class="item" effect="light" content="删除报修信息">
                            <el-button size="mini" plain type="danger" @click="onDelete(scope.$index)">删除</el-button>
                        </el-tooltip>
                    </template>
                </el-table-column>
            </el-table>

        </div>
    </div>

    <!--使用el-dialog组件显示添加表单-->
    <el-dialog
            width="80%"
            :title="dialog.title"
            :visible.sync="dialog.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>
        <div class="form">
            <!--使用el-form组件进行数据添加和修改-->
            <el-form
                    ref="myform"
                    :model="mymodel"
                    label-width="150px"
                    style="margin:10px; width:auto;">
<%--                表单的每一项--%>
<%--                这一项的标签+列(组件input)--%>
                <el-form-item  label="报修编号" required>
                    <el-col :span="15">
                        <el-form-item prop='repairId'>
                            <el-input type="integer" v-model="mymodel.repairId"></el-input>
                        </el-form-item>
                    </el-col>
<%--                    <el-input type="integer" v-model="mymodel.repairId"></el-input>--%>
                </el-form-item>

<%--                <el-form-item label="宿舍号" required>--%>
<%--                    <el-col :span="15">--%>
<%--                        <el-form-item prop='dormNo'>--%>
<%--                            <el-input type="string" v-model="mymodel.dormNo"></el-input>--%>
<%--                        </el-form-item>--%>
<%--                    </el-col>--%>
<%--                </el-form-item>--%>

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

                <el-form-item label="报修内容" required>
                    <el-col :span="15">
                        <el-form-item prop='repairContent'>
                            <el-input type="timestamp" v-model="mymodel.repairContent"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>

                <el-form-item class="text_right">
                    <el-button type="primary" @click='onSubmitAdd("myform")'>保 存</el-button>
                    <el-button @click="dialog.show = false">取 消</el-button>
                </el-form-item>

            </el-form>
        </div>
    </el-dialog>

    <!--修改用户信息对话框-->
    <el-dialog
            width="80%"
            :title="dialogEdit.title"
            :visible.sync="dialogEdit.show"
            :close-on-click-modal='false'
            :close-on-press-escape='false'
            :modal-append-to-body='false'>
        <div class="form">
            <!--使用el-form组件进行数据添加和修改-->
            <el-form
                    ref="myformedit"
                    :model="mymodel"
            <%--                    :rules="myrulesEdit"--%>
                    label-width="150px"
                    style="margin:10px;width:auto;">
<%--                <el-form-item hidden prop='repairId' label="ID:">--%>
<%--                    <el-input type="integer" v-model="mymodel.repairId"></el-input>--%>
<%--                </el-form-item>--%>
<%--    报修编号不修改--%>
<%--                    <el-form-item  label="报修编号" required>--%>
<%--                        <el-col :span="15">--%>
<%--                             <el-form-item prop='repairId'>--%>
<%--                                <el-input type="integer" v-model="mymodel.repairId"></el-input>--%>
<%--                            </el-form-item>--%>
<%--                         </el-col>--%>
<%--        &lt;%&ndash;                    <el-input type="integer" v-model="mymodel.repairId"></el-input>&ndash;%&gt;--%>
<%--                    </el-form-item>--%>

<%--                <el-form-item label="宿舍号" required>--%>
<%--                    <el-col :span="15">--%>
<%--                        <el-form-item prop='dormNo'>--%>
<%--                            <el-input type="string" v-model="mymodel.dormNo"></el-input>--%>
<%--                        </el-form-item>--%>
<%--                    </el-col>--%>
<%--                </el-form-item>--%>

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

                <el-form-item label="日期" required>
                    <el-col :span="15">
                        <el-form-item prop='repairData'>
                            <el-input type="timestamp" v-model="mymodel.repairData"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item label="报修内容" required>
                    <el-col :span="15">
                        <el-form-item prop='repairContent'>
                            <el-input type="data" v-model="mymodel.repairContent"></el-input>
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item class="text_right">
                    <el-button type="primary" @click='onSubmitEdit("myformedit")'>保 存</el-button>
                    <el-button @click="dialog.show = false">取 消</el-button>
                </el-form-item>

            </el-form>
        </div>
    </el-dialog>
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
                tableData: [],
                //定义一个变量,存放哪行数据被选中
                selectItemIdex: -1,

                //定义对话框:如果对话框有自定义的数据需要通过变量控制,需要先定义
                //添加对话框
                dialog: {
                    show: false,
                    title: "",
                    option: ""
                },
                //修改对话框
                dialogEdit: {
                    show: false,
                    title: "",
                    option: ""
                },

                //定义模型,通过:model="form"与表单绑定
                mymodel: {
                    repairId: '',
                    dormNo:'',
                    repairData: '',
                    repairContent: ''
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
            selectData() {
                //通过axios调用服务器json服务
                axios.get("/app/repair/").then(res => {
                    this.tableData = res.data;
                });
            },

            // 响应添加按钮,弹出添加对话框(与修改共用)
            onAdd:function() {
                this.dialog = {
                    show: true,
                    title: "添加报修信息",
                    option: "add"
                };
                this.mymodel = {
                    repairId: '',
                    dormNo:'',
                    repairData: '',
                    repairContent: ''
                };
            },
            onEdit(index) {
                // 编辑
                this.dialogEdit = {
                    show: true,
                    title: "修改报修信息",
                    option: "edit"
                };
                //更新model数据
                this.mymodel = {
                    repairId: this.tableData[index].repairId,
                    dormNo: this.tableData[index].dormNo,
                    repairData: this.tableData[index].repairData,
                    repairContent: this.tableData[index].repairContent
                };
                //设置哪行被选中了
                this.selectItemIdex = index;
            },
            // 响应删除按钮
            onDelete(index) {
                this.$confirm('确认删除该数据吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() =>{
                    // 删除
                    axios.delete("/app/repair/" + this.tableData[index].repairId).then(res => {
                        this.$message("删除成功");
                        // 删除table起始下标为1，长度为1的一个值
                        this.tableData.splice(index, 1);
                    });
                }).catch(() => {}
                );
            },
            // 响应添加/修改对话框中的保存按钮
            onSubmitAdd() {
                //添加,调用post方法
                axios.post("/app/repair",this.mymodel).then(res => {
                    // 操作成功
                    this.$message({
                        message: "保存成功！",
                        type: "success"
                    });
                    //方法1:更新table
                    //this.tableData.push(res.data);
                    //方法2:更新table:在最后添加一个元素,0表示添加
                    this.tableData.splice(this.tableData.length,0,res.data);
                    //关闭对话框
                    this.dialog.show = false;
                })
            },
            //修改,调用put方法
            onSubmitEdit() {

                axios.put("/app/repair", this.mymodel).then(res => {
                    // 操作成功
                    this.$message({
                        message: "保存成功！",
                        type: "success"
                    });

                    // 方法1:更新指定索引的元素
                    this.tableData.splice(this.selectItemIdex, 1, res.data)
                    // 方法2:数据重新从服务器加载table数据,这种方法效率差
                    // this.getData();
                    // 关闭对话框
                    this.dialogEdit.show = false;
                })
            }
        },
    })
</script>
</body>
</html>

