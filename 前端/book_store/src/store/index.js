//这里是vuex的配置

//引入Vuex
import Vuex from "vuex";
import Vue from "vue";

//在此注册Vuex。否则报错
Vue.use(Vuex)


//准备actions，用于响应组件中的动作
const actions = {
    //参数列表为 (context,value) context上下文对象包括commit
    //当用户登录成功后改变用户登录状态
    userLoginState(context){
        //调用mutations中的改变用户登录状态的函数
        context.commit("USER_LOGIN_STATE");
    },
    adminLogin(context){
        //同上
        context.commit("ADMIN_LOGIN");
    },
    //多组件共享page页码 backstageBodyList BackstageBodyPagination
    updatePage(context,page){
        context.commit("UPDATE_PAGE",page);
    },
    logOut(cotext){
        cotext.commit("LOG_OUT");
    }
};
//准备mutations,用于操作数据
const mutations = {
    //为了和actions区分，使用全大写
    //改变登录状态为未登录
    LOG_OUT(state){
      state.showLogin = true;
      state.showBackstage = true;
      sessionStorage.removeItem('showLogin');
      sessionStorage.removeItem('showBackstage');
    },

    //改变用户登录状态为已登录
    USER_LOGIN_STATE(state){
        //将 展示登录选项改为false
        state.showLogin =false;
        //设置session为true，因为state中要取反(取反后为false)
        sessionStorage.setItem('showLogin',true);
    },
    //改变管理员登录状态为已登录
    ADMIN_LOGIN(state){
        //同上
        state.showBackstage = false;
        sessionStorage.setItem('showBackstage',true);
    },
    //将Pagination组件传来的页码同步更新到Vuex
    UPDATE_PAGE(state,page){
        //将更新后的page对象赋值给vuex的page
        state.pagination = page;
    }
}
//准备 state，用于存储数据
const state = {
    //从session中获取值才不会被刷新
    showLogin: !sessionStorage.getItem('showLogin'),
    showBackstage: !sessionStorage.getItem('showBackstage'),
    //多组件共享的页码
    pagination: {
        page: 1,
        size: 10
    }
}



//创建 暴露store
export default new Vuex.Store({
    actions,
    mutations,
    state
})
