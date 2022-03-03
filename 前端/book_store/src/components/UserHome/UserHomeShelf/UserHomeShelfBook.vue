<template>
<div>
<!--  这里是书架里的书-->
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <div class="text">{{book.name}}</div>
      <el-button style="float: left; padding: 3px 0" type="text" class="text" @click="bookDetails">查看详情</el-button>
      <el-button style="float: right; padding: 3px 0" type="text" class="text" @click="$emit('deleteBook',book.id)" >移除</el-button>
    </div>
    <div>
<!--      这里放书籍主体信息-->
      <img src="../../../assets/indexBodyMain/img2.png">
    </div>
  </el-card>
</div>
</template>

<script>

export default {
  name: "UserHomeShelfBook",
  methods: {
    bookDetails(){
      this.$router.push({
        name: 'bookDetails',
        query: {
          id: this.book.id
        }
      })
    }
  },
  props: ['book']
}
</script>

<style scoped>
.text {
  font-size: 2px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 100%;
}

img{
  width: 100%;
}
</style>