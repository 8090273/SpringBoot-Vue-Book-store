<template>
<div>
  这里是用户书架
  <el-row :gutter="20">
    <el-col :span="4" v-for="book in books" :key="book.id">
      <user-home-shelf-book :book="book" @deleteBook="deleteBook"/>
    </el-col>
  </el-row>
</div>
</template>

<script>
import UserHomeShelfBook from "./UserHomeShelf/UserHomeShelfBook";
import axios from "axios";
export default {
  name: "UserHomeShelf",
  data(){
    return{
      books: []
    }
  },
  methods: {
    selectBookByUser(){
      //将username放入axiosForm
      let axiosForm = new FormData();
      axiosForm.append('username',this.username);
      axios.post("/userHome/selectBook",axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.books = response.data
      })
    },

    deleteBook(id){
      //将id装入表单
      let axiosForm = new FormData();
      axiosForm.append('username',sessionStorage.getItem('username'));
      axiosForm.append('id',id);

      axios.post('/userHome/deleteMyShelf',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        alert(response.data);
        this.selectBookByUser();
      }).catch(e=>e);
    }
  },
  mounted() {
    this.selectBookByUser()
  },
  components: {UserHomeShelfBook},
  props: ['username']
}
</script>

<style scoped>

</style>