
const naverArrow={

  init:function(){
    const _this=this;
    const keyWord_dict={0:"MJI",1:"YSY",2:"LNY",3:"LJM",4:"HJP",5:"HKA"};

    $("#naverPrev").on('click',function(){
      let keyWord_index=$("#keywordIndex").val();
      if(keyWord_index>0){
        keyWord_index-=1;
        $("#keywordIndex").val(keyWord_index);
      }
      _this.selectNaverResult(keyWord_index,keyWord_dict);
    });

    $("#naverNext").on('click',function(){
      if(keyWord_index<5){
        keyWord_index+=1;
        $("#keywordIndex").val(keyWord_index);
      }
      _this.selectNaverResult(keyWord_index,keyWord_dict);
    });
  },//init

  selectNaverResult : function(keyWord_index,keyWord_dict){

    swal("clicked",keyWord_index,keyWord_dict[keyWord_index]);

    value=keyWord_dict[keyWord_index];
    location.href="/api/nlp/mine/naver/"+value;
  }

};//const

$(document).ready(function(){
  naverArrow.init();
});