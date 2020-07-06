import Vue from 'vue'
import Router from 'vue-router'
import p2000207 from '@/components/2000207'
import p2000002 from '@/components/2000002'
import p2000006 from '@/components/2000006'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'p2000002',
      component: p2000002
    },
    {
      path: '/p2000002',
      name: 'p2000002',
      component: p2000002
    },
    {
      path: '/p2000006',
      name: 'p2000006',
      component: p2000006
    },
    {
      path: '/p2000207',
      name: 'p2000207',
      component: p2000207
    }
  ]
})
