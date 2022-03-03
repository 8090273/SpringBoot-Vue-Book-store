<template>
<div>
<!--  这里是下单页面-->
  <div v-for="book in books" :key="book.id">
    <h1>{{book.name}}</h1>
    <img src="../../assets/indexBodyMain/img1.png" style="width: 30%;">
    <h3>数量：{{book.num}}</h3>
    <h3>总价格：{{book.price * book.num}}</h3>
  </div>

  收货地址：<el-input v-model="address" placeholder="请准确到门牌号"></el-input><br><br><br>
  手机号：<el-input v-model="phoneNumber" placeholder="请输入手机号码"></el-input><br><br><br>
  <el-button type="success" @click="createOrderForm">付款</el-button>￥{{totalPrice}}元

</div>
</template>

<script>
import axios from "axios";

export default {
  name: "ShoppingBuy",
  data(){
    return{
      address: '',
      phoneNumber: ''
    }
  },
  methods: {
    //创建订单
    createOrderForm(){
      let axiosForm = new FormData();
      axiosForm.append('username',sessionStorage.getItem('username'));
      axiosForm.append('address',this.address);
      axiosForm.append('phoneNumber',this.phoneNumber);
      axiosForm.append('books',JSON.stringify(this.books));

      axios.post('/orderForm/createOrderForm',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.$alert(response.data+'；因为小店没有营业执照，不能收款下单，只能到此为止了。点击返回主页','很抱歉',{
          confirmButtonText: '返回首页',
          callback: () => {
              this.$router.push('/');
          }
        })
      }).catch(e=>e);
    },
    //从订单中查出必要数据
    selectOrderForm(){

    }
  },
  props: ['books','totalPrice']
}
</script>

<style scoped>

</style>