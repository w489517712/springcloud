

//ajax 全局设置
$.ajaxSetup({
    beforeSend: function(xhr) {
        xhr.setRequestHeader("token",getToken());
    },
})






// 空或者null返回false
function isBlank(str){
    if(null == str){
        return false
    }

    if (str.replace(/(^s*)|(s*$)/g, "").length ==0)
    {
       return false
    }

    return true
}
//获取参数
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(null);
}

//分页js
function doFenye(){
    $("#fydiv").html('');
    $(".active").removeClass("active")

    var page = vm.q.page
    var allPageNum = vm.allPageNum
    var allPage = Math.ceil(allPageNum/6)
    if(allPage>5){
        if(page<4){
            var ul = ""
            ul = "<ul>"+
                   "<li class = 'fli'><span>&lt;</span></li>"+
                   "<li id='l1'><span>1</span></li>"+
                   "<li id='l2'><span>2</span></li>"+
                   "<li id='l3'><span>3</span></li>"+
                   "<li id='l4'><span>4</span></li>"+
                   "<li id='l5'><span>5</span></li>"+
                   "<li class = 'eli'><span>&gt;</span></li>"+
                   "</ul>";
            $("#fydiv").append(ul);

            $("#l"+page).addClass("active");

        }else{
            var ul = ""
            ul = "<ul>"+
                "<li class = 'fli'><span>&lt;</span></li>"+
                "<li id='l"+(page-2)+"'><span>"+(page-2)+"</span></li>"+
                "<li id='l"+(page-1)+"'><span>"+(page-1)+"</span></li>"+
                "<li id='l"+page+"'  class=' active'><span>"+page+"</span></li>";
                if(allPage >= (page*1+1)){
                    ul+= "<li id = 'l"+(page*1+1)+"' ><span>"+(page*1+1)+"</span></li>"
                }
                if(allPage >= (page*1+2)){
                    ul+="<li  id = 'l"+(page*1+2)+"' ><span>"+(page*1+2)+"</span></li>"
                }
            ul+="<li class = 'eli'><span>&gt;</span></li>"
            ul+="</ul>";
            $("#fydiv").append(ul);
        }
    }else{
        var ul = "<ul>";
        ul += "<li class = 'fli'><span>&lt;</span></li>";
        for(var i=0;i<allPage;i++){
            ul += "<li id='l"+(i+1)+"'><span>"+(i+1)+"</span></li>";
        }
        ul +=  "<li class = 'eli'><span>&gt;</span></li>"
        ul +=  "</ul>";
        $("#fydiv").append(ul);
        $("#l"+page).addClass("active");
    }
    $("#fydiv li").not(".fli,.eli").click(toPage)
    $(".fli").click(toFristPage)
    $(".eli").click(toEndPage)


}

function toFristPage(){
    vm.q.page = 1
    vm.queryList();
}
function toEndPage(){
    vm.q.page = Math.ceil(vm.allPageNum/6)
    vm.queryList();
}
function toPage(){
    //alert($(this).attr("id"))
    vm.q.page = $(this).attr("id").split("l")[1];
    vm.queryList();
}

function getToken(){
    var strcookie = document.cookie;//获取cookie字符串
    var arrcookie = strcookie.split("; ");//分割
    //遍历匹配
    var token = "";
    for ( var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        if (arr[0] == "token"){
            token = arr[1];
            return arr[1];
        }
    }
    if(window.location.href.indexOf('contact') == -1){
        if(token == ""){
            window.location.href = '/html/contact.html';  //跳转到首页
        }
    }


    return "";
}
