<!-- app应用管理 -->

<template>
  <div className="basic-table">
    <basic-container id="top"> 
      <el-card>
        <!-- 列表 -->
        <el-table :data="userlist">
          <el-table-column prop="id" label="app ID"></el-table-column>
          <el-table-column prop="name" label="app应用名称"></el-table-column>
          <el-table-column prop="birthday" label="创建时间"></el-table-column>
          <el-table-column label="操作" width="500">
            <template slot-scope="scope">
              <el-button size="mini" type="success" @click="choose(scope.$index, scope.row)">选择配置</el-button>
              <el-button size="mini" type="warning" @click="cancel(scope.$index, scope.row)">解绑</el-button>
              <el-button size="mini" @click="detail(scope.$index, scope.row)">查看详情</el-button>
            </template>
          </el-table-column>
        </el-table>
          
        <el-pagination @current-change="handleCurrentChange" :current-page="queryInfo.pagenum" :page-size="queryInfo.pagesize" layout="total, prev, pager, next, jumper" :total="total"> 
        </el-pagination>
      </el-card>
    </basic-container>

  <!-- 绑定配置 -->
    <el-dialog title="绑定配置" :visible.sync="bindDialogFormViseble">
      <div v-for="item in sum" class="box">
        <input type="radio" :id="item.order" :value="item.value" v-model="disposition" name="radio" @click="addbtn(item.value)">
        <label :for="item.order">{{item.value}}</label>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="bindDialogFormViseble = false" >取 消</el-button>
        <el-button type="primary" @click="sure">确 定</el-button>
      </div>
    </el-dialog>

  <!-- 详情查看 -->
    <el-dialog title="查看配置详情" :visible.sync="detailDialogFormViseble">
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
import BasicContainer from '@vue-materials/basic-container'
import Mock from 'mockjs'
require('../../../../mock/index.js')
import axios from 'axios';

export default {
  components: {
    BasicContainer,
  },
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
      //选择配置
      btnstate: false,  //是否选择了配置
      disposition:'',     //选择了什么配置
      btnlocal: '',     //编辑的位置

      bindDialogFormViseble: false,  //配置子组件状态
      detailDialogFormViseble: false,  //详情查看子组件状态

      sum: [
        { order: "one",value: "One"},
        { order: "two",value: "Two"},
        { order: "three",value: "three"},
        { order: "four",value: "four"},
        { order: "five",value: "five"},
      ],

    }
  },
  created(){
    this.getUsersList();
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
    //选择配置
    choose(index,row){
      var status = this.userlist[index].isMale;   
      // console.log(this.child);
      console.log(status);

      if(status){
        //已经绑定状态
        this.$message({
          message: '请先解绑',
          type: 'warning'
        });
         this.bindDialogFormViseble = false;
      }else{
        this.bindDialogFormViseble = true;

        this.btnlocal = index    //获取正在编辑的位置
        this.disposition = ''    //要选择的配置先初始化为空
      }
    },
    addbtn(index){     //获取选择到的配置
      // console.log("hi"+index);
      this.disposition = index     //点击选择改配置的值
      console.log("disposition"+this.disposition)      
    },
    sure(){
      //当然要确定才能为true
      if(this.disposition){    //选择了配置才能确定绑定
        this.bindDialogFormViseble = false;
        this.userlist[this.btnlocal].isMale = true;
        this.$message({
          message: '绑定配置成功',
          type: 'success'
        });
      }else{
        this.bindDialogFormViseble = true;
        this.userlist[this.btnlocal].isMale = false; 
        this.$message({
          message: '绑定配置失败',
          type: 'error'
        });
      }
        
    },
    // 解绑
    cancel(index,row){
      var status = this.userlist[index].isMale;   
      console.log(status);
      if(status){
        this.userlist[index].isMale = false;
        this.$message({
          message: '成功取消绑定',
          type: 'success'
        });
      }else{
        this.$message.error('暂无绑定任何配置');
      }
    },

    // 详情查看
    detail(index,row){
      if(!this.userlist[index].isMale){
        this.$message.error('暂无任何配置详情,请先绑定');
        return 
      }
      this.detailDialogFormViseble = true;
    },
  },
}
</script>

 
<style>
  #top{
    /*height:1300px;*/
  }
  .box{
    margin:0 30px 10px 0;
    float: left;
    height: 500px !important;
  }
</style>
