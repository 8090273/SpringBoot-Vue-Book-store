<template>
<div>
<!--  购物车的页脚-->
  <p>总价：{{totalPrice}}
    <el-button type="success" @click="$emit('openBuy')">购买</el-button>
  </p>
</div>
</template>

<script>
export default {
  name: "shoppingFooter",
  props: ['totalPrice']
}
</script>

<style scoped>

</style>