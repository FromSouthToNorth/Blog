import Vue from 'vue'
import VueRouter from "vue-router"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    component: () => import('views/homeBlog/HomeBlog')
  },
  {
    path: '/type',
    component: () => import('views/type/Type')
  },
  {
    path: '/type/:typeid',
    component: () => import('views/type/Type')
  },
  {
    path: '/tag',
    component: () => import('views/tag/Tag')
  },
  {
    path: '/tag/:tagid',
    component: () => import('views/tag/Tag')
  },
  {
    path: '/archives',
    component: () => import('views/archives/Archives')
  },
  {
    path: '/about',
    component: () => import('views/about/About')
  },
  {
    path: '/blog',
    component: () => import('views/blog/Blog')
  },
  {
    path: '/blog/:bid',
    component: () => import('views/blog/Blog')
  },
  {
    path: '/search',
    component: () => import('views/search/Search')
  },
  {
    path: '*',
    component: () => import('views/error/404')
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

router.beforeEach((to, from, next) => {
  next()
})

export default router
