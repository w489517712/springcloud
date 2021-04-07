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
           s2:'',   //酒店
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
                url:'/tour/queryTourList',
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
                            '<h3><a href="#">'+info.country+'</a></h3>';
                        divInfo+=
                            '<p class="rate">';
                            for(var j = 0;j<5;j++){
                                if(j<info.lev){
                                    divInfo+= '<i class="icon-star"></i>';
                                }else{
                                    divInfo+= '<i class="icon-star-o"></i>';
                                }
                            }
                        divInfo+=
                            '<span>'+info.lev+' Rating</span>'+
                            '</p>';
                        divInfo+=
                            '</div>'+
                            '<div class="two">'+
                            '<span class="price">$'+info.money+'</span>'+
                            '</div>'+
                            '</div>'+
                            ' <p>'+info.remark+'</p>'+
                            ' <p class="days"><span>'+info.setmeal+'</span></p>'+
                            '<hr>'+
                            '<p class="bottom-area d-flex">'+
                            '<span><i class="icon-map-o"></i> San Franciso, CA</span>'+
                            '<span class="ml-auto"><a href="#">Discover</a></span>'+
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