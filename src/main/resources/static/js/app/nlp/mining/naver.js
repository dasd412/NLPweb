
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

              $('#naverComp').empty();
              $('#naverComp').append('<img src="/images/'+value+'.png" style="height: auto; width: auto; max-width: 1200px; max-height: 500px;">');

              $('#naverWord').empty();
              $("#naverWord").append('<img src="/images/Ncloud'+value+'.png" style="height: auto; width: auto; max-width: 580px; max-height: 500px;">');
              $("#naverWord").append('<img src="/images/sometrend'+value+'.png" style="padding-left:10px;height: auto; width: auto; max-width: 580px; max-height: 500px;">');
        }
    });
  }

};//const

$(document).ready(function(){
  naverArrow.init();
});