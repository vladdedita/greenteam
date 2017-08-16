// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Vuelidate from 'vuelidate'

Vue.use(Vuelidate);
Vue.use(BootstrapVue);

Vue.config.productionTip = false

window.ApiUrl = "http://localhost:8081";
window.ApiUrlTest = "https://jsonplaceholder.typicode.com";
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
