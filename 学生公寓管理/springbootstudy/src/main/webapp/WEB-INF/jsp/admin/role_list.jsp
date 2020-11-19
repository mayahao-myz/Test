<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>角色管理</title>
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
      <span>角色列表</span>&nbsp;&nbsp;
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
        <el-table-column
            type="index"
            label=""
            align='center'
            width="50">
        </el-table-column>
        <el-table-column
            prop="roleCode"
            label="编码"
        >
        </el-table-column>
        <el-table-column
            prop="roleName"
            label="名称"
        >
        </el-table-column>
        <!--操作按钮-->
        <el-table-column
            label="操作"
            align='center'
            width="300">
          <template slot-scope="scope">

<%--            <el-tooltip class="item" effect="light" content="分配权限">--%>
<%--            <el-button type="info" icon="el-icon-check" circle @click="onRight(scope.$index)"></el-button>--%>

            <el-button size="mini" plain type="info" @click="onRight(scope.$index)">分配权限</el-button>

            <el-button size="mini" plain type="primary" @click="onEdit(scope.$index)">修改</el-button>
<%--            <el-button type="primary" icon="el-icon-edit" circle @click="onEdit(scope.$index)"></el-button>--%>

            <el-button size="mini" plain type="danger" @click="onDelete(scope.$index)">删除</el-button>
<%--            <el-button type="danger" icon="el-icon-delete" circle @click="onDelete(scope.$index)"></el-button>--%>
          </template>
        </el-table-column>
      </el-table>
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
        <el-form-item hidden prop='roleId' label="ID:">
          <el-input type="string" v-model="mymodel.roleId"></el-input>
        </el-form-item>

        <el-form-item label="编码" required>
          <el-col :span="15">
            <el-form-item prop='roleCode'>
              <el-input type="string" v-model="mymodel.roleCode"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="名称" required>
          <el-col :span="15">
            <el-form-item prop='roleName'>
              <el-input type="string" v-model="mymodel.roleName"></el-input>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item prop='orderIndex' label="排序">
          <el-col :span="15">
            <el-input type="string" v-model="mymodel.orderIndex"></el-input>
          </el-col>
        </el-form-item>
        <el-form-item prop='comments' label="备注">
          <el-col :span="15" :rows="3" resize="none">
            <el-input type="textarea" v-model="mymodel.comments"></el-input>
          </el-col>
        </el-form-item>


        <el-form-item class="text_right">
          <el-button type="primary" @click='onSubmit("myform")'>保 存</el-button>
          <el-button @click="dialog.show = false">取 消</el-button>
        </el-form-item>

      </el-form>
    </div>
  </el-dialog>

  <!--分配权限对话框-->
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
        <el-tree
            :data="moduleRightData"
            show-checkbox
            default-expand-all
            node-key="id"
            ref="mytree"
            highlight-current
            :props="defaultProps">
        </el-tree>
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
        //应用模块作为权限资源
        moduleRightData: [],
        //指定树节点显示的数据属性
        defaultProps: {
          children: 'children',
          label: 'label'
        },

        //定义一个变量,存放哪行数据被选中
        selectItemIdex: -1,

        //定义对话框:如果对话框有自定义的数据需要通过变量控制,需要先定义
        dialog: {
          show: false,
          title: "",
          option: ""
        },
        dialogRight: {
          show: false,
          title: "",
          option: ""
        },
        //定义模型,通过:model="form"与表单绑定
        mymodel: {
          roleId: '',
          roleCode: '',
          roleName: '',
          orderIndex: '',
          comments: ''
        },
        //表单校验规则
        myrules: {
          roleCode: [
            {required: true, message: '请输入编码', trigger: 'blur'},
            {min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur'}
          ],
          roleName: [
            {required: true, message: '请输入名称', trigger: 'blur'},
            {min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur'}
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
        axios.get("/admin/role").then(res => {
          //把返回结果赋给data里定义的变量this.tableData
          this.tableData = res.data;
        });
        axios.get("/admin/moduleright").then(res => {
          //把返回结果赋给data里定义的变量this.tableData
          this.moduleRightData = res.data;
        });
      },
      //响应添加按钮
      onAdd: function () {
        this.dialog = {
          show: true,//显示对话框
          title: "添加角色",
          option: "add"
        };
        this.mymodel = {
          roleId: '',
          roleCode: '',
          roleName: '',
          orderIndex: '',
          comments: ''
        };
      },
      //修改
      onEdit: function (index) {
        // 编辑
        this.dialog = {
          show: true,
          title: "修改角色信息",
          option: "edit"
        };
        //清除校验,需要延迟,否则会由于还未渲染完form,报错
        this.$nextTick(() => {
          this.$refs['myform'].clearValidate();
        });
        //更新model数据
        this.mymodel = {
          roleId: this.tableData[index].roleId,
          roleCode: this.tableData[index].roleCode,
          roleName: this.tableData[index].roleName,
          orderIndex: this.tableData[index].orderIndex,
          comments: this.tableData[index].comments
        };
        //设置哪行被选中了
        this.selectItemIdex = index;
      },
      //删除
      onDelete: function (index) {
        this.$confirm('确认删除该数据吗?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 删除
          axios.delete("/admin/role/" + this.tableData[index].roleId).then(res => {
            this.$message("删除成功");
            // 删除table起始下标为1，长度为1的一个值
            this.tableData.splice(index, 1);
          });
        }).catch(() => {

        });
      },
      //打开分配权限对话框
      onRight: function (index) {
        this.dialogRight = {
          show: true,
          title: "给角色分配权限",
          option: "right"
        };
        //先清空之前的选择，需要延迟,否则会由于还未渲染完,报错
        this.$nextTick(() => {
          this.$refs.mytree.setCheckedKeys([]);
        });

        let roleid = this.tableData[index].roleId;
        //获得原先已经分配过的模块权限
        axios.get("/admin/roleright/" + roleid).then(res => {
          //把返回结果赋给data里定义的变量this.tableData
          let moduleRightIds = res.data;
          //设置 树显示选中 原先已经分配过的模块权限
          this.$refs.mytree.setCheckedKeys(moduleRightIds);
        });
        //设置哪行被选中了
        this.selectItemIdex = index;
      },

      onSubmit(myform) {
        //添加,调用post方法
        if (this.dialog.option == "add") {
          axios.post("/admin/role", this.mymodel).then(res => {
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
          axios.put("/admin/role", this.mymodel).then(res => {
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
      onSaveRight: function (index) {
        console.log(this.$refs.mytree.getCheckedNodes());
        let roleid = this.tableData[this.selectItemIdex].roleId;
        let data = this.$refs.mytree.getCheckedNodes();
        axios.post("/admin/roleright/" + roleid, data).then(res => {
          // 操作成功
          this.$message({
            message: "保存成功！",
            type: "success"
          });
          //保存后，清空选择
          this.$refs.mytree.setCheckedKeys([]);

          // 关闭对话框
          this.dialogRight.show = false;
        });
      }
    }
  })
</script>
</body>
</html>
