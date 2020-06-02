<template>
    <div class="Fluid">
         <Crumbs :msg="msg" />
    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs"
    export default {  
        data(){
            return{
               msg:{
                   father:'规则管理',
                   son:'流控规则'
               }
            }
        },
        components:{
            Crumbs,
        }
    }
</script>

<style lang="stylus" scoped>
.Fluid{
    width 100%
    height 100%
}
</style>