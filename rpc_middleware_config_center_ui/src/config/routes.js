import HeaderAsideLayout from '@/layouts/HeaderAsideLayout';   //首页
import NotFound from '@/pages/NotFound'; //404
import Dashboard from '@/pages/Dashboard';
import UserLogin from '@/pages/UserLoginBlock'; //登陆
import machineManagement from '@/pages/machineManagement';  
import serviceManagement from '@/pages/serviceManagement';
import dispositionManagement from '@/pages/dispositionManagement';
import Welcome from "@/pages/Welcome/welcome"

const routerConfig = [
  { path: '*', component: NotFound },
// 登录页
  {
    path: '/login',
    component: UserLogin,
    meta:{
      title:'登录页'
    },
  },
  {
    path:'/',redirect:"/login"
  },
//首页
  {
    path: '/home',
    component: HeaderAsideLayout,
    children: [
      {
        path:"/home",redirect:"/home/welcome"
      },
      { path: '/table/basic', component: NotFound },
      { path: '/table/fixed', component: NotFound },
      { path: "/home/welcome" ,component:Welcome}
    ],
  },
//侧边栏
  {
    path: '/obj-management',
    component: HeaderAsideLayout,
    children: [
      { path: '/obj-management/machine-management', component: machineManagement },
      { path: '/obj-management/service-management', component: serviceManagement },
      { path: '/obj-management/disposition-management', component: dispositionManagement },
      { path: '/obj-management/app-management', component: NotFound },
    ],
  },
  {
    path: '/contor-center',
    component: HeaderAsideLayout,
    children: [
      { path: '/contor-center/link-monitoring', component: NotFound },
      { path: '/contor-center/service-monitoring', component: NotFound },
    ],
  },
  { 
    path: '/rule-management',
    component: HeaderAsideLayout,
    children: [
      { path: '/rule-management/flow-control-rule', component: NotFound },
      { path: '/rule-management/demotion-rule', component: NotFound },
    ],
  },
];

export default routerConfig;
