<template>
    <div class="Lower">
         <Crumbs :msg="msg" />
        <demoTable></demoTable>
    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs"
import demoTable from '@/components/rule/demotionRule/demotionRule'

    export default {  
        data(){
            return{
               msg:{
                   father:'规则管理',
                   son:'降级规则'
               }
            }
        },
        components:{
            Crumbs,
            demoTable,
        }
    }
</script>
<style lang="stylus" scoped>
.Lower{
    width 100%
    height 100%
}
</style>