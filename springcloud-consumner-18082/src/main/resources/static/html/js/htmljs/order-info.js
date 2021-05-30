var id;
$(function(){

    if(document.cookie==""){
        window.location.href = '/html/contact.html';  //跳转到首页
    }

    id = getQueryVariable('id')
    if(id != ''&& id != null){
        //修改
        vm.getInfo(id);
        vm.tag = '修改'
        $(".h4text").html('修改')

    }else{
        //新增
        vm.tag = '新增'
        $(".h4text").html('新增')
    }


});
var vm= new Vue({
    el: '#app',
    data: {
        order:{
            tourid:'',
            ticketid:'',
            username:'',
            phone:'',
            money:0,
            remark:'',
            ticketInfo:'',
            tourInfo:''
        },
        ticketMoney:0,
        tourMoney:0,
        tag:'',
        allPageNum :0,
        message: 'Hello Vue!',
    },
    methods:{

        getInfo:function(orderId){
            var url = '/tour/queryOrderObject';
            $.ajax({

                url: url,
                type: 'post',
                async: true,
                data: JSON.stringify({"id": orderId}),
                contentType: 'application/json',
                success: function (r) {
                    if (r.code == 1) {
                        vm.order = r.result

                        vm.order.ticketInfo = r.result.ticketRemark + "/" + r.result.ticketMoney + "$"
                        vm.ticketMoney = r.result.ticketMoney;

                        vm.order.tourInfo = r.result.setmeal + "/" + r.result.tourMoney + "$"
                        vm.tourMoney = r.result.tourMoney;
                    } else {
                        alert(r.msg)
                    }
                }
            })
        },

        selectTicket:function(){
            window.open("/html/ticket-open.html","newWindow","menubar=0,scrollbars=1, resizable=1,status=1,titlebar=0,toolbar=0,location=1");

        },

        selectedTicket:function(ticketid){

            var url  = "/tour/queryTicketObject";
            $.ajax({
                url: url,
                type: 'post',
                async: true,
                data: JSON.stringify({"id": ticketid}),
                contentType: 'application/json',
                success: function (r) {
                    if (r.code == 1) {
                        var info = r.result
                        vm.order.ticketInfo = info.remark + "/" + info.money + "$"
                        vm.order.ticketid = ticketid;
                        vm.ticketMoney = info.money;
                        vm.order.money = vm.ticketMoney + vm.tourMoney;
                    } else {
                        alert(r.msg)
                    }
                }
            })
        },


        selectTour:function () {
            window.open("/html/tour-open.html","newWindow","menubar=0,scrollbars=1, resizable=1,status=1,titlebar=0,toolbar=0,location=1");

        },

        selectedTour:function(tourId){
            var url  = "/tour/queryTourObject";
            $.ajax({
                url: url,
                type: 'post',
                async: true,
                data: JSON.stringify({"id": tourId}),
                contentType: 'application/json',
                success: function (r) {
                    if (r.code == 1) {
                        var info = r.result
                        vm.order.tourInfo = info.setmeal+"/"+info.money+"$"
                        vm.order.tourid = tourId;
                        vm.tourMoney = info.money;
                        vm.order.money = vm.ticketMoney + vm.tourMoney;
                    } else {
                        alert(r.msg)
                    }
                }
            })
        },


        saveOrUpdate:function(){
            var url  = id == null?'/tour/saveOrder':'/tour/updateOrder'
            $.ajax({
                url:url,
                type:'post',
                async:true,
                data:JSON.stringify(vm.order),
                contentType:'application/json',
                success:function(r){
                    if(r.code == 1){
                        id =  r.id
                        var f = confirm("操作成功");
                        if(f){
                            window.location.href = '/html/order.html';
                        }

                    }else{
                        alert(r.msg)
                    }
                }

            })
        }









    }
})