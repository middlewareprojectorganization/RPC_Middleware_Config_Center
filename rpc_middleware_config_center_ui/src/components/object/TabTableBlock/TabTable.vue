<!-- 配置管理页 -->

<template>
  <div class="main">
    <el-card>
      <el-tabs v-model="activeName" @tab-click="handleClick(activeName)">
        <el-tab-pane label="消费者" name="first">
          <el-table style="width: 100%" :data="consumerlist">
            <el-table-column label="服务ID" prop="id" width="180"></el-table-column>
            <el-table-column label="服务名称" prop="name" width="180"></el-table-column>
            <el-table-column label="所属app" prop="name" width="180"></el-table-column>
            <el-table-column label="所属机器" prop="name" width="180"></el-table-column>
            <el-table-column label="导出/引入时间" prop="birthday"></el-table-column>
            <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="edit(scope.row, scope.$index)">编辑</el-button>
              <el-button size="mini" type="danger" @click="del(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
          </el-table>
        </el-tab-pane>
        <el-tab-pane label="服务者" name="second">
          <el-table style="width: 100%" :data="consumerlist">
            <el-table-column label="服务ID" prop="id" width="180"></el-table-column>
            <el-table-column label="服务名称" prop="name" width="180"></el-table-column>
            <el-table-column label="所属app" prop="name" width="180"></el-table-column>
            <el-table-column label="所属机器" prop="name" width="180"></el-table-column>
            <el-table-column label="导出/引入时间" prop="birthday"></el-table-column>
            <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="edit(scope.row, scope.$index)">编辑</el-button>
              <el-button size="mini" type="danger" @click="del(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
          </el-table>
        </el-tab-pane>
    </el-tabs>

    <el-pagination @current-change="handleCurrentChange" :current-page="queryInfo.pagenum" :page-size="queryInfo.pagesize" layout="total, prev, pager, next, jumper" :total="total">
    </el-pagination>
  </el-card>
  
<!-- 修改记录对话框 -->
  <el-dialog
  title="编辑"
  :visible.sync="editDialogVisible"
  width="30%">
  
  <el-form :model="editForm" :rules="editFormRules" ref="editForm" label-width="100px">
    <el-form-item label="所属app" prop="editapp">
      <el-input v-model="editForm.editapp"></el-input>
    </el-form-item>
    <el-form-item label="所属机器" prop="editmachine">
      <el-input v-model="editForm.editmachine"></el-input>
    </el-form-item>
  </el-form>
  
  <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="editParams('editForm')">确 定</el-button>
  </span>
  </el-dialog>
</div>
</template>

<script>
  import Mock from 'mockjs'
require('../../../../mock/index.js')
import axios from 'axios'; 
import { isInteger } from '../../validator.js';


  export default {
    data() {
      return {
        multipleSelection: [],
        queryInfo:{
          query:'',    //要搜索的关键字
          pagenum:1,    //页码
          pagesize:20,   //一页的数量
        },
        consumerlist:[],  
        total:0,  //总页数
        editDialogVisible: false,    //显示隐藏修改对话框
        configDialogVisible: false,
        editForm:{        //修改表单的数据对象
          editapp: '',
          editmachine:''
        },
        editFormRules:{    //修改表单的验证规则
          editapp: [
            // { required: true, message: "请输入正确的app名", trigger: "blur" },
            // { validator: isInteger, trigger: "blur" }
          ],
          editmachine: [
            // { required: true, message: "请输入应用名称", trigger: "blur" },
            // { min: 2, max: 15, message: "长度在 2 到 15 个字符", trigger: "blur" }
          ],
        },
        local:'',     //编辑位置
        activeName: 'first',  //默认显示的表
      }
    },
    created(){
      this.getUsersList();
    },
    methods: {
      async getUsersList(type){
        //要判断是在哪个tab   if-else请求数据
        if(this.activeName == 'first'){
          if(type) this.queryInfo.pagenum=1
        const data=Object.assign({},this.queryInfo)
        axios.get('/api/users',{data}).then(res=>{
          console.log(res.data.status);
          this.consumerlist = res.data.data.user;
          this.total = res.data.data.total;
          console.log(this.consumerlist)
          console.log('first')
        })
      }else{
        if(type) this.queryInfo.pagenum=1
        const data=Object.assign({},this.queryInfo)
        axios.get('/api/users',{data}).then(res=>{
          console.log(res.data.status);
          this.consumerlist = res.data.data.user;
          this.total = res.data.data.total;
          console.log(this.consumerlist)
          console.log('second')

        })
      }
        
      },
       //监听页码值改变
    handleCurrentChange(newPage){
      console.log(newPage); 
      this.queryInfo.pagenum = newPage;
      this.getUsersList();
    },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      // 切换表
      handleClick(tab) {
        // console.log(tab);
        this.getUsersList()
      },
      //根据id删除数据
      del(id){
         this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          console.log('删除了')
          // this.$http.delete(``) p265
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      //修改记录   p264
      edit(row, index){
        //修改弹框获取该条记录的数据
        this.editForm.editapp = row.name
        this.editForm.editmachine = row.name
        this.local = index   //获取到正在编辑的位置
        this.editDialogVisible=true    //显示隐藏修改对话框
      },
      //修改确认
      editParams(editForm){
        this.$refs.editForm.validate((valid) => {
            if(valid){
            // console.log("确定修改"+this.editForm.editapp)
              console.log(this.consumerlist[this.local].birthday)
              this.editDialogVisible=false 
            // 调用修改接口修改数据
              //重新渲染数据
              
            }else{
                this.editDialogVisible = true
                this.$message({
                  type: 'warning',
                  message: '修改失败'
                }); 
            }
        })
      },
    },
  }
</script>
<style scoped>
  /*  .main{
   height: 1300px;
   margin-top: 10px;
    } 
    .detai{
   text-indent: 10px !important;
    }
    .configDetail{
   height: 300px !important;
    } */
    .main{
      margin-top: 10px
    }
</style>