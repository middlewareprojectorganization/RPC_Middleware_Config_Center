<!-- <template>
	<h1>hi</h1>
</template> -->

<template>
  <div>
 <el-dialog title="查看配置详情" :visible.sync="dialogFormViseble" @close="closeDialog">
	<h4>机器详情</h4>
		<p>机器详情巴拉巴拉</p>
	<h4>服务详情</h4>
		<p>服务详情巴拉巴拉</p>

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
</style>

