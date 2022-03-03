<template>
<div class="pagination">
<!--  这里是分页栏-->
<!--  layout属性的顺序对应组件顺序-->
  <el-pagination

      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.page"
      :page-sizes="[10, 20, 30, 40]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="bookCount">
  </el-pagination>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "BackstageBodyPagination",
  methods: {
    //改变当前每页条数时执行 val是每页条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.$store.dispatch('updatePage',this.pagination);
    },
    //改变当前页码时执行 val是当前页码
    handleCurrentChange(val) {
      this.pagination.page = val;
      this.$store.dispatch('updatePage',this.pagination);
    },
    //查询有几本书
    selectBookCount(){
      axios.post('/backstage/selectCount').then(response=>{
        this.bookCount = response.data;
      })
    }
  },
  data() {
    return {
      pagination: this.$store.state.pagination,
      bookCount: null
    };
  },
  mounted() {
    this.selectBookCount();
  }
}
</script>

<style >
.el-pagination__total,.el-pagination__jump{
  color: #fff;
}
</style>