import Vue from 'vue'
import Router from 'vue-router'
import Register from '@/components/Register'
import Booking from '@/components/Booking'
import Calendar from '@/components/Calendar'
import LogIn from '@/components/LogIn'
import Dashboard from '@/components/Dashboard'
import AddServ from '@/components/AddServ'
import Company from '@/components/Company'
import Recover from '@/components/Recover'
import Profile from '@/components/Profile'
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
      path: '/logIn',
      name: 'LogIn',
      component: LogIn
    },
    {
      path: '/recover',
      name: 'Recover',
      component: Recover
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard
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
      path: '/profile',
      name: 'Profile',
      component: Profile
    },
    {
      path: '/addServ',
      name: 'AddServ',
      component: AddServ
    },
    {
      path: '/',
      name: 'Companies',
      component: Companies
    },
    {
      path: '/company',
      name: 'Company',
      component: Company
    }
  ],
  mode: 'history'
})