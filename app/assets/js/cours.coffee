$ ->
  $.get "/courses", (courses) ->
    $.each courses, (index,cours) ->
      $('#courses').append "<tr><td> " + cours.titre + "</td>" + "<td> " + cours.description + "</td>" +
        "<td> " + cours.sigle + "</td>" + "<td> " + cours.credits + "</td>" + "<td> " + cours.siglePrealable + "</td></tr>"
      $('#prealable').append "<option value =" + cours.sigle + ">" + cours.sigle + "</option>"