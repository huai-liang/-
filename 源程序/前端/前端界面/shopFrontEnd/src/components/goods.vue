<!--商品详情页面-->
<template>
  <div>
    <img src="static\kinds\5.tu29.jpg"
         width="100%"
         height="130px">
    <div class="grid_c1">
      <div class="top_b">
        <TopInput></TopInput>

      </div>
      <div class="floatRight">
        <div class="fontSize">{{Jumptitle}}
          <br />
          <span style="color:red;">￥{{Jumpprice}}</span>
          <div class="check">
            <el-input-number v-model="num"
                             @change="handleChange"
                             :min="1"
                             :max="999"
                             label="购物车"
                             style="float: left;"></el-input-number>
            <el-row>
              <el-button type="danger"
                         style="margin-left:10px;"
                         @click="goshop">加入购物车</el-button>

              <el-button type="danger"
                         style="margin-left:10px;"
                         @click="Jump">去结算</el-button>

            </el-row>
          </div>
        </div>
      </div>
      <div class="floatLeft">
        <img :src="JumpimageSrc"
             width="250px"
             height="250px">
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
      ok: true,
      togoshop: this.$store.state.url + 'ShopCarController/addCar',
      toshop: {
        goodsId: "",
        imageSrc: "",
        num: "",
        phone: "",
        price: "",
        title: "",
        phone: "",
        address: "",
      },
      shoplist: {},
      num: 1,
      Jumptitle: "",
      Jumpprice: "",
      JumpimageSrc: "",
      JumpgoodsId: "",
      phone: '',
      address: '',
    }
  },
  methods: {
    goshop () {
      this.toshop.goodsId = this.JumpgoodsId;
      this.toshop.imageSrc = this.JumpimageSrc;
      this.toshop.num = this.num;
      this.toshop.phone = this.phone;
      this.toshop.price = this.Jumpprice;
      this.toshop.title = this.Jumptitle;
      this.toshop.address = this.address
      this.$axios.post(this.togoshop, this.toshop).then(res => {
        if (this.phone === 'undefined') {
          this.$message({
            message: '您还没有登录，请先登录',
            type: 'error'
          });
          this.$router.push({
            path: '/login',
            name: 'login',
          })
        }
        else {
          if (0 == res.data.code) {
            this.$message({
              showClose: true,
              message: res.data.msg,
              type: "success"
            });
          }
          else {
            this.$message({
              showClose: true,
              message: res.data.msg,
              type: "error"
            });
          }
        }
      });
    },
    //跳转传值
    Jump (val) {
      if (this.phone === 'undefined') {
        this.$message({
          message: '您还没有登录，请先登录',
          type: 'error'
        });
        this.$router.push({
          path: '/login',
          name: 'login',
        })
      } else {
        localStorage.setItem('phone', this.phone),
          localStorage.setItem('address', this.address)
        this.$router.push({
          path: '/car',
          name: 'car',
        })
      }
    },
    handleChange (value) {
    },
    getParams () {
      // 取到路由带过来的参数
      var Jumptitle = localStorage.getItem('Jumptitle');
      var Jumpprice = localStorage.getItem('Jumpprice');
      var JumpimageSrc = localStorage.getItem('JumpimageSrc');
      var JumpgoodsId = localStorage.getItem('JumpgoodsId');
      var phone = localStorage.getItem('phone');
      var address = localStorage.getItem('address');
      // 将数据放在当前组件的数据内
      this.Jumptitle = Jumptitle;
      this.Jumpprice = Jumpprice;
      this.JumpimageSrc = JumpimageSrc;
      this.JumpgoodsId = JumpgoodsId;
      this.phone = phone;
      this.address = address;
    }
  },
  watch: {
    // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
    $route: "getParams"
  },
  mounted () {
    this.getParams();
  }
}
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
.top_b1 {
  float: left;
}
.top_b2 {
  width: 30%;
  float: left;
  margin-top: 35px;
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
.floatLeft {
  padding: 5%;
  width: 300px;
  background: #fff;
}
.floatRight {
  float: right;
  margin-top: 5%;
  margin-right: 15%;
}
.fontSize {
  font: 700 16px Arial;
  color: #666;
  padding-top: 10px;
  line-height: 28px;
  margin-bottom: 5px;
  width: 500px;
}
.el-input-number {
  position: relative;
  display: inline-block;
  width: 140px;
  line-height: 38px;
}
.el-button--danger {
  width: 140px;
  color: #fff;
  background-color: #f56c6c;
  border-color: #f56c6c;
}

.check {
  margin-top: 23%;
  width: 500px;
  height: 40px;
}
.last {
  color: red;
}
</style>