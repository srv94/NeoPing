var abcdef;

$(document).ready(function() {
	$("#date-popover").popover({
		html : true,
		trigger : "manual"
	});
	$("#date-popover").hide();
	$("#date-popover").click(function(e) {
		$(this).hide();
	});

	$("#my-calendar").zabuto_calendar({
		action : function() {
			return myDateFunction(this.id, false);
		},
		action_nav : function() {
			return myNavFunction(this.id);
		},
		ajax : {
			url : "show_data.php?action=1",
			modal : true
		},
		legend : [ {
			type : "text",
			label : "Special event",
			badge : "00"
		}, {
			type : "block",
			label : "Regular event",
		} ]
	});
	$('#all_env_sidebar a').addClass("active");
	abcdef = setInterval(checkEnvStatus, 5000);
	checkEnvStatus();
});

function myNavFunction(id) {
	$("#date-popover").hide();
	var nav = $("#" + id).data("navigation");
	var to = $("#" + id).data("to");
	console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
}

function setStatus(id, result) {
	if (result == true) {
		$('#status_' + id).html('Up');
		$('#status_' + id).attr('class', '');
		$('#status_' + id).attr('class', 'label label-success label-mini');
	} else {
		$('#status_' + id).html('Down');
		$('#status_' + id).attr('class', '');
		$('#status_' + id).attr('class', 'label label-danger label-mini');
	}

}