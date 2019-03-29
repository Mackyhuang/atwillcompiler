<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>At Will Compiler</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
    #container{
        display: flex;
        flex-direction: row;
    }
    #editorDiv{
        flex:12;
        min-height: 800px;
    }
    #showDiv{
        flex:9;
        min-height: 800px;
        width:600px;
    }
    #run-btn{
        margin-left: 10px;
        margin-right: 10px;
        flex:0.8;
        padding-top: 700px;
    }
    div{
        display: inline-block;
    }
</style>
<body>
<div id="container">
    <div id="editorDiv">
        #include
    </div>
    <div id="run-btn">
        <button class="btn-info" id="run">运行</button>
    </div>
    <div id="showDiv"></div>
</div>
</body>
<script src="src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="src-noconflict/ext-language_tools.js" type="text/javascript"></script>
<script src="src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
<script src="src-noconflict/ext-language_tools.js" type="text/javascript"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    var editor = ace.edit("editorDiv");
    //设置编辑器样式，对应theme-*.js文件
    editor.setTheme("ace/theme/twilight");
    //设置代码语言，对应mode-*.js文件
    editor.session.setMode("ace/mode/java");
    //设置打印线是否显示
    editor.setShowPrintMargin(false);
    //设置是否只读
    editor.setReadOnly(false);

    //以下部分是设置输入代码提示的，如果不需要可以不用引用ext-language_tools.js
    ace.require("ace/ext/language_tools");
    editor.setOptions({
        enableBasicAutocompletion: true,
        enableSnippets: true,
        enableLiveAutocompletion: true
    });
    var show = ace.edit("showDiv");
    //设置编辑器样式，对应theme-*.js文件
    show.setTheme("ace/theme/twilight");
    show.setReadOnly(true);
</script>
<script>
    //    editor.setValue("the new text here");
    //    editor.getValue();
    $("#run").click(function () {
        $.ajax({
            type: "POST",
            url: "run",
            dataType: "json",
            data: {
                "codeinfo": editor.getValue(),
            },
            success: function (data) {
                alert(data.info)
                show.setValue(data.info);
            },
            error: function () {
                alert("服务器在开小差噢");
            }
        })
    })
</script>

</html>