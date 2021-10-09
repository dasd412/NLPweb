
const naverArrow={

  init:function(){
    const _this=this;
    const keyWord_dict={0:"MJI",1:"YSY",2:"LNY",3:"LJM",4:"HJP",5:"HKA"};

    const name_dict={"MJI":"문재인","YSY":"윤석열","LNY":"이낙연","LJM":"이재명","HJP":"홍준표","HKA":"황교안"};
    $("#naverPrev").on('click',function(){
      let keyWord_index=parseInt($("#keywordIndex").val());
      if(keyWord_index>0){
        keyWord_index-=1;
        $("#keywordIndex").val(parseInt(keyWord_index));
      }
      _this.selectNaverResult(keyWord_index,keyWord_dict,name_dict);
    });

    $("#naverNext").on('click',function(){
      let keyWord_index=parseInt($("#keywordIndex").val());
      if(keyWord_index<5){
        keyWord_index+=1;
         $("#keywordIndex").val(parseInt(keyWord_index));
      }
      _this.selectNaverResult(keyWord_index,keyWord_dict,name_dict);
    });

    let keyWord_index=parseInt($("#keywordIndex").val());
    _this.selectNaverResult(keyWord_index,keyWord_dict,name_dict);
  },//init

  selectNaverResult : function(keyWord_index,keyWord_dict,name_dict){

    value=keyWord_dict[keyWord_index];

    $.ajax({
        type: "GET",
        url: "/api/nlp/mine/naver/"+value,
        success: function(response) {
              $("#naverContent").empty();
              $("#naverContent").html(response);
        }
    });

    $("#keywordNaver").text(name_dict[value]);
    img_url="/images/"+value+".png";
    $("#comparisonNaver").attr("src", img_url);
  }

};//const

$(document).ready(function(){
  naverArrow.init();
});