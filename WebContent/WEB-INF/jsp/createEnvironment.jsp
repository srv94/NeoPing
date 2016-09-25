<%@include file="taglib_includes.jsp"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="head.jsp"%>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->

		<%@include file="header.jsp"%>

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<%@include file="sidebar.jsp"%>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> Add/Edit New Environment
				</h3>

				<!-- BASIC FORM ELELEMNTS -->
				<div class="row mt">
					<div class="col-lg-12">
						<div class="form-panel">
							<h4 class="mb">
								<i class="fa fa-angle-right"></i> Add/Edit New Environment
							</h4>
							<form:form action="${baseUrl}/saveEnvironment"
								class="form-horizontal style-form" method="post"
								commandName="environment">
								<form:input path="keyId" type="hidden" class="form-control" />
								<form:input path="id" type="hidden" class="form-control" />
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Environment
										Type</label>
									<div class="col-sm-10">
										<form:radiobutton path="environmentType" value="CAS" />
										CAS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<form:radiobutton path="environmentType" value="LMS" />
										LMS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<form:radiobutton path="environmentType" value="INTEGRATION" />
										INTEGRATION
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Environment
										Name</label>
									<div class="col-sm-10">
										<form:input path="envName" type="text" class="form-control"
											placeholder="Enter Environment Name" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Environment
										Url</label>
									<div class="col-sm-10">
										<form:input path="envUrl"
											placeholder="Enter Environment Url ( Expl. For CAS - 10.1.61.133:6688/finnone-webapp and for LMS - 10.1.60.247:5599/finnone-LMS) No htttp or www"
											type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Revision
										Number</label>
									<div class="col-sm-8">
										<form:input path="revisionNumber"
											placeholder="Enter Current Revision Number" type="text"
											class="form-control" />
									</div>
									<div class="col-sm-2">
										<button type="button"
											class="btn btn-info btn-default btn-block" id="getEnvDetails"
											onclick="getBuildDetails();">Get Details</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Build
										Number</label>
									<div class="col-lg-10">
										<p id="StaBuildNumber" class="form-control-static"></p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Job Name</label>
									<div class="col-lg-10">
										<p id="staJobName" class="form-control-static"></p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Creation
										Time</label>
									<div class="col-lg-10">
										<p id="staCreateTime" class="form-control-static"></p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log
										Details :</label>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log Host
										Name</label>
									<div class="col-sm-10">
										<form:input path="envLogUrl" type="text" class="form-control"
											placeholder="Enter log host name" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log User
										Name</label>
									<div class="col-sm-10">
										<form:input path="envLogUser" type="text" class="form-control"
											placeholder="Enter Logs User Name" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log
										Password</label>
									<div class="col-sm-10">
										<form:input path="envLogPass" type="text" class="form-control"
											placeholder="Enter Log Password" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log Path</label>
									<div class="col-sm-10">
										<form:input path="envLog" type="text" class="form-control"
											placeholder="Enter Log Path" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">War
										Location</label>
									<div class="col-sm-10">
										<form:input path="envWar" type="text" class="form-control"
											placeholder="Enter WAR Location" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Server
										Log Path</label>
									<div class="col-sm-10">
										<form:input path="envServerLog" type="text"
											class="form-control" placeholder="Enter Server Log path" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">DB
										Details :</label>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">DB Host</label>
									<div class="col-sm-10">
										<form:input path="dbUrl" type="text" class="form-control"
											placeholder="DB server Host URL" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">User
										Name</label>
									<div class="col-sm-10">
										<form:input path="dbUser" type="text" class="form-control"
											placeholder="DB server User Name" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">User
										Password</label>
									<div class="col-sm-10">
										<form:input path="dbPass" type="text" class="form-control"
											placeholder="DB Server Password" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">DB
										Schema</label>
									<div class="col-sm-10">
										<form:input path="dbSchema" type="text" class="form-control"
											placeholder="DB Schema Name" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-0"></label>
									<div class="col-sm-12">
										<button type="submit"
											class="btn btn-info btn-default btn-block" id="addButton">Add
											New Env</button>
									</div>
								</div>

							</form:form>
						</div>
					</div>
					<!-- col-lg-12-->
				</div>

			</section>
			<!-- --/wrapper ---->
		</section>

		<!--main content end-->
		<!--footer start-->
		<%@include file="footer.jsp"%>
		<!--footer end-->
	</section>

	<script type="text/javascript">
		/* $(document)
				.ready(
						function() {
							var unique_id = $.gritter
									.add({
										// (string | mandatory) the heading of the notification
										title : 'Welcome to Dashgum!',
										// (string | mandatory) the text inside the notification
										text : 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
										// (string | optional) the image to display on the left
										image : '<c:url value="/assets/img/ui-sam.jpg" />',
										// (bool | optional) if you want it to fade out on its own or just sit there
										sticky : true,
										// (int | optional) the time you want it to be alive for before fading out
										time : '',
										// (string | optional) the class name you want to apply to that specific message
										class_name : 'my-sticky-class'
									});

							return false;
						}); */
	</script>

	<script type="application/javascript">
		
		
		
		
		
		
		
		
		
		
		
		
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
            $('#add_environment_sidebar a').addClass( "active" );
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
        
        function getBuildDetails(){
        	var user = $('#envLogUser').val();
        	var password = $('#envLogPass').val();
        	var host = $('#envLogUrl').val();
        	var remotePath = $('#envWar').val();
        	$.ajax({
  			  url: "${baseUrl}/api/buildDetials",
  			  data : "user="+user+"&password="+password+"&host="+host+"&remotePath="+remotePath,
  			  success: function(data){
  			    $('#revisionNumber').val(data[0]);
  			 	$('#StaBuildNumber').html(data[1]);
  				$('#staJobName').html(data[2]);
  				$('#staCreateTime').html(data[3]);
  			    
  			  }
  			});
        }
    
	
	
	
	
	
	
	
	
	
	
	
	</script>


</body>
</html>
