// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from "axios"
import ElementUI from 'element-ui';
import VeLine from 'v-charts/lib/line.common'
import { Form, FormItem ,Input,Message} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.prototype.$http = axios
Vue.prototype.$Message=Message
Vue.use(ElementUI)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.component(VeLine.name, VeLine)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
