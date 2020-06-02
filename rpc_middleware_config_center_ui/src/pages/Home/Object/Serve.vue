<template>
    <div class="Serve">
         <Crumbs :msg="msg" />
    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs"
    export default {  
        data(){
            return{
               msg:{
                   father:'对象管理',
                   son:'服务管理'
               }
            }
        },
        components:{
            Crumbs,
        }
    }
</script>

<style lang="stylus" scoped>
.Serve{
    width 100%
    height 100%
}
</style>