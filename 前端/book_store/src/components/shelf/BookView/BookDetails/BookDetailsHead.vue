<template>
<div >
<!--  这里是书籍详情头部信息:<br>-->
<!--  这里是书籍详情:-->

  <el-row :gutter="20">
    <el-col :span="3">
      <div class="colFill"></div>
    </el-col>
    <el-col :span="18" >
      <el-row class="bookBody">
        <!--    这是封面  给子元素设置行高会直接把父元素撑起来-->
        <el-col :span="4" class="bookCover">
        </el-col>
        <el-col :span="15" class="bookMessage">

          <el-row style="margin-top: 20px;">
            <!--      这是书名-->
            <el-col :span="12" style="font-size: 20px;color:#303133;">{{book.name}}</el-col>
            <!--        这是作者-->
            <el-col :span="12" style="color: #909399;">{{book.author}} 著</el-col>
          </el-row>
          <!--      这是书籍类型-->
          <el-col :span="4" style="color:#C0C4CC;">类型:</el-col>
          <el-col :span="20" style="color:#909399;">{{book.book_type}}</el-col>
          <el-row>
            <!--        这是书籍简介-->
            <el-col>简介：{{book.synopsis}}</el-col>
          </el-row>
          <el-row>
            <!--        出版社-->
            <el-col :span="12">出版社：{{book.publish}}</el-col>
            <!--        字数-->
            <el-col :span="12">{{book.word_length}}字</el-col>
          </el-row>

          <!--      各种按钮-->
          <el-row>
            <el-col :span="6">
              <el-button type="primary" plain>试读</el-button>
            </el-col>
            <el-col :span="6">
              <el-button type="primary" plain @click="addMyShelf">加入我的书架</el-button>
            </el-col>
            <el-col :span="6">
              <el-button type="primary" plain @click="addShoppingCart">加入购物车</el-button>
            </el-col>
            <el-col :span="6">
              <el-button type="primary" plain>找同类</el-button>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="5"></el-col>
      </el-row>
    </el-col>
    <el-col :span="3"  class="colFill">
    </el-col>
  </el-row>

</div>
</template>

<script>

import axios from "axios";

export default {
  name: "BookDetailsHead",
  methods: {
    addMyShelf(){
    //  将bookId放入axios表单中
      let axiosForm = new FormData();
      axiosForm.append('id',this.book.id);
      axiosForm.append('username',sessionStorage.getItem('username'));
    //  发送axios请求
      axios.post('/userHome/addMyShelf',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        // console.log(response.data);
        alert(response.data);
      }).catch(e=>e)
    },
    addShoppingCart(){
      //  将bookId放入axios表单中
      let axiosForm = new FormData();
      axiosForm.append('id',this.book.id);
      axiosForm.append('username',sessionStorage.getItem('username'));
      //  发送axios请求
      axios.post('/shoppingCart/addBook',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        // console.log(response.data);
        alert(response.data);
      }).catch(e=>e)
    }
  },
  props: ['book']
  /*,
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
  }*/
}
</script>

<style scoped>
  .bookBody{
    background-color: #F2F6FC;
    color: #606266;
    height: 230px;
    border-radius: 30px
  }
  .el-row{
    margin-bottom: 10px;
  }
  .colFill{
    display: inline-block;
  }

  .bookCover{
    height: 100%;
    background-image: url('../../../../assets/indexBodyMain/img2.png');
    background-size:100% 100%;
  }

  .bookMessage{
    line-height: 30px;
  }

</style>