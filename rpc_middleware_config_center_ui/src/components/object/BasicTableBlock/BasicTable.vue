<!-- 机器管理页 -->

<template>
  <div className="basic-table">
    <basic-container id="top"> 
      <el-card>
      
        <el-row :gutter="20" class="head">
          <el-col :span="6">
            <div class="grid-content bg-purple"> 
              <el-input placeholder="请输入ip地址" v-model="queryInfo.query"></el-input>
              <p class="inputp">{{ input1 }}</p>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-input placeholder="请输入端口号" v-model="queryInfo.query2"></el-input> 
              <p class="inputp">{{ input2 }}</p>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-button type="primary" icon="el-icon-search" @click=" search(1)">搜索</el-button>
              <el-button type="warning" @click="reset">重置</el-button>
            </div>
          </el-col>
        </el-row>

        <!-- 列表 -->
        <el-table :data="userlist">
          <el-table-column prop="id" label="机器ID"></el-table-column>
          <el-table-column prop="ip" label="IP地址"></el-table-column>  
          <el-table-column prop="age" label="端口号"></el-table-column>
          <el-table-column prop="birthday" label="创建时间"></el-table-column>
          <el-table-column prop="isMale" label="健康值">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.isMale"
                disabled>
              </el-switch>
            </template>
          </el-table-column>
          <el-table-column prop="name" label="所属app"></el-table-column>
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

<script>
import BasicContainer from '@vue-materials/basic-container'
import Mock from 'mockjs'
require('../../../../mock/index.js')
import axios from 'axios';  


export default {
  components: { BasicContainer },
  name: 'BasicTable',
   data () {
    return {
      //获取用户列表带的参数
      queryInfo:{
        query:'',    //要搜索的ip
        query2:'',    //要搜索的端口
        pagenum:1,    //页码
        pagesize:20,   //一页的数量
      },
      userlist:[],  
      total:0,  //总页数

      input1:'',   //第一个文本框下的提示文字
      input2:'',
      editip:false,     //是否可以搜索的标志
      editport:false,
      reflag:false,    //解决重置会触发watch的标志 ，能不显示文字提示
    }
  },
  created(){
    this.getUsersList();
  },
  watch:{
    queryInfo:{
      handler(val, oldVal){
        if(!this.reflag){     //非重置的时候监听
        //ip
          var reg = /^((25[0-5]|2[0-4]\d|[01]?\d\d?)($|(?!\.$)\.)){4}$/
          if(val.query){                  //监听是否输入ip
            this.input1 = ""
          }
          if(!reg.test(val.query.trim())){   //监听ip格式
            this.input1 = "ip格式不正确"
            this.editip = false
          }else{
            this.editip = true
          }
        //端口
          if(val.query2){
            this.input2 = ""
          }
          if(!(parseInt( val.query2 ) >= 0 && parseInt( val.query2) <= 65535) ){
            this.input2 = "端口号格式不正确"
            this.editport = false
          }else{
            this.editport = true
          }
        }
      },
      deep:true //true 深度监听
    }
  },
  methods:{ 
    async getUsersList(type){
      if(type) this.queryInfo.pagenum=1
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
    //搜索
    search() {
      //校验ip格式
      this.reflag = false
      if(!this.queryInfo.query){
        this.input1 = "   * 请输入ip地址"
      }
      // 端口号
      if(!this.queryInfo.query2){
        this.input2 = "   * 请输入端口号"
      }
      if(this.editport && this.editip){
        this.getUsersList(1);
      }

    },
    //重置
    reset(){
      this.queryInfo={
        query:'',    //要搜索的关键字
        pagenum:1,    //页码
        pagesize:20,   //一页的数量
      }
      this.getUsersList();
      this.reflag = true
      this.input1= ''
      this.input2= ''
      // console.log("文字提示"+this.input2)
    },
    release(index, row){         
      // console.log(row.isMale);
      if(row.isMale == false){
        this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          console.log('删除了'+ index)
          // this.$http.delete(``) p265
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      }
    }, 
  },
}
</script>

<style>
  .head{
    height: 60px;
  }
  .inputp{
    font-size: 12px;
    color: red;
  }
</style>
 