<template>
  <div>
 <el-dialog title="绑定配置" :visible.sync="dialogFormViseble" @close="closeDialog">
 
 <div v-for="item in sum" class="box">
    <input type="radio" :id="item.order" :value="item.value" v-model="disposition" name="radio" @click="addbtn(item.value)">
    <label :for="item.order">{{item.value}}</label>
  </div>
   <div slot="footer" class="dialog-footer">
     <el-button @click="dialogFormViseble = false" >取 消</el-button>
     <el-button type="primary" @click="sure" >确 定</el-button>
   </div>
 </el-dialog>
</div>
</template>
<script>
 export default {
   props: ['child'],

   data () {
     return {
      disposition:'',
       gridData: [{
         date: '2016-05-02',
         name: '王小虎',
         address: '上海市普陀区金沙江路 1518 弄'
       }],
       sum: [
        { order: "one",value: "One"},
        { order: "two",value: "Two"},
        { order: "three",value: "three"},
        { order: "four",value: "four"},
        { order: "five",value: "five"},
      ],
       dialogFormViseble:false,   //默认隐藏子组件
     }
   },
   methods: {
    show(dialogFormViseble){
      this.dialogFormViseble = true;
      // return 
    },
    closeDialog() {
      this.$emit('CB_dialogStatus')

     },
     addbtn(index){   
      console.log(index);
      
     },
     fail(){

     },
     sure(){
      // this.btnstate=true;
      // console.log(btnstate)
      // $emit('')
      this.dialogFormViseble = false;
     },
   },

  /* watch:{
     dialogStatus(newLv,oldLv){
         this.dialogFormViseble=newLv
     }*/
   // }
 }
</script> 
<style>
  .box{
    margin:0 30px 10px 0;
    float: left;
  }
</style>

