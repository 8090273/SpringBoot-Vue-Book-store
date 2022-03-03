<template>
<div id="Login">
<!--        status-icon	是否在输入框中显示校验结果反馈图标 -->
  <el-form :model="user" status-icon :rules="rules" ref="user" label-width="100px" class="demo-ruleForm">
<!--     prop是user的username-->
    <h2 class="centerSpan">客官这边请</h2>
    <el-form-item label="用户名" prop="username" >
  <!--                         绑定pass用户名          原生属性自动补全 -->
      <el-input type="text" v-model="user.username" autocomplete="off"></el-input>
    </el-form-item>


    <el-form-item label="密码" prop="password">
      <!-- validate-event属性的作用是: 输入时不触发表单验证.提交时再验证,你也可以设置成动态验证 -->
      <el-input type="password" :validate-event="false" v-model="user.password" autocomplete="off"></el-input>
    </el-form-item>

    <el-row>
      <el-col :span="12">
        <el-form-item>
          <el-button type="primary" @click="submitForm('user')">提交</el-button>
          <el-button @click="resetForm('user')">重置</el-button>
        </el-form-item>
      </el-col>

<!--      <el-col :span="6"></el-col>-->
      <el-col :span="12" >
        <span>没有账号？点击注册</span>
        <el-button type="primary" icon="el-icon-user" @click="$router.push('/register').catch(e=>e)">注册</el-button>
      </el-col>
    </el-row>


  </el-form>
</div>
</template>
<script>

import axios from "axios";

export default {
  name: "Login",
   data() {
    //第一个验证器
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入用户名'));
        }
        callback()
      };
      //第二个验证器
      var validatePass2 = async (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        }
        else{
          //密码不为空则发送axios请求
            //bug axios被调用了三次 X  解决：第一个校验器调用了第二个校验器，关掉则减少一个;因为校验规则是失去焦点执行，所以会有提交两次的bug;
              //在input中加入 :validate-event="false" 让此输入在失焦时不验证，只有提交时才验证
          await this.requestAxios();
          console.log(this.LoginSuccess)
          if (!this.LoginSuccess) {
            //bug this.LoginMessage未被修改便被访问了，想办法延时一下|| 延时后会有缓存,多延时一段时间就好 还是有小bug，延时到350就好
            callback(new Error(this.LoginMessage));
          } else {
            //校验通过 饿了么自带的提示
            this.$notify.success({
              title: '成功',
              message: '欢迎光临小店',
              showClose: false
            });

            callback();
          }
/*          setTimeout(()=>{
            //如果密码与数据库密码不一致(小bug，if(false)不会执行（无语）)
            //bug 响应需要时间
            console.log(this.LoginSuccess)
            if (!this.LoginSuccess) {
              //bug this.LoginMessage未被修改便被访问了，想办法延时一下|| 延时后会有缓存,多延时一段时间就好 还是有小bug，延时到350就好
              callback(new Error(this.LoginMessage));
            } else {
              //校验通过
              alert("验证通过")
              callback();
            }
          },350)*/

          //使用nextTick试试 不管用
          /*this.$nextTick(()=>{
            //如果密码与数据库密码不一致(小bug，if(false)不会执行（无语）)
            //bug 响应需要时间
            console.log(this.LoginSuccess)
            if (!this.LoginSuccess) {
              //bug this.LoginMessage未被修改便被访问了，想办法延时一下|| 延时后会有缓存,多延时一段时间就好 还是有小bug，延时到350就好
              callback(new Error(this.LoginMessage));
            } else {
              //校验通过
              alert("验证通过")
              callback();
            }
          })*/

        }
      };
      return {
        //表单中的数据
        user: {
          username: '',
          password: ''
        },
        //验证规则
        rules: {
          username: [
            //    blur失去焦点时触发验证  change数据改变时触发验证  required为是否加红色星号
            { validator: validatePass, trigger: 'blur' ,required: true}
          ],
          password: [
            { validator: validatePass2, trigger: 'blur' ,required: true }
          ]
        },
        //表单类型，用于模拟表单
        formData: new FormData(),
        //登录状态，用于接收后端状态
        LoginSuccess: false,
        //登录信息，用于接收后端信息
        LoginMessage: ""
      };
    },
    methods: {
      submitForm(formName) {

        //valid为验证状态
        this.$refs[formName].validate((valid) => {
          //如果登录验证通过
          if (valid) {
            //登陆成功返回首页，使用路由实现重定向
            this.$router.push('/')
          //  向cookie中放入登录信息
            sessionStorage.setItem('username',this.user.username);
            sessionStorage.setItem('password',this.user.password);

            //将登录成功的信息返回给导航栏组件
            this.$store.dispatch('userLoginState');
            //如果是管理员登录，则打开后台管理
            if (this.user.username === 'admin')
            {
              this.$store.dispatch('adminLogin');
            }
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      //重置表单
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },

      //调用axios,并更改登录状态
      async requestAxios(){
        //将表单数据放入模拟表单格式中
        this.formData.set('username',this.user.username);
        this.formData.set('password',this.user.password);
        await axios.post('/Login',this.formData,{
          //axios默认发送json，@ResquesParam默认接收键值对 用request Body 返回Map就成功了
          //修改headers配置
          headers: {
            'Content-Type': "application/x-www-form-urlencoded;charset=utf-8"
          },
        }).then((response)=>{
          //将响应内容写入模型
          this.LoginMessage = response.data.message;
          this.LoginSuccess = response.data.success;
        }).catch(e => console.log(e));
      }
    }
  }

</script>

<style scoped>
#Login{
  width: 50%;
  background-color: #E4E7ED;
  padding: 10px;
  border-radius: 30px;

  /*  居中显示*/
  margin: auto;
}

/*栅格文字居中*/
.centerSpan{
  text-align: center;
}
</style>