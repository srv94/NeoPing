$(document).ready(function (){
	checkAllEnv();
});
function checkAllEnv(){
	$.ajax({
		   url: baseUrl+'/checkStatus',
		   error: function() {
		   },
		   success: function(data) {
		      for (var i = 0; i < data.length; i++) {
		    	    if(data[i]){
		    	    	$('#status_'+i).html('Running');
		    	    }else{
		    	    	$('#status_'+i).html('Down');
		    	    }
		    	}
		   },
		   type: 'GET'
		});
}