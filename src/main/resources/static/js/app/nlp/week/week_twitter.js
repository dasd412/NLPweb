
let latest_week_twitter="";
const week_twitter_dict={0:"week1_T_",1:"week2_T_",2:"week3_T_",
3:"week4_T_",4:"week5_T_",5:"week6_T_"};

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

    $('#twitter_word_week').empty();
    $('#twitter_word_week').append("<h1>주차별 후보의 트위터 워드 클라우드</h1>");
    $("#twitter_word_week").append('<img src="/images/'+selected+'.png" style="height: auto; width: auto; max-width: 580px; max-height: 500px;">');

    const target="#"+value+"_week_T";

    $(target).css("background-color","pink");
    $(target).css("color","white");
    latest_week_twitter=target;
  }

};//const

$(document).ready(function(){
  twitterWeekArrow.init();
});