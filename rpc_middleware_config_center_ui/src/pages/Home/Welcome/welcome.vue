<template>
    <div class="Welcome">
    	<div class="main">
            <h2>系统性能监测图</h2>
            <!-- <div class="pic"><histogram></histogram></div> -->
            <!-- <div class="pic"><pei></pei></div> -->
            <!-- <div class="pic"><aline></aline></div> -->
        </div>
        <div class="message">
            <h3>系统简介：</h3>
            <p>{{introduction}}</p>
            <h3>用户信息：</h3>
            
            <h3>监控app应用列表</h3>
        </div>
    </div>
</template>

<script>
// import histogram from '@/components/home/HistogramChartBlock/HistogramChart'
// import aline from '@/components/home/LineChartBlock/LineChart'
// import pei from '@/components/home/PieChartBlock/PieChart'
    export default {
         data(){
            return{
                introduction:'巴拉巴拉巴拉巴拉巴拉巴拉巴拉巴拉'
            }
        },
        components: {
            // histogram,
            // aline,
            // pei
        },
    }
</script>

<style lang="stylus" scoped>
     .Welcome{
         width 100%
         height 100%
     }


     .main{
        height: 500px;
    }
    .main h2{
        text-align: center;
        margin-bottom: 15px;
    } 
    .pic{
        width: 33%;
        float: left;
    }
</style>