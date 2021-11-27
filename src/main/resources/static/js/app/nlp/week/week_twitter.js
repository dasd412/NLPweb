
let latest_week_twitter="";

const twitterWeekArrow={

  init:function(){
    const _this=this;
    $("#MJI_week_T").on('click',function(){_this.selectTwitterResult("MJI");});
    $("#YSY_week_T").on('click',function(){_this.selectTwitterResult("YSY");});
    $("#LNY_week_T").on('click',function(){_this.selectTwitterResult("LNY");});
    $("#LJM_week_T").on('click',function(){_this.selectTwitterResult("LJM");});
    $("#HJP_week_T").on('click',function(){_this.selectTwitterResult("HJP");});
    $("#WHR_week_T").on('click',function(){_this.selectTwitterResult("WHR");});
    $("#RSM_week_T").on('click',function(){_this.selectTwitterResult("RSM");});
  },//init

  selectTwitterResult : function(value){
    if (latest_week_twitter!=""){
        $(latest_week_twitter).css("background-color","white");
        $(latest_week_twitter).css("color","black");
    }

//    $.ajax({
//        type: "GET",
//        url: "/api/nlp/mine/naver/"+value,
//        success: function(response) {
//
//
//        }
//    });
    const target="#"+value+"_week_T";

    $(target).css("background-color","pink");
    $(target).css("color","white");
    latest_week_twitter=target;
  }

};//const

$(document).ready(function(){
  twitterWeekArrow.init();
});