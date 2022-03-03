<template>
<div>
<!--  这里是用户的各个订单-->
  <p>id:{{orderForm.id}}</p>
  <p>日期: {{orderForm.date}}</p>
</div>
</template>

<script>
export default {
  name: "UserHomeOrderForm",
  props: ['orderForm']
}
</script>

<style scoped>

</style>