<template>
<div>
<!--  这里是推荐书籍-->
  <el-row :gutter="30" v-if="books[1]">
    <el-col :span="8" >
      <div class="block">
        <el-carousel height="400px">
          <el-carousel-item v-for="item in [0,1,2,3]" :key="item">
            <h3 class="small">{{ books[item].name }}</h3>
            <h3 class="small">售价:￥{{ books[item].price }}</h3>
            <el-button @click="gotoBookDetails(books[item].id)">详情</el-button>
          </el-carousel-item>
        </el-carousel>
      </div>
    </el-col>

    <el-col :span="8">
      <div class="block">
        <el-carousel direction="vertical" height="400px">
          <el-carousel-item v-for="item in [4,5,6,7]" :key="item">
            <h3 class="small">{{ books[item].name }}</h3>
            <h3 class="small">售价:￥{{ books[item].price }}</h3>
            <el-button @click="gotoBookDetails(books[item].id)">详情</el-button>
          </el-carousel-item>
        </el-carousel>
      </div>
    </el-col>

    <el-col :span="8">
      <div class="block">
        <el-carousel height="400px ">
          <el-carousel-item v-for="item in [8,9,10,11]" :key="item">
            <h3 class="small">{{ books[item].name }}</h3>
            <h3 class="small">售价:￥{{ books[item].price }}</h3>
            <el-button @click="gotoBookDetails(books[item].id)">详情</el-button>
          </el-carousel-item>
        </el-carousel>
      </div>
    </el-col>
  </el-row>
  <el-row>
    没有喜欢的？
    <el-button @click="changeBooks">换一批</el-button>
  </el-row>


</div>
</template>

<script>
import axios from "axios";

export default {
  name: "BookRecommend",
  data(){
    return{
      books: []
    }
  },
  methods: {
    //初始化书籍，只返回10本书
    async initBooks() {
      await axios.post('/initBooks').then(response=>{
        this.books = response.data;
      }).catch(e=>console.log(e));
    },
    changeBooks(){
      axios.post('/selectRandomBook').then(response=>{
        this.books = response.data;
      }).catch(e=>console.log(e))
      alert("成功更换");
    },
    gotoBookDetails(id){
      this.$router.push({
        name: 'bookDetails',
        query: {
          id
        }
      });
    }
  },
  mounted() {
    //发送axios请求查出12个书籍
    this.initBooks();

  }
}
</script>

<style>
.el-row {
  margin-bottom: 20px;
}

.el-carousel__item h3 {
  color: #409EFF;
}

.el-carousel__item:nth-child(2n) {
  background-image: url('../../../assets/indexBodyMain/img2.png');
  background-size:100% 100%;
}

.el-carousel__item:nth-child(2n+1) {
  background-image: url('../../../assets/indexBodyMain/img1.png');
  background-size:100% 100%;
}
</style>