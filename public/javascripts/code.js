$(function(){ // on dom ready

var demoNodes = [];
var demoEdges = [];

$(document).ready(function ($) {
    $.when(
        $.ajax({
            type: 'GET',
            url: '/courses',
            data: { get_param: 'value' },
            dataType: 'json',
            success: function (data) {
                $.each(data, function(index, element) {
                    demoNodes.push({
                        data: {
                            id: element.sigle,
                            name:element.sigle,
                            weight: 45,
                            faveShape: 'rectangle',
                            faveColor: '#33334C'
                        }
                    });
                    demoEdges.push({
                        data: {
                            source: element.sigle,
                            target:element.siglePrealable,
                            faveColor: '#33334C',
                            strength: 20
                        }
                    });
                });
            }
        })
    ).done(function ()
    {
        $('#cy').cytoscape({
            layout: {
                name: 'breadthfirst',
                padding: 10,
                directed: true,
                avoidOverlap: true,
                zoomingEnabled: false,
                userZoomingEnabled: false,
                panningEnabled: false,
                userPanningEnabled: false
                //roots:['PHY150','LOG240','MAT150','COM101']
            },

            style: cytoscape.stylesheet()
                .selector('node')
                .css({
                    'shape': 'data(faveShape)',
                    'width': '70',
                    'content': 'data(name)',
                    'text-valign': 'center',
                    'text-outline-width': 0.5,
                    'text-outline-color': '#000000',
                    'background-color': 'data(faveColor)',
                    'color': '#fff',
                    'font-size': '12'
                })
                .selector(':selected')
                .css({
                    'border-width': 1,
                    'border-color': '#333',
                    'background-color': '#D67834',
                    'color': '#fff'
                })
                .selector('edge')
                .css({
                    'opacity': 0.666,
                    'width': '0.5',
                    'target-arrow-shape': 'none',
                    'source-arrow-shape': 'none',
                    'line-color': 'data(faveColor)',
                    'source-arrow-color': 'data(faveColor)',
                    'target-arrow-color': 'data(faveColor)'
                })
                .selector('edge.questionable')
                .css({
                    'line-style': 'dotted',
                    'target-arrow-shape': 'diamond'
                })
                .selector('.faded')
                .css({
                    'opacity': 0.25,
                    'text-opacity': 0
                }),

            elements: {
                nodes: demoNodes,
                edges: demoEdges
            },

            ready: function(){
                window.cy = this;

                cy.on('click', function(evt){
                console.log( 'clicked ' + evt.cyTarget.id() );
                $('#preview').text('Cours choisi pour inscription : ' + evt.cyTarget.id());
                $('#coursfield').val('' + evt.cyTarget.id());
                $('#Lundi').html("");
                $('#Mardi').html("");
                $('#Mercredi').html("");
                $('#Jeudi').html("");
                $('#Vendredi').html("");

                $.when(
                    $.ajax({
                        type: 'GET',
                        url: '/courses/' + evt.cyTarget.id(),
                        data: { get_param: 'value' },
                        dataType: 'json',
                        success: function (data)
                        {
                            $('#horairesdispo').text("");
                            $.each(data, function(index, cours) {
                                $('#horairesdispo').append("<li> Titre du cours :" + cours.titre + "</li>" + "<li> Description :" + cours.description + "</li>"
                                + "<li> # de credits :" + cours.credits + "</li>" + "<li> Cours prealable :" + cours.siglePrealable + "</li>");
                            } );
                        }
                    })
                )
                    .done(function ()
                    {
                        $.ajax({
                            type: 'GET',
                            url: '/horaires/' + evt.cyTarget.id(),
                            data: { get_param: 'value' },
                            dataType: 'json',
                            success: function (data)
                            {
                                $.each(data, function(index, horaire) {
                                    $('#' + horaire.journee).html("<h4>" + evt.cyTarget.id() + "</h4><br>" + horaire.heuredebut + " - " + horaire.heurefin);
                                } );
                            }
                        });
                    });

             });
            }
        });
    });
}); // ready
}); // on dom ready



