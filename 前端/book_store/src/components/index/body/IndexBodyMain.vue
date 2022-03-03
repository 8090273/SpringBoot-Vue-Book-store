<template>
<div>
  <el-row :gutter="20">
    <el-col :span="8">
<!--      卡片组件-->
      <index-body-main-card/>
    </el-col>
    <el-col :span="16">
<!--      信息组件-->
      <index-body-main-message/>
    </el-col>
  </el-row>

</div>
</template>

<script>
import IndexBodyMainMessage from "./Main/IndexBodyMainMessage";
import IndexBodyMainCard from "./Main/IndexBodyMainCard";
export default {
  name: "IndexBodyMain",
  components: {IndexBodyMainCard, IndexBodyMainMessage}
}
</script>

<style scoped>

/*.time {
  font-size: 13px;
  color: #999;
}
.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  max-width: 100%;
  height: 460px;
  overflow: hidden;
}*/

</style>