$(function(){

    if(document.cookie==""){
        window.location.href = '/html/contact.html';  //跳转到首页
    }


});
var vm= new Vue({
    el: '#app',
    data: {
        q:{
           s1:'',  //国家
           s2:''   //酒店
        },
        message: 'Hello Vue!',
    },
    methods:{
        selectChange:function () {
        },


        //页面点击search
        selectClick:function(){

            //这样定义
            //如果要搜索酒店就必须要选择国家  这样跳转到酒店的页面
            //如果只搜索国家  这样跳转到旅游的页面
            //什么都不搜索跳转到旅游的页面
            if(isBlank(vm.q.s1) &&  !isBlank(vm.q.s2)){
                //只选择了国家的情况
                //跳转到旅游
                window.location.href = '/html/tour.html?s1='+vm.q.s1+"&s2="+vm.q.s2;  //跳转到旅游页面
            }else if(!isBlank(vm.q.s1) &&  isBlank(vm.q.s2)){
                //只选择了酒店的情况
                alert("请选择国家！")

            }else if (isBlank(vm.q.s1) && isBlank(vm.q.s2)){
                //2个都选了的情况
                window.location.href = '/html/hotel.html?s1='+vm.q.s1+"&s2="+vm.q.s2;  //跳转到酒店页面
            }else{
                //2个条件都为空的话  不需要调用后台 直接跳转页面就可以了
                window.location.href = '/html/tour.html?s1='+vm.q.s1+"&s2="+vm.q.s2;  //跳转到旅游页面
            }

        }
    }
})