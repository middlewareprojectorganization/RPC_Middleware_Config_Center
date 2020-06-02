<template>
    <div class="App">
        <Crumbs :msg="msg"/>
        <appTable></appTable>

    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs";
import appTable from '@/components/object/appManagement/appManagement';

    export default {
      data(){
          return{
            msg:{
               father:'对象管理',
               son:'App应用管理'
            }  
          }
      },
      components:{
          Crumbs,
          appTable,
      }
    }
</script>

<style lang="stylus" scoped>
.App{
    width 100%
    height 100%
}
</style>