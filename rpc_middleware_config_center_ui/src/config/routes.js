import HeaderAsideLayout from '@/layouts/HeaderAsideLayout';   //首页
import NotFound from '@/pages/NotFound'; //404
import Dashboard from '@/pages/Dashboard';

import UserLogin from '@/pages/UserLoginBlock'; //登陆






const routerConfig = [
  { path: '*', component: NotFound },
// 登录页
  {
    path: '/',
    component: UserLogin,
  },
//首页
  {
    path: '/home',
    component: HeaderAsideLayout,
    children: [
      { path: '/table/basic', component: NotFound },
      { path: '/table/fixed', component: NotFound },
    ],
  },
//侧边栏
  {
    path: '/obj-management',
    component: HeaderAsideLayout,
    children: [
      { path: '/obj-management/machine-management', component: NotFound },
      { path: '/obj-management/service-management', component: NotFound },
      { path: '/obj-management/disposition-management', component: NotFound },
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
