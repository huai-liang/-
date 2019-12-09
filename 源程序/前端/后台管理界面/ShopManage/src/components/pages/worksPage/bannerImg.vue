<template>
  <div class="customer">
    <div class="searchArea">
      <el-row :gutter="20">
        <el-col :span="6">
          <el-form label-width="80px">
            <el-form-item label="手机号码">
              <el-input v-model="searchList.userName"></el-input>
            </el-form-item>
          </el-form>
        </el-col>
        <el-col :span="6">
          <el-button type="primary"
                     @click="getData">查询</el-button>
          <el-button @click="resetData">重置</el-button>
        </el-col>
      </el-row>
    </div>
    <div class="buttonArea">
      <el-button type="primary"
                 @click="delData">删除</el-button>
    </div>
    <div class="tableArea">
      <el-table :data="tableData"
                border
                style="width:100%"
                @select="selectOne"
                @select-all="selectOne">
        <el-table-column type="selection"
                         width="55"></el-table-column>

        <el-table-column prop="phone"
                         label="手机号码"></el-table-column>
        <el-table-column prop="goodsId"
                         label="商品id"
                         show-overflow-tooltip></el-table-column>
        <el-table-column prop="title"
                         label="商品标题"
                         show-overflow-tooltip></el-table-column>
        <el-table-column prop="num"
                         label="数量"
                         show-overflow-tooltip></el-table-column>
        <el-table-column prop="total"
                         label="总价"
                         show-overflow-tooltip></el-table-column>
        <el-table-column prop="createTime"
                         label="下单时间"
                         show-overflow-tooltip></el-table-column>
        <el-table-column prop="imageSrc"
                         label="商品封面">
          <template slot-scope="scope">
            　　　　<img :src="scope.row.imageSrc"
                 width="100%"
                 height="100%" />
            　　</template></el-table-column>
        <el-table-column prop="status"
                         label="状态"
                         show-overflow-tooltip>
          <template slot-scope="scope">
            <span v-if="scope.row.status==0">未发货</span>
            <span v-else-if="scope.row.status==1">已发货</span>
            <span v-else-if="scope.row.status==2">已完成</span>
            <span v-else-if="scope.row.status==3">已取消</span>
            <span v-else-if="scope.row.status==4">已关闭</span>
          </template>

        </el-table-column>
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
              <el-form-item label="电话"
                            prop="phone">
                <el-input v-model="editDataList.phone"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="商品id"
                            prop="goodsId">
                <el-input v-model="editDataList.goodsId"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="商品标题"
                            prop="title">
                <el-input v-model="editDataList.title"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="数量"
                            prop="num">
                <el-input v-model="editDataList.num"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="状态"
                            prop="status">
                <el-input v-model="editDataList.status"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="总价"
                            prop="total">
                <el-input v-model="editDataList.total"></el-input>
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
      searchList: {
        userName: ""
      },
      tableData: [],
      total: 0,
      pageSize: 10,//每页条数
      currentPage: 1,//当前页

      dialogAddVisible: false,
      dialogEditVisible: false,

      editDataList: {},
      hasChooseList: [],
      rules: {
        userAcct: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
        ],
        userName: [
          { required: true, message: '请输入名称', trigger: 'blur' },
        ],
        sex: [
          { required: true, message: '性别', trigger: 'blur' },
        ],
        phone: [
          { required: true, message: '请输入电话', trigger: 'blur' },
        ],
        email: [
          { required: true, message: '请输入邮箱地址', trigger: 'blur' },
        ],
        idCard: [
          { required: true, message: '请输入身份证号', trigger: 'blur' },
        ],
        userPwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
      },
      getDataUrl: this.$store.state.url + 'OrderController/selectOrder',
      addDataUrl: this.$store.state.url + 'customer/insertCustomer',
      editDataUrl: this.$store.state.url + 'customer/updateCustomer',
      delDataUrl: this.$store.state.url + 'OrderController/delOrder',
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
        userType: '0',//0客户 1用户
        pageNum: this.currentPage,
        pageSize: this.pageSize,
        phone: this.searchList.userName,
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
    //重置查询区域
    resetData (formName) {
      this.searchList = {};
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
          let listphone = []
          for (var i = 0; i < this.hasChooseList.length; i++) {
            list.push(this.hasChooseList[i].goodsId);
            listphone.push(this.hasChooseList[i].phone);
          }
          let obj = {
            list: list,
            phone: listphone
          };

          this.$axios.post(this.delDataUrl, obj).then(res => {
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

