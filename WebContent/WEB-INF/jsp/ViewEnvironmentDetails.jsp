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
				<div class="row mt">
					<div class="col-lg-12">
						<div class="form-panel">
							<h4 class="mb">
								<i class="fa fa-angle-right"></i> Environment Details
							</h4>
							<form method="get" class="form-horizontal style-form">
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Environment
										Name</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.envName}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Environment
										Url</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.envUrl}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Revision
										Number</label>
									<div class="col-lg-8">
										<p class="form-control-static" id="revisionNumber">${environment.revisionNumber}</p>
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
									<label class="col-lg-2 col-sm-2 control-label">Log Host</label>
									<div class="col-lg-10">
										<p id="envLogUrl" class="form-control-static">${environment.envLogUrl}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Log User
										Name</label>
									<div class="col-lg-10">
										<p id="envLogUser" class="form-control-static">${environment.envLogUser}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Log
										Password</label>
									<div class="col-lg-10">
										<p id="envLogPass" class="form-control-static">${environment.envLogPass}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Environment
										Log Path</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.envLog}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">War Path</label>
									<div class="col-lg-10">
										<p id="envWar" class="form-control-static">${environment.envWar}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">Server
										Log Path</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.envServerLog}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">DB Host</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.dbUrl}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">DB User
										Name</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.dbUser}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">DB
										Password</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.dbPass}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 col-sm-2 control-label">DB
										Schema</label>
									<div class="col-lg-10">
										<p class="form-control-static">${environment.dbSchema}</p>
									</div>
								</div>


							</form>
						</div>
					</div>
					<!-- col-lg-12-->
				</div>

			</section>
		</section>

		<!--main content end-->
		<!--footer start-->
		<%@include file="footer.jsp"%>
		<!--footer end-->
	</section>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							
						}); 
	</script>

	<script type="application/javascript">
		
		
		
		

    function getBuildDetails(){
    	var user = $('#envLogUser').html();
    	var password = $('#envLogPass').html();
    	var host = $('#envLogUrl').html();
    	var remotePath = $('#envWar').html();
    	$.ajax({
			  url: "${baseUrl}/api/buildDetials",
			  data : "user="+user+"&password="+password+"&host="+host+"&remotePath="+remotePath,
			  success: function(data){
			    $('#revisionNumber').htnl(data[0]);
			 	$('#StaBuildNumber').html(data[1]);
				$('#staJobName').html(data[2]);
				$('#staCreateTime').html(data[3]);
			    
			  }
			});
    }
		
		
		
		
        $(document).ready(function () {
        
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    
	
	
	
	
	
	
	
	
	</script>

	<script src="<c:url value="/assets/js/other/showAllEnvironment.js" />"></script>
</body>
</html>