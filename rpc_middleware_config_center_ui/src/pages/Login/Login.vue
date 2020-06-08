<template>
    <div class="Login">
      <h1 class="slogan">欢 迎 使 用 <br> 中 间 件 管 控 平 台</h1>
      <div class="login_box">
        <!-- 头像区域 -->
        <div class="header_box">
          <img src="@/assets/logo.png"  />
        </div>
        <!-- 登入表单区域 -->
        <el-form
          ref="loginFormRef"
          label-width="0px"
          class="login_form"
          :model="loginForm"
          :rules="loginFromRules"
        >
          <!-- 用户名 -->
          <el-form-item prop="username">
            <el-input v-model="loginForm.username" prefix-icon="el-icon-user" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <!-- 密码 -->
          <el-form-item prop="password">
            <el-input
              v-model="loginForm.password"
              type="password"
              show-password
              prefix-icon="el-icon-s-tools"
              placeholder="请输入密码"
            ></el-input>
          </el-form-item>
          <!-- 验证码 -->
          <el-form-item prop="code">
            <el-input v-model="loginForm.code" placeholder="请输入验证码" class="code"></el-input>
            <div class="imgbox">验证码</div>
          </el-form-item>
          <!-- 按钮 -->
          <el-form-item class="btns">
            <el-button type="primary" @click="loginJudge">登陆</el-button>
            <el-button type="info" @click="resetLoginForm">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        //这是登入表单的数据对象
        loginForm: {
          username: "",
          password: ""
        },
        //表达验证规则
        loginFromRules: {
          //验证用户名
          username: [
            { required: true, message: "请输入用户名", trigger: "blur" },
            { min: 3, max: 10, message: "长度在 3 到 10 个字符", trigger: "blur" }
          ],
          //验证密码
          password: [
            { required: true, message: "请输入密码", trigger: "blur" },
            { min: 6, max: 15, message: "长度在 6 到 16 个字符", trigger: "blur" }
          ],
          //验证码
          code: [{ required: true, message: "请输入验证码", trigger: "blur" }]
        }
      };
    },
    methods: {
      //点击重置按钮，重置表单
      resetLoginForm() {
        this.$refs.loginFormRef.resetFields();
      },
      //表单的预验证
      loginJudge() {
        this.$refs.loginFormRef.validate(valid => {
          if (!valid) return;
        });
        this.$router.push({path:'/home'});

      }
    }
  };
  </script>
  
  <style scoped>

.Login {
  width: 100%;
  height: 100%;
  display: block;
  position: relative;
}

.Login::after {
  content: "";
  background-image: url("https://img.alicdn.com/tfs/TB1zsNhXTtYBeNjy1XdXXXXyVXa-2252-1500.png");
  opacity: 0.7;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  position: absolute;
  z-index: -1;   
  background-position: 0px -10px;
  background-size: 1600px;
}
  .slogan {
    position: absolute;
    text-align: center;
    top: 40%;
    left: 20%;
    transform: translateY(-50%);
    font-size: 38px;
  }
  .code {
    width: 50%;
    float: left;
  }
  .imgbox {
    width: 30%;
    height: 40px;
    background-color: aqua;
    float: right;
  }
  .login_box {
    width: 400px;
    height: 370px;
    background-color: #fff;
    border-radius: 3px;
    position: absolute;
    left: 70%;
    top: 50%;
    transform: translate(-50%, -50%);
  }
  .header_box {
    width: 120px;
    height: 120px;
    border-radius: 50%;
    position: absolute;
    top: -50px;
    left: 50%;
    transform: translate(-50%, 0);
    padding: 10px;
    border: 1px solid #eee;
    box-shadow: 0 0 10px #ddd;
    background-color: white;
  }
  .header_box img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
    background-color: #fff;
  }
  .btns {
    display: block;
    float: right;
    padding-top: 20px;
  }
  .login_form {
    position: absolute;
    bottom: 0;
    left: 50%;
    transform: translate(-50%, 0);
    width: 80%;
  }
  </style>