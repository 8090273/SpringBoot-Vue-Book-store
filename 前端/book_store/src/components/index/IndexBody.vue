<template>
<div>
  <!--  这里是首页的主体-->
  <div class = 'indexBody'>
    Welcome
  </div>
<!--  点击跳到页面底部-->
  <div class="down" @click="down">
    <div class="bigIcon">
      <i class="el-icon-arrow-down"></i>
    </div>
    <div class="midIcon">
      <i class="el-icon-arrow-down"></i>
    </div>
    <div class="smallIcon">
      <i class="el-icon-arrow-down"></i>
    </div>
  </div>
  <index-body-main/>
<!--  跳转坐标-->
  <div id="bottom"></div>
</div>
</template>

<script>
import IndexBodyMain from "./body/IndexBodyMain";
export default {
  name: "IndexBody",
  components: {IndexBodyMain},
  methods: {
    //跳转到指定坐标
    down() {
      this.$nextTick(() => {
        var container = this.$el.querySelector("#bottom");
        container.scrollIntoView();
      });
    }
  }
}
</script>

<style scoped>
  .indexBody{
    margin-top: 40px;
    font-size: 50px;
    text-align: center;
    color: #fff;
  }
  /*设置向下箭头为居中*/
  .down{
    width: 7%;
    margin: 0 auto;
  }

  .el-icon-arrow-down{
    color: white;
    display: block;
    text-align: center;
  }

  /*定义向下图标的尺寸*/
  .bigIcon {
    font-size: 45px;
  }
  .midIcon {
    font-size: 30px;
  }
  .smallIcon {
    font-size: 20px;
  }

/*  定义向下的内容*/
  .down{
    height: 300px;
  }
</style>