import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import zhuce from '@/components/zhuce'
import login from '@/components/login'
import Bottom from '@/components/Bottom'
import kinds from '@/components/kinds'
import goods from '@/components/goods'
import kindsof from '@/components/kindsof'
import select from '@/components/select'
import car from '@/components/car'
import test from '@/components/test'
import kindsImg from '@/components/kindsimg'
import banner from '@/components/banner'
Vue.use(Router)
const routerPush = Router.prototype.push
Router.prototype.push = function push (location) {
  return routerPush.call(this, location).catch(error => error)
}

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/zhuce',
      name: 'zhuce',
      component: zhuce
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/Bottom',
      name: 'Bottom',
      component: Bottom
    },
    {
      path: '/kinds',
      name: 'kinds',
      component: kinds
    },
    {
      path: '/goods',
      name: 'goods',
      component: goods
    },
    {
      path: '/kindsof',
      name: 'kindsof',
      component: kindsof
    },
    {
      path: '/select',
      name: 'select',
      component: select
    },
    {
      path: '/car',
      name: 'car',
      component: car
    },
    {
      path: '/test',
      name: 'test',
      component: test
    },
    {
      path: '/kindsImg',
      name: 'KindsImg',
      component: kindsImg
    },
    {
      path: '/banner',
      name: 'banner',
      component: banner
    }
  ]
})
