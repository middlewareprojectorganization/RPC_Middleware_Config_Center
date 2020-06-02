<template>
    <div class="Lower">
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
                   son:'降级规则'
               }
            }
        },
        components:{
            Crumbs,
        }
    }
</script>
<style lang="stylus" scoped>
.Lower{
    width 100%
    height 100%
}
</style>