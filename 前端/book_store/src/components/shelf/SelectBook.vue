<template>
  <div>
<!--    这里是搜索框-->
    <el-row>
      <el-col :span="12">
        <!--    这里是页头  返回事件不能使用@click 必须使用@back-->
        <el-page-header @back="back" content="详情页面" >
        </el-page-header>
      </el-col>

      <el-col :span="12">
        <!--   :fetch-suggestions 点击输入框时执行	返回输入建议的方法，仅当你的输入建议数据 resolve 时，通过调用 callback(data:[]) 来返回它 -->
        <!--    value-key	输入建议对象中用于显示的键名,默认为value-->
        <!--    @select	点击建议时 调用函数-->
        <el-autocomplete
            prefix-icon="el-icon-search"
            v-model="selectString"
            value-key="name"
            :fetch-suggestions="inputSuggestions"
            placeholder="请输入书名或作者"
            @select="handleSelect"
        ></el-autocomplete>
      </el-col>
    </el-row>

  </div>
</template>

<script >
import axios from "axios";

export default {
  name: "SelectBook",
  data() {
    return {
      //存储后端数据
      books: [],
      //用户输入的字符串
      selectString: ''
    };
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
        //      将state的值转为小写,并匹配字符串返回索引，参数为要搜索的字符串匹配到第一个子串相同才返回结果
        // return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
        //重写后可以匹配任意位置子串
        // return (state.address.toLowerCase().indexOf(queryString.toLowerCase()) !== -1);
        //可以根据书名和作者查出书籍
        return (book.name.toLowerCase().indexOf(queryString.toLowerCase()) !== -1 || book.author.toLowerCase().indexOf(queryString.toLowerCase()) !== -1);
      };
    },
    //点击建议时调用
    handleSelect(book) {
      //这里写点击查看的逻辑

      //路由到书籍详情,传参为书的id
      this.$router.push({
        name: 'bookDetails',
        query: {
          id: book.id
        }
      }).catch(e=>e)
    },
    back(){
      this.$router.back();
    }
  },
  mounted() {
    //将数据加载进来
    this.initBooks();
  }
}
</script>

<style >
.el-page-header__content {
  color: #fff;
}
</style>