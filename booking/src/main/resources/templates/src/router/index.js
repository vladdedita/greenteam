import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Booking from '@/components/Booking'
import Calendar from '@/components/Calendar'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/booking',
      name: 'Booking',
      component: Booking
    },
    {
      path: '/calendar',
      name: 'Calendar',
      component: Calendar
    }
  ],
    mode: 'history'
})
