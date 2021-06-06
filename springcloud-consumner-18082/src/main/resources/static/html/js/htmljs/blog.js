$(function(){

    if(document.cookie==""){
        window.location.href = '/html/contact.html';  //跳转到首页
    }
    vm.q.s1 = getQueryVariable('s1')
    vm.q.s2 = getQueryVariable('s2')
    vm.getInfo();

});
var vm= new Vue({
    el: '#app',
    data: {
        q:{
            s1:'',
            s2:'',
            city:'',
            page:'1',
            pageNum:'8'
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
                url:'/tour/queryBlogList',
                type:'post',
                //async
                data:JSON.stringify(vm.q),
                contentType:'application/json',
                success:function(r){

                    //先清空
                    $("#blogdiv").html("");



                    var list = r.list;
                    for(var i = 0;i<list.length;i++){
                        var info = list[i]
                        var divInfo = '';
                        divInfo =
                            '<div class="col-md-3 d-flex ftco-animate fadeInUp ftco-animated">'+
                            '<div class="blog-entry align-self-stretch" style="width: 500px; ">'+
                            '<a href="javascript:void(0)" class="block-20" style="background-image: url('+info.pngurl+');">'+
                            '</a>'+
                            '<span class="tag">'+info.tag+'</span>'+
                            '<h3 class="heading mt-3"><a href="#">'+info.msg+'</a></h3>'+
                            '<div class="meta mb-3">'+
                            '<div><a href="javascript:void(0)">'+info.createtime+'</a></div>'+
                            '<div><a href="javascript:void(0)">'+info.username+'</a></div>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';
                        $("#blogdiv").append(divInfo);
                    }
                    vm.allPageNum = r.total;
                    doFenye(8);
                }

            })
        }









    }
})