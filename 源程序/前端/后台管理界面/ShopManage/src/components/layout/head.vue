<template>
  <div class="headCom">
    <div class="headStyle">
      <div class="title">京猫网站后台管理</div>
      <div class="userNews">
        <div><img src="../../assets/timg.jpeg"></div>
        <div>
          <div class="btn-fullscreen"
               @click="handleFullScreen">
            <el-tooltip effect="dark"
                        :content="fullscreen ? `取消全屏`:`全屏显示`"
                        placement="bottom">
              <i class="el-icon-rank"
                 style=" width:60px;"></i>
            </el-tooltip>
          </div>
          <el-dropdown @command="handleCommand">
            <span>
              {{userName}}
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="changePassword">修改密码</el-dropdown-item>
              <el-dropdown-item command="backToLogin">退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      fullscreen: false,
      userName: sessionStorage.getItem("userName")
    }
  },
  methods: {
    //点击修改密码/退出
    handleCommand (val) {
      if ('changePassword' == val) {
        alert("修改密码暂未开发")
      } else {
        this.$router.push({
          path: '/'
        })
      }
    },

    handleFullScreen () {
      let element = document.documentElement;
      if (this.fullscreen) {
        if (document.exitFullscreen) {
          document.exitFullscreen();
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen();
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen();
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen();
        }
      } else {
        if (element.requestFullscreen) {
          element.requestFullscreen();
        } else if (element.webkitRequestFullScreen) {
          element.webkitRequestFullScreen();
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen();
        } else if (element.msRequestFullscreen) {
          // IE11
          element.msRequestFullscreen();
        }
      }
      this.fullscreen = !this.fullscreen;
    },
  }
}
</script>
<style scoped>
.headStyle {
  height: 50px;
  width: 100%;
  background: #544242;
}
.title {
  width: 20%;
  float: left;
  text-align: center;
  line-height: 50px;
  color: #fff;
}
.userNews {
  float: right;
  line-height: 50px;
  text-align: right;
  padding-right: 30px;
  overflow: hidden;
  color: #fff;
  font-size: 12px;
}
.userNews div:first-child {
  float: left;
}
.userNews div:first-child img {
  width: 30px;
  margin-top: 10px;
  border-radius: 100px;
  margin-right: 10px;
}
.userNews div:last-child {
  float: left;
}
</style>
<style>
.headCom .el-dropdown {
  color: #fff;
}
</style>
