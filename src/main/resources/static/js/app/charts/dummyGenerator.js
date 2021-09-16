
const generator={

  init:function(){
    const _this=this;
    const randomSet=document.querySelector('#randomSet');

    $('#randomSet').on('click',function(){
      _this.generateRandomData();
    });
  },

  generateRandomData : function(){
    console.log('test function');
  }

};


$(document).ready(function(){
  generator.init();
});