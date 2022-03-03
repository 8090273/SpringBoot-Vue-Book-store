<template>
<div>
  这里是书籍详情之作品信息
  <el-row>
    售价：{{book.price}}
  </el-row>

  <el-row>
    销量: {{book.sales}}
  </el-row>
  <el-row>
    库存： {{book.stock}}
  </el-row>

  <el-row>
    预览：{{book.preview}}
  </el-row>
</div>
</template>

<script>
export default {
  name: "BookDetailsBodyBookMessage",
  props: ['book']
}
</script>

<style scoped>

</style>