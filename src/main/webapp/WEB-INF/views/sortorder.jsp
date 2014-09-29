<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
        href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
    <title>Order</title>
    </head>
    <body>
    	<section class="container" ng-app="sortOrderApp">
    		<div ng-controller="sortOrderCtrl">

            <div class="jumbotron">
                <div class="container">
                    <h1>Name: {{header.nameGen}} </h1>
                    <p>Order Number:  {{header.orderNum}} </p>
                    <p>Number of Boxes: {{order.numOfBoxes}} </p>
                </div>
            </div>


                <div>
    				<a class="btn btn-danger btn-mini pull-left"
    					ng-click="randomOrder()">Sort Random Order
    				</a>
    			</div>
    			<div>
    			    <br>
    			    <h1 ng-repeat="box in order.boxes">Box {{box.boxId}}
                        <table class="table table-hover">
                            <tr>
                                <th>Item Name</th>
                                <th>Item Type</th>
                                <th>SKU#</th>
                            </tr>

                            <tr ng-repeat="item in box.boxItems">
                                <td>{{item.name}}</td>
                                <td>{{item.itemType}}</td>
                                <td>{{item.sku}}</td>
                            </tr>
                        </table>
                    </h1>
                </div>
            </div>
        </section>
    </body>
</html>

