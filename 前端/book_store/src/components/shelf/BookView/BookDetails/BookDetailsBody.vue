<template>
<div>
  <el-row :gutter="20">
    <el-col :span="3">
      <div class="colFill"></div>
    </el-col>
    <el-col :span="18">
      <!--  这里是书籍详情主体  点击事件使用：@tab-click="handleClick-->
      <el-tabs v-model="activeName">
        <el-tab-pane label="作品信息" name="bookMessage">
          <book-details-body-book-message :book="book"/>
        </el-tab-pane>
        <el-tab-pane label="作者信息" name="authorMessage">
          <book-details-author-message :authorName="book.author"/>
        </el-tab-pane>
      </el-tabs>
    </el-col>
    <el-col :span="3"></el-col>
  </el-row>

</div>
</template>

<script>
import BookDetailsBodyBookMessage from "./BookDetailsBody/BookDetailsBodyBookMessage";
import BookDetailsAuthorMessage from "./BookDetailsBody/BookDetailsAuthorMessage";
export default {
  name: "BookDetailsBody",
  data() {
    return {
      activeName: 'bookMessage'
    };
  },
  components: {BookDetailsAuthorMessage, BookDetailsBodyBookMessage},
  props: ['book']
}
</script>

<style>
.el-tabs__item {
  color: #F2F6FC;
}

.colFill{
  display: inline-block;
}
</style>