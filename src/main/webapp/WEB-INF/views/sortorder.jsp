<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
    <meta name="viewport" content ="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resource/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resource/bootstrap/css/style.css">
    <link rel="stylesheet" id="font-awesome-css" href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" type="text/css" media="screen">
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>

    <title>Order</title>
    <title>Zappos Warehouse Order Sorter Program</title>
    </head>
    <body>
    <div class="navbar-static-top navbar-inverse navbar-fixed-top" role="navigation" id="home">
        <div class="container">
            <div class="navbar-brand">
                <img src="/resource/bootstrap/images/zapposLogoBlue.png" img-responsive img-left alt="logo"/>
            </div>
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
                Menu
            </button>
            <div class="collapse navbar-collapse navHeaderCollapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#viewOrder">View Order</a></li>
                    <li><a href="#siteManager">Site Manager</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="scroll-top-wrapper ">
        <span class="scroll-top-inner">
            <i class="fa fa-2x fa-arrow-circle-up"></i>
        </span>
    </div>
    <section class="sortOrder" ng-app="sortOrderApp">
    	<div ng-controller="sortOrderCtrl">
            <div class="jumbotron padding">
            </div>
            <div>
                <br>
                    <div class="row ">
                        <div class="col-md-4">
                        <button type="button" class="btn btn-primary btn-lg" id="viewOrder"
                            ng-click="randomOrder()">
                            <div ng-show="goCats">loading...</div>
                            <div ng-show="!goCats">Sort Random Order</div>
                        </button>
                            <div class="checkbox">
                                <label><input type="checkbox" ng-model="houseware" ng-true-value="1" ng-false-value="0">Remove Housewares</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                                <p>Order Number:  {{order.orderNumber}} </p>
                                <p>Customer Name: {{header.nameGen}} </p>
                                <p>Number of Boxes: {{order.numOfBoxes}} </p>
                        </div>
                    </div>
                </br>
            </div>
    		<div>
                <br>
    			    <div class="row" ng-repeat="box in order.boxes">
    			        <div class="col-md-2">
    			            <h1 ng-click="boxview=!boxview"><i class="glyphicon glyphicon-expand" ng-show="!boxview"></i><i class="glyphicon glyphicon-collapse-down" ng-show="boxview"></i>  Box {{box.boxId}}</h1>
                        </div>
                            <div ng-show="boxview">
                                <div class="col-md-8 padding">
                                    <table class="table table-hover">
                                        <tr ng-click="viewable=!viewable">
                                            <th class="col-md-4">Item Name</th>
                                            <th class="col-md-3">Item Type</th>
                                            <th class="col-md-2">SKU#</th>
                                            <th class="col-md-3">Item Size</th>
                                        </tr>
                                        <tr ng-repeat="item in box.boxItems" ng-show="viewable">
                                            <td class="col-md-4">{{item.name}}</td>
                                            <td class="col-md-3">{{item.itemType}}</td>
                                            <td class="col-md-2">{{item.sku}}</td>
                                            <td class="col-md-3">{{item.size}}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                    </div>
    		    </div>
    		</div>
        </div>
            <div class="siteManager padding" id="siteManager">
                <div class="container">
                </div>
            </div>
            <div class="footer">
                <div class="container">
                </div>
            </div>
    </section>


    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="/resource/bootstrap/js/bootstrap.js"></script>
    <script>
    $(function() {
      $('a[href*=#]:not([href=#])').click(function() {
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
          var target = $(this.hash);
          target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
          if (target.length) {
            $('html,body').animate({
              scrollTop: target.offset().top
            }, 1000);
            return false;
          }
        }
      });
    });
    </script>
    <script>
    $(function(){
        $(document).on( 'scroll', function(){
            if ($(window).scrollTop() > 100) {
                $('.scroll-top-wrapper').addClass('show');
            } else {
                $('.scroll-top-wrapper').removeClass('show');
            }
        });
    });
    </script>
    <script>
    $(function(){
        $(document).on( 'scroll', function(){
            if ($(window).scrollTop() > 100) {
                $('.scroll-top-wrapper').addClass('show');
            } else {
                $('.scroll-top-wrapper').removeClass('show');
            }
        });
        $('.scroll-top-wrapper').on('click', scrollToTop);
    });
    function scrollToTop() {
        verticalOffset = typeof(verticalOffset) != 'undefined' ? verticalOffset : 0;
        element = $('body');
        offset = element.offset();
        offsetTop = offset.top;
        $('html, body').animate({scrollTop: offsetTop}, 500, 'linear');
    }
    </script>
    </body>
</html>

