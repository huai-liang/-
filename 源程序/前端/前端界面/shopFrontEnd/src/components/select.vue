<!--搜索跳转页面-->
<template>
  <div>
    <div class="top_b">
      <TopInput></TopInput>
    </div>
    <img src="static\kinds\5.tu29.jpg"
         width="100%"
         height="130px" />
    <div class="grid_c1">
      <template v-for=" v in goodslist">
        <div class="box_bot"
             :key="v.id">
          <div class="box_botImg1">
            <img :src="v.imageSrc"
                 width="160"
                 height="170"
                 @click="Jump(v)" />
          </div>
          <div class="font">{{v.title}}</div>
          <div class="fontMoney">￥{{v.price}}</div>
        </div>
        
      </template>
    </div>
  </div>
</template>

<script>
import TopInput from './search.vue'
export default {

  components: { TopInput },
  data () {
    return {
      totitle: {
        title: ""
      },
      goodslist: {},
      JumpgoodsId: "",
      Jumptitle: "",
      JumpimageSrc: "",
      Jumpprice: "",
      toGoods: this.$store.state.url + 'GoodsController/selectGoods',
    };
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
      this.totitle.title = this.$route.query.title;
      var phone = this.$route.query.loginphone;
      var address = this.$route.query.address;
      // 将数据放在当前组件的数据内
      this.address=address;
      this.phone=phone;
     
      this.getData()
    },
    //跳转传值
    Jump (val) {
      localStorage.setItem('Jumptitle', val.title),
        localStorage.setItem('Jumpprice', val.price),
        localStorage.setItem('JumpimageSrc', val.imageSrc),
        localStorage.setItem('JumpgoodsId', val.goodsId),
        localStorage.setItem('loginUserName', val.loginUserName),
        
        
        this.$router.push({
          path: '/goods',
          name: 'goods',
          params: {
            JumpgoodsId: val.goodsId,
            Jumptitle: val.title,
            Jumpprice: val.price,
            JumpimageSrc: val.imageSrc,
          }
        })
    },
    getData () {
      this.$axios.post(this.toGoods, this.totitle).then(res => {
        if (0 == res.data.code) {
          this.goodslist = res.data.data;
        } else {
          this.$message({
            showClose: true,
            message: res.data.msg,
            type: "error"
          });
        }
      });
    }
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
  height: 30px;
  margin-top: 26px;
  border: #e1251b solid 2px;
}
.imgStyle {
  float: right;
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
.box_bot {
  width: 222px;
  height: 300px;
  background: #fff;
  float: left;
  margin: 10px 5px 1px 5px;
}
.box_botImg1 {
  padding: 10% 5% 4% 10%;
}
.box_botImg1 img:hover {
  width: 180px;
  height: 190px;
}
.font {
  padding: 5% 3% 3% 9%;
  color: #666;
  font-size: 14px;
  height: 33px;
  width: 153px;
  position: relative;
  overflow: hidden;
}
.font:after {
  position: absolute;
  bottom: 0;
  right: 0;
  content: "...";
}
.fontMoney {
  padding: 1% 0 1% 8%;
  float: left;
  color: red;
}
</style>