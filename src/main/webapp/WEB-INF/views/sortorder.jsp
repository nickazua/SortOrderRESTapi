<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
    <meta name="viewport" content ="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resource/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resource/bootstrap/css/style.css">
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
                    <li><a href="#">View Order</a></li>
                    <li><a href="#about">About</a></li>
                    <li><a href="#portfolio">Portfolio</a></li>
                    <li><a href="#contact">Contact</a></li>
                </ul>
            </div>
        </div>
    </div>
    <section class="sortOrder" ng-app="sortOrderApp">
    	<div ng-controller="sortOrderCtrl">
            <div class="jumbotron">
            </div>
            <div class="container" id="contact">
                <h1>Name: {{header.nameGen}} </h1>
                <p>Order Number:  {{order.orderNumber}} </p>
                <p>Number of Boxes: {{order.numOfBoxes}} </p>
            </div>
            <div>
                <div class="row padding">
                    <div class="form-group">
                        <div class=".col-md-4">
                            <button type="button" class="btn btn-success btn-lg"
                                ng-click="randomOrder()">
                                <div ng-show="goCats">loading...</div>
                                <div ng-show="!goCats">Sort Random Order</div>
                            </button>
                            <div class="checkbox">
                                <label><input type="checkbox"> Remove Housewares</label>
                            </div>
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
                <footer><a href="#home">Back to top</a></footer>
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
    </body>
</html>

