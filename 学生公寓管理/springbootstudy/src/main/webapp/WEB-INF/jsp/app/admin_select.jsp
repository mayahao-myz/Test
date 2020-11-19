%--
  Created by IntelliJ IDEA.
  User: SongYandi
  Date: 2020/4/7
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统管理人员查询界面</title>
</head>
<body>
<div id="app">
    <div class="mx-main-content">
        <div class="mx-table-title">

            <input type="text" placeholder="请输入您的账号" id="userSelectId" name="userSelectId">

            <el-button type="select" size="mini" @click="onSelect()">查询</el-button>
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
                        prop="userName"
                        label="姓名" width="100">
                </el-table-column>
                <el-table-column
                        prop="utilities"
                        label="水电费用" width="100">
                </el-table-column>
                <el-table-column
                        prop="rent"
                        label="房租费用" width="150">
                </el-table-column>
                <el-table-column
                        prop="goods"
                        label="物品赔偿费" width="150">
                </el-table-column>
            </el-table>
        </div>
    </div>



</div>
</body>
</html>
