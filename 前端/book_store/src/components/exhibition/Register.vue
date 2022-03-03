<template>
  <div id="register">
    <el-form label-position="left" :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <h2 class="centerSpan">客官来小憩片刻</h2>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="ruleForm.username"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="affirm">
        <el-input v-model="ruleForm.affirm"></el-input>
      </el-form-item>

      <el-form-item
          prop="email"
          label="邮箱"
          :rules="[
            { required: true, message: '请输入邮箱地址', trigger: 'blur' },
            { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
          ]"
      >
        <el-input v-model="ruleForm.email"></el-input>
      </el-form-item>

      <el-form-item label="喜好分类" prop="type">
        <el-checkbox-group v-model="ruleForm.type">
          <el-checkbox label="工具书籍" name="type"></el-checkbox>
          <el-checkbox label="人文历史" name="type"></el-checkbox>
          <el-checkbox label="文学散文" name="type"></el-checkbox>
          <el-checkbox label="艺术鉴赏" name="type"></el-checkbox>
          <el-checkbox label="小说故事" name="type"></el-checkbox>
          <el-checkbox label="学习资料" name="type"></el-checkbox>
          <el-checkbox label="漫画插画" name="type"></el-checkbox>
          <el-checkbox label="唐诗宋词" name="type"></el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-radio-group v-model="ruleForm.sex">
          <el-radio label="男"></el-radio>
          <el-radio label="女"></el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="座右铭" prop="desc">
        <el-input type="textarea" v-model="ruleForm.desc"></el-input>
      </el-form-item>

      <el-row>
        <el-col :span="12">
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">立即注册</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <span>已有账号？点击登录</span>
          <el-button type="primary" icon="el-icon-user" @click="$router.push('/Login').catch(e=>e)">登录</el-button>
        </el-col>
      </el-row>

    </el-form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Register",
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.affirm !== '') {
          this.$refs.ruleForm.validateField('affirm');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      //注册状态 true为注册成功
      registerState: false,

      ruleForm: {
        username: '',
        password: '',
        //确认密码
        affirm: '',

        email: '',
        //喜好类型
        type: [],
        sex: '',
        //个性签名
        desc: ''
      },
      //校验表单规则
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 8 到 20 个字符', trigger: 'blur' }
        ],
        password: [
          {validator: validatePass,required: true,message: '请输入密码！',trigger: 'blur'},
          { min: 6, max: 20, message: '长度在 8 到 20 个字符', trigger: 'blur' }
        ],
        //确认密码
        affirm: [
          {validator: validatePass2,required: true,trigger: 'blur'}
        ],
        type: [
          { type: 'array', required: true, message: '请至少选择一个喜爱分类', trigger: 'change' }
        ],
        sex: [
          { required: true, message: '请选择性别', trigger: 'blur' },
        ]
      }
    }
  },
  methods: {
    submitForm(formName) {
      //async应该加在直接父函数上
      this.$refs[formName].validate(async (valid) =>{
        if (valid) {
          //发送axios,加入关键字await 使此语句变为串行同步的，必须等待请求完成才能继续
          await this.sendAxios();
          if (this.registerState){
            this.$message({
              message: '欢迎成为小店的一员！记得重新登录哟',
              type: 'success'
            });
          }else {
            this.$message.error('用户名已存在！');
          }
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    async sendAxios(){
      let axiosForm = new FormData();
      axiosForm.append("username",this.ruleForm.username);
      axiosForm.append("password",this.ruleForm.password);
      axiosForm.append("email",this.ruleForm.email);

      await axios.post("/registerServer",axiosForm,{
        headers: {
          'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
        }
      }).then((response)=>{
        this.registerState = response.data;
      }).catch(e => console.log(e));
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
#register{
  width: 50%;
  background-color: #E4E7ED;
  padding: 10px;
  border-radius: 30px;

/*  居中显示*/
  margin: auto;
}

.centerSpan{
  text-align: center;
}
</style>