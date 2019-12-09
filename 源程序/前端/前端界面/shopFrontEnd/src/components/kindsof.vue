<!--分类跳转页面-->
<template>
  <div>
    <div class="grid_c1">
      <div class="top_b">
        <TopInput></TopInput>
      </div>
      <div class="top">发现好货</div>

      <div class="boxBig"
           v-for="x in booklist"
           :key="x.goodsId">
        <div class="boxOne"><img :src="x.imageSrc"
               width="200px"
               height="200px"></div>
        <div class="boxTwo">
          <div class="font">{{x.title}}<br />
            <div class="moneyStyle">
              ￥ {{x.price}}
            </div>
            <div style="margin-top:20px;float:right">
              <el-row>
                <el-button type="danger"
                           @click="Jump(x)">立即抢购</el-button>
              </el-row>
            </div>
          </div>
        </div>
      </div>

    </div>
    <hr>
  </div>
</template>

<script>

import TopInput from './search.vue'
export default {
  components: { TopInput },
  data () {
    return {
      booklist: {},
    };
  },
  methods: {
    handleClick (tab, event) {
    },
    //跳转传值
    Jump (val) {
      localStorage.setItem('Jumptitle', val.title),
        localStorage.setItem('Jumpprice', val.price),
        localStorage.setItem('JumpimageSrc', val.imageSrc),
        localStorage.setItem('JumpgoodsId', val.goodsId),
        localStorage.setItem('loginUserName', this.loginUserName),
        localStorage.setItem('phone', this.phone),
        localStorage.setItem('address', this.address),
        this.$router.push({
          path: '/goods',
          name: 'goods',
        })
    },
    getParams () {
      // 取到路由带过来的参数
      var bookList = JSON.parse(localStorage.getItem('bookList'));
      var phone = localStorage.getItem('phone');
      var address = localStorage.getItem('address')
      //var booklist=this.$route.query.booklist;
      // 将数据放在当前组件的数据内
      this.booklist = bookList;
      this.phone = phone;
      this.address = address;
    },

  },
  watch: {
    // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
    $route: "getParams"
  },
  mounted () {
    this.getParams();
  }
};
</script>
<style scoped>
.input {
  height: 25px;
  width: 508px;
}
.sousuo {
  width: 450px;
}
.top_b {
  width: 100%;
  height: 135px;
  text-align: center;
}
.top_b2 {
  width: 30%;
  float: left;
  margin-top: 35px;
  margin-left: 10%;
}
.top_b2_input {
  width: 508px;
  float: left;
  height: 31px;
  border: rgb(241, 10, 10) solid 2px;
}
.grid_c1 {
  width: 1190px;
  margin: 0 auto;
}
.top {
  font-weight: bolder;
  font-size: 24px;
  color: red;
  margin-left: 45%;
  margin-top: 20px;
}
.boxBig {
  margin-left: 5%;
  margin-top: 1%;
  width: 500px;
  height: 250px;
  background: #fff;
  float: left;
}
.boxOne {
  float: left;
  margin: 2%;
  width: 230px;
  height: 250px;
  background: #fff;
}
.boxOne img {
  padding: 6%;
}
.boxTwo {
  float: left;
  margin: 2%;
  width: 230px;
  height: 250px;
  background: #e7e7e7;
}
.fontSize {
  position: relative;
  height: 32px;
  margin-top: 30px;
  margin-bottom: 30px;
  font-size: 18px;
  color: #4797a0;
  font-weight: 400;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.font {
  margin-left: 5px;
  height: 230px;
  line-height: 24px;
  font-size: 14px;
  color: #585858;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 6;
  -webkit-box-orient: vertical;
}
.el-button--danger {
  color: red;
  background-color: #e7e7e7;
  border-color: #df5d5d;
  float: right;
}
.moneyStyle {
  color: red;
  float: left;
  font-size: 14px;
  margin-top: 30px;
  margin-left: 30px;
}
</style>