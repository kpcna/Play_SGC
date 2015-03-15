$ ->
  $.get "/users", (users) ->
    $.each users, (index,user) ->
      $('#users').append "<tr><td> " + user.email + "</td>" + "<td> " + user.name + "</td>" +
        "<td> " + user.userTypeStr + "</td></tr>"