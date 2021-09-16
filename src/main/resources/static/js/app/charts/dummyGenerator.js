
const generator={

  init:function(){
    const _this=this;
    const randomSet=document.querySelector('#randomSet');

    $('#randomSet').on('click',function(){
      _this.generateRandomData();
    });
  },//init function

  generateRandomData : function(){
    $.ajax({
      url:"/api/nlp/charts/randomset",
      type:'get',
      dataType:'json',
      contentType:'application/json;charset=utf-8'
    }).done(function(data){
      const e=data.response;

      approvalRatings=[];
      comment=[];

      for(i=0;i<e.length;i++){
        approvalRatings.push(e[i].approvalRating);
        comment.push(e[i].comment);
      }

      localStorage.setItem('approvalRatings',JSON.stringify(approvalRatings));
      localStorage.setItem('comment',JSON.stringify(comment));

      //localComment=(localStorage.getItem('comment');
    });
  }//generate random data function

};


$(document).ready(function(){
  generator.init();
});