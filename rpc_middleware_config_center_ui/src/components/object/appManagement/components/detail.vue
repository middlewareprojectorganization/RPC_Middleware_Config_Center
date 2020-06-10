
<template>
  <div>
 <el-dialog title="查看配置详情" :visible.sync="dialogFormViseble" @close="closeDialog">
  <div class="configDetail">
  	<h3>绑定的配置ID</h3><br>
  	<p>-------------</p><br><br>
  	<h3>配置名称</h3><br>
  	<p>=====</p><br><br>
    <h3>下属机器列表</h3><br>
    <p>============</p><br><br>
  </div>
 </el-dialog>
</div>
</template>
<script>
 export default {
   props: ['child2'],

   data () {
     return {
      disposition:'',
       gridData: [{
         date: '2016-05-02',
         name: '王小虎',
         address: '上海市普陀区金沙江路 1518 弄'
       }],
       dialogFormViseble:false,   //默认隐藏子组件
     }
   },
   methods: {
    show(dialogFormViseble){
      this.dialogFormViseble = true;
    },
    closeDialog() {
      this.$emit('CB_dialogStatus')
     },
  	},
 }
</script> 
<style>
  .box{
    margin:0 30px 10px 0;
    float: left;
  }
  .configDetail{
    width: 40%;
    text-indent: 10px !important;
    height: 300px !important;
  }
  .configDetail p{
    text-indent: 10px !important;
  }
</style>

