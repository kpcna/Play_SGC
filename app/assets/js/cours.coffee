$ ->
  $.get "/courses", (courses) ->
    $.each courses, (index,cours) ->
      $('#courses').append $("<li>").text cours.titre