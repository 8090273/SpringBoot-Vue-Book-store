<template>
<div>
<!--  这里是购物车-->
  <el-container>
<!--    <el-header>Header</el-header>-->
    <el-main>
<!--      滚动条-->
      <el-scrollbar style="height: 100%;" wrapStyle="overflow-x:hidden;">
        <el-row>
          <el-col :span="3"><div style="display:inline-block"></div></el-col>
          <el-col :span="18" class="shoppingBody">
<!--            购物车主体-->
            <el-checkbox  :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
            <div style="margin: 15px 0;"></div>
<!--            复选框群组 绑定checkBooks                       当勾选改变时触发-->
            <el-checkbox-group v-model="checkBooks" @change="handleCheckedCitiesChange">
<!--              将每本书展示-->
              <el-row v-for="book in books" :key="book.id">
<!--                点击书名勾选-->
                  <el-checkbox style="width: 100%;" :label="book" >{{book.name}}</el-checkbox>
<!--                每本书的组件-->
                <shopping-body :book="book" @updateBookNum="updateBookNum" @openBuy="openBuy" @deleteBook="deleteBook"/>
              </el-row>
            </el-checkbox-group>
          </el-col>


          <el-col :span="3"><div style="display:inline-block"></div></el-col>
        </el-row>

      </el-scrollbar>

    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="3"><div style="display:inline-block"></div></el-col>

        <el-col :span="18">
<!--          这里是购物车页脚（负责合计和结算）-->
          <shopping-footer @openBuy="openBuy" :totalPrice="totalPrice"/>
        </el-col>


        <el-col :span="3"><div style="display:inline-block"></div></el-col>
      </el-row>
    </el-footer>
  </el-container>

<!--  -->
  <el-drawer
      title="订单"
      :visible.sync="drawer"
      :before-close="handleClose"
  >
    <shopping-buy :books="checkBooks" :totalPrice="totalPrice"/>
  </el-drawer>
</div>
</template>

<script>
import ShoppingBody from "../shopping/shoppingBody";
import ShoppingFooter from "../shopping/shoppingFooter";
import axios from "axios";
import ShoppingBuy from "../shopping/ShoppingBuy";

export default {
  name: "Shopping",
  data(){
    return{
      drawer: false,
      books: [],
      checkBooks: [],
      checkAll: false,
      totalPrice: null,
      isIndeterminate: true
    }
  },
  methods: {
    selectTotalPrice(){
      //服务器端算出总价将总价给Buy界面
      axios.post('/orderForm/selectTotalPrice',this.checkBooks).then(response=>{
        this.totalPrice = response.data;
      }).catch(e=>e)
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then( ()=> {
            done();
          })
          .catch(() => {});
    },
    openBuy(books){
      if (books !==undefined){
        this.checkBooks = books;
      }
      if (this.checkBooks.length === 0){
        alert("请先选择书籍");
        return false;
      }
        console.log(this.checkBooks);
        this.drawer = true;
        this.selectTotalPrice();

    },
    updateBookNum(book,num){
      book.num = num;
      this.selectTotalPrice();
    }
    ,
    handleCheckAllChange(val) {
      this.checkBooks = val ? this.books : [];
      this.isIndeterminate = false;
      this.selectTotalPrice();
    },
    handleCheckedCitiesChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.books.length;
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.books.length;
      this.selectTotalPrice();
    },
    selectBooks(){
      let axiosForm = new FormData();
      axiosForm.append('username',sessionStorage.getItem('username'));
      axios.post('/shoppingCart/selectBook',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.books = response.data
      }).catch(e=>e);
    },
    deleteBook(bookId){
      let axiosForm = new FormData();
      axiosForm.append('username',sessionStorage.getItem('username'));
      axiosForm.append('bookId',bookId);
      axios.post('/shoppingCart/deleteBook',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        alert(response.data);
        this.selectBooks();
      }).catch(e=>e);
    }
  },
  mounted() {
    this.selectBooks();
    // this.selectTotalPrice();
  },
  components: {ShoppingBuy, ShoppingFooter, ShoppingBody}
}
</script>

<style >
/*.el-checkbox-group{
  font-size: 10px;
  color: #909399;
}*/

.el-checkbox__label{
  font-size: 20px;
}

.el-footer .el-col-18 {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
}

.el-main{
  /*background-color: #E9EEF3;*/
  color: #333;
  /*text-align: center;*/
  height: 555px;
}

.shoppingBody{
  background-color: #fff;
}


/*body > .el-container {
  margin-bottom: 40px;
}*/
</style>