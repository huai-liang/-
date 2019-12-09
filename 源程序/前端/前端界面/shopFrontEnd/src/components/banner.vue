<template>
<div class="hello">
  
      <div class="top">
      <div class="top_head"><img src="static/login/logo.gif"
             style=" height: 135px;"></div>
      <div class="font">我的订单</div>
     <div class="buttonArea">
      <el-button type="primary"
                 @click="delData" v-show="ok">删除订单</el-button>
    </div>
    </div>
    <div class="tableArea" >
      <el-table :data="tableData"
                style="width:100%"
                @select="selectOne"
                @select-all="selectOne">
        <el-table-column type="selection"
                         width="55">
                         </el-table-column>
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
      ok: false,
      phone:"",
      tableData: [],
      total: 0,
      pageSize: 10,//每页条数
      currentPage: 1,//当前页
      hasChooseList: [],
      getDataUrl: this.$store.state.url + 'OrderController/selectOrder',
      delDataUrl: this.$store.state.url + 'OrderController/delOrder',
    };
  },
  mounted () {
       this.getParams();
       this.getData();
  },
  beforeRouteUpdate (to, from, next) {

    // 在当前路由改变，但是该组件被复用时调用
    // 举例来说，对于一个带有动态参数的路径 /foo/:id，在 /foo/1 和 /foo/2 之间跳转的时候，
    // 由于会渲染同样的 Foo 组件，因此组件实例会被复用。而这个钩子就会在这个情况下被调用。
    // 可以访问组件实例 `this`
    next()
  },
  methods: {
       getParams () {
      // 取到路由带过来的参数
      var phone = localStorage.getItem('phone');
      var address = localStorage.getItem('address');
      // 将数据放在当前组件的数据内
        this.phone=phone;
        this.address=address;
        console.log(this.phone+this.address+"asds123123")
    },
    getData () {
      let list = {
        userType: '0',//0客户 1用户
        pageNum: this.currentPage,
        pageSize: this.pageSize,
        phone: this.phone
      }
      console.log(this.phone)
      this.$axios.post(this.getDataUrl, list).then(res => {
        if (0 == res.data.code) {
          this.tableData = res.data.data.list
          this.total = res.data.data.total
        } else {
          this.tableData=res.data.data
          this.$message({
            showClose: true,
            message: "暂无订单",
            type: "warning"
          });
         this.$router.push({path:'/banner'})
        }
      });
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
    
    //点击一行选中checkbox时触发
    selectOne (selection) {
      this.hasChooseList = selection
      if(selection=false){
        this.ok=false
      }else{
        this.ok=true
      }
    },
    //点击全选
    selectAll (selection) {
      this.hasChooseList = selection
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
      console.log(obj.phone+"asda")
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
    },
  },
  watch: {
    // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
    $route: "getParams"
  }
};
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello {
  width: 1190px;
  margin: 0 auto;
}
.searchArea {
  height: 50px;
  padding: 20px;
}
.buttonArea {
  padding-left: 20px;
  width: 70px;
  height: 40px;
  float: left;
  padding-top: 6%;
}
.tableArea {
  padding: 20px;
}
.paginationArea {
  height: 40px;
  float: right;
  padding-right: 20px;
}
.top_head {
  float: left;
}
.font {
  font-size: 36px;
  font-weight: bolder;
  color: brown;
  padding-top: 5%;
  margin-left: 20%;
  width: 150px;
  height: 50px;
}
.top {
  height: 150px;
}
</style>

