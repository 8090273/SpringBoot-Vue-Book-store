<template>
<div>
<!--  这里是表格List-->
  <BackstageBodyListSelect @updateBooks="updateBooks"/>
  <el-table
    :data="books"
    stripe
    >
    <el-table-column
      prop="id"
      label="id"
      width="100"
    >
    </el-table-column>
    <el-table-column
      label="书名"
      >
      <template v-slot="scope">
        <span v-show="!scope.row.isEdit">{{scope.row.name}}</span>
        <el-input v-model="scope.row.name" v-show="scope.row.isEdit" placeholder="书名"></el-input>
      </template>
    </el-table-column>
    <el-table-column
      label="价格">
<!--      如果使用了v-slot那么原来的内容会消失-->
      <template v-slot="scope">
        <span v-show="!scope.row.isEdit">{{scope.row.price}}</span>
        <el-input v-model="scope.row.price" v-show="scope.row.isEdit" placeholder="价格"></el-input>
      </template>
    </el-table-column>

    <el-table-column
      label="作者">
      <template v-slot="scope">
        <span v-show="!scope.row.isEdit">{{scope.row.author}}</span>
        <el-input v-model="scope.row.author" v-show="scope.row.isEdit" placeholder="作者"></el-input>
      </template>
    </el-table-column>

    <el-table-column
        label="销量">
      <template v-slot="scope">
        <span v-show="!scope.row.isEdit">{{scope.row.sales}}</span>
        <el-input v-model="scope.row.sales" v-show="scope.row.isEdit" placeholder="销量"></el-input>
      </template>
    </el-table-column>

    <el-table-column
        fixed="right"
        label="操作"
        width="180"
    >
<!--      v-slot:取代了 slot-scope-->
      <template v-slot="scope">

        <el-button
            v-show="!scope.row.isEdit"
            @click.native.prevent="editBook(scope.row)">
          编辑
        </el-button>
        <el-button
            type="success"
            v-show="scope.row.isEdit"
            @click.native.prevent="overEdit(scope.row)">
          完成
        </el-button>
        <el-button
            type="danger"
            @click.native.prevent="deleteBook(scope.row.id)">
          删除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
    <el-button type="primary" round @click="$router.push('/backstage/backstageBodyAdd').catch(e=>e)" class="add">添加</el-button>


  <!--  <backstage-body-list-item v-for="book in books" :book = 'book' :key="book.id"/>-->
</div>
</template>

<script>
import BackstageBodyListSelect from "./BackstageBodyListSelect";
import axios from "axios";
export default {
  name: "BackstageBodyList",
  data(){
    return{
      pagination: this.$store.state.pagination,
      books: []
    }
  },

  methods: {
    updateBooks(books){
      console.log(books)
      this.books = [];
      this.books.push(books)
    },

    deleteBook(id){
      console.log(id)

      let axiosForm = new FormData();
      axiosForm.append('id',id);
      axios.post('/backstage/delete',axiosForm,{
        headers:{
          'Content-Type':"application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        console.log(response.data);
        this.books = this.books.filter((book)=> id !==book.id)
      })
    },

    //进入编辑模式
    editBook(row){
    //  点击编辑后不再显示此行的操作按钮
      if(row.hasOwnProperty('isEdit')){
        row.isEdit = true
      }else {
        //如果没有isEdit属性，设置上去
        this.$set(row,'isEdit',true);
      }

    },
    overEdit(row){
      row.isEdit = false;
      //完成编辑后将修改的数据传给服务器
      let axiosForm = new FormData();
      axiosForm.append('id',row.id);
      axiosForm.append('name',row.name);
      axiosForm.append('author',row.author);
      axiosForm.append('price',row.price);
      axiosForm.append('sales',row.sales);
      axiosForm.append('stock',row.stock);

      axios.post('/backstage/updateBook',axiosForm,{
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }
      }).then(response=>{
        console.log(response.data)
      })
    }
  },
  //想要监听store的值，可以先computed这个store,然后watch这个computed
  computed: {
    selectBookPage(){
    //  根据分页查询

      //发送axios请求，要把分页信息给后台，后台准备个分页对象
      let axiosForm = new FormData();
      axiosForm.append('page', this.pagination.page);
      axiosForm.append('size', this.pagination.size);
      axios.post('/backstage/selectPage',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.books = response.data;
      })
    }
  },
  watch:{
    selectBookPage(oldPage,newPage){
      this.books = newPage;
    }
  },
  components: {BackstageBodyListSelect}
}
</script>

<style scoped>

.add{
  float: right;
}
</style>