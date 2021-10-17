
const twitterArrow={

  init:function(){
    const _this=this;
    $("#Tw_MJI").on('click',function(){_this.selecttwitterResult("MJI");});
    $("#Tw_YSY").on('click',function(){_this.selecttwitterResult("YSY");});
    $("#Tw_LNY").on('click',function(){_this.selecttwitterResult("LNY");});
    $("#Tw_LJM").on('click',function(){_this.selecttwitterResult("LJM");});
    $("#Tw_HJP").on('click',function(){_this.selecttwitterResult("HJP");});
    $("#Tw_HKA").on('click',function(){_this.selecttwitterResult("HKA");});
  },//init

  selecttwitterResult : function(value){

    $.ajax({
        type: "GET",
        url: "/api/nlp/mine/twitter/"+value,
        success: function(response) {
              $("#twitterContent").empty();
              $("#twitterContent").html(response);

              $('#twitterComp').empty();
              $('#twitterComp').append('<img src="/images/'+value+'.png" style="height: auto; width: auto; max-width: 1200px; max-height: 500px;">');

              $('#twitterWord').empty();
              $("#twitterWord").append('<img src="/images/cloud'+value+'.png" style="height: auto; width: auto; max-width: 580px; max-height: 500px;">');
              $("#twitterWord").append('<img src="/images/sometrend'+value+'.png" style="padding-left:10px;height: auto; width: auto; max-width: 580px; max-height: 500px;">');

        }
    });
  }

};//const

$(document).ready(function(){
  twitterArrow.init();
});