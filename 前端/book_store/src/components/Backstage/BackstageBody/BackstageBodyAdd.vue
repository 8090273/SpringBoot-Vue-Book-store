<template>
<div >
<!--  这里是添加书籍组件-->
  <el-form label-position="right" label-width="100px" ref="addBookForm" :model="book" class="addForm">
   <h2>请填写具体内容</h2>

    <el-form-item label="书名">
      <el-input v-model="book.name" placeholder="书名" clearable></el-input>
    </el-form-item>
    <el-form-item label="作者">
      <el-input v-model="book.author" placeholder="作者" clearable></el-input>
    </el-form-item>
    <el-form-item label="价格">
      <el-input v-model="book.price" placeholder="价格" clearable></el-input>
    </el-form-item>
    <el-form-item label="销量">
      <el-input v-model="book.sales" placeholder="销量" clearable></el-input>
    </el-form-item>
    <el-form-item label="库存">
      <el-input v-model="book.stock" placeholder="库存" clearable></el-input>
    </el-form-item>
    <el-form-item label="封面地址">
      <el-input v-model="book.img_path" placeholder="封面地址" clearable></el-input>
    </el-form-item>


    <el-form-item label="简介">
      <el-input v-model="book.synopsis" placeholder="简介" clearable></el-input>
    </el-form-item>
    <el-form-item label="出版社">
      <el-input v-model="book.publish" placeholder="出版社" clearable></el-input>
    </el-form-item>
    <el-form-item label="试看内容">
      <el-input v-model="book.preview" placeholder="试看内容" clearable></el-input>
    </el-form-item>
    <el-form-item label="字数">
      <el-input v-model="book.word_length" placeholder="字数" clearable></el-input>
    </el-form-item>
    <el-form-item label="书籍类型">
      <el-input v-model="book.book_type" placeholder="书籍类型" clearable></el-input>
    </el-form-item>

    <el-button style="float: right" type="success" @click="overAdd">添加</el-button>
  </el-form>

</div>
</template>

<script>
import axios from "axios";

export default {
  name: "BackstageBodyAdd",
  data(){
    return{
      book:{
        name: '',
        price: null,
        author: '',
        //销量
        sales: null,
        //库存
        stock: null,
        img_path: 'img/img.jpg',

        //简介
        synopsis:'',
        //出版社
        publish: '',
        //试看内容
        preview:'',
        //字数
        word_length: '',
        //  书籍类型
        book_type:''
      }

    }
  },
  methods: {
    async overAdd(){
      //先发送t_book表的数据
      let axiosForm1 = new FormData();
      axiosForm1.append('name',this.book.name);
      axiosForm1.append('author',this.book.author);
      axiosForm1.append('price',this.book.price);
      axiosForm1.append('sales',this.book.sales);
      axiosForm1.append('stock',this.book.stock);
      axiosForm1.append('imgPath',this.book.img_path);
      await axios.post('/backstage/addBook',axiosForm1,{
        header: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        alert(response.data);
      }).catch(e=>e);

      let axiosForm2 = new FormData();
      axiosForm2.append('synopsis',this.book.synopsis);
      axiosForm2.append('publish',this.book.publish);
      axiosForm2.append('preview',this.book.preview);
      axiosForm2.append('wordLength',this.book.word_length);
      axiosForm2.append('bookType',this.book.book_type);

      await axios.post('/backstage/addBookDetails',axiosForm2,{
        header: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        alert(response.data);
      }).catch(e=>e);


      this.$router.push('/backstage/backstageBody')
    }
  }
}
</script>

<style scoped>
.addForm{
  background-color: #F2F6FC;
}
</style>