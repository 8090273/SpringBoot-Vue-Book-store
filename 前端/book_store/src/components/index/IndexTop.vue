<template>
<div>
<!--  这里是首页的头部-->
  <el-carousel indicator-position="outside" type="card" height="200px">
    <el-carousel-item v-for="item in 4" :key="item">
        <img :src="imgPath(item)">
    </el-carousel-item>
  </el-carousel>
</div>
</template>

<script>
export default {
  name: "IndexTop",
  methods: {
    imgPath(index){
      return require("../../assets/indexTop/img" + index +".png")
    }
  }
}
</script>

<style scoped>

  img{
    width: 100%;
    height: 100%;
  }


</style>