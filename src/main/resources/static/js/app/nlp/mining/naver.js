
const naverArrow={

  init:function(){
    const _this=this;
    $("#MJI").on('click',function(){_this.selectNaverResult("MJI");});
    $("#YSY").on('click',function(){_this.selectNaverResult("YSY");});
    $("#LNY").on('click',function(){_this.selectNaverResult("LNY");});
    $("#LJM").on('click',function(){_this.selectNaverResult("LJM");});
    $("#HJP").on('click',function(){_this.selectNaverResult("HJP");});
    $("#HKA").on('click',function(){_this.selectNaverResult("HKA");});
  },//init

  selectNaverResult : function(value){

    $.ajax({
        type: "GET",
        url: "/api/nlp/mine/naver/"+value,
        success: function(response) {

              $("#naverContent").empty();
              $("#naverContent").html(response);

              $('#naverTitle').empty();
              $("#naverTitle").append("<h1>LDA 모델링 차트</h1>");

              $('#naverComp').empty();
              $("#naverComp").append("<h1>타 사이트와의 비교</h1>");
              $('#naverComp').append('<img src="/images/'+value+'.png" style="height: auto; width: auto; max-width: 1200px; max-height: 500px;">');

              $('#naverWord').empty();
              $('#naverWord').append("<h1>워드 클라우드</h1>");
              $("#naverWord").append('<img src="/images/Ncloud'+value+'.png" style="height: auto; width: auto; max-width: 580px; max-height: 500px;">');
              $("#naverWord").append('<img src="/images/sometrend'+value+'.png" style="padding-left:10px;height: auto; width: auto; max-width: 580px; max-height: 500px;">');
        }
    });
  }

};//const

$(document).ready(function(){
  naverArrow.init();
});