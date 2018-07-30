var picCode;
$(function() {

    picCode = drawPic("canvas");

    layui.use([ 'form', 'layer' ], function() {
        var form = layui.form;
        var layer = layui.layer;

        form.on('submit(login)', function() {
            login()
            return false;
        });

    });

    $("#canvas").on("click", function(obj) {
        var e = obj.originalEvent;
        e.preventDefault();
        picCode = drawPic(this.id)
    });

});

function login(){
    //验证参数
    if(!validateParam()){
        return;
    }
    var loginForm = document.getElementById("loginForm")
    var formData = new FormData(loginForm);
    $.post("/user/login",$("#loginForm").serialize(),function(data){
        if(data.code=='1001'){
            layer.alert("登录成功");
            location.href = "/user/list";
        }else{
            layer.alert(data.message);
            $("#password").val("");
            picCode=drawPic("canvas");
        }
    });

}

function validateParam(){
    //验证码校验
    var code = $("#validCode").val();
    if(!code){
        layer.tips("请输入验证码","#validCode",{tips:[2,"red"]});
        return false;
    }

    if(code.toLowerCase()!=picCode.toLowerCase()){
        layer.tips("验证码错误","#validCode",{tips:[2,"red"]});
        picCode = drawPic("canvas");
        return false;
    }

    //验证短信验证码

    var msgCode = $("#msgCode").val();
    if(!msgCode){
        layer.tips("请输入6位验证码","#msgCode",{tips:[2,"red"]});
        return false;
    }

    if(!msgCode.match(/\d{6}/)){
        layer.tips("验证码有误","#msgCode",{tips:[2,"red"]});
        return false;
    }

    return true;
}