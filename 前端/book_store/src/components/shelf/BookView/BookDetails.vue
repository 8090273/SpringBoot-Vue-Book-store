<template>
<div v-if="updataComponent">
  <book-details-head :book="book"/>
  <book-details-body :book="book"/>

</div>
</template>

<script>
import BookDetailsHead from "./BookDetails/BookDetailsHead";
import BookDetailsBody from "./BookDetails/BookDetailsBody";
import axios from "axios";

export default {
  name: "BookDetails",
  data(){
    return{
      book: null
    }
  },
  methods: {
    selectBookDetails(){
      let axiosForm = new FormData();
      axiosForm.set('id',this.$route.query.id);
      axios.post('/selectBookDetails',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.book = response.data;
      })
    }

  },
  computed: {
    updataComponent(){
      if (this.book == null)
        return false;
      if (this.book.id !== this.$route.query.id)
      {
        this.selectBookDetails();
      }
      return true;
    }
  },
  //组件挂载完成后初始化书籍详情
  mounted() {
    this.selectBookDetails();
  },
  components: {BookDetailsBody, BookDetailsHead}
}
</script>

<style scoped>

</style>