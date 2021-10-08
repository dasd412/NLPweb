
const twitSelector={


  init:function(){
      const _this=this;
      const ul_list=$("#dataList");
      let page_standard=0;


      $("#reTwitPrev").on('click',function(){
        if (page_standard>0){
          page_standard-=1;
        }
        _this.selectReTwit(ul_list,page_standard);
      });

      $("#reTwitNext").on('click',function(){
         page_standard+=1;
         _this.selectReTwit(ul_list,page_standard);
      });


      $("#twitList").on('click',function(){
        _this.selectTwit(ul_list);
      });

      // _this.selectReTwit(ul_list,page_standard);
  },//init

  selectReTwit : function(ul_list,page_standard){
    $.ajax({
      url:"/api/nlp/reTwit/list/"+page_standard,
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
    }).fail(function(data){
      ul_list.empty();
      swal("that data not found !","error");
    });
  }//select twit of retwit

};//const

$(document).ready(function(){
  twitSelector.init();
});