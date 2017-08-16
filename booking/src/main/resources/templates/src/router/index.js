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
import Home from '@/components/Home'




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
      path: '/home',
      name: 'Home',
      component: Home
    }
  ],
    mode: 'history'
})
