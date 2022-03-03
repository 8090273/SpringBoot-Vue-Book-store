<template>
<div>
  这里是{{username}}的主页
  <el-row>
    <el-button @click="logOut">退出登录</el-button>
  </el-row>

  <el-row>
<!--    用户书架-->
    <user-home-shelf :username="username"></user-home-shelf>
  </el-row>
  <el-row>
<!--    用户订单-->
    <user-home-order-form-list :username="username"/>
  </el-row>
</div>
</template>

<script>
import UserHomeShelf from "../UserHome/UserHomeShelf";
import UserHomeOrderFormList from "../UserHome/UserHomeOrderFormList";
export default {
  name: "UserHome",
  components: {UserHomeOrderFormList, UserHomeShelf},
  data(){
    return{
      username: sessionStorage.getItem("username")
    }
  },
  methods: {
    //退出登录
    logOut(){
      this.$router.push('/');
      sessionStorage.removeItem('username');
      sessionStorage.removeItem('password');

      //将退出登录的信息返回给vuex
      this.$store.dispatch('logOut');
    }
  }
}
</script>

<style scoped>

</style>