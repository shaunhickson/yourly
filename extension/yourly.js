$("a").each(function(){
  var server_app = "http://yourly.cfapps.io/"
  var element = $(this);
  var url = element.attr("href");
  var link_text = element.html();
  if (url.indexOf("youtube.com") !== -1 && url == link_text) {
    var id = url.substring(url.indexOf("v=") + 2);
    $.ajax({
        type: "GET",
        async: true, 
        url: server_app + id}).done(function(message, text, jqXHR) {
            new_text = JSON.parse(jqXHR.responseText).title
            element.html(new_text);
        });
    }  
});

























