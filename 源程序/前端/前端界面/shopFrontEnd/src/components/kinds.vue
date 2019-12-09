
<template>
  <div class="back">
    <TopInput></TopInput>
    <div>
      <div>
        <img src="static\kinds\beijin.tu1.jpg"
             width="100%"
             height="320px;" />
        <div class="grid_c1">
          <hr />

          <div class="box"
               v-for="x in homelist"
               :key="x.goodsId">
            <div class="imgStyle">
              <img :src="x.imageSrc"
                   width="180"
                   @click="Jump(x)" />
            </div>
            <div class="boxseccond">
              <div class="fontStyle">{{x.title}}</div>
              <div class="moneyStyle">{{x.price}}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import TopInput from "./search.vue";
export default {
  components: { TopInput },
  data () {
    return {
      homelist: {},
    };
  },
  methods: {

    getParams () {
      // 取到路由带过来的参数

      var homeList = JSON.parse(localStorage.getItem('homeList'));
      var phone = localStorage.getItem('phone');
      var address = localStorage.getItem('address');
      // 将数据放在当前组件的数据内
      this.homelist = homeList;
      this.phone = phone;
      this.address = address;
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
.grid_c1 {
  width: 1190px;
  margin: 0 auto;
}
.box {
  width: 294px;
  height: 350px;
  float: left;
  margin-right: 3px;
}
.imgStyle {
  margin-right: 56px;
  margin-top: 50px;
  transition: 0.5s;
}
.imgStyle:hover {
  margin-top: 40px;
}
.boxseccond {
  margin-left: 12px;
  margin-top: 260px;
  width: 270px;
  height: 70px;
  background: #eff2f7;
}
.fontStyle {
  padding: 13px;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
.moneyStyle {
  color: red;
  width: 65px;
  margin: 0 auto;
}
</style>