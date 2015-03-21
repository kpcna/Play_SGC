$ ->
  $.get "/courses", (courses) ->
    $.each courses, (index,cours) ->
      $('#CoursSigle').append "<option value =" + cours.sigle + ">" + cours.sigle + "</option>"