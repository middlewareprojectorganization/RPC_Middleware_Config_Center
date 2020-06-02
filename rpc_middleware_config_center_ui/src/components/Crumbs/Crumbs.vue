<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>{{msg.father}}</el-breadcrumb-item>
      <el-breadcrumb-item>{{msg.son}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
    props:["msg"],
    data(){
        return{
           
        }
    },
};
</script>

<style lang="stylus" scoped></style>