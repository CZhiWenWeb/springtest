window.onload = function reloadCode() {
    $("#codeImg").attr("src", "/captcha/image?data=" + new Date() + "");
};

function reloadCode() {
    $("#codeImg").attr("src", "/captcha/image?data=" + new Date() + "");
}

function sendCaptcha() {
    var phone = $("#phoneNum").val();
    var data = {};
    var url = "/captcha/sms?phone=" + phone;
    $.get(url, data, function (t) {

    })
}

//ajax进行表单提交，添加头部
// function login() {
//     var username=$("#username").val();
//     var password=$("#password").val();
//     var data={};
//     data["username"]=username;
//     data["password"]=password;
//     //设置发送前添加auth,同步
//     $.ajax({
//         beforeSend:function (request) {
//             request.setRequestHeader("Authorization","Basic ZGVtbzoxMjM0NTY=");
//         },
//         async:false,
//         type:"POST",
//         url:"/user/login",
//         data:data,
//         success:function (e) {
//             // location.href='index.html';
//             debugger
//             console.log(e.getAllKeys());
//         },
//         error:function (jqXHR) {
//             debugger
//             console.log(jqXHR);
//         }
//     });
// }