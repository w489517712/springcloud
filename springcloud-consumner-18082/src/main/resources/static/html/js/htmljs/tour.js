$(function(){

    vm.q.s1 = getQueryVariable('s1')
    vm.q.s2 = getQueryVariable('s2')
    vm.getInfo();

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
        getInfo:function(){

            $.ajax({
                url:'/tour/queryTourList',
                type:'post',
                //async
                data:JSON.stringify(vm.q),
                contentType:'application/json',
                success:function(result){

                }

            })


        }
    }
})