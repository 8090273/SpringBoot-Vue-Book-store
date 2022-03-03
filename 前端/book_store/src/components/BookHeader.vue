<template>
<div>
<!--  这是总页首-->
  <el-row>
    <el-col :span="23">书轩阁<div class="grid-content bg-purple"></div></el-col>
    <el-col :span="1">
      <div class="grid-content bg-purple-light">
        <el-avatar size="small" :src="circleUrl" fit="fill"></el-avatar>
      </div></el-col>
  </el-row>

</div>
</template>

<script>
export default {
  name: "BookHeader",
  data () {
    return {
      circleUrl: require("../assets/userHanderPhoto/img.png")
    }
  }
}
</script>

<style scoped>
.el-avatar{
  float: right;
}

</style>