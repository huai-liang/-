<!--登录页面-->
<template>
  <div>
    <div class="grid_c1">
      <div class="zhucetop">
        <div class="regit"><img src="static/login/logo.gif"
               style="width:200px;" /></div>
        <div class="regit1">欢迎登录</div>
      </div>
    </div>
    <div class="zhuce">
      <div class="login-wrap">
        <div style="float:left;text-align: center;margin-top:3%;"><img src="static\login\login_bgimg.jpg"
               height="300px" /></div>
        <div class="right_box">
          <br />
          <h3 style="color:red;">账户登录</h3>
          <br />
          <input type="text"
                 placeholder="请输入手机号"
                 v-model="tologinParm.phone">
          <input type="password"
                 placeholder="请输入密码"
                 v-model="tologinParm.userPwd">
          <button v-on:click="login">登录</button><br />
          <span v-on:click="ToRegister">没有账号？马上注册</span>
        </div>
      </div>
    </div>
    <div class="weibu5">
      <ul>
        <li>关于我们 | </li>
        <li>联系我们 | </li>
        <li>联系客服 | </li>
        <li>合作招商 | </li>
        <li>商家帮助 | </li>
        <li>营销中心 | </li>
        <li>手机京东 | </li>
        <li>有情链接 | </li>
        <li>销售联盟 | </li>
        <li>京东社区 | </li>
        <li>风险监测 | </li>
        <li>隐私政策 | </li>
        <li>京东公益 | </li>
        <li>Enlish site | </li>
        <li>Media & IR</li>
      </ul>
    </div>
    <div class="weibu6">
      <ul>
        <li>京公网安备11005525225号 | </li>
        <li>京ICP证070359号 | </li>
        <li>互联网药品信息服务资格编号(京)-经营性-2014-0008 | </li>
        <li>新出发京零 字第大120007号 </li>
      </ul>
    </div>
    <div class="weibu7">
      <ul>
        <li>互联网出版许可编号新出网证(京)子150号 | </li>
        <li>出版物经营许可证 | </li>
        <li>网络文化经营许可证京网文[2014]2148-348号 | </li>
        <li>违法和不良信息举报电话:4006561155 </li>
      </ul>
    </div>
    <div class="weibu8">
      <ul>
        <li>Copyright 2004-2019 京东JD.com版权所有 | </li>
        <li>消费者维权热线:4006067733 | </li>
        <li>经营证照 | </li>
        <li>(京)网械平台备字(2018)第00003号 | </li>
        <li>营业执照 </li>
      </ul>
    </div>
    <div class="weibu9">
      <ul>
        <li>Global site | </li>
        <li>Cant PoccNN | </li>
        <li>Sitio de ESpana | </li>
        <li>เว็บไซต์ประเทศไทย </li>
      </ul>
    </div>
    <div class="weibu10">
      <ul>
        <li>京东旗下网站：京东钱包 | </li>
        <li>京东云 | </li>
      </ul>
    </div>
  </div>
</template>
<style scoped>
.zhucetop {
  height: 133px;
  border-bottom: rgb(230, 228, 228) solid 1px;
}
.zhuce {
  background-color: #ea2c1e;
  width: 100%;
  text-align: center;
}
.grid_c1 {
  width: 1000px;
  margin: 0 auto;
}
.regit {
  width: 150px;
  float: left;
  text-align: center;
}
.regit1 {
  margin-left: 2%;
  line-height: 133px;
  float: left;
  font-size: 30px;
}
.login-wrap {
  width: 1000px;
  text-align: center;
  height: 400px;
  margin-left: 20%;
  background-color: #ea2c1e;
}
.right_box {
  background: #fff;
  width: 300px;
  height: 280px;
  float: right;
  margin-right: 5%;
  margin-top: 3%;
}
input {
  display: block;
  width: 250px;
  height: 40px;
  line-height: 40px;
  margin: 0 auto;
  margin-bottom: 10px;
  outline: none;
  border: 1px solid #888;
  padding: 10px;
  box-sizing: border-box;
}
p {
  color: #ea2c1e;
}
button {
  display: block;
  width: 250px;
  height: 40px;
  line-height: 40px;
  margin: 0 auto;
  border: none;
  background-color: red;
  color: #fff;
  font-size: 16px;
  margin-bottom: 5px;
}
span {
  color: red;
  cursor: pointer;
}
span:hover {
  color: rgb(59, 57, 57);
}
.weibu5 {
  background-color: #fff;
  height: 30px;
}
.weibu5 ul {
  list-style-type: none;
  color: rgb(102, 100, 100);
  margin-left: 15%;
}
.weibu5 ul li {
  float: left;
  padding-left: 10px;
}
.weibu6 {
  background-color: #fff;
  height: 30px;
}
.weibu6 ul {
  list-style-type: none;
  color: rgb(102, 100, 100);
  margin-left: 19%;
  font-size: 14px;
}
.weibu6 ul li {
  float: left;
  padding-left: 10px;
}
.weibu7 {
  background-color: #fff;
  height: 30px;
}
.weibu7 ul {
  list-style-type: none;
  color: rgb(102, 100, 100);
  margin-left: 17%;
  font-size: 14px;
}
.weibu7 ul li {
  float: left;
  padding-left: 10px;
}
.weibu8 {
  background-color: #fff;
  height: 30px;
}
.weibu8 ul {
  list-style-type: none;
  color: rgb(102, 100, 100);
  margin-left: 26%;
  font-size: 14px;
}
.weibu8 ul li {
  float: left;
  padding-left: 10px;
}
.weibu9 {
  background-color: #fff;
  height: 30px;
}
.weibu9 ul {
  list-style-type: none;
  color: rgb(102, 100, 100);
  margin-left: 35%;
  font-size: 14px;
}
.weibu9 ul li {
  float: left;
  padding-left: 10px;
}
.weibu10 {
  background-color: #fff;
  height: 30px;
}
.weibu10 ul {
  list-style-type: none;
  color: rgb(102, 100, 100);
  margin-left: 40%;
  font-size: 14px;
}
.weibu10 ul li {
  float: left;
  padding-left: 10px;
}
</style>
<script>
export default {
  data () {
    return {
      showLogin: true,
      tishi: '',
      loginUserName: "",
      loginphone: "",
      address: "",
      tologinParm: {
        phone: '',
        userPwd: ''
      },
      tologinUrl: this.$store.state.url + 'user/login'
    }
  },
  methods: {
    login () {
      if (this.tologinParm.phone == '' || this.tologinParm.userPwd == '') {
        this.$message({
          message: '用户名或者密码不能为空，请输入用户名或密码',
          type: 'error'
        });
      } else {
        this.$axios.post(this.tologinUrl, this.tologinParm).then(res => {
          if (0 == res.data.code) {
            this.loginUserName = res.data.data.userName;
            this.loginphone = res.data.data.phone;
            this.address = res.data.data.address;
            this.$router.push({
              path: '/',
              name: 'index',
              query: {
                loginUserName: this.loginUserName,
                loginphone: this.loginphone,
                address: this.address,
              }
             
            })
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
    ToRegister () {
      this.$router.push({
        path: '/zhuce'
      })
    }
  }
}
</script>
