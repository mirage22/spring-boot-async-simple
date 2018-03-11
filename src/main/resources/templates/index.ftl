<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="/app.js"></script>
</head>
<body>
<div id="floating-panel">
    <b>Mode of Travel: </b>
    <select id="mode">
        <option value="DRIVING">Driving</option>
        <option value="WALKING">Walking</option>
        <option value="BICYCLING">Bicycling</option>
        <option value="TRANSIT">Transit</option>
    </select>
</div>
<div>
    Date: ${time?date}
</div>
<div id="map"></div>
<!-- Replace the value of the key parameter with your own API key. -->
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA4cD6KQsuPnuYqwhITc5HHgNMuHjUe8qc
    &callback=initMap">
</script>

<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="col-md-6">
        <table>
            <tr>
                <th>geo-location</th>
            </tr>
            <tr>
                <th>
                    <div id="locationPoint">
                    </div>
                </th>
            </tr>
        </table>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Number</th>
                </tr>
                </thead>
                <tbody id="numbers">
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>