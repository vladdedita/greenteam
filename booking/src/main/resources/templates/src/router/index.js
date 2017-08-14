import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Booking from '@/components/Booking'
import Calendar from '@/components/Calendar'
import LogIn from '@/components/LogIn'
import Dashboard from '@/components/Dashboard'
import AddServ from '@/components/AddServ'
import Companies from '@/components/Companies'
import Recover from '@/components/Recover'
import Profile from '@/components/Profile'
import Confirmation from '@/components/Confirmation'



Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
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
    },
    {
      path: '/recover',
      name: 'Recover',
      component: Recover
    },{
      path: '/profile',
      name: 'Profile',
      component: Profile
    },{
      path: '/confirmation',
      name: 'Confirmation',
      component: Confirmation
    }
  ],
    mode: 'history'
})
