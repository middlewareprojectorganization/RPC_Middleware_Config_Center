<template>
  <div className="basic-table">
    <basic-container id="top"> 
      <!-- <div class="search">
        <input type="text" v-model="search">
        <button @click="searchIp">搜索IP</button>
        &nbsp;
        <button @click="reset">重置</button>
      </div>  -->

     <!--  <el-table
       :data="arr"
       style="width: 90%; text-indent: 20px;"
       :key="arr.id">
       <el-table-column
         prop="id"
         label="序号"
         width="180"
         :filters="[{text: search, value: search}]"
         :filter-method="filterHandler"> 
       </el-table-column>
       <el-table-column
         prop="birthday"
         label="日期"
         width="180"
         >
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
           <template slot-scope="scope">    子组件可获取到位置 （scope）
           <el-button
             size="mini"
             type="danger"
             @click="release(scope.$index, scope.row)"
             :disabled="scope.row.isMale">释放</el-button>
         </template>
       </el-table-column>
     </el-table> -->

      <!-- <ul class="page-bar" >
        <li v-if="cur>1"><a v-on:click="cur--,firstpage()">首页</a></li>
        <li v-if="cur>1"><a v-on:click="cur--,pageClick()">上一页</a></li>
          
        <li v-if="cur==1"><a class="banclick">首页</a></li>
        <li v-if="cur==1"><a class="banclick">上一页</a></li>
        <li v-for="index in indexs" v-bind:class="{ 'active': cur == index}">
          <a v-on:click="btnClick(index)">{{ index }}</a>
        </li>
        <li v-if="cur!=pageSize"><a v-on:click="cur++,pageClick()">下一页</a></li>
        <li v-if="cur!=pageSize"><a v-on:click="cur++,lastpage()">尾页</a></li>
        <li><a>共<i>{{pageSize}}</i>页</a></li>
      </ul> -->
      <el-card>
        <el-row :gutter="20">
          <el-col :span="7">
            <el-input placeholder="请输入查询的id" v-model="queryInfo.query">
              <el-button slot="append" icon="el-icon-search" @click="getUsersList"></el-button>
            </el-input>
          </el-col>
          <el-col :span="4">
            <el-button type="primary" @click="reset">重置</el-button>
          </el-col>
        </el-row>

        <!-- 列表 -->
        <el-table :data="userlist">
          <el-table-column type="index"></el-table-column>
          <el-table-column prop="birthday" label="日期"></el-table-column>
          <el-table-column prop="name" label="姓名"></el-table-column>
          <el-table-column prop="city" label="城市"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="danger">释放</el-button>
            </template>
          </el-table-column>
        </el-table>
        
        <el-pagination @current-change="handleCurrentChange" :current-page="queryInfo.pagenum" :page-size="queryInfo.pagesize" layout="total, prev, pager, next, jumper" :total="total"> 

        </el-pagination>
      </el-card>
    </basic-container>
  </div>
</template>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <script src="https://cdn.bootcdn.net/ajax/libs/Mock.js/1.0.1-beta3/mock-min.js"></script> -->

<script>
import BasicContainer from '@vue-materials/basic-container'
// import Mock from 'mockjs'
// require('../../../mock/index.js')
import axios from 'axios';    //vue2.x的引入axios进行前后端交互

export default {
  components: { BasicContainer },
    inject: ['reload'], // 引入方法
  name: 'BasicTable',
   data () {
    return {
     /* users: [],
      len: 1,
      pageSize:1, //总长度
      cur: 1,  //当前页码
      arr:[],
      search:''*/

      //获取用户列表带的参数
      queryInfo:{
        query:'',    //要搜索的关键字
        pagenum:1,    //页码
        pagesize:2,   //一页的数量
      },
      userlist:[],  
      total:0,  //总页数
    }
  },
  created(){
    this.getUsersList();
  },
  methods:{ 
    async getUsersList(){
      /*axios.get('/api/users').then(res=>{
        console.log(res);
      })*/
      const {data: res} = await this.$http.get('users',{params:this.queryInfo});
      if(res.meta.status !== 200){
        return this.$message.error('获取用户列表失败');
      }
      this.userlist = res.data.users;  //获取所有信息
      this.total = res.data.total;   //获取总页数
    },
    //监听页码值改变
    handleCurrentChange(newPage){
      console.log(newPage); 
      this.queryInfo.pagenum = newPage;
      this.getUsersList();
    },
    //重置
    reset(){
      this.getUsersList();
    },
  },
 /* mounted: function(){
    axios.get('/api/users').then(res=>{
      console.log(res.data.user)
      this.users= res.data.user;
      this.len = this.users.length;
      console.log("总条数"+this.len);
      this.pageSize = Math.ceil(this.len / 10);
      console.log("总页数"+this.pageSize);
      //第一页
      this.arr = this.users.slice(0,10);*/

    // })
  // },
  // methods:{
    //分页数据
    // dataListFn:function(page){
    //   page--;
    //   this.arr = this.users.slice(10*page,10*page+10);
    //   console.log("arr.length:"+this.arr.length)
    // },
     //分页
    /*btnClick: function(data){//页码点击事件
      if(data != this.cur){
        this.cur = data
      }*/
      //根据点击页数请求数据
     /* this.dataListFn(this.cur.toString());
    },*/
    // pageClick: function(){
    //   //根据点击上下页请求数据
    //   this.dataListFn(this.cur.toString());
    // },
    /*firstpage(){
      this.cur = 1;
      this.dataListFn(this.cur.toString());
    },
    lastpage(){
      this.cur = this.pageSize;
      this.dataListFn(this.cur.toString());
    },*/
    /*release(index, row){         
      console.log(index)
    }, */
    //过滤
    /*filterHandler(){

    },
    searchIp(){
      console.log(this.search)
    },
    reset(){

    },*/
  // },
  // watch:{

  // },
  // computed: {
  //按钮分页
   /* indexs: function(){ //控制页数btn的个数
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
    }*/
  // },
}
</script>

 
<style>
 .el-table tr:nth-child(){
   background-color: rgba(128,128,128,.2);
 
 }

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
  .search{
    margin-left: 70%;
  }
  .search input,
  .search button{
    height: 30px
  }
 /*  .el-table-filter{
   margin-left: 900px;
 } */
 el-card{
  /*float: right;*/
} 
</style>
 