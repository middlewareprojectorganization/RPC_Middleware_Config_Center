<template>
  <div class="tab-table">
    <basic-container>
      <el-tabs v-model="tabKey" @tab-click="handleClick">
        <el-tab-pane
          v-for="tab in tabs"
          :label="tab.tab"
          :name="tab.key"
          :key="tab.key" 
          class="head">

        

          <el-table
            :data="dataSource[tab.key]"
            style="width: 100%">
            <el-table-column
              v-for="item, index in columns"
              :label="item.title"
              :prop="item.dataIndex"
              :key="item.key"
              :width="item.key !== 'action' ? (item.width || 150) : item.width">
              <template slot-scope="scope">
                <span v-if="item.key !== 'action'">{{scope.row[item.dataIndex]}}</span>
                <edit-dialog :row="scope.row" :key.sync="item.key" :index="scope.$index" :tabKey="tabKey" @handleMod="handleMod"></edit-dialog>
                <delete-balloon :key.sync="item.key" :index="scope.$index" :tabKey="tabKey" @handleRemove="handleRemove"></delete-balloon>
              </template>
            </el-table-column>
          </el-table>
        </el-tab-pane>
      </el-tabs>

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
    </basic-container>
  </div>
</template>

<script>
import BasicContainer from '@vue-materials/basic-container';
import DeleteBalloon from './components/DeleteBalloon';
import EditDialog from './components/EditDialog';
import response from './tab-table.json';

export default {
  components: {
    BasicContainer,
    DeleteBalloon,
    EditDialog,
  },
  name: 'TabTable',

  data() {
    return {
      users: [],
      len: 1,
      pageSize:1, //总长度
      cur: 1,  //当前页码
      arr:[],
      changeCss:null,
      tabKey: 'all',
      dataSource: [],
      tabs: [
        { tab: '消费者', key: 'all' },
        { tab: '服务者', key: 'inreview' },
        // { tab: '服务者', key: 'released' },
        // { tab: '已拒绝', key: 'rejected' },
      ],
      columns: [
        {
          title: '标题',
          dataIndex: 'title',
          key: 'title',
        },
        {
          title: '作者',
          dataIndex: 'author',
          key: 'author',
        },
        {
          title: '状态',
          dataIndex: 'status',
          key: 'status',
        },
        {
          title: '发布时间',
          dataIndex: 'date',
          key: 'date',
        },
        {
          title: '操作',
          key: 'action',
        },
      ],
      visible: false,
    };
      
 
  },

  created() {},



  mounted() {
    this.dataSource = response.data;
  },

  methods: {
    handleClick(tab) {
      console.log(tab);
    },
    handleRemove(index, tabKey) {
      this.dataSource[tabKey].splice(index, 1);
    },
    handleMod(row, index, tabKey) {
      this.$set(this.dataSource[tabKey], index, row);
    },

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
    firstpage(){
      this.cur = 1;
      this.dataListFn(this.cur.toString());
    },
    lastpage(){
      this.cur = this.pageSize;
      this.dataListFn(this.cur.toString());
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

<style>
  .tab-table {
    margin-left: 30px;
  }
 /*  .head{
   margin-left: -10px;
 } */
 .el-tabs__content{
  margin-left: -75px;
 }
</style>



