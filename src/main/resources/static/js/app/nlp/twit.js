
const twitSelector={

  init:function(){
      const _this=this;
      const ul_list=$("#dataList");
      $("#reTwitList").on('click',function(){
        _this.selectReTwit(ul_list);
      });

      $("#twitList").on('click',function(){
        _this.selectTwit(ul_list);
      });
  },//init

  selectReTwit : function(ul_list){
    const value=$("#reTwitStart").val();
    $.ajax({
      url:"/api/nlp/reTwit/list/"+value,
      type:"get",
      dataType:"json",
      contentType:"application/json;charset=utf-8"
    }).done(function(data){
      const e=data.response;
      console.log(JSON.stringify(e));

      ul_list.empty();

      for(let i=0;i<e.length;i++){
        ul_list.append("<li class=\"list-group-item\">"+JSON.stringify(e[i])+"</li>");
      }

    });
  },//select retwit

  selectTwit : function(ul_list){
    const value=$("#reTwitId").val();

    $.ajax({
      url: "/api/nlp/twit/list/"+value,
      type:"get",
      dataType:"json",
      contentType:"application/json;charset=utf-8"
    }).done(function(data){
      const e=data.response;
      console.log(JSON.stringify(e));

      ul_list.empty();

      for(let i=0;i<e.length;i++){
        ul_list.append("<li class=\"list-group-item\">"+JSON.stringify(e[i])+"</li>");
      }
    });
  }//select twit of retwit

};//const

$(document).ready(function(){
  twitSelector.init();
});