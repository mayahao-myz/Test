<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>授权管理</title>
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
      <span>给用户授予角色</span>&nbsp;&nbsp;
    </div>
    <el-divider></el-divider>
    <div class="mx-table-content">
      <!--使用element-ui table组件-->
      <el-table
          v-if="tableData.length > 0"
          :data='tableData'
          stripe="true"
          style="width: 100%">
        <el-table-column
            type="index"
            label=""
            align='center'
            width="80">
        </el-table-column>
        <el-table-column
            prop="userLoginId"
            label="账号">
        </el-table-column>
        <el-table-column
            prop="userName"
            label="姓名">
        </el-table-column>
        <el-table-column
            prop="mobile"
            label="电话">
        </el-table-column>
        <!--操作按钮-->
        <el-table-column
            label="操作"
            align='center'
            width="200">
          <template slot-scope="scope">
             <el-button size="mini" plain type="primary" @click="onRight(scope.$index)">授予角色</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>

  <!--给用户授予角色对话框-->
  <el-dialog
      width="80%"
      :title="dialogRight.title"
      :visible.sync="dialogRight.show"
      :close-on-click-modal='false'
      :close-on-press-escape='false'
      :modal-append-to-body='false'>
    <div class="form">
      <!--使用el-form组件进行数据添加和修改-->
      <el-form
          ref="myformRight"
          label-width="150px"
          style="margin:10px;width:auto;">

        <el-table
            ref="multipleTable"
            :data="roleTableData"
            tooltip-effect="dark"
            style="width: 100%">
          <el-table-column
              type="selection"
              width="55">
          </el-table-column>
          <el-table-column
              prop="roleCode"
              label="编码"
              width="120">
          </el-table-column>
          <el-table-column
              prop="roleName"
              label="角色名称">
          </el-table-column>
        </el-table>

        <br>
        <el-form-item class="text_right">
          <el-button type="primary" @click='onSaveRight()'>保 存</el-button>
          <el-button @click="dialogRight.show = false">取 消</el-button>
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
    data: function () {
      return {
        //定义表格要的数据
        tableData: [],
        //角色列表，可授予用户
        roleTableData: [],

        //定义一个变量,存放哪行数据被选中
        selectItemIdex: -1,

        dialogRight: {
          show: false,
          title: "",
          option: ""
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
        axios.get("/admin/user").then(res => {
          //把返回结果赋给data里定义的变量this.tableData
          this.tableData = res.data;
        });
        axios.get("/admin/role").then(res => {
          this.roleTableData = res.data;
        });
      },
      //打开分配权限对话框
      onRight: function (index) {
        this.dialogRight = {
          show: true,
          title: "给用户授予角色",
          option: "right"
        };
        let userId = this.tableData[index].userId;

        axios.get("/admin/roleuser/"+userId).then(res => {
          //获得原先已经授予过的角色
          let roles = res.data;
          this.$nextTick(() => {
            this.$refs.multipleTable.clearSelection();
            //循环判断表格每一行，看是否是原先已经授予过的角色
            this.roleTableData.forEach(row => {
              if(roles.indexOf(row.roleId) >= 0){
                this.$refs.multipleTable.toggleRowSelection(row,true);
              }
            });
          });
        });
        //设置哪行被选中了
        this.selectItemIdex = index;
      },
//userId 去判断哪个用户 账号和密码分配了什么样的权限，显示页面的不同--登录时去判断
      onSaveRight:function () {
        let userId = this.tableData[this.selectItemIdex].userId;
        let data = this.$refs.multipleTable.selection;
        axios.post("/admin/roleuser/"+userId, data).then(res => {
          // 操作成功
          this.$message({
            message: "保存成功！",
            type: "success"
          });
          this.$refs.multipleTable.clearSelection();

          // 关闭对话框
          this.dialogRight.show = false;
        });
      },
    }
  })
</script>
</body>
</html>
