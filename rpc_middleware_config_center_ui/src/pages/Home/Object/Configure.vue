<template>
    <div class="Configure">
         <Crumbs :msg="msg" />
         <DTable></DTable>
    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs"
  import DTable from '@/components/object/D2CrudIceBlockSimple/D2Crud'

    export default {  
        data(){
            return{
               msg:{
                   father:'对象管理',
                   son:'配置管理'
               }
            }
        },
        components:{
            Crumbs,
            DTable,
        }
    }
</script>

<style lang="stylus" scoped>
.Configure{
    width 100%
    height 100%
}
</style>