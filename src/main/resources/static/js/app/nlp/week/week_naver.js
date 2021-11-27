
let latest_week_naver="";

const naverWeekArrow={

  init:function(){
    const _this=this;
    $("#MJI_week").on('click',function(){_this.selectNaverResult("MJI");});
    $("#YSY_week").on('click',function(){_this.selectNaverResult("YSY");});
    $("#LNY_week").on('click',function(){_this.selectNaverResult("LNY");});
    $("#LJM_week").on('click',function(){_this.selectNaverResult("LJM");});
    $("#HJP_week").on('click',function(){_this.selectNaverResult("HJP");});
    $("#WHR_week").on('click',function(){_this.selectNaverResult("WHR");});
    $("#RSM_week").on('click',function(){_this.selectNaverResult("RSM");});
  },//init

  selectNaverResult : function(value){
    if (latest_week_naver!=""){
        $(latest_week_naver).css("background-color","white");
        $(latest_week_naver).css("color","black");
    }

//    $.ajax({
//        type: "GET",
//        url: "/api/nlp/mine/naver/"+value,
//        success: function(response) {
//
//
//        }
//    });
    const target="#"+value+"_week";

    $(target).css("background-color","pink");
    $(target).css("color","white");
    latest_week_naver=target;
  }

};//const

$(document).ready(function(){
  naverWeekArrow.init();
});