import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/pages/Login/Login'
import Home from '@/pages/Home/Home'
import App from '@/pages/Home/Object/App'
import Machine from "@/pages/Home/Object/Machine"
import Serve from "@/pages/Home/Object/Serve"
import Configure from "@/pages/Home/Object/Configure"
import QPS from "@/pages/Home/SupervisoryControl/QPS"
import Link from "@/pages/Home/SupervisoryControl/Link"
import Fluid from "@/pages/Home/Rlues/Fluid"
import Lower from "@/pages/Home/Rlues/Lower"
Vue.use(Router)

export default new Router({
  routes: [
    {
      path:"/",redirect:"/login"
    },
    {
      path:"/login",component:Login
    },
    {
      path:"/home",component:Home,children:[{
        path:'app',component:App
      },{
        path:'machine',component:Machine
      },{
        path:'serve',component:Serve
      },{
        path:'configure',component:Configure
      },{
        path:'qps',component:QPS
      },{
        path:'link',component:Link
      },{
        path:'fluid',component:Fluid
      },{
        path:'lower',component:Lower
      }]
    }
  ]
})
