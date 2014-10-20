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
    <div class="navbar-static-top navbar-inverse" id="home">
        <div class="container">
            <div class="navbar-brand">
                <img src="/resource/bootstrap/images/zapposLogoBlue.png" img-responsive img-left" alt="logo"/>
            </div>
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
                Menu
            </button>
            <div class="collapse navbar-collapse navHeaderCollapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#viewOrder">View Order</a></li>
                    <li><a href="#siteManager">Site Manager</a></li>
                    <li><a href="#weather">Weather</a></li>
                    <li><a href="#tetris">Tetris</a></li>
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
            <div class="jumbotron">
            </div>
            <div>
                <div class="row padding">
                        <div class=".col-md-2">
                            <button type="button" class="btn btn-primary btn-lg"
                                ng-click="randomOrder()">
                                <div ng-show="goCats">loading...</div>
                                <div ng-show="!goCats">Sort Random Order</div>
                            </button>
                            <div class="checkbox">
                                <label><input type="checkbox"> Remove Housewares</label>
                            </div>
                        </div>
                        <div class=".col-md-8">
                            <div class="container" id="viewOrder">
                                <h1>Name: {{header.nameGen}} </h1>
                                    <p>Order Number:  {{order.orderNumber}} </p>
                                    <p>Number of Boxes: {{order.numOfBoxes}} </p>
                            </div>
                        </div>
                </div>
            <div>
    		<div>
                <br>
    			    <div class="row" ng-repeat="box in order.boxes">
    			        <div class='col-md-1'>
    			            <h1>Box {{box.boxId}}</h1>
                        </div>
                        <div class="col-md-2">
                            <img src="/resource/bootstrap/images/zapposBox.png" alt="box"/>
                        </div>
                        <div class="col-md-8">
                            <table class="table table-hover">
                                <tr>
                                    <th>Item Name</th>
                                    <th>Item Type</th>
                                    <th>SKU#</th>
                                    <th>Item Size</th>
                                </tr>
                                    <tr ng-repeat="item in box.boxItems">
                                    <td>{{item.name}}</td>
                                    <td>{{item.itemType}}</td>
                                    <td>{{item.sku}}</td>
                                    <td>{{item.size}}</td>
                                </tr>
                            </table>
                        </div>
                    </div>
    		    </div>
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

