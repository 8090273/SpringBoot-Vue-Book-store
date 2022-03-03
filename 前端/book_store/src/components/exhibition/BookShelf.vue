<template>
<div>
<!--  这里是书架-->
  <el-row>
      <select-book></select-book>
  </el-row>
  <el-row>
      <book-view></book-view>
  </el-row>


</div>
</template>

<script>
import BookView from "../shelf/BookView";
import SelectBook from "../shelf/SelectBook";
export default {
  name: "BookShelf",
  components: {SelectBook, BookView}
}
</script>

<style scoped>
div{
  color: #fff;
}

.el-row {
  margin-bottom: 10px;
}
</style>