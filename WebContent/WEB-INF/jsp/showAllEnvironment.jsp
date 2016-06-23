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
					<div class="col-md-12">
						<div class="content-panel">
							<h4>
								<i class="fa fa-angle-right"></i> All Environments
							</h4>
							<hr>
							<table class="table table-striped table-advance table-hover">


								<thead>
									<tr>
										<th><i class="fa fa-bullhorn"></i> Env. Name</th>
										<th class="hidden-phone"><i class="fa fa-question-circle"></i>
											Location</th>
										<th><i class="fa fa-bookmark"></i> Revision numbers</th>
										<th><i class=" fa fa-edit"></i> Status</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="environment" items="${allEnvironment}" varStatus="i" begin="0" step="1">
										<tr>
											<td><a href="http://${environment.envUrl}/finnone-webapp/app/auth/login" target = "_blank">${environment.envName}</a></td>
											<td class="hidden-phone">${environment.envUrl}</td>
											<td>${ environment.revisionNumber}</td>
											<td><span id="status_${i.index}" class="label label-info label-mini">Running</span></td>
											<td align="right">
												<button class="btn btn-success btn-xs">
													<i class="fa fa-check"></i>
												</button>
												<button class="btn btn-primary btn-xs" onclick="location.href='${baseUrl}/getEnvironmentById/${environment.id}';">
													<i class="fa fa-pencil"></i>
												</button>
												<button class="btn btn-danger btn-xs" onclick="location.href='${baseUrl}/deleteEnvironmentById/${environment.id}';">
													<i class="fa fa-trash-o "></i>
												</button>
												<button class="btn btn-success btn-xs" onclick="location.href='${baseUrl}/environmentDetails/${environment.id}';">
													<i class="fa fa-trash-o "></i> Details
												</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /content-panel -->
					</div>
					<!-- /col-md-12 -->
				</div>
				<!-- /row -->

			</section>
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
            $('#all_env_sidebar a').addClass( "active" );
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
