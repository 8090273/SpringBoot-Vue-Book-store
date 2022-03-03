<template>
<div>
<!--这里是后台-->
<!--  标题-->
  <backstage-title/>
  <el-button type="primary" @click="$router.push('/backstage/backstageBody').catch(e=>e);showButton = true" v-show="!showButton">管理书籍列表</el-button>
  <el-row>
    <el-col :span="3" >
      <div class="occupy"></div>
    </el-col>
    <el-col :span="18">
      <router-view></router-view>
    </el-col>
    <el-col :span="3" >
      <div class="occupy"></div>
    </el-col>


  </el-row>

</div>
</template>

<script>
import BackstageTitle from "../Backstage/BackstageTitle";
export default {
  name: "Backstage",
  data(){
    return{
      showButton: false
    }
  },
  components: { BackstageTitle}
}
</script>

<style scoped>

.occupy{
  display: inline-block;
}
</style>