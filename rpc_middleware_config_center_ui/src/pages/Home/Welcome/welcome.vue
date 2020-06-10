<template>
    <div class="Welcome">
    	<div class="main">
            <!-- <h1>系统性能监测图</h1> -->
            <div class="main-left">
               <div id="aline"></div>
                <el-table :data="configlist" style="width: 100%;padding-left: 10px">
                    <el-table-column prop="date"  label="操作" width="180">
                        <template slot-scope="scope">
                            <span class="look" @click="edit(scope.row, scope.$index)">查看</span> |
                            <span class="del" @click="del(scope.row.id)">删除</span>
                        </template>
                    </el-table-column>
                    <el-table-column prop="data" label="时间" width="180"></el-table-column>
                    <el-table-column  prop="name" label="姓名"  width="180"></el-table-column>
                    <el-table-column  prop="id" label="机器id"  width="180"></el-table-column>
                </el-table>
                <el-pagination @current-change="handleCurrentChange" :current-page="queryInfo.pagenum" :page-size="queryInfo.pagesize" layout="total, prev, pager, next, jumper" :total="total">
                </el-pagination>
            </div>
            <div class="main-top">
                <div class="top-title"></div>
                <div id="histogram"></div>
            </div>
            <div class="main-bottom">
                <div class="bottom-title"></div>
                <div id="pei"></div>
            </div>
        </div>
        <!-- <div class="message">
            <h3>系统简介：</h3>
            <p>{{introduction}}</p>
            <h3>用户信息：</h3>
            
            <h3>监控app应用列表</h3>
        </div> -->
    </div>
</template>

<script>
import Mock from 'mockjs'
require('../../../../mock/home.js')
import axios from 'axios'; 
import echarts from 'echarts'
    export default {
        data() {
            return {
                queryInfo:{
                  query:'',    //要搜索的关键字
                  pagenum:1,    //页码
                  pagesize:5,   //一页的数量
                },
                //查看
                lookname:'',
                lookid:'',

                arr:[],
                configlist:[],  
                total:0,  //总页数
                showHeader: false,
                introduction:'巴拉巴拉巴拉巴拉巴拉巴拉巴拉巴拉',
                tableData: [{
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    date: '2016-05-04',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1517 弄'
                }, {
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                },  {
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                }, {
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1516 弄'
                }]
            }
        },
        components: {
          
        },
        mounted(){
            //柱形
            // 基于准备好的dom，初始化echarts实例
            var histogramChart = echarts.init(document.getElementById('histogram'));
            // 指定图表的配置项和数据
            var histogramOption = {
                /*title: {
                    text: 'ECharts 入门示例'
                },*/
                tooltip: {},
                legend: {
                    data:['销量']
                },
                xAxis: {
                    data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: [5, 20, 36, 10, 10, 20]
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            histogramChart.setOption(histogramOption);


            //饼图
            var peiChart = echarts.init(document.getElementById('pei'));
            var peiOption = {
                series : [{
                    name: '访问来源',
                    type: 'pie',
                    radius: '55%',
                    data:[
                        {value:235, name:'视频广告'},
                        {value:274, name:'联盟广告'},
                        {value:310, name:'邮件营销'},
                        {value:335, name:'直接访问'},
                        {value:400, name:'搜索引擎1'}
                    ]
                }]
            };
            peiChart.setOption(peiOption);

            // 折线
            var alineChart = echarts.init(document.getElementById('aline'));
            var alineOption = {
                /*title: {
                    text: '折线图堆叠'
                },*/
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    // data: ['邮件营销', '联盟广告', '视频广告', '直接访问', '搜索引擎']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                     /*   name: '邮件营销',
                        type: 'line',
                        stack: '总量',
                        data: [120, 132, 101, 134, 90, 230, 210]
                    },
                    {
                        name: '联盟广告',
                        type: 'line',
                        stack: '总量',
                        data: [220, 182, 191, 234, 290, 330, 310]
                    },
                    {*/
                        name: this.lookname,
                        type: 'line',
                        // stack: '总量',
                        data: [820, 932, 901, 934, 1290, 1330, 1320]
                    }]
            };
            alineChart.setOption(alineOption);

        },
        created(){
            this.getUsersList();
        },
        methods:{
            async getUsersList(type){
                if(type) this.queryInfo.pagenum=1
                const data=Object.assign({},this.queryInfo)
                axios.get('/api/home',{data}).then(res=>{
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
            //查看
            edit(row, index){
                //渲染折线图
                // console.log(alineOption.series);
                //获取到查看的用户信息
                this.lookid = row.id
                this.lookname = row.name
                console.log(this.lookname)

                for(let i = 0; i < 7; i++){
                    this.arr[i] = this.configlist[index].arr[i].id

                }
                console.log(this.arr)  //获得用户的模拟数据

           /* alineChart.setOption({
                 series: [{
                            data: this.arr //此处只对data数据修改即可
                        }]
            });*/


            },
        }
    }
</script>

<style lang="stylus" scoped>
     .Welcome{
        width 100%;
        height 100%;
     }

    .main{
        height: 600px;
        width: 100%;
    }
    .main h1{
        text-align: center;
        margin-bottom: 15px;
        font-size: 28px;
    } 
    #histogram{
        width: 90%;
        height: 300px;
        float: right;
    }
    #pei{
        width: 90%;
        height: 300px;
        float: right;

    }
    #aline{
        width: 100%;
        height:300px;
        float: left;
    }


    .main-left{
        width: 55%;
        float:left;
        margin-right: 20px;
        box-shadow: #ccc 0px 0px 10px;
    }
    .main-top{
        width: 43%;
        height: 51%;
        float: right;
        margin-bottom: 10px;
        box-shadow: #ccc 0px 0px 10px;

    }
    .top-title,
    .bottom-title{
        width: 10%;
        height: 100%;
        box-shadow: #ccc 0px 0px 5px;
        float:left;

    }
    .main-bottom{
        width: 43%;
        height: 51%;
        box-shadow: #ccc 0px 0px 10px;
        float: right;
    }

    .look:hover{
        color: #409eff;
    }
    .del:hover{
        color: #f56c6c;
    }
</style>