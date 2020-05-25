// 菜单配置
// headerMenuConfig：头部导航配置
// asideMenuConfig：侧边导航配置

const headerMenuConfig = [];

const asideMenuConfig = [
  {
    path: '/obj-management',
    name: '对象管理',
    icon: 'el-icon-menu',
    children: [
      {
        path: '/machine-management',
        name: '机器管理',
      },
      {
        path: '/service-management',
        name: '服务管理',
      },
      {
        path: '/disposition-management',
        name: '配置管理',
      },
    ],
  },

  {
    path: '/contor-center',
    name: '控制中心',
    icon: 'el-icon-date',
    children: [
      {
        path: '/link-monitoring',
        name: '调用链路监控',
      },
      {
        path: '/service-monitoring',
        name: '服务qps监控',
      },
    ],
  },

  {
    path: '/rule-management',
    name: '规则管理',
    icon: 'el-icon-edit-outline',
    children: [
      {
        path: '/flow-control-rule',
        name: '流控规则',
      },
      {
        path: '/demotion-rule',
        name: '降级规则',
      },
    ],
  },
];

export { headerMenuConfig, asideMenuConfig };
