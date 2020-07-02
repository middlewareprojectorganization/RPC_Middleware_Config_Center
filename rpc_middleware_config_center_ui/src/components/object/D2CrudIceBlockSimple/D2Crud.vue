<!-- 配置管理页 -->

<template>
  <div class="main">
    <el-card>
        <el-row :gutter="20">
          <el-col :span="7">
            <el-button @click="delArray()" type="danger">删除所选</el-button>
            </el-input>
          </el-col>
        </el-row>

    <el-table
      ref="multipleTable"
      :data="configlist"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="80">
      </el-table-column>
      <el-table-column
        label="配置ID"
        prop="age"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="isMale"
        label="是否绑定"
        show-overflow-tooltip
        width="200">
          <template slot-scope="scope">{{ scope.row.date }}
            <el-switch
              v-model="scope.row.isMale"
              disabled>
            </el-switch>
          </template>
      </el-table-column>
      <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="detail(scope.row)">详情</el-button>
              <el-button size="mini" type="warning" @click="edit(scope.row)">修改</el-button>
              <el-button size="mini" type="danger" @click="del(scope.row.age)">删除</el-button>
            </template>
          </el-table-column>
    </el-table>
    
    <el-pagination @current-change="handleCurrentChange" :current-page="queryInfo.pagenum" :page-size="queryInfo.pagesize" layout="total, prev, pager, next, jumper" :total="total"> 
    </el-pagination>
  </el-card>
  
  <!-- 修改记录对话框 -->
  <el-dialog
  title="修改配置"
  :visible.sync="editDialogVisible"
  width="30%">

  <el-form :model="editForm" :rules="editFormRules" ref="editForm" label-width="100px">
    <el-form-item label="配置ID" prop="editid">
      <el-input v-model.number="editForm.editid"></el-input>
    </el-form-item>
    <el-form-item label="名称" prop="editname">
      <el-input v-model="editForm.editname"></el-input>
    </el-form-item>
  </el-form>

  <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="editParams('editForm')">确 定</el-button>
  </span>
</el-dialog>

<!-- 查看详情 -->
  <el-dialog
  title="配置详情"
  :visible.sync="configDialogVisible"
  width="40%"
  >
  <div class="configDetail">
    <h3>配置ID</h3><br>
    <p class="detai">{{ configId }}</p><br><br>
    <h3>应用名称</h3><br>
    <p class="detai">{{ appName }}</p>
  </div>
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
        configlist:[],  
        total:0,  //总页数
        editDialogVisible: false,    //显示隐藏修改对话框
        configDialogVisible: false,
        editForm:{        //修改表单的数据对象
          editid: '',
          editname:''
        },   
        editFormRules:{    //修改表单的验证规则
          editid: [
            { required: true, type:'number', message: "请输入正确的配置id", trigger: "blur" },
            { validator: isInteger, trigger: "blur" }
          ],
          editname: [
            { required: true, message: "请输入应用名称", trigger: "blur" },
            { min: 2, max: 15, message: "长度在 2 到 15 个字符", trigger: "blur" }
          ],
        },
        //详情查看
        configId:'',    //详情查看的配置id
        appName:'',   //详情查看的应用名称
      }
    },
    created(){
      this.getUsersList();
    },
    methods: {
      async getUsersList(type){
        if(type) this.queryInfo.pagenum=1
        const data=Object.assign({},this.queryInfo)
        axios.get('/api/users',{data}).then(res=>{
          console.log(res.data.status);
          this.configlist = res.data.data.user;
          this.total = res.data.data.total;
          console.log(this.configlist)
        })
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
      //单行根据id(age)删除数据
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
      //多行删除
      delArray() {
        if(this.multipleSelection.length){
          this.$confirm('此操作将此'+this.multipleSelection.length+'条记录永久删除, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            //删除记录
            var _this = this;
            const length = this.multipleSelection.length;

            for (let i = 0; i < length; i++) {
                console.log(this.multipleSelection[i])   //获取到的记录
                // this.delarr.push(this.multipleSelection[i].id);
                // console.log(this.delarr[i])
            }
            /*_this.$http({
                method: 'GET',
                url:    ?ids=' + this.delarr,
            }).then(function(res) {
                if (res.data.code == 0) {
                    alert('成功！');
                    _this.getTechSort();
                } else {
                    alert('数据加载失败！');
                }
            })*/

          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });          
          });
      }else{
        this.$message({
            type: 'error',
            message: '暂无选中的数据'
          });  
        return
      }
      },
      //修改记录   p264
      edit(row){
        
        //修改弹框获取该条记录的数据
        this.editForm.editid = row.age
        this.editForm.editname = row.name
        this.editDialogVisible=true    //显示隐藏修改对话框
      },
      //修改确认
      editParams(editForm){
        this.$refs.editForm.validate((valid) => {
            if(valid){
            // console.log("确定修改"+this.editForm.editid)
              this.editDialogVisible=false 
            // 调用修改接口修改数据
              //重新渲染数据
              
            }else{
                this.editDialogVisible = true
                this.$message({
                  type: 'warning',
                  message: '请输入正确的配置信息'
                }); 
            }
        })
      },
      //配置详情
      detail(row){
        // console.log(row.age)
        this.configId = row.age
        this.appName = row.name
        this.configDialogVisible=true
      },
    },
  }
</script>
<style scoped>
   .main{
    height: 1300px;
    margin-top: 10px;
  } 
  .detai{
    text-indent: 10px !important;
  }
  .configDetail{
    height: 300px !important;
  }
</style>