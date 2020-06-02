<template>
  <div class="home">
    <el-container>
      <el-header>
        <div class="log">
          <h1>中间件管控平台</h1>
        </div>
      </el-header>
      <el-container>
        <el-aside>
          <el-menu
            class="el-menu-vertical-demo"
            background-color="rgb(38, 43, 47)"
            text-color="#fff"
            active-text-color="skyblue"
            router
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-platform-eleme"></i>
                <span>对象管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="/home/machine">
                  <i class="el-icon-menu"></i>机器管理
                </el-menu-item>
                <el-menu-item index="/home/serve">
                  <i class="el-icon-menu"></i>服务管理
                </el-menu-item>
                <el-menu-item index="/home/configure">
                  <i class="el-icon-menu"></i>配置管理
                </el-menu-item>
                <el-menu-item index="/home/app">
                  <i class="el-icon-menu"></i>App应用管理
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-setting"></i>
                <span>控制中心</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="/home/link">
                  <i class="el-icon-menu"></i>调用链路监控
                </el-menu-item>
                <el-menu-item index="/home/qps">
                  <i class="el-icon-menu"></i>服务qps监控
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-s-promotion"></i>
                <span>规则管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="/home/fluid">
                  <i class="el-icon-menu"></i>流控规则
                </el-menu-item>
                <el-menu-item index="/home/lower">
                  <i class="el-icon-menu"></i>降级规则
                </el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
            <router-view></router-view>
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {};
</script>

<style lang="stylus">
.home {
  width: 100%;
  height: 100%;

  .el-container {
    width: 100%;
    height: 100%;

    .el-header {
      width: 100%;
      padding: 0;
      border-bottom: 1px solid #999;

      .log {
        width: 300px;
        height: 100%;
        padding-left: 50px;
        background: url('../../assets/ho.png') no-repeat 40px 12px;
        background-color: rgb(38, 43, 47);
        border-bottom: 1px solid rgb(38, 43, 47);

        h1 {
          text-align: center;
          line-height: 60px;
          color: #fff;
        }
      }
    }

    .el-aside {
      width: 300px !important;
      background-color: rgb(38, 43, 47);

      .el-menu-vertical-demo {
        border: none;
        border-radius: none;
      }
    }

    .el-main {
    }

    .el-menu-item:hover,
    .el-menu-item:active,
    .el-submenu__title:hover{
      background-color: rgba(128,128,128,.5) !important;
    }
  }
}
</style>