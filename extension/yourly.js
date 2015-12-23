$("a").each(function(){
  var server_app = "http://yourly.cfapps.io/"
  var url = $(this).attr("href");
  console.log(url);
  if (url.indexOf("youtube.com") !== -1) {
    var id = url.substring(url.indexOf("v=") + 2);
    console.log(id);
    $.ajax({
        type: "GET",
        async: true, 
        url: server_app + id}).done(function(message, text, jqXHR) {
            console.log(jqXHR);
        });
    }  
});


























