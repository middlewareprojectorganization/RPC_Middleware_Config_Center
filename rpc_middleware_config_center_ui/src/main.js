import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'normalize.css/normalize.css';
import './styles/index.scss';
import App from './App.vue';
import router from './router';
import Mock from 'mockjs' ;
//登录页
import VueMaterial from 'vue-material'
import "vue-material/dist/vue-material.css";
import 'vue-material/dist/theme/default.css'
Vue.use(VueMaterial)


Vue.use(ElementUI);

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');
