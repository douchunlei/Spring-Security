$(function(){
/*<![CDATA[*/
    var errorMessage = [[${errors}]];  
    console.log(errorMessage);
    if(errorMessage != null){
	    for(i = 0; i< errorMessage.length; i++){
	    		var filed = errorMessage[i].field;
	    		var message = errorMessage[i].defaultMessage;
	    		$("input[name='"+ filed +"']").addClass("error-tip");
	    		$("input[name='"+ filed +"']").after("<div><p class='error-tip'>"+ message +"</p></div>");
	    }
    }
  
/*]]>*/  
});