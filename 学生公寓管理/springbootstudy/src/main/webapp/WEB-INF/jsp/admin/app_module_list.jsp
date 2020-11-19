<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>应用模块管理</title>
  <!--引入element-ui.css-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/element-ui/index.css">
  <!--引入自定义样式el-custom.css-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/el-custom.css">
  <style>
    /*本页样式*/
    .leftpane {
      width: 40%;
      height: calc(100% - (30px + 48px));
      overflow: auto;
      border: solid 1px #ecf3fd;
      float: left;
    }

    .rightpane {
      width: 58%;
      height: calc(100% - (30px + 48px));
      border: solid 1px #ecf3fd;
      float: right;
    }

    .mx-table-title2 {
      box-sizing: border-box;
      width: 100%;
      height: 30px;
      margin: 10px 0px;
      padding-left: 15px;
      font-size: larger;
      color: #909399;
      text-align: left;
    }
  </style>

</head>
<body>
<!--开始使用vue模板-->
<div id="app">
  <!--页面内容区域-->
  <div class="mx-main-content">
    <div class="mx-table-title">
      <span>应用子系统（模块分组）列表</span>&nbsp;&nbsp;
    </div>
    <el-divider></el-divider>
    <div class="mx-table-content">
      <!--使用element-ui table组件-->
      <div class="leftpane">
        <div class="mx-table-title2">
          <span>子系统</span>&nbsp;&nbsp;
        </div>
        <el-table
            v-if="appTableData.length > 0"
            :data='appTableData'
            :stripe="true"
            :show-header="false"
            highlight-current-row
            @current-change="handleCurrentChange"
            style="width: 100%">
          <el-table-column
              type="index"
              label=""
              align='center'>
          </el-table-column>
          <el-table-column
              prop="appName"
              label="">
          </el-table-column>
        </el-table>
      </div>
      <div class="rightpane">
        <div class="mx-table-title2">
          <span>{{appName}}&nbsp;&nbsp;应用模块</span>
          <el-button v-if="appName != ''"
                     type="primary"
                     size="mini"
                     @click='onAdd()'>添加
          </el-button>
        </div>
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
              prop="moduleCode"
              label="编码">
          </el-table-column>
          <el-table-column
            prop="moduleName"
            label="名称">
        </el-table-column>
          <el-table-column
              prop="needRight"
              label="需要权限"
              align="center">
            <template slot-scope="scope">
              <span v-if="scope.row.needRight == '1'">是</span>
              <span v-if="scope.row.needRight == '0'">否</span>
            </template>
          </el-table-column>

          <!--操作按钮-->
          <el-table-column
              label="操作"
              align='center'
              width="220">
            <template slot-scope="scope">
                <el-button size="mini" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
                <el-button size="mini" plain type="danger" @click="onDelete(scope.$index)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>

    </div>
  </div>

  <!--使用el-dialog组件显示添加/修改表单-->
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
          :rules="myrules"
          label-width="150px"
          style="margin:10px;width:auto;">
        <el-form-item hidden prop='moduleId' label="ID:">
          <el-input type="string" v-model="mymodel.moduleId"></el-input>
        </el-form-item>

        <el-form-item label="编码" required>
          <el-col :span="15">
            <el-form-item prop='moduleCode'>
              <el-input type="string" v-model="mymodel.moduleCode"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="名称" required>
          <el-col :span="15">
            <el-form-item prop='moduleName'>
              <el-input type="string" v-model="mymodel.moduleName"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="入口URL" required>
          <el-col :span="15">
            <el-form-item prop='moduleUrl'>
              <el-input type="string" v-model="mymodel.moduleUrl"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item prop='moduleIconUrl' label="图标URL">
          <el-col :span="15">
            <el-input type="string" v-model="mymodel.moduleIconUrl"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item prop='needRight' label="需要权限">
          <!--使用label表示值-->
          <el-radio-group v-model="mymodel.needRight">
            <el-radio-button label="1">是</el-radio-button>
            <el-radio-button label="0">否</el-radio-button>
          </el-radio-group>
        </el-form-item>

        <el-form-item class="text_right">
          <el-button type="primary" @click='onSubmit("myform")'>保 存</el-button>
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
<script src="${pageContext.request.contextPath}/static/axios/axios.min.js"></script>
<!--引入配置js-->
<script src="${pageContext.request.contextPath}/static/mx-config.js"></script>
<script>
  var app = new Vue({
    //模板名称,在html中引用的组件名称
    el: '#app',
    //定义数据
    //可以在html中使用
    data:function() {
      return {
        //定义表格要的数据
        tableData: [],
        appTableData: [],//子系统列表
        //定义一个变量,存放哪行数据被选中
        selectItemIdex: -1, //右侧被选中的行
        currentRow: null, //左侧被选中的行
        //被选中的子系统名称
        appName: '',

        //定义对话框:如果对话框有自定义的数据需要通过变量控制,需要先定义
        dialog: {
          show: false,
          title: "",
          option: ""
        },

        //定义模型,通过:model="form"与表单绑定
        mymodel: {
          appId: '',
          appName: '',
          moduleId: '',
          moduleCode: '',
          moduleName: '',
          moduleUrl: '',
          moduleIconUrl: '',
          needRight: '1'
        },
        //表单校验规则
        myrules: {
          moduleCode: [
            {required: true, message: '请输入编码', trigger: 'blur'},
            {min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur'}
          ],
          moduleName: [
            {required: true, message: '请输入名称', trigger: 'blur'},
            {min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur'}
          ],
          moduleUrl: [
            {required: true, message: '请输入模块功能入口URL', trigger: 'blur'},
            {min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur'}
          ]
        },
      }
    },

    //生命周期函数:mounted--是加载模板后
    //一般初始化的数据都可在这执行
    mounted: function () {
      this.searchData();
    },

    methods: {
      //从服务器获得数据
      searchData: function () {
        //通过axios调用服务器json服务
        axios.get("/admin/app").then(res => {
          //把返回结果赋给data里定义的变量this.tableData
          this.appTableData = res.data;
        });
      },
      searchData2: function (appId) {
        //通过axios调用服务器json服务
        axios.get("/admin/module/"+appId).then(res => {
          //把返回结果赋给data里定义的变量this.tableData
          this.tableData = res.data;
        });
      },
      //响应添加按钮
      onAdd: function () {
        this.dialog = {
          show: true,//显示对话框
          title: "添加应用模块",
          option: "add"
        };
        //清除校验,需要延迟,否则会由于还未渲染完form,报错
        this.$nextTick(()=>{
          this.$refs['myform'].clearValidate();
        });
        this.mymodel = {
          //给哪个子系统添加模块
          appId: this.currentRow.appId,
          appName: this.currentRow.appName,
          moduleId: '',
          moduleCode: '',
          moduleName: '',
          moduleUrl: '',
          moduleIconUrl: '',
          needRight: '1'
        };
      },
      onEdit: function (index) {
        // 编辑
        this.dialog = {
          show: true,
          title: "修改模块信息",
          option: "edit"
        };
        //清除校验,需要延迟,否则会由于还未渲染完form,报错
        this.$nextTick(() => {
          this.$refs['myform'].clearValidate();
        });
        //更新model数据
        this.mymodel = {
          appId: this.tableData[index].appId,
          appName: this.tableData[index].appName,
          moduleId: this.tableData[index].moduleId,
          moduleCode: this.tableData[index].moduleCode,
          moduleName: this.tableData[index].moduleName,
          moduleUrl: this.tableData[index].moduleUrl,
          moduleIconUrl: this.tableData[index].moduleIconUrl,
          needRight: this.tableData[index].needRight
        };
        //设置哪行被选中了
        this.selectItemIdex = index;
      },
      onDelete: function (index) {
        this.$confirm('确认删除该数据吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 删除
          axios.delete("/admin/module/" + this.tableData[index].moduleId).then(res => {
            this.$message("删除成功");
            // 删除table起始下标为1，长度为1的一个值
            this.tableData.splice(index, 1);
          });
        }).catch(() => {

        });
      },
      onSubmit(myform) {
        //添加,调用post方法
        if (this.dialog.option == "add") {
          axios.post("/admin/module", this.mymodel).then(res => {
            // 操作成功
            this.$message({
              message: "保存成功！",
              type: "success"
            });
            //方法1:更新table
            this.tableData.push(res.data);
            //方法2:更新table:在最后添加一个元素,0表示添加
            //this.tableData.splice(this.tableData.length,0,res.data);
            //关闭对话框
            this.dialog.show = false;
          })
          //修改,调用put方法
        } else if (this.dialog.option == "edit") {
          axios.put("/admin/module", this.mymodel).then(res => {
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
            this.dialog.show = false;
          })
        }
      },
      //处理左侧产品表格点击事件
      handleCurrentChange(val) {
        this.appName = '['+val.appName+']的';

        this.currentRow = val;

        this.searchData2(val.appId);
      },
    }
  })
</script>
</body>
</html>
