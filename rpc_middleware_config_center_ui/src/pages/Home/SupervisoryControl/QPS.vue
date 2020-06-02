<template>
    <div class="QPS">
         <Crumbs :msg="msg" />
    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs"
    export default {  
        data(){
            return{
               msg:{
                   father:'控制中心',
                   son:'服务qps监控'
               }
            }
        },
        components:{
            Crumbs,
        }
    }
</script>

<style lang="stylus" scoped>
.QPS{
    width 100%
    height 100%
}
</style>