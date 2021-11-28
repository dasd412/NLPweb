
let latest_week_naver="";
const week_naver_dict={0:"week1_N_",1:"week2_N_",2:"week3_N_",
3:"week4_N_",4:"week5_N_",5:"week6_N_"};
const lda_naver_dict={0:"09220926",1:"10051008",2:"10121015",
                     3:"10181022",4:"10251029",5:"11011105"};
function imgError(image) {
    image.onerror = "";
    image.src = "/images/notFound.png";
    return true;
}

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
    $("#ACS_week").on('click',function(){_this.selectNaverResult("ACS");});
  },//init

  selectNaverResult : function(value){
    if (latest_week_naver!=""){
        $(latest_week_naver).css("background-color","white");
        $(latest_week_naver).css("color","black");
    }
    const selected_week=$("#naver_week_select option:selected").val();
    const selected=week_naver_dict[selected_week]+value;

    $('#naver_word_week').empty();
    $('#naver_word_week').append("<h1>주차별 후보의 네이버 워드 클라우드</h1>");
    $("#naver_word_week").append('<img src="/images/'+selected+'.png" onerror="imgError(this)" style="height: auto; width: auto; max-width: 580px; max-height: 500px;">');

    const params={
        folder:lda_naver_dict[selected_week],
        candidate:value
    };

    $("#naver_word_content").empty();

    $.ajax({
        type: "GET",
        url: "/api/nlp/week/naver/LDA",
        data:params,
        contentType:'application/json;charset=utf-8',
        success: function(response) {
              $("#naver_word_content").html(response);
        }
    });
    const target="#"+value+"_week";

    $(target).css("background-color","pink");
    $(target).css("color","white");
    latest_week_naver=target;
  }

};//const

$(document).ready(function(){
  naverWeekArrow.init();
});