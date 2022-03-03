<template>
<div>
<!--  这里是后台主体-->
  <!--  分页/滚动-->
  <backstage-body-list/>
  <backstage-body-pagination/>
</div>
</template>

<script>
import BackstageBodyList from "./BackstageBody/BackstageBodyList";
import BackstageBodyPagination from "./BackstageBody/BackstageBodyPagination";
export default {
  name: "BackstageBody",
  components: {BackstageBodyPagination,BackstageBodyList}
}
</script>

<style scoped>

</style>