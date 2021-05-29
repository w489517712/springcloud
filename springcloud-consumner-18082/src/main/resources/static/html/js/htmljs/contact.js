$(function(){

    document.cookie="";

});
var vm= new Vue({
    el: '#app',
    data: {
        user:{
            name:'',
            password:''
        },
        message: 'Hello Vue!',
    },
    methods:{

        formClick:function(){

            if(!isBlank(vm.user.name)){

                return alert("Please enter user name！")
            }else if(!isBlank(vm.user.password)){

                return  alert("Please enter password！")
            }


            $.ajax({
                url:'/tour/login',
                type:'post',
                data:JSON.stringify(vm.user),
                contentType:'application/json',
                success:function(r){

                    if(r.code == 1){
                        document.cookie="token="+r.user.token+";path=/";


                        window.location.href = '/html/index.html';  //跳转到首页
                    }else{
                        alert(r.msg)
                    }

                }
            })


        }

    }

})