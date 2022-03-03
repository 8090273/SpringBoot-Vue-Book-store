<template>
<div>
<!--  这里是首页-->

    <index-top></index-top>
    <index-body></index-body>

</div>
</template>

<script>
import IndexTop from "../index/IndexTop";
import IndexBody from "../index/IndexBody";
export default {
  name: "IndexPage",
  components: {IndexBody, IndexTop}
}
</script>

<style scoped>
/*.el-scrollbar__wrap {
  overflow-x: hidden;
}*/
</style>