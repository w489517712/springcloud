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

            $.ajax({
                url: '/tour/queryAboutObject',
                type: 'post',
                data:JSON.stringify(vm.q),
                //async
                contentType: 'application/json',
                success: function (r) {
                    var infolist = r.result


                    var div = '<div class="row">';
                    for(var i =0;i<infolist.length;i++){
                        var info = infolist[i];
                        div += '<div class="col-md-12">' +
                            '<div class="card">'+
                            '<div class="card-header">'+
                            '<a class="card-link" data-toggle="collapse"  href="#menu'+i+'" aria-expanded="true" aria-controls="menu'+i+'">'+info.question+'<span class="collapsed"></span><span class="expanded"></span></a>'+
                            '</div>'+
                            '<div id="menuone" class="collapse show">'+
                            '<div class="card-body">'+
                            '<p>'+info.frequently+'</p>'+
                            '</div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';
                    }
                    div += '</div>';
                    $("#accordion").append(div);

                }
            })

        }

    }
})