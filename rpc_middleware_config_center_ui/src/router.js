import Vue from 'vue';
import Router from 'vue-router';
import routerConfig from '@/config/routes';
// import index from '@/pages/index.html';


Vue.use(Router);

export default new Router({
  routes: routerConfig,
  // routes:[
  // 	{
  // 		path:'/',
  // 		name:'index',
  // 		component:index
  // 	}
  // ]
});
