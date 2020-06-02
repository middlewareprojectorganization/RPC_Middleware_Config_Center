<template>
    <div class="App">
        <Crumbs :msg="msg"/>
    </div>
</template>

<script>
import Crumbs from "@/components/Crumbs/Crumbs"
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
      }
    }
</script>

<style lang="stylus" scoped>
.App{
    width 100%
    height 100%
}
</style>