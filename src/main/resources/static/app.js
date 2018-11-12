var stompClient = null;

var backEndHost = document.location.href.substring(0,document.location.href.length-1);
$.ajax({
  url: `${backEndHost}/api/regions/region`,
  dataType: 'json',
  success: function(response){
    var region = response.data;
    region = "My Region is "+region;
    console.log("Region is::"+response.data);
    $(".region-info").text(region);
  }
});


function connect() {
    var socket = new SockJS('/event-service');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/publishing', function (activity) {
          var activityObj = JSON.parse(activity.body);
          var activityRow = `<tr>
             <td class="col-md-1">${activityObj.action}</td>
          </tr>`;
            $("#publishing-table-body").append(activityRow);
            console.log("Activity recieved is::"+JSON.stringify(activity));
        });
        stompClient.subscribe('/topic/registrations', function (activity) {
            var activityObj = JSON.parse(activity.body);
            var activityRow = `<tr>
                <td class="col-md-1">${activityObj.action}</td>
               </tr>`;
            $("#registrations-table-body").append(activityRow);
            console.log("Activity recieved is::"+JSON.stringify(activity));
        });
        stompClient.subscribe('/topic/subscriptions', function (activity) {
          var activityObj = JSON.parse(activity.body);
          var activityRow = `<tr>
              <td class="col-md-1">${activityObj.action}</td>
             </tr>`;
          $("#subscriptions-table-body").append(activityRow);
            console.log("Activity recieved is::"+JSON.stringify(activity));
        });
        stompClient.subscribe('/topic/notifications', function (activity) {
          var activityObj = JSON.parse(activity.body);
          var activityRow = `<tr>
              <td class="col-md-1">${activityObj.action}</td>
             </tr>`;
          $("#notifications-table-body").append(activityRow);
            console.log("Activity recieved is::"+JSON.stringify(activity));
        });
    });
}

connect();
