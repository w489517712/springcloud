$(function(){

    if(document.cookie==""){
        window.location.href = '/html/contact.html';  //跳转到首页
    }
    vm.getInfo();

});
var vm= new Vue({
    el: '#app',
    data: {
        q:{
            addrA:'',
            addrB:'',
            page:'1'
        },
        allPageNum :0,
        message: 'Hello Vue!',
    },
    methods:{
        getInfo:function(){

            vm.queryList();

        },

        queryList:function(){
            $.ajax({
                url:'/tour/queryOrderList',
                type:'post',
                //async
                data:JSON.stringify(vm.q),
                contentType:'application/json',
                success:function(r){

                    //先清空
                    $("#tourDiv").html("");

                    var list = r.list;
                    for(var i = 0;i<list.length;i++){
                        var info = list[i]
                        var divInfo = '';
                        divInfo =
                            '<div class="col-md-4 ftco-animate fadeInUp ftco-animated">'+
                            '<div class="destination">'+
                            '<a href="#" class="img img-2 d-flex justify-content-center align-items-center" style="background-image: url('+info.pngurl+');">'+
                            '<div class="icon d-flex justify-content-center align-items-center">'+
                            '<span class="icon-search2"></span>'+
                            '</div>'+
                            '</a>'+
                            '<div class="text p-3">'+
                            '<div class="d-flex">'+
                            '<div class="one">'+
                            '<h3><a href="#">'+info.setmeal+'/'+info.ticketRemark+'</a></h3>';
                        divInfo+=
                            '</div>'+
                            '<div class="two">'+
                            '<span class="price">$'+info.money+'</span>'+
                            '</div>'+
                            '</div>'+
                            ' <p>'+info.addrA+'</p>'+
                            ' <p>'+info.addrB+'</p>'+
                            '<hr>'+
                            '<p class="bottom-area d-flex">'+
                            '<span>'+info.createTimeStr+'</span>'+
                            '</p>'+
                            '</div>'+
                            '</div>'+
                            '</div>';
                        $("#tourDiv").append(divInfo);
                    }
                    vm.allPageNum = r.total;
                    doFenye();
                }

            })
        }









    }
})