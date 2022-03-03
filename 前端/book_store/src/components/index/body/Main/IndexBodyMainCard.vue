<template>
<div>
  <el-card :body-style="{ padding: '0px'}">
    <div class="image">
      <img :src="require('../../../../assets/indexBodyMain/img1.png')" style="width: 100%;">
    </div>
    <div style="padding: 14px;">
      <span>畅销中</span>
      <div class="bottom clearfix">
        <time class="time">{{ currentDate }}</time>
        <el-button type="text" class="button">查看详情</el-button>
      </div>
    </div>
  </el-card>
</div>
</template>

<script>
export default {
  name: "IndexBodyMainCard",
  data() {
    return {
      currentDate: new Date()
    };
  }
}
</script>

<style scoped>
.time {
  font-size: 13px;
  color: #999;
}
.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  max-width: 100%;
  height: 460px;
  overflow: hidden;
}
</style>