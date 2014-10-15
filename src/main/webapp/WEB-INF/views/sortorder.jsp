<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
        href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>

    <title>Order</title>
    </head>
    <body>
    	<section class="container" ng-app="sortOrderApp">
    		<div ng-controller="sortOrderCtrl">

            <div class="jumbotron">
                <div class="container">
                    <h1>Name: {{header.nameGen}} </h1>
                    <p>Order Number:  {{order.orderNumber}} </p>
                    <p>Number of Boxes: {{order.numOfBoxes}} </p>
                </div>
            </div>

            <div>
                <div>
                    <button type="button" id="loading-example-btn" class="btn btn-primary" data-loading-text="Loading..."
                     ng-click="randomOrder()">
                        <div ng-show="goCats">loading...</div>
                        <div ng-show="!goCats">Sort Random Order</div>
    				</button>
    			</div>

    			<div>
                    <label><input type="checkbox" ng-model="houseware" ng-true-value="1" ng-false-value="0">Remove Housewares</label>
    			</div>

    			<div>
                    <h1 ng-repeat="box in order.boxes">Box {{box.boxId}}
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
                    </h1>
                </div>
            </div>
        </section>
    </body>
</html>

