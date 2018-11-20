<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Charts</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/echarts.common.min.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="echarts.common.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Lumino</span>Admin</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-cog"></span> Settings</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<li><a href="index.html"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
			<li><a href="widgets.html"><span class="glyphicon glyphicon-th"></span> Widgets</a></li>
			<li class="active"><a href="charts.html"><span class="glyphicon glyphicon-stats"></span> Charts</a></li>
			<li><a href="tables.html"><span class="glyphicon glyphicon-list-alt"></span> Tables</a></li>
			<li><a href="forms.html"><span class="glyphicon glyphicon-pencil"></span> Forms</a></li>
			<li><a href="panels.html"><span class="glyphicon glyphicon-info-sign"></span> Alerts &amp; Panels</a></li>
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> Dropdown <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 1
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
			<li><a href="login.html"><span class="glyphicon glyphicon-user"></span> Login Page</a></li>
		</ul>
		<div class="attribution">Template by <a href="http://www.medialoot.com/item/lumino-admin-bootstrap-template/">Medialoot</a></div>
	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">Charts</li>
			</ol>
		</div><!--/.row-->
		
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Line Chart</div>
					<div class="panel-body" >
					<div id="main" style="width: 859px; height: 400px; margin: 10px auto;" ></div>
					</div>
					
				</div>
			</div>
		</div><!--/.row-->
	</div>

	<script src="js/echarts.common.min.js"></script>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>

	<script type="text/javascript">
	$(function() {
        $(document).ready(
            function() {
                Highcharts.setOptions({
                    global : {
                        useUTC : false
                    }
                });
                $('#main').highcharts(
                    {
                        chart : {
                            type : 'spline',
                            animation : Highcharts.svg, // don't animate in old IE
                            marginRight :5,
                            events : {
                                load : function() {
                                    // set up the updating of the chart each second
                                    var series = this.series;
                                    setInterval(function() {
                                        $.get('<%=request.getContextPath()%>/listSensor.do', function( response) {
                                            var x = (new Date()).getTime();// current time
                                            //var y = $.each(data)["mq2"];
                                            var obj = JSON.parse(response);
                                            var y = parseFloat(obj[0].tEM);
                                            //alert(y);
                                            series[0].addPoint([ x, y ],
                                                true, true);
                                        });
                                    }, 1000);
                                }
                            }
                        },
                        title : {
                            text : ''
                        },
                        xAxis : {
                            type : 'datetime',
                            tickPixelInterval : 100
                        },
                        yAxis : {
                            title : {
                                text : '烟雾/ppm'
                            },
                            plotLines : [ {
                                value : 0,
                                width : 1,
                                color:'rgba(0,0,255,0.5)'
                            } ]
                        },
                        tooltip : {
                            formatter : function() {
                                return '<b>'
                                    + this.series.name
                                    + '</b><br/>'
                                    + Highcharts.dateFormat(
                                        '%Y-%m-%d %H:%M:%S',
                                        this.x)
                                    + '<br/>'
                                    +Highcharts.numberFormat(
                                        this.y, 2);
                            }
                        },
                        legend: {
                            align: 'left',
                            verticalAlign: 'top',
                            y: 0,
                            floating: true,
                            borderWidth: 0
                        },
                        exporting : {
                            enabled : false
                        },
                        series : [ {
                            name : 'Mq2',
                            color:'rgba(0,255,0,0.5)',
                            data : (function() {
                                // generate an array of random data
                                var data = [], time = (new Date())
                                    .getTime(), i;

                                for (i = -19; i <= 0; i++) {
                                    data.push({
                                        x : time + i * 1000,
                                        y : Math.random()
                                    });
                                }
                                return data;
                            })()
                        }]
                    });
            });

    });
    // 基于准备好的dom，初始化echarts实例
		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>
