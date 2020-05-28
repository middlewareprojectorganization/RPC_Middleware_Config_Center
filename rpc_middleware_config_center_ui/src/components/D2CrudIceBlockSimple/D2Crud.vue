<template>
  <div>
    <d2-crud
    ref="d2Crud"
    :columns="columns"
    :data="data"
    add-title="我的新增"
    :add-template="addTemplate"
    :form-options="formOptions"
    :rowHandle="rowHandle"
    @row-remove="handleRowRemove"
    @dialog-open="handleDialogOpen"
    @row-add="handleRowAdd"
    @dialog-cancel="handleDialogCancel">
      <el-button slot="header" class="add" @click="addRow">添加</el-button>
      <!-- <el-button slot="header" style="margin-bottom: 5px" @click="addRowWithNewTemplate">使用自定义模板新增</el-button> -->
      <el-button slot="header"><i class="el-icon-search"></i> 搜索</el-button>
    </d2-crud>

    <ul class="page-bar" >
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
      </ul>
  </div>
</template>

<script>
import Vue from 'vue'
import D2Crud from '@d2-projects/d2-crud'

Vue.use(D2Crud)

export default {
  data() {
    return {
      users: [],
      len: 1,
      pageSize:1, //总长度
      cur: 1,  //当前页码
      arr:[],
      columns: [
        {
          title: '日期',
          key: 'date',
          width: '180'
        },
        {
          title: '姓名',
          key: 'name',
          width: '180'
        },
        {
          title: '地址',
          key: 'address'
        }
      ],
      data: [
        {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄',
          forbidRemove: false,
          showRemoveButton: true
        },
        {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄',
          forbidRemove: false,
          showRemoveButton: true
        },
        {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄',
          forbidRemove: false,
          showRemoveButton: true
        },
        {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄',
          forbidRemove: false,
          showRemoveButton: true
        }
      ],
      addTemplate: {
        date: {
          title: '日期',
          value: '2016-05-05'
        },
        name: {
          title: '姓名',
          value: '王小虎'
        },
        address: {
          title: '地址',
          value: '上海市普陀区金沙江路 1520 弄'
        }
      },
      formOptions: {
        labelWidth: '80px',
        labelPosition: 'left',
        saveLoading: false
      },

      rowHandle: {
        remove: {
          icon: 'el-icon-delete',
          size: 'small',
          fixed: 'right',
          confirm: true,
          show (index, row) {
            if (row.showRemoveButton) {
              return true
            }
            return false
          },
          disabled (index, row) {
            if (row.forbidRemove) {
              return true
            }
            return false
          }
        },
      }
    }
  },
  methods: {
    //删除btn
    handleRowRemove ({ index, row }, done) {
      setTimeout(() => {
        console.log(index)
        console.log(row)
        this.$message({
          message: '删除成功',
          type: 'success'
        })
        done()
      }, 300)
    },
    handleDialogOpen ({ mode }) {
      /*this.$message({
        message: '打开模态框，模式为：' + mode,
        type: 'success'
      })*/
    },
    // 普通的新增
    addRow () {
      this.$refs.d2Crud.showDialog({
        mode: 'add'
      })
    },
    handleMod(row, index, tabKey) {
      this.$set(this.dataSource[tabKey], index, row);
    },
    // 传入自定义模板的新增
    // addRowWithNewTemplate () {
    //   this.$refs.d2Crud.showDialog({
    //     mode: 'add',
    //     template: {
    //       name: {
    //         title: '姓名',
    //         value: ''
    //       },
    //       value1: {
    //         title: '新属性1',
    //         value: ''
    //       },
    //       value2: {
    //         title: '新属性2',
    //         value: ''
    //       }
    //     }
    //   }
    //},
    handleRowAdd (row, done) {
      this.formOptions.saveLoading = true
      setTimeout(() => {
        console.log(row)
        this.$message({
          message: '保存成功',
          type: 'success'
        });

        // done可以传入一个对象来修改提交的某个字段
        done({
          address: '我是通过done事件传入的数据！'
        })
        this.formOptions.saveLoading = false
      }, 300)
    },
    handleDialogCancel (done) {
      this.$message({
        message: '取消保存',
        type: 'warning'
      });
      done()
    },

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
<style scoped>
  .add{
    margin:2% 0 0 70% !important;
    background-color: rgb(188,188,188) !important;
  }
</style>
