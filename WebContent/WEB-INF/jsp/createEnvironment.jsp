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
					<i class="fa fa-angle-right"></i> Form Components
				</h3>

				<!-- BASIC FORM ELELEMNTS -->
				<div class="row mt">
					<div class="col-lg-12">
						<div class="form-panel">
							<h4 class="mb">
								<i class="fa fa-angle-right"></i> Form Elements
							</h4>
							<form:form action="saveEnvironment"
								class="form-horizontal style-form" method="post"
								commandName="environment">
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Environment
										Name</label>
									<div class="col-sm-10">
										<form:input path="envName" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Environment
										Url</label>
									<div class="col-sm-10">
										<form:input path="envUrl" placeholder="Enter Env Name"
											type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log
										Details :</label>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log Host Name</label>
									<div class="col-sm-10">
										<form:input path="envLogUrl" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log User Name</label>
									<div class="col-sm-10">
										<form:input path="envLogUser" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log Password</label>
									<div class="col-sm-10">
										<form:input path="envLogPass" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Log Path</label>
									<div class="col-sm-10">
										<form:input path="envLog" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">War Location</label>
									<div class="col-sm-10">
										<form:input path="envWar" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Server Log Path</label>
									<div class="col-sm-10">
										<form:input path="envServerLog" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">DB
                Details :</label>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">DB Host</label>
									<div class="col-sm-10">
										<form:input path="dbUrl" type="text" class="form-control" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">User
										Name</label>
									<div class="col-sm-10">
										<form:input path="dbUser" type="text" class="form-control" />
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
    
	
	
	
	</script>


</body>
</html>
