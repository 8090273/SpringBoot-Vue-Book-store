<template>
<div>
  这里是用户的订单列表
  <el-row>
    <el-col :span="8" v-for="orderForm in orderForms" :key="orderForm.date">
      <user-home-order-form :orderForm="orderForm"/>
    </el-col>
  </el-row>

</div>
</template>

<script>
import axios from "axios";
import UserHomeOrderForm from "./UserHomeOrderFormList/UserHomeOrderForm";

export default {
  name: "UserHomeOrderFormList",
  components: {UserHomeOrderForm},
  data(){
    return{
      orderForms: []
    }
  },
  methods: {
    selectOrderForm() {
      let axiosForm = new FormData();
      axiosForm.append('username',this.username);
      axios.post('/orderForm/selectOrderForm',axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then(response=>{
        this.orderForms = response.data;
      }).catch(e=>e)
    }
  },
  mounted() {
    this.selectOrderForm();
  },
  props: ['username']
}
</script>

<style scoped>

</style>