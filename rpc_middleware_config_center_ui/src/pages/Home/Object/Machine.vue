<template>
    <div class="Machine">
        <!-- <Crumbs :msg="msg" /> -->
        <BasicTable></BasicTable>
        
    </div>
</template>

<script>
// import Crumbs from "@/components/Crumbs/Crumbs"
  import BasicTable from '@/components/object/BasicTableBlock/BasicTable'

    export default {  
        data(){
            return{
               msg:{
                   father:'对象管理',
                   son:'机器管理'
               }
            }
        },
        components:{
            // Crumbs,
            BasicTable

        }
    }
</script>

<style lang="stylus" scoped>
   .Machine{
       width 100%
       height 100%
   }
</style>