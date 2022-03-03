import Vue from 'vue'
import App from './App.vue'

//引入饿了么UI API
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//引入路由API
import VueRouter from "vue-router";


//引入自定义路由器
import router from "./router";
//引入store(Vuex)
import store from "./store";


//关闭浏览器提醒
Vue.config.productionTip = false

//注册全局API
Vue.use(VueRouter)
Vue.use(ElementUI)

new Vue({
  render: h => h(App),
  //编写路由配置项(简写)
  router,
  //编写vuex的配置项store
  store,
  //配置事件总线
  beforeCreate() {
    Vue.prototype.$bus = this
  }
}).$mount('#app')
