import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Booking from '@/components/Booking'
import Calendar from '@/components/Calendar'
import LogIn from '@/components/LogIn'
import Dashboard from '@/components/Dashboard'
import AddServ from '@/components/AddServ'
import Companies from '@/components/Companies'



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
    },
     {
      path: '/logIn',
      name: 'LogIn',
      component: LogIn
    },{
      path: '/dashboard',
        name: 'Dashboard',
        component: Dashboard 
    },{
      path: '/addServ',
        name: 'AddServ',
        component: AddServ 
    },{
      path: '/companies',
        name: 'Companies',
        component: Companies 
    }
  ],
    mode: 'history'
})
