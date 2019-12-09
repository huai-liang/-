<!--注册页面-->
<template>
  <div>
    <div class="hello">
      <div class="zhucetop">
        <div class="regit"><img src="static/login/logo.gif"
               style="width:200px;" /></div>
        <div class="regit1">欢迎注册</div>
        <div class="regit3"
             v-on:click="ToLogin">已有帐号?<i style="color:red;">请登陆></i></div>
      </div>
    </div>
    <div class="zhuce">
      <div class="zhucebody">
        <div style="float:left;text-align: center;margin-top:3%;"><img src="static\login\login_bgimg.jpg"
               height="310" /></div>
        <div class="box_input">
          <div class="zhucebody1">
            <el-form :model="ruleForm"
                     status-icon
                     :rules="rules"
                     ref="ruleForm"
                     label-width="100px"
                     class="demo-ruleForm">
              <el-form-item label="手机号"
                            prop="phone">
                <el-input type="text"
                          placeholder="请输入手机号"
                          v-model="ruleForm.phone"
                          autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="用户名"
                            prop="userName">
                <el-input type="text"
                          v-model="ruleForm.userName"
                          autocomplete="off"
                          placeholder="请输入用户名"></el-input>
              </el-form-item>
              <el-form-item label="密码"
                            prop="pass">
                <el-input type="password"
                          v-model="ruleForm.pass"
                          autocomplete="off"
                          placeholder="请输入密码"></el-input>
              </el-form-item>
              <el-form-item label="确认密码"
                            prop="userPwd">
                <el-input type="password"
                          v-model="ruleForm.userPwd"
                          autocomplete="off"
                          placeholder="请再次输入密码"></el-input>
              </el-form-item>
              <el-form-item label="收货地址"
                            prop="address">
                <el-input v-model.number="ruleForm.address"
                          placeholder="请输入收货地址"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary"
                           @click="tozhuce('ruleForm')">注册</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-form>
          </div>
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

<script>
import '../style/zhuce.css'
export default {
  data () {
    var checkname = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('用户名不能为空'));
      } else {
        callback();
      }
    };
    var checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('地址不能为空'));
      } else {
        callback();
      }
    };
    var checkphone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('手机号不能为空'));
      }
      setTimeout(() => {
        if (!Number.isInteger(value) && value.length != 11) {
          callback(new Error('电话号码不合法'));
        } else {
          callback();
        }
      }, 100);
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.userPwd !== '') {
          this.$refs.ruleForm.validateField('userPwd');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      tozhuceUrl: this.$store.state.url + 'user/addUser',
      ruleForm: {
        phone: '',
        pass: '',
        userPwd: '',
        address: '',
        userName: ''
      },
      rules: {
        userName: [
          { validator: checkname, trigger: 'blur' }
        ],
        phone: [
          { validator: checkphone, trigger: 'blur' }
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        userPwd: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        address: [
          { validator: checkAge, trigger: 'blur' }
        ]
      },
    };
  },
  methods: {
    //注册
    tozhuce (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post(this.tozhuceUrl, this.ruleForm).then(res => {
            if (0 == res.data.code) {
              this.$router.push({
                path: '/login'
              })
            } else {
              this.$message({
                showClose: true,
                message: res.data.msg,
                type: "error"
              });
            }
          });
        } else {
          return false;
        }
      });

    },
    //重置
    resetForm (formName) {
      this.$refs[formName].resetFields();
    },
    ToLogin () {
      this.$router.push({
        path: "/login"
      })
    }
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
