<template>
    <div class="Link">
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
                   son:'调用链路监控'
               }
            }
        },
        components:{
            Crumbs,
        }
    }
</script>

<style lang="stylus" scoped>
.Link{
    width 100%
    height 100%
}
</style>