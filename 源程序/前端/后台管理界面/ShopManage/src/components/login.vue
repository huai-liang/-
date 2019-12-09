<template>
  <div :style="height">
    <div class="logo">
      <div class="scene">
        <div class="container">
          <div class="sun"></div>
          <div class="band"
               style="animation-delay: -0s"></div>
          <div class="band"
               style="animation-delay: -1s"></div>
          <div class="band"
               style="animation-delay: -2s"></div>
          <div class="band"
               style="animation-delay: -3s"></div>
          <div class="band"
               style="animation-delay: -4s"></div>
          <div class="band"
               style="animation-delay: -5s"></div>
          <div class="band"
               style="animation-delay: -6s"></div>
          <div class="band"
               style="animation-delay: -7s"></div>
          <div class="band"
               style="animation-delay: -8s"></div>
          <div class="band"
               style="animation-delay: -9s"></div>
        </div>
      </div>
      <img src="../assets/logoko3.png"
           alt="">
    </div>
    <div class="login">
      <div class="login-box">
        <img src="../assets/logo.jpg" />
        <el-form ref="loginForm"
                 :model="loginForm"
                 :rules="rules"
                 style="position: relative;left: 0px;top: -55px;">
          <div class="login-field1">
            <label class="login-title"
                   style="color:black"></label>
            <el-form-item prop="name">
              <el-input placeholder="请输入账号"
                        v-model="loginForm.name"
                        clearable></el-input>
            </el-form-item>
          </div>

          <div class="login-field2">
            <label class="login-title"
                   style="color:black"></label>
            <el-form-item prop="password">
              <el-input placeholder="请输入密码"
                        v-model="loginForm.password"
                        show-password></el-input>
            </el-form-item>
          </div>

          <el-form-item size="small"
                        class="me-login-button">
            <el-button type="primary"
                       class="login-button"
                       @click="denglu">登陆</el-button>
            <el-button type="primary"
                       class="login-button">默认账号:admin - 密码:admin</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data () {
    return {
      tologin: this.$store.state.url + '/Admincontroller/selectAdmin',
      loginForm: {
        name: "",
        password: ""
      },
      height: {
        height: ""
      },
      rules: {
        name: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { max: 10, message: "不能大于10个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { max: 10, message: "不能大于10个字符", trigger: "blur" }
        ]
      }
    };
  },
  created () {
    this.hh();
  },
  methods: {
    denglu () {
      this.$axios.post(this.tologin, this.loginForm).then(res => {
        if (res.data.code == 0) {
          sessionStorage.setItem("userName", res.data.data.name)
          this.$router.push({ path: "/homePage" });
          this.$message("登陆成功");
        } else {
          this.$message("账号密码有误");
        }
      }).catch(err => {
        this.$message("账号密码有误");
      });
    },

    zhuce () {
      this.$router.push({ path: "/zhuce" });
    },
    hh () {
      this.height.height = window.innerHeight + "px";
    }
  }
};
</script>

<style scoped>
body {
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
  background: url(./../assets/loginbg.jpg) no-repeat;
  background-size: 100% 100%;
  background-color: #111122;
}
.login {
  width: 100%;
  height: 100%;
  background: #111122;
  background-color: #112;
}
.logo {
  margin-top: 20px;
  position: absolute;
  left: 200px;
  top: 90px;
  width: 500px;
}
.logo img {
  height: 90px;
  position: relative;
  bottom: 65px;
  left: 40px;
}
.login-box {
  height: 458px;
  position: absolute;
  top: 305px;
  right: -125px;
  transform: translate(-50%, -50%);
  width: 400px;
  padding: 40px;
  background: #fff;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.5);
  border-radius: 10px;
}
.login-box img {
  width: 300px;
  position: relative;
  left: 13px;
  top: -40px;
}

.login-box .login-field {
  position: relative;
}
.login-box .login-field1 {
  margin-bottom: 20px;
}
.login-box .login-field1 .login-title {
  color: #fff;
  margin-bottom: 10px;
}
.login-box .login-field2 .login-title {
  color: #fff;
}
.login-box .login-button {
  margin-top: 10px;
  width: 320px;
}
.el-button + .el-button {
  margin-left: 0;
  margin-top: 22px;
}

input[type="checkbox"] {
  display: none;
}
input[type="checkbox"]:checked ~ label {
  -webkit-transform: translate(0, -0.65em);
  transform: translate(0, -0.65em);
  padding-bottom: 0.65em;
}
input[type="checkbox"]:checked ~ .scene {
  background-color: #00ffff;
  -webkit-animation: hue-rotate 60s linear infinite 0s;
  animation: hue-rotate 60s linear infinite 0s;
}
input[type="checkbox"]:checked ~ .scene .container {
  -webkit-filter: blur(0.75vw) contrast(3);
  filter: blur(0.75vw) contrast(3);
}
input[type="checkbox"]:checked ~ .scene .container .sun {
  background: radial-gradient(transparent 65%, #fd1 100%),
    linear-gradient(#f53 0, #fd1 100%);
  -webkit-animation: initial;
  animation: initial;
}
input[type="checkbox"]:checked ~ .scene .container .band {
  background-color: #5affff;
}

label {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1;
  padding-left: 0.1em;
  font-size: 4em;
  cursor: pointer;
  transition: all 0.5s cubic-bezier(0.65, 0.05, 0.36, 1);
}

.scene {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background-color: #112;
}

.container {
  position: relative;
  height: 30vw;
  width: 30vw;
  overflow: hidden;
}

.sun {
  position: absolute;
  top: 0;
  left: 50%;
  -webkit-transform: translate(-50%, 0);
  transform: translate(-50%, 0);
  width: 25vw;
  height: 25vw;
  background: radial-gradient(transparent 65%, #ff0488 100%),
    linear-gradient(#ffcb55 0, #ff0488 100%);
  border-radius: 50%;
  -webkit-animation: hue-rotate 60s ease-in-out infinite 5s;
  animation: hue-rotate 60s ease-in-out infinite 5s;
}

.band {
  position: absolute;
  bottom: -6vw;
  width: 100%;
  height: 10%;
  background: #112;
  -webkit-animation: wave 10s linear infinite;
  animation: wave 10s linear infinite;
}

@-webkit-keyframes wave {
  0% {
    -webkit-transform: translateY(0) scaleY(1);
    transform: translateY(0) scaleY(1);
  }
  100% {
    -webkit-transform: translateY(-24vw) scaleY(0);
    transform: translateY(-24vw) scaleY(0);
  }
}

@keyframes wave {
  0% {
    -webkit-transform: translateY(0) scaleY(1);
    transform: translateY(0) scaleY(1);
  }
  100% {
    -webkit-transform: translateY(-24vw) scaleY(0);
    transform: translateY(-24vw) scaleY(0);
  }
}
@-webkit-keyframes hue-rotate {
  0% {
    -webkit-filter: hue-rotate(360deg);
    filter: hue-rotate(360deg);
  }
  100% {
    -webkit-filter: hue-rotate(0deg);
    filter: hue-rotate(0deg);
  }
}
@keyframes hue-rotate {
  0% {
    -webkit-filter: hue-rotate(360deg);
    filter: hue-rotate(360deg);
  }
  100% {
    -webkit-filter: hue-rotate(0deg);
    filter: hue-rotate(0deg);
  }
}
</style>
