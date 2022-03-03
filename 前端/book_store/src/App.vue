<template>
  <div id="app">

<!--    使用饿了么布局容器-->
    <el-container>
      <el-aside style="width: 13.1%;">
<!--        这里放导航栏-->
        <Navigation></Navigation>
      </el-aside>
      <el-container>
        <el-header height="30px">
<!--          这里放头部组件-->
          <BookHeader></BookHeader>

        </el-header>
        <el-main>
<!--          这里放主内容-->
          <el-scrollbar style="height: 100%;" wrapStyle="overflow-x:hidden;">

            <router-view></router-view>
          </el-scrollbar>

        </el-main>
        <el-footer height="40px">
<!--          这里放页脚-->
          <BookFooter></BookFooter>
        </el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>

import Navigation from "./components/Navigation";
import BookHeader from "./components/BookHeader";
import BookFooter from "./components/BookFooter";
export default {
  name: 'App',
  components: {BookFooter, BookHeader, Navigation}
}
</script>

<style scoped>

.el-header{
  height: 30px;
  background-color:#909399;
  color: #fff;
  text-align: center;
  line-height: 30px;

}
.el-footer {
  background-color: #303133;
}
.el-aside{
  background-color: #545c64;
 margin: 0px 1px 0px 0px;
}

 .el-container{
  /*margin-bottom: 40px;*/
  height: 705px;
}

 .el-main{
   background-color: #606266;
   padding: 10px;
 }

</style>
