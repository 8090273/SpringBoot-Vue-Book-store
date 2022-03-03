<template>
<div>
<!--  这里是购物车主体-->

  <el-row>
    <el-col :span="4">
      <img src="../../assets/indexBodyMain/img1.png" style="width: 100%;">
    </el-col>
    <el-col :span="6" class="bookDetails">
      <el-row>
        {{book.author}} 著
      </el-row>
      <el-row v-if="bookDetail">
        简介：{{bookDetail.synopsis}}
      </el-row>
      <el-row v-if="bookDetail">
        出版社：{{bookDetail.publish}}
      </el-row>
      <el-row v-if="bookDetail">
        字数：{{bookDetail.word_length}}
      </el-row>
    </el-col>


    <el-col :span="14">
      <el-row class="totalPrice">
        总价：￥{{book.price * num}}
      </el-row>
      <el-row>
        <el-button style="float: right" type="danger" @click="$emit('deleteBook',book.id)">删除</el-button>
        <el-button style="float: right" type="success" @click="$emit('openBuy',[book])" >购买</el-button>
        <el-input-number style="float: right;" v-model="num" :min="1" :max="100" label="购买数量" @change="changeNum"></el-input-number>

      </el-row>
    </el-col>

  </el-row>
<!--  分割线-->
  <el-divider></el-divider>



</div>
</template>

<script>
import axios from "axios";

export default {
  name: "shoppingBody",
  data(){
    return{
      bookDetail: null,
      num: 1
    }
  },
  methods: {
    selectBookDetails(){
      let axiosForm = new FormData();
      axiosForm.set('id',this.book.id);
      axios.post('/selectBookDetails',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.bookDetail = response.data;
      })
    },
    changeNum(){
      this.$emit('updateBookNum',this.book,this.num)
    }
  },
  mounted() {
    this.selectBookDetails();
    this.changeNum();
  },
  props: ['book']
}
</script>

<style scoped>
.el-button{
  margin-left: 10px;
}
.bookDetails{
  font-size: 10px;
  color: #909399;
}
.totalPrice{
  margin-right: 20px;
  text-align: right;
  font-size: 20px;
  color: #F56C6C;
}
</style>