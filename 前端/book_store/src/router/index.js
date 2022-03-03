//该文件专门用于整个项目的路由器
import VueRouter from "vue-router";
import { Message } from "element-ui";
import BookShelf from "../components/exhibition/BookShelf";
import IndexPage from "../components/exhibition/IndexPage";
import Login from "../components/exhibition/Login";
import Register from "../components/exhibition/Register";
import Shopping from "../components/exhibition/Shopping";
import Backstage from "../components/exhibition/Backstage";
import UserHome from "../components/exhibition/UserHome";
import BookRecommend from "../components/shelf/BookView/BookRecommend";
import BookDetails from "../components/shelf/BookView/BookDetails";
import BookBuy from "../components/shelf/BookView/BookBuy";
import BackstageBodyList from "../components/Backstage/BackstageBody/BackstageBodyList";
import BackstageBody from "../components/Backstage/BackstageBody";
import BackstageBodyAdd from "../components/Backstage/BackstageBody/BackstageBodyAdd";
//必须引入要参与路由的组件

//创建一个路由
const router = new VueRouter({
    //mode值['hash','history'] hash带井号#井号后的内容不会请求到服务端 history不带
    mode: 'hash',
    routes:[
        {
            //首页的路由
            path: '/',
            component: IndexPage
        },
        {
            //测试页的路由
            path: '/test'
        },
        {
            //登录的路由
            name: 'Login',
            path: '/Login',
            component: Login
        },
        {
            //个人中心的路由
            name: 'userHome',
            path: '/userHome',
            component: UserHome
        },
        {
            //注册的路由
            name: 'register',
            path: '/register',
            component: Register
        },
        {
            //书架的路由
            name: 'shelf',
            path: '/shelf',
            component: BookShelf,
            children: [
                {
                    //书籍推荐的路由
                    name: 'bookRecommend',
                    path: 'bookRecommend',
                    component: BookRecommend
                },
                {
                    //书籍详情页的路由
                    name: 'bookDetails',
                    path: 'bookDetails',
                    component: BookDetails
                },
                {
                    //书籍购买页的路由
                    name: 'bookBuy',
                    path: 'bookBuy',
                    component: BookBuy
                }

            ]
        },
        {
            //购物车的路由
            name: 'shopping',
            path: '/shopping',
            component: Shopping
        },
        {
            //后台管理的路由
            name: 'backstage',
            path: '/backstage',
            component: Backstage,
            children:[
                {
                    //书籍列表的 路由
                    name: 'backstageBody',
                    path: 'backstageBody',
                    component: BackstageBody
                },
                {
                    //书籍添加的路由
                    name: 'backstageBodyAdd',
                    path:'backstageBodyAdd',
                    component: BackstageBodyAdd
                }
            ]
        }

    ]
})

//全局前置路由守卫  在路由跳转之前执行回调（初始化的时候调用）
router.beforeEach((to,from,next)=>{
    //在这里配置拦截功能
    //首页和登录注册页不拦截
    if (to.path === '/' || to.path === '/Login' || to.path === '/register')
    {
        next();
    }else {
        //登录后可以去普通页面
        if(sessionStorage.getItem('username')!== null){
            if (sessionStorage.getItem('username') === 'admin'){
                next();
            }else if (to.path === '/backstage'){
                Message.error("您没有权限！！");
                next('/');
            }else {
                next();
            }
        }else {
            //未登录则跳转到登录页
            // alert("请先登录");
            Message.error("请先登录")
            next('/Login')
        }

    }
})

//后置路由守卫    在路由跳转后执行回调（初始化时也调用）
router.afterEach(()=>{
})

export default router;