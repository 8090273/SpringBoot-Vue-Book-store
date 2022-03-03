<template>
<div>
<!--  这是总导航栏-->
  <el-col :span="12">
<!--    default-active为默认选择1
 背景颜色必须在标签内指定-->
    <el-menu
        default-active="1"
        class="el-menu-vertical-demo"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
      <el-menu-item index="1" @click="$router.push('/').catch(e=>e)">
        <i class="el-icon-s-home"></i>
        <span slot="title">首页</span>
      </el-menu-item>
<!--      未登录显示登录按钮-->
      <el-menu-item v-show="$store.state.showLogin" index="2" @click="$router.push('/Login').catch(e=>e)">
        <i class="el-icon-s-custom"></i>
        <span slot="title">登录</span>
      </el-menu-item>
<!--      登录后改为个人中心-->
      <el-menu-item v-show="!$store.state.showLogin" index="2" @click="$router.push('/userHome').catch(e=>e)">
        <i class="el-icon-menu"></i>
        <span slot="title">个人中心</span>
      </el-menu-item>

      <el-menu-item index="3" @click="$router.push('/register').catch(e=>e)">
        <i class="el-icon-user"></i>
        <span slot="title">注册</span>
      </el-menu-item>
<!--      点击书架自动路由到书架组件-->
      <el-menu-item index="4" @click="$router.push('/shelf/bookRecommend').catch(e=>e)">
        <i class="el-icon-s-goods"></i>
        <span slot="title" >书架</span>
      </el-menu-item>
      <el-menu-item index="5" @click="$router.push('/shopping').catch(e=>e)">
        <i class="el-icon-shopping-cart-full"></i>
        <span slot="title">购物车</span>
      </el-menu-item>
      <el-menu-item index="6" @click="$router.push('/backstage').catch(e=>e)" :disabled = "$store.state.showBackstage" >
        <i class="el-icon-setting"></i>
        <span slot="title">后台管理</span>
      </el-menu-item>
    </el-menu>
  </el-col>
</div>
</template>

<script>
export default {
  name: "Navigation",
/*  data(){
    return{
      showLogin: !sessionStorage.getItem('showLogin'),
      showBackstage: !sessionStorage.getItem('showBackstage')
    }
  },*/
//  这里是使用事件总线的方法
/*  mounted() {
    //使用事件总线改变用户登录状态
    this.$bus.$on('userLoginState',()=>{
      this.showLogin = false;
      sessionStorage.setItem('showLogin',true);
    })

    this.$bus.$on('adminLogin',()=>{
      this.showBackstage = false;
      sessionStorage.setItem('showBackstage',true);
    })
  },
  beforeDestroy() {
    //销毁组件前解绑总线事件
    this.$bus.$off('userLoginState');
    this.$bus.$off('adminLogin');
  }*/
}
</script>

<style scoped>
.el-menu{
  width: 195px;
  /*把导航ul的白边去掉*/
  border: 0px;
          }
</style>