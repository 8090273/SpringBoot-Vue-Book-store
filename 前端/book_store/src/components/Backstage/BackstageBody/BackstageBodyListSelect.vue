<template>
<div>
<!--  这里是搜索框-->
  <el-autocomplete
      prefix-icon="el-icon-search"
      v-model="selectString"
      value-key="name"
      :fetch-suggestions="inputSuggestions"
      placeholder="请输入书名或作者"
      @select="handleSelect"
  ></el-autocomplete>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: "BackstageBodyListSelect",
  data(){
    return{
      //用户输入的字符串
      books: [],
      selectString: ''
    }
  },
  methods: {
    //初始化书籍，只返回10本书
    initBooks() {
      axios.post('/initBooks').then(response=>{
        this.books = response.data;
      }).catch(e=>console.log(e));
    },

    //点击输入框、输入时执行  queryString：输入框的文字
    async inputSuggestions(queryString, callback) {

      let axiosForm = new FormData();
      axiosForm.set("selectString",this.selectString);
      //把过滤规则改为去数据库模糊查询
      if (queryString){
        await axios.post('/selectBooks',
            axiosForm,
            {
              //axios默认发送json，@ResquesParam默认接收键值对 用request Body 返回Map就成功了
              //修改headers配置
              headers: {
                'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
              },
            }).then(response=>{
          this.books = response.data;

        }).catch(e=>console.log(e))
      }
      //如果输入框内不为空则显示搜索结果，否则为空    filter会遍历整个对象数组，也就是说this.createStateFilter会被调用很多次
      // selectResult = queryString ? books.filter(this.bookFilter(queryString)) : books;

      //将搜索结果以输入建议显示
      callback(this.books);
    },
    //过滤规则
    bookFilter(queryString) {
      //state 所输入的内容
      return (book) => {
        //将state的值转为小写,并匹配字符串返回索引，可以根据书名和作者查出书籍
        return (book.name.toLowerCase().indexOf(queryString.toLowerCase()) !== -1 || book.author.toLowerCase().indexOf(queryString.toLowerCase()) !== -1);
      };
    },
    //点击建议时调用
    handleSelect(book) {
      //这里写点击查看的逻辑

      //点击后修改父组件的值
      this.$emit('updateBooks',book);

    }
  },
  mounted() {
    //将数据加载进来
    this.initBooks();
  }
}
</script>

<style scoped>

</style>