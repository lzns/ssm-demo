function test1(){
    $.ajax({
        type:'post',
        url:'json/test1',
        dataType:'json',
        success:function(text){
            /*var code = text.code;
            var desc = text.desc;
            alert(code+desc);
            var obj = text.data;
            alert(obj.name + obj.age);
            var str = JSON.stringify(text);
            alert(str);*/
            alert(text);
            for (var i = 0;i<text.length;i++){
                var name = text[i].name;
                var age = text[i].age;
                alert(name + ":" + age);
            }

        },
        error:function(data){
            alert("后台发生异常，请联系管理员！");
        },
        asyn:false,
        cache:false
    });
}
function test2(){
    $.ajax({
        type:'post',
        url:'json/test2',
        dataType:'json',
        success:function(text){
            alert(text);
            alert(text.code+text.desc);
        },
        error:function(text){
            alert("后台发生异常！");
        },
        async:false,
        cache:false
    });
}
function test3(){
    var json = '{"name":"李四","age":"23"}';
    var $json = eval("("+json+")");
    alert(typeof($json));//object
    alert($json.name);//李四
}
function test4(){
    $.ajax({
        type:'post',
        url:'json/test4',
        dataType:'json',
        data:{name:"丁振锋",age:"323"},
        success:function(text){
            if(text!=null){
                alert(typeof(text));
                alert(text.desc);
            }
        },
        error:function(text){
            alert("后台发生异常！");
        },
        async:false,
        cache:false
    });
}
function test6(){
    $.ajax({
        type:'post',
        url:'json/test6',
        contentType:'application/x-result',
        data:{code:"200",desc:"我是丁振锋"},
        success:function(text){
            alert(text);
        },
        error:function(data){
            alert("后台异常！")
        },
        async:false,
        cache:false
    });
}