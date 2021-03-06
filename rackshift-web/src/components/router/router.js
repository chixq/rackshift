import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../login/Login.vue"
import Index from "../index/Index.vue"
import Role from "../role/Role.vue"
import User from "../user/User.vue"
import BareMetal from "../bare-metal/Bare-Metal"
import Image from "../image/Image"
import Network from "../network/Network"
import SystemParameter from "../systemparameter/SystemParameter"
import ExecutionLog from "../execution-log/Execution-Log"

Vue.use(VueRouter);

const routes = [
    {path: '/', redirect: '/index'},
    {path: '/login', component: Login},
    {path: '/index', component: Index},
    {path: '/role', component: Role},
    {path: '/user', component: User},
    {path: '/bare-metal', component: BareMetal},
    {path: '/image', component: Image},
    {path: '/network', component: Network},
    {path: '/system-parameter', component: SystemParameter},
    {path: '/execution-log', component: ExecutionLog},
]
const router = new VueRouter({
    routes: routes
})
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

router.beforeEach((to, from, next) => {
    if (to.path != '/login') {
        if (localStorage.getItem('login') == "true") {
            next();
        } else {
            router.push("login");
        }
    } else {
        next();
    }
})
export default router;