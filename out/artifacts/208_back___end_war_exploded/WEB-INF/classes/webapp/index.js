var bookappointment={
    //封装相关ajax的url
    URL:{
        appoint:function(bookId,studentId){
            return '/books/'+bookId+'/appoint?studentId='+studentId;
        },
        verify:function(){
            return '/books'+'/verify';
        }
    },

    //验证学号和密码
    validateStudent:function(userId,password){
        console.log("userId"+userId);
        if(!userIdId||!password){
            return "nothing";
        }else if(userIdId.length!=10 ||isNaN(userIdId)||password.length!=6 ||isNaN(password)){
            return "typerror";
        }else {
            if(bookappointment.verifyWithDatabase(userIdId, password)){
                console.log("验证成功！");
                return "success";
            }else{
                console.log("验证失败！");
                return "mismatch";
            }
        }
    },

    verifyWithDatabase:function(userId,password){
        var result=false;
        var params={};
        params.userId=userId;
        params.password=password;
        console.log("params.password:"+params.password);
        var verifyUrl=bookappointment.URL.verify();
        $.ajax({
            type:'post',
            url:verifyUrl,
            data:params,
            datatype:'josn',
            async:false,                       //同步调用，保证先执行result=true,后再执行return result;
            success:function(data){
                if(data.result=='SUCCESS'){
                    window.location.reload();
                    //弹出登录成功！
                    alert("登陆成功！");
                    result=true;
                }else{
                    result=false;
                }
            }
        });
        console.log("我是验证结果："+result);
        return result;

    },



}