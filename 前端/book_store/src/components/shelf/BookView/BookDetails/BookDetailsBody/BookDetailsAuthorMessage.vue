<template>
<div v-if="showAuthor">
  这里是书籍详情之作者信息:
  <el-row>
    笔名:{{author.pseudonym}}
  </el-row>
  <el-row>
    原名:{{author.name}}
  </el-row>
  <el-row>
    笔龄:{{author.writingTime}}
  </el-row>
  <el-row>
    累计字数:{{author.writingWordNumber}}
  </el-row>
  <el-row>
    年龄:{{author.age}}
  </el-row>
  <el-row>
    生日:{{author.birthday}}
  </el-row>
  <el-row>
    个性签名:{{author.motto}}
  </el-row>
  <el-row>
    著作数量:{{author.bookNumber}}
  </el-row>
  <el-row>
    经典著作:{{author.representative.name}}
  </el-row>

</div>
</template>

<script>
import axios from "axios";

export default {
  name: "BookDetailsAuthorMessage",
  data(){
    return{
      author: null
    };
  },
  methods: {
    //查询作者信息
    selectAuthor(){
      let axiosForm = new FormData();
      axiosForm.set('authorName',this.authorName);
      //  查询作者信息
      axios.post("/selectAuthor",axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.author = response.data;
      }).catch(e=>console.log(e));
    }
  },
  computed: {
    showAuthor(){
      if (this.author == null)
        return false;
      if (this.author.pseudonym !== this.authorName)
      {
        this.selectAuthor();
      }
      return true;
    }
  },
  mounted() {
    this.selectAuthor();
  },
  props: ['authorName']
}
</script>

<style scoped>

</style>