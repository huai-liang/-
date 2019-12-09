<template>
  <div>
        <div class="top_b1"><img src="static/login/logo.gif"
               style=" height: 135px;"></div>
        <div class="top_b2">
          <div class="input">
          <div style="float:left;height:25px;">
            <input type="text"
                   v-model="totitle.title"
                   placeholder="请输入您心仪的商品"
                   class="sousuo">
          </div>
          <div class="imgStyle">
            <img src="static\index\sousuo.png"
                 @click="sousuo" />
          </div>
        </div>
        </div>
      
  </div>
</template>

<script>

export default {
  data () {
    return {
      toGoods: this.$store.state.url + 'GoodsController/selectGoods',
      totitle: {
        title: ""
      },
    }
  },
  methods:{
    //搜索
    // sousuo () {
    //   this.$axios.post(this.toGoods, this.totitle).then(res => {
    //     if (0 == res.data.code) {
    //       this.goodslist = res.data.data;
    //       this.$router.push({
    //         path: '/select',
    //         name: 'select',
    //         params: {
    //           goodslist: this.goodslist,
    //         }
    //       })
    //     } else {
    //       this.$message({
    //         showClose: true,
    //         message: res.data.msg,
    //         type: "error"
    //       });
    //     }
    //   });
    // },
       sousuo () {
          this.$router.push({
            path: '/select',
            name: 'select',
            query: {
              title: this.totitle.title,
            }
          })
    },
  },
    beforeRouteUpdate (to, from, next) {
      next()
  },
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
</style>