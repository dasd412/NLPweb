
const twitterArrow={

  init:function(){
    const _this=this;
    const keyWord_dict={0:"MJI",1:"YSY",2:"LNY",3:"LJM",4:"HJP",5:"HKA"};

    const name_dict={"MJI":"문재인","YSY":"윤석열","LNY":"이낙연","LJM":"이재명","HJP":"홍준표","HKA":"황교안"};

    $("#twitterPrev").on('click',function(){
      let keyWord_index=parseInt($("#keywordIndexTwitter").val());
      if(keyWord_index>0){
        keyWord_index-=1;
        $("#keywordIndexTwitter").val(parseInt(keyWord_index));
      }
      _this.selecttwitterResult(keyWord_index,keyWord_dict,name_dict);
    });

    $("#twitterNext").on('click',function(){
      let keyWord_index=parseInt($("#keywordIndexTwitter").val());
      if(keyWord_index<5){
        keyWord_index+=1;
         $("#keywordIndexTwitter").val(parseInt(keyWord_index));
      }
      _this.selecttwitterResult(keyWord_index,keyWord_dict,name_dict);
    });

    let keyWord_index=parseInt($("#keywordIndexTwitter").val());
     _this.selecttwitterResult(keyWord_index,keyWord_dict,name_dict);

  },//init

  selecttwitterResult : function(keyWord_index,keyWord_dict,name_dict){

    value=keyWord_dict[keyWord_index];

    $.ajax({
        type: "GET",
        url: "/api/nlp/mine/twitter/"+value,
        success: function(response) {
              $("#twitterContent").empty();
              $("#twitterContent").html(response);
        }
    });

    $("#keywordTwitter").text(name_dict[value]);
    img_url="/images/"+value+".png";
    $("#comparisonTwitter").attr("src", img_url);

  }

};//const

$(document).ready(function(){
  twitterArrow.init();
});