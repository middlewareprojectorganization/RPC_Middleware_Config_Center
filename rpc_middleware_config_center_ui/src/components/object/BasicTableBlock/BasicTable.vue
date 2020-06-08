<template>
  <div className="basic-table">
    <basic-container id="top"> 
      <el-card>
        <el-row :gutter="20">
          <el-col :span="7">
            <el-input placeholder="请输入姓名" v-model="queryInfo.query">
              <el-button slot="append" icon="el-icon-search" @click="getUsersList(1)"></el-button>
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
              <el-button size="mini" type="danger" @click="release(scope.$index, scope.row)" :disabled="scope.row.isMale">释放</el-button>
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
<script src="https://cdn.bootcdn.net/ajax/libs/Mock.js/1.0.1-beta3/mock-min.js"></script>

<script>
import BasicContainer from '@vue-materials/basic-container'
import Mock from 'mockjs'
require('../../../../mock/index.js')
import axios from 'axios';    

export default {
  components: { BasicContainer },
    // inject: ['reload'], // 引入方法
  name: 'BasicTable',
   data () {
    return {
      //获取用户列表带的参数
      queryInfo:{
        query:'',    //要搜索的关键字
        pagenum:1,    //页码
        pagesize:20,   //一页的数量
      },
      userlist:[],  
      total:0,  //总页数
    }
  },
  created(){
    this.getUsersList();
  },
  methods:{ 
    async getUsersList(type){
      if(type)this.queryInfo.pagenum=1
      const data=Object.assign({},this.queryInfo)
      axios.get('/api/users',{data}).then(res=>{
        console.log(res.data.status);
        this.userlist = res.data.data.user;
        this.total = res.data.data.total;
        console.log(res)
      })
    },
    //监听页码值改变
    handleCurrentChange(newPage){
      console.log(newPage); 
      this.queryInfo.pagenum = newPage;
      this.getUsersList();
    },
    //重置
    reset(){
      this.queryInfo={
        query:'',    //要搜索的关键字
        pagenum:1,    //页码
        pagesize:20,   //一页的数量
      }
      this.getUsersList();
    },
    release(index, row){         
      // console.log(row.isMale);
      if(row.isMale == false){
        console.log(index+1)
      }
    }, 
  },
}
</script>

 
<style>
  #top{
    height:1300px;
  }
</style>
 