$ ->
  $.get "/horaires", $('#coursfield').val(),(horaires) ->
    $.each horaires, (index,horaire) ->
      $('#horairesdispo').append "<li>" + horaire.datedebut + + "</li>"