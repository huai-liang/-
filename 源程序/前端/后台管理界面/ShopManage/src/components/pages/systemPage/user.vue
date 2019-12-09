<template>
  <div class="user">
    <div class="buttonArea">
      <el-button type="primary"
                 @click="addData">新增</el-button>
      <el-button type="primary"
                 @click="editData">修改</el-button>
    </div>
    <div class="tableArea">
      <el-table :data="tableData"
                border
                style="width:100%"
                @select="selectOne"
                @select-all="selectOne">
        <el-table-column type="selection"
                         width="55"></el-table-column>
        <el-table-column prop="status"
                         label="用户状态">
          <template slot-scope="scope">
            <span v-if="scope.row.status==0">未激活</span>
            <span v-else-if="scope.row.status==1">正常</span>
            <span v-else>已冻结</span>
          </template>
        </el-table-column>
        <el-table-column prop="userName"
                         label="用户姓名"></el-table-column>
        <el-table-column prop="phone"
                         label="手机号码"></el-table-column>
        <el-table-column prop="userPwd"
                         label="密码"
                         show-overflow-tooltip></el-table-column>
        <el-table-column prop="address"
                         label="地址"
                         show-overflow-tooltip></el-table-column>
      </el-table>
    </div>
    <div class="paginationArea">
      <el-pagination @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page="currentPage"
                     :page-sizes="[1,10,100,500]"
                     :page-size="pageSize"
                     layout="total,sizes,prev,pager,next,jumper"
                     :total="total">
      </el-pagination>
    </div>
    <!--新增-->
    <el-dialog title="新增用户"
               :visible.sync="dialogAddVisible"
               width="40%"
               :close-on-click-modal="false"
               :destroy-on-close=true
               :before-close="handleClose"
               :modal-append-to-body="false">
      <div>
        <el-row>
          <el-form label-width="80px"
                   :model="addDataList"
                   ref="addDataListRest"
                   :rules="rules">
            <el-col :span="12">
              <el-form-item label="状态"
                            prop="status">
                <el-input v-model="addDataList.status"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="用户名称"
                            prop="userName">
                <el-input v-model="addDataList.userName"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="电话"
                            prop="phone">
                <el-input v-model="addDataList.phone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="密码"
                            prop="userPwd">
                <el-input v-model="addDataList.userPwd"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="地址"
                            prop="address">
                <el-input v-model="addDataList.address"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
      </div>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click="cancleDialog('addDataListRest')">取消</el-button>
        <el-button type="primary"
                   @click="addDataSure('addDataListRest')">确定</el-button>
      </div>
    </el-dialog>
    <!--修改-->
    <el-dialog title="修改用户"
               :visible.sync="dialogEditVisible"
               width="40%"
               :close-on-click-modal="false"
               :destroy-on-close=true
               :before-close="handleClose"
               :modal-append-to-body="false">
      <div>
        <el-row>
          <el-form label-width="80px"
                   :model="editDataList"
                   ref="editDataListRest"
                   :rules="rules">
            <el-col :span="12">
              <el-form-item label="状态"
                            prop="status">
                <el-select v-model="editDataList.status">
                  <el-option label="未激活"
                             value="0"></el-option>
                  <el-option label="正常"
                             value="1"></el-option>
                  <el-option label="已冻结"
                             value="2"></el-option>

                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="姓名"
                            prop="userName">
                <el-input v-model="editDataList.userName"></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="12">
              <el-form-item label="电话"
                            prop="phone">
                <el-input v-model="editDataList.phone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="密码"
                            prop="userPwd">
                <el-input v-model="editDataList.userPwd"
                          type="password"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
      </div>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click="cancleDialog('editDataListRest')">取消</el-button>
        <el-button type="primary"
                   @click="editDataSure('editDataListRest')">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { Loading } from 'element-ui';
export default {
  data () {
    return {
      ruleForm: {
        pass: '',
        checkPass: '',
        age: ''
      },

      tableData: [],
      total: 0,
      pageSize: 10,//每页条数
      currentPage: 1,//当前页

      dialogAddVisible: false,
      dialogEditVisible: false,
      addDataList: {
        userPwd: '',
        phone: '',
        address: '',
        status: '',
        userName: '',
      },
      editDataList: {},
      hasChooseList: [],
      rules: {

        userName: [
          { required: true, message: '请输入名称', trigger: 'blur' },
        ],
        phone: [
          { required: true, message: '请输入电话', trigger: 'blur' },
        ],
        userPwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        userPwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
      },
      getDataUrl: this.$store.state.url + 'user/getUserList',
      addDataUrl: this.$store.state.url + 'user/addUser',
      editDataUrl: this.$store.state.url + 'user/modifyStatus',
      delDataUrl: this.$store.state.url + 'customer/deleteCustomer',
    };
  },
  mounted () {
    this.getData()
  },
  methods: {
    openFullScreen () {
      const loading = this.$loading({
        lock: true,
        text: 'Loading',
        spinner: 'el-icon-loading',
        background: 'rgba(0,0,0,0.7)'
      });
    },
    closeFullScreen () {
      const loading = this.$loading({
        lock: true,
        text: 'Loading',
        spinner: 'el-icon-loading',
        background: 'rgba(0,0,0,0.7)'
      });
      loading.close();
    },
    getData () {
      let list = {
        pageNum: this.currentPage,
        pageSize: this.pageSize,
      }
      this.openFullScreen()
      this.$axios.post(this.getDataUrl, list).then(res => {
        this.closeFullScreen()
        if (0 == res.data.code) {
          this.tableData = res.data.data.list
          this.total = res.data.data.total
        } else {
          this.$message({
            showClose: true,
            message: res.data.msg,
            type: "error"
          });
        }
      });
    },
    resetForm (formName) {
      console.log(formName)
      this.$refs[formName].resetFields();
    },
    //每页条数改变时触发
    handleSizeChange (val) {
      console.log('每页 ${val} 条');
      this.pageSize = val
      this.getData()
    },
    //页数改变时触发
    handleCurrentChange (val) {
      console.log('当前页：${val}');
      this.currentPage = val
      this.getData()
    },
    //点击新增
    addData (addDataList) {
      this.dialogAddVisible = true;
      //this.$refs['addDataListRest'].resetFields();
    },
    //确认新增用户
    addDataSure (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.dialogAddVisible = false;
          //调接口
          //if接口成功，就清空里面的输入值
          console.log(this.addDataList)
          this.$axios.post(this.addDataUrl, this.addDataList).then(res => {
            if (0 == res.data.code) {
              this.$refs["addDataListRest"].resetFields();
              this.dialogAddVisible = false
              this.getData();
            } else {
              this.$message({
                showClose: true,
                message: res.data.msg,
                type: "error"
              });
            }
          });
        } else {
          return false;
        }
      });
    },
    //取消新增用户
    cancleDialog (val) {
      this.$refs[val].resetFields();
      this.dialogAddVisible = false;
      this.dialogEditVisible = false;
    },
    //点击X取消新增弹框
    handleClose () {
      if (this.$refs['addDataListRest']) {
        this.$refs['addDataListRest'].resetFields();
      }
      if (this.$refs['editDataListRest']) {
        this.$refs['editDataListRest'].resetFields();
      }
      this.dialogAddVisible = false;
      this.dialogEditVisible = false;
    },
    //点击一行选中checkbox时触发
    selectOne (selection) {
      this.hasChooseList = selection
    },
    //点击全选
    selectAll (selection) {
      this.hasChooseList = selection
    },
    //点击修改按钮
    editData () {
      if (1 != this.hasChooseList.length) {
        this.$message.error('请选择一条数据进行修改');
      } else {
        //开始打开修改框
        this.dialogEditVisible = true;
        this.editDataList = JSON.parse(JSON.stringify(this.hasChooseList[0]))
      }
    },
    //确认修改
    editDataSure (formName) {
      //调接口
      //if 接口返回成功，就关闭输入框
      this.openFullScreen()
      this.$refs[formName].validate((valid) => {
        this.closeFullScreen()
        if (valid) {
          console.log(this.editDataList)
          this.$axios.post(this.editDataUrl, this.editDataList).then(res => {
            if (0 == res.data.code) {
              this.getData();
              this.dialogEditVisible = false;
              this.$refs['editDataListRest'].resetFields();
              //查询成功
            } else {
              this.$message({
                showClose: true,
                message: res.data.msg,
                type: "error"
              });
            }
          });
        } else {
          return false;
        }
      });
    },
    //删除提示
    delData () {
      if (0 < this.hasChooseList.length) {
        this.$confirm('此操作将永久删除该文件，是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          //调接口 把值传给后台
          let list = []
          for (var i = 0; i < this.hasChooseList.length; i++) {
            list.push(this.hasChooseList[i].id)
          }
          let arrayList = {
            "idList": list
          }
          this.$axios.post(this.delDataUrl, arrayList).then(res => {
            if (0 == res.data.code) {
              this.$message({
                type: 'success',
                message: '删除成功！'
              });
              this.getData();
            } else {
              this.$message({
                showClose: true,
                message: res.data.msg,
                type: "error"
              });
            }
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      } else {
        this.$message.error('请选择要删除的数据');
      }
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.searchArea {
  height: 50px;
  padding: 20px;
}
.buttonArea {
  padding-left: 20px;
}
.tableArea {
  padding: 20px;
}
.paginationArea {
  height: 40px;
  float: right;
  padding-right: 20px;
}
</style>
