<!--购物车页面-->
<template>
  <div class="hello">
    <div class="top">
      <div class="top_head"><img src="static/login/logo.gif"
             style=" height: 135px;"></div>
      <div class="font">购物车</div>
      <div class="banner"
           @click="gobanner">查看订单</div>
    </div>
    <div v-show="ok"
         style="font-size:36px;color:#666;margin: 15% 0 0 25%;">购物车为空，请先去首页逛逛</div>

    <div class="bodyStyle">
      <div class="goodList"
           v-for="x in shoppinglist"
           :key="x.goodsId">
        <div class="checkboxStyle">
          <input type="checkbox"
                 v-model="x.checked"
                 @change="changeCheckboxValue(x)">
        </div>
        <div class="imgStyle">
          <img :src="x.imageSrc"
               alt="">
        </div>
        <div class="titleStyle">
          <div style="color:red;">{{x.title}}</div>
          <!--删除-->

          <div class="changeMoney">
            <div class="moneyStyle">￥{{x.price}}</div>
            <div class="inputStyle"><span @click="delNum(x)">-</span><input type="text"
                     v-model="x.num"><span @click="addNum(x)">+</span></div>
          </div>
        </div>
      </div>
    </div>
    <div class="sumNumArea"
         v-show="over">
      <div><input type="checkbox"
               v-model="idAllSelect"
               @change="checkAll(idAllSelect)">全选</div>
      <div class="sumMoney">合计:￥{{sumMoney}}</div>
      <div class="toPay">
        <div class="delbutton"
             v-show="not">
          <el-button type="danger"
                     @click="handleDel">删 除</el-button>
        </div>
        <div @click="Settlement">
          <el-button type="danger">结算({{sumNum}})</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      over: false,
      ok: true,
      not: false,
      getshopping: this.$store.state.url + 'ShopCarController/selectCar',
      delshop: this.$store.state.url + 'ShopCarController/delCar',
      addorder: this.$store.state.url + '/OrderController/addOrder',
      toshopping: {
        phone: "",
        JumpgoodsId: "",
      },
      selectgoods: {
        title: "",
        phone: "",
        JumpgoodsId: "",
      },
      delshopping: {
      },
      phone: "",
      JumpgoodsId: "",
      address: "",
      shoppinglist: { total: "", address: "" },
      shoppinglist: "",
      carlist: "",
      data: {},
      sumMoney: 0,//总价格
      sumNum: 0,//总数量
      idAllSelect: false,//全选
      checked: "",
      order: {
        phone: "",
        goodsId: "",
        num: "",
        total: "",
        address: "",
        title: "",
        imageSrc: ""
      },
      orderlist: []
    }
  },
  created () {
    this.countSumPrice();
    this.goshopping();
    this.getParams();
  },
  methods: {
    gobanner () {
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
        localStorage.setItem('phone', this.order.phone),
          localStorage.setItem('address', this.order.address)
        this.$router.push({
          path: '/banner',
          name: 'banner',
        })
      }
    },
    //删除
    handleDel () {
      if (1 <= this.shoppinglist.length) {
        let listphone = []
        let goodsId = []
        for (var i = 0; i < this.orderlist.length; i++) {
          goodsId.push(this.orderlist[i].goodsId);
          listphone.push(this.orderlist[i].phone);
        }
        let obj = {
          list: goodsId,
          phone: listphone
        };
        if (obj.list.length == 0 || obj.phone.length == 0) {
          this.$message({
            showClose: true,
            message: "请勾选商品进行删除",
            type: "warning"
          });
        } else {
          this.$axios.post(this.delshop, obj).then(res => {
            if (0 == res.data.code) {
              this.goshopping();
              this.orderlist.length = 0;
              this.sumMoney = 0;
              this.sumNum = 0;
              this.not = false
              this.idAllSelect = false
              this.over = false;
            } else {
              this.$message({
                showClose: true,
                message: res.data.msg,
                type: "warning"
              });
            }
          });
        }
      } else {
        this.$message.error('请选择一条数据进行删除');
      }
    },
    shows (e) { },
    Settlement () {
      this.$axios.post(this.addorder, this.orderlist).then(res => {
        if (res.data.code == 0) {
          if (this.orderlist == undefined || this.orderlist.length <= 0) {
            this.$message({
              message: '请先选择结算的商品',
              type: 'warning'
            });
          } else {
            this.$message({
              message: res.data.msg,
              type: 'success'
            });
            this.handleDel()
            this.sumMoney = 0;
            this.idAllSelect = false
          }
        } else {
          this.$message({
            message: res.data.msg,
            type: 'error'
          });
        }
      })
    },
    //计算总金额
    countSumPrice () {
      this.sumMoney = 0;
      this.sumNum = 0;
      for (var i = 0; i < this.shoppinglist.length; i++) {
        if (true == this.shoppinglist[i].checked) {
          this.sumMoney += this.shoppinglist[i].num * this.shoppinglist[i].price
          this.text = this.sumMoney
          this.sumNum++
        }
      }
    },
    //点击加号
    addNum (val) {
      for (var i = 0; i < this.shoppinglist.length; i++) {
        if (val.goodsId == this.shoppinglist[i].goodsId) {
          this.shoppinglist[i].num++
        }
      }
      this.countSumPrice()
    },
    //点击减号
    delNum (val) {
      if (val.num > 1) {
        for (var i = 0; i < this.shoppinglist.length; i++) {
          if (val.goodsId == this.shoppinglist[i].goodsId) {
            this.shoppinglist[i].num--
          }
        }
        this.countSumPrice()
      }
    },
    //点击每一行的checkbok
    changeCheckboxValue (val) {
      for (var i = 0; i < this.shoppinglist.length; i++) {
        if (val.goodsId == this.shoppinglist[i].goodsId) {
          if (false == val.checked) {
            this.shoppinglist[i].checked = false
            this.over = false;
            this.not = false
            for (let j = 0; j < this.orderlist.length; j++) {
              if (val.goodsId == this.orderlist[j].goodsId) {
                this.orderlist.splice(j, 1)
              }
            }
            this.idAllSelect = false
          } else {
            this.shoppinglist[i].checked = true
            this.over = true;
            this.shoppinglist[i].address = this.order.address
            this.shoppinglist[i].total = this.shoppinglist[i].price * this.shoppinglist[i].num;
            this.orderlist.push(this.shoppinglist[i])
            this.changeIsAllSelect()
            this.not = true
          }
        }
      }
      this.countSumPrice()
    },
    //全选
    checkAll (val) {
      for (var i = 0; i < this.shoppinglist.length; i++) {
        if (true == val) {
          this.shoppinglist[i].checked = true
          this.shoppinglist[i].address = this.order.address
          this.shoppinglist[i].total = this.shoppinglist[i].price * this.shoppinglist[i].num;
          this.orderlist.push(this.shoppinglist[i])
          this.shoppinglist[i].checked = true

        } else {
          this.shoppinglist[i].checked = false
          for (let j = 0; j < this.orderlist.length; j++) {
            if (val.goodsId == this.orderlist[j].goodsId) {
              this.orderlist.splice(j, 1)
              this.goshopping();
            }
          }
        }
      }
      this.countSumPrice()
    },
    //判断是否全部勾选
    changeIsAllSelect () {
      let flag = false
      for (var i = 0; i < this.shoppinglist.length; i++) {
        console.log(this.shoppinglist[i].checked)
        if (false == this.shoppinglist[i].checked || null == this.shoppinglist[i].checked) {
          flag = false
          return;
        } else {
          flag = true
        }
      }
      this.idAllSelect = flag
    },
    //查询商品
    goshopping () {
      this.$axios.post(this.getshopping, this.toshopping).then(res => {
        if (0 == res.data.code) {
          this.shoppinglist = res.data.data;
          if (this.shoppinglist.length === 0) {
            this.ok = true
          } else {
            this.ok = false
          }
        } else {
          this.$message({
            showClose: true,
            message: res.data.msg,
            type: "error"
          });
        }
      });
    },

    getParams () {
      // 取到路由带过来的参数
      var JumpgoodsId = localStorage.getItem('JumpgoodsId');
      var phone = localStorage.getItem('phone');
      var address = localStorage.getItem('address');
      // 将数据放在当前组件的数据内
      this.toshopping.phone = phone;
      this.order.phone = phone;
      this.toshopping.JumpgoodsId = JumpgoodsId;
      this.order.goodsId = JumpgoodsId;
      this.order.address = address;
    },
  },

  watch: {
    // 监测路由变化,只要变化了就调用获取路由参数方法将数据存储本组件即可
    $route: "getParams"
  },
}

</script>
<style scoped>
.hello {
  width: 1190px;
  margin: 0 auto;
}
.top_head {
  float: left;
}
.font {
  font-size: 36px;
  font-weight: bolder;
  color: brown;
  padding-top: 5%;
}
.banner {
  font-size: 36px;
  font-weight: bolder;
  color: #666;
  padding-top: 5%;
  float: right;
  margin-right: 4%;
}
.banner:hover {
  color: brown;
}
.top {
  height: 150px;
}
.title {
  position: fixed;
  top: 0;
  height: 40px;
  width: 100%;
  line-height: 40px;
  text-align: center;
  background: #fff;
  z-index: 999;
  border-bottom: 1px solid #eee;
}
.bodyStyle {
  margin: 40px 0 90px 0;
}
.goodList {
  overflow: auto;
  font-size: 12px;
  padding: 10px 10px 10px 0;
  border-bottom: 1px solid #eee;
  background: #fff;
}
.goodList > div {
  float: left;
}
.checkboxStyle {
  width: 15%;
  text-align: center;
  height: 80px;
  line-height: 80px;
}
.imgStyle {
  width: 27%;
}
.imgStyle img {
  height: 80px;
  width: 80px;
}
.titleStyle {
  width: 58%;
  height: 80px;
  position: relative;
}
.titleStyle div:first-child {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}
.changeMoney {
  overflow: hidden;
  position: absolute;
  bottom: 0px;
  width: 100%;
}
.moneyStyle {
  float: left;
  color: red;
  font-size: 14px;
}
.inputStyle {
  float: right;
}
.inputStyle input {
  width: 40px;
  background: #f6f6f6;
  padding-left: 10px;
  border: 0;
}
.inputStyle span {
  padding: 0 15px;
}
.sumNumArea {
  height: 40px;
  line-height: 40px;
  width: auto;
  background: #fff;
  border-bottom: 1px solid #eee;
}
.sumNumArea div {
  float: left;
}
.sumNumArea div:first-child {
  font-size: 12px;
  width: 20%;
  text-align: center;
}
.sumNumArea div:last-child {
  float: right;
}
.sumMoney {
  margin-left: 10px;
  font-size: 16px;
}

.delbutton {
  padding-right: 10px;
  font-size: 14px;
}
</style>
