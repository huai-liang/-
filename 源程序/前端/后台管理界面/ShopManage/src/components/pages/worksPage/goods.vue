<template>
  <div class="goods">
    <div class="buttonArea">
      <el-button type="primary"
                 @click="delData">删除</el-button>
      <el-button type="primary"
                 @click="openOrClose(0)">上架</el-button>
      <el-button type="primary"
                 @click="openOrClose(1)">下架</el-button>
    </div>
    <div class="tableArea">
      <el-table :data="tableData"
                border
                style="width:100%"
                @select="selectOne"
                @select-all="selectOne">
        <el-table-column type="selection"
                         width="55"
                         fixed></el-table-column>
        <el-table-column prop="goodsId"
                         label="商品ID"
                         fixed
                         width="200px"></el-table-column>
        <el-table-column prop="title"
                         label="商品名称"
                         fixed
                         width="200px"
                         show-overflow-tooltip></el-table-column>
        <el-table-column prop="price"
                         label="销售价"
                         width="80px"></el-table-column>
        <el-table-column prop="imageSrc"
                         label="图片"
                         width="200px">
          <template slot-scope="scope">
            　　　　<img :src="scope.row.imageSrc"
                 width="100%"
                 height="100%" />
            　　</template>
        </el-table-column>
        <el-table-column prop="reserves"
                         label="库存"
                         width="80px"></el-table-column>
        <el-table-column prop="status"
                         label="状态"
                         width="80px">
          <template slot-scope="scope">
            <span v-if="scope.row.status==0">在售</span>
            <span v-else>下架</span>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="paginationArea">
      <el-pagination @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page="currentPage"
                     :page-sizes="[1,10,50,100,500]"
                     :page-size="pageSize"
                     layout="total,sizes,prev,pager,next,jumper"
                     :total="total">
      </el-pagination>
    </div>

  </div>
</template>

<script>
import { Loading } from 'element-ui';
export default {
  data () {
    return {
      searchList: {
        title: "",
        status: ""
      },
      imageSrc1: "",
      dialogImageUrl: '',
      dialogVisible: false,
      goodsImgList: [],//上传的图片
      fileList: [],//修改查询到的图片
      tableData: [],
      total: 0,
      pageSize: 10,//每页条数
      currentPage: 1,//当前页

      dialogAddVisible: false,
      dialogEditVisible: false,

      editDataList: {},
      hasChooseList: [],
      rules: {
        title: [
          { required: true, message: '请输入商品名称', trigger: 'blur' },
          { min: 1, max: 10, message: '长度在 1 到 200 个字符', trigger: 'blur' }
        ],

        price: [
          { required: true, message: '请输入销售价', trigger: 'blur' },
        ],
        detail: [
          { required: true, message: '请输入介绍', trigger: 'blur' },
        ],
        reserves: [
          { required: true, message: '请输入库存', trigger: 'blur' },
        ],

      },
      getDataUrl: this.$store.state.url + 'GoodsController/select',
      editDataUrl: this.$store.state.url + 'goods/updateGoods',
      getGoodsDetail: this.$store.state.url + 'GoodsController/select',//获取商品详情 -修改前查询
      delDataUrl: this.$store.state.url + 'GoodsController/del',
      openOrcloseUrl: this.$store.state.url + 'GoodsController/updataGoods',//上下架
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
    //获取表格数据
    getData () {
      let list = {
        pageNum: this.currentPage,
        pageNo: this.pageSize,

      }
      this.openFullScreen()
      this.$axios.post(this.getDataUrl, list).then(res => {
        this.closeFullScreen()
        if (0 == res.data.code) {
          this.tableData = res.data.data.list
          this.total = res.data.data.total

          //查询成功
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
      this.$refs[formName].resetFields();
    },
    //重置查询区域
    resetData (formName) {
      this.searchList = {};
    },
    //每页条数改变时触发
    handleSizeChange (val) {
      this.pageSize = val
      this.getData()
    },
    //页数改变时触发
    handleCurrentChange (val) {
      this.currentPage = val
      this.getData()
    },

    //点击X取消新增弹框
    handleClose () {

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
        this.getOneCate()
        //开始打开修改框
        // console.log(this.hasChooseList[0].id)
        this.dialogEditVisible = true;
        this.geiGoodsDetail(this.hasChooseList[0].goodsId)
      }
    },
    geiGoodsDetail (val) {
      var list = {
        id: val
      }
      this.$axios.post(this.getGoodsDetail, list).then(res => {
        this.closeFullScreen()
        if (0 == res.data.code) {
          this.editDataList = res.data.data
          this.getTwoCate(this.editDataList.oneCateId)
          var list = []
          for (var i = 0; i < this.editDataList.files.length; i++) {
            list.push({
              name: this.editDataList.files[i].fileName,
              url: this.editDataList.files[i].fileUrl,
              filePath: this.editDataList.files[i].filePath
            })
          }
          this.fileList = list
          this.goodsImgList = this.editDataList.files
          //查询成功
        } else {
          this.$message({
            showClose: true,
            message: res.data.msg,
            type: "error"
          });
        }
      });
    },
    //确认修改
    editDataSure (formName) {
      //调接口
      //if 接口返回成功，就关闭输入框
      this.openFullScreen()
      this.$refs[formName].validate((valid) => {
        this.closeFullScreen()
        if (valid) {
          var list = []
          for (var i = 0; i < this.goodsImgList.length; i++) {
            if (this.goodsImgList[i].response) {
              list.push({
                name: this.goodsImgList[i].name,
                fileUrl: this.goodsImgList[i].response.data.fileUrl,
                filePath: this.goodsImgList[i].response.data.filePath
              })
            } else {
              list.push({
                name: this.goodsImgList[i].name,
                fileUrl: this.goodsImgList[i].url,
                filePath: this.goodsImgList[i].filePath
              })
            }
          }
          this.editDataList.files = list
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
      if (1 == this.hasChooseList.length) {
        this.$confirm('此操作将永久删除该文件，是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          //调接口 把值传给后台
          let arrayList = {
            "goodsId": this.hasChooseList[0].goodsId
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
        this.$message.error('请选择一条数据进行删除');
      }
    },
    //删除图片
    handleRemove (file, fileList) {
      this.goodsImgList = fileList
    },
    //放大图片
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    //上传校验
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error('上传图片只能是 JPG 格式！');
      }
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 2MB！')
      }
      return isJPG && isLt2M;
    },
    //上传成功
    upLoadSuccess (response, file, fileList) {
      this.goodsImgList = fileList
    },
    //查询一级分类
    getOneCate () {
      this.$axios.post(this.getOneCateUrl).then(res => {
        if (0 == res.data.code) {
          this.oneCateIdList = res.data.data
          //查询成功
        } else {
          this.$message({
            showClose: true,
            message: res.data.msg,
            type: "error"
          });
        }
      });
    },
    //查询二级分类
    getTwoCate (val) {
      var list = {
        id: val
      }
      this.$axios.post(this.getTwoCateUrl, list).then(res => {
        if (0 == res.data.code) {
          this.twoCateIdList = res.data.data
          this.addDataList.twoCateId = ""
          //查询成功
        } else {
          this.$message({
            showClose: true,
            message: res.data.msg,
            type: "error"
          });
        }
      });
    },
    //查询二级分类
    getTwoCateEdit (val) {
      var list = {
        id: val
      }
      this.$axios.post(this.getTwoCateUrl, list).then(res => {
        if (0 == res.data.code) {
          this.twoCateIdList = res.data.data
          this.addDataList.twoCateId = ""
          //查询成功
        } else {
          this.$message({
            showClose: true,
            message: res.data.msg,
            type: "error"
          });
        }
      });
    },
    //上架or下架
    openOrClose (val) {
      var text;
      if (2 == val) {//上架
        text = "上架";
      } else {//下架
        text = "下架"
      }
      if (1 == this.hasChooseList.length) {
        this.$confirm('此操作将' + text + '该文件，是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          //调接口 把值传给后台
          let arrayList = {
            "goodsId": this.hasChooseList[0].goodsId,
            "status": val
          }
          this.$axios.post(this.openOrcloseUrl, arrayList).then(res => {
            if (0 == res.data.code) {
              this.$message({
                type: 'success',
                message: text + '成功！'
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
            message: '已取消' + text
          });
        });
      } else {
        this.$message.error('请选择一条数据进行删除' + text);
      }
    },
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
