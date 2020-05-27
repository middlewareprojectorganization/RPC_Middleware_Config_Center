<template>
  <div className="basic-table">
    <basic-container id="top">  
      

      <el-table
        :data="arr"
        style="width: 90%; text-indent: 20px;"
        :class="changeCss">
        <el-table-column
          prop="id"
          label="序号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="birthday"
          label="日期"
          width="180">
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="200">
        </el-table-column>
        <el-table-column
          prop="city"
          label="城市">
        </el-table-column>
         <el-table-column
          label="操作" class="btn">
            <template slot-scope="scope">    <!-- 子组件可获取到位置 （scope）-->
            <el-button
              size="mini"
              type="primary"
              @click="open(scope.$index, scope.row)">开通</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="release(scope.$index, scope.row)">释放</el-button>
          </template>
        </el-table-column>
      </el-table>

      <ul class="page-bar" >
        <li v-if="cur>1"><a v-on:click="cur--,pageClick()">首页</a></li>
        <li v-if="cur>1"><a v-on:click="cur--,pageClick()">上一页</a></li>
    
        <li v-if="cur==1"><a class="banclick">首页</a></li>
        <li v-if="cur==1"><a class="banclick">上一页</a></li>
        <li v-for="index in indexs" v-bind:class="{ 'active': cur == index}">
          <a v-on:click="btnClick(index)">{{ index }}</a>
        </li>
        <li v-if="cur!=pageSize"><a v-on:click="cur++,pageClick()">下一页</a></li>
        <li v-if="cur!=pageSize"><a v-on:click="cur++,pageClick()">尾页</a></li>
        <li><a>共<i>{{pageSize}}</i>页</a></li>
      </ul>
    </basic-container>
  </div>
</template>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/Mock.js/1.0.1-beta3/mock-min.js"></script>

<script>
import BasicContainer from '@vue-materials/basic-container'
import Mock from 'mockjs'
require('../../../mock/index.js')
import axios from 'axios';    //vue2.x的引入axios进行前后端交互

export default {
  components: { BasicContainer },
  name: 'BasicTable',
   data () {
    return {
      users: [],
      len: 1,
      pageSize:1, //总长度
      cur: 1,  //当前页码
      arr:[],
      changeCss:null,
    }
  },
  mounted: function(){
    axios.get('/api/users').then(res=>{
      console.log(res)
      this.users= res.data.user;
      this.len = this.users.length;
      console.log("总条数"+this.len);
      this.pageSize = Math.ceil(this.len / 10);
      console.log("总页数"+this.pageSize);
      //第一页
      this.arr = this.users.slice(0,10);
    
    })
  },
  methods:{
    //分页数据
    dataListFn:function(page){
      page--;
      this.arr = this.users.slice(10*page,10*page+10);
      console.log("arr.length:"+this.arr.length)
    },
     //分页
    btnClick: function(data){//页码点击事件
      if(data != this.cur){
        this.cur = data
      }
      //根据点击页数请求数据
      this.dataListFn(this.cur.toString());
    },
    pageClick: function(){
      //根据点击上下页请求数据
      this.dataListFn(this.cur.toString());
    },

    //btn
    release(index,row){         
      for (let i=0;i<10;i++){
        if (row === this.arr[i]){
          // console.log(1);
          this.changeCss = 'disClick';
          console.log(this.changeCss);
        }
      }
    },
    open(index,row){

    }
  },
  computed: {
  //按钮分页
    indexs: function(){ //控制页数btn的个数
      var left = 1;
      var right = this.pageSize;
      var ar = [];
      if(this.pageSize>= 5){
        if(this.cur > 3 && this.cur < this.pageSize-2){
          left = this.cur - 2
          right = this.cur + 2
        }else{
          if(this.cur<=3){
            left = 1
            right = 5
          }else{
            right = this.pageSize
            left = this.pageSize -4
          }
        }
      }
      while (left <= right){
        ar.push(left)
        left ++
      }
      return ar
    }
  },
}
</script>

 
<style>
  .el-table {
        margin: 10px 0 0 80px;
  }
  /*分页*/
  .page-bar{
    margin: 10px 20%;
    align-items: center;
  }
  ul,li{
    margin: 0px;
    padding: 0px;
  }
  li{
   list-style: none
  }
  .page-bar li:first-child>a {
    margin-left: 0px
  }
  .page-bar a{
    border: 1px solid #ddd;
    text-decoration: none;
    position: relative;
    float: left;
    padding: 6px 12px;
    margin-left: -1px;
    line-height: 1.42857143;
    color: #5D6062;
    cursor: pointer;
    margin-right: 20px;
  }
  .page-bar a:hover{
    background-color: #eee;
  }
  .page-bar a.banclick{
    cursor:not-allowed;
  }
  .page-bar .active a{
    color: #fff;
    cursor: default;
    background-color: lightblue;
    border-color: #1880f0;
  }
  .page-bar i{
    font-style:normal;
    color: #d44950;
    margin: 0px 4px;
    font-size: 12px;
  }

.test{
  background: green;
}

 .disClick{
  background: red!important;
 position: relative;
 z-index: 100;
 }

</style>
 