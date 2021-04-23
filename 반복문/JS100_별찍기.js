var tree_height = prompt();
var t = 1;
for(var i=1;i<tree_height*2;i+=2){
    for(var k=tree_height;k>t;k--){
        document.write("&nbsp");
    }
    for(var j=0;j<i;j++){
        document.write("*");
    }
    document.write("<br/>");
    t++;
}