import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import Text from '../views/html/Text.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/oneDay',
    name: 'Text',
    component: Text
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
