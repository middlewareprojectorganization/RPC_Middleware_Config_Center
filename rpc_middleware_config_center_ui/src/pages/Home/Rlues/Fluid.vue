<template>
    <div class="Fluid">
         <Crumbs :msg="msg" />
        <appTable></appTable>
    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs"
import appTable from '@/components/rule/controlRule/controlRule'

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
            appTable,
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