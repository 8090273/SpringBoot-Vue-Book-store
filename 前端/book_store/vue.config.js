module.exports = {

    lintOnSave:false, //关闭语法检查
    //配置代理服务器实现 跨域请求
    devServer: {
        port: 8000,
        proxy: 'http://localhost:8081'
    }
}