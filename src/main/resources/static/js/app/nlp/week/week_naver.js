
let latest_week_naver="";
const week_naver_dict={0:"2021-09-22-2021-09-26-",1:"2021-10-05-2021-10-08-",2:"2021-10-11-2021-10-15-",
3:"2021-10-18-2021-10-22-",4:"2021-10-25-2021-10-29-",5:"2021-11-01-2021-11-05-"};

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
    const selected_week=$("#naver_week_select option:selected").val();

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