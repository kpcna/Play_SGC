$(function(){ // on dom ready

$('#cy').cytoscape({
  layout: {
    name: 'cose',
    padding: 10
  },
  
  style: cytoscape.stylesheet()
    .selector('node')
      .css({
        'shape': 'data(faveShape)',
        'width': '50',
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
    nodes: [
      { data: { id: 'LOG515', name: 'LOG515', weight: 45, faveColor: '#33334C', faveShape: 'rectangle' }, renderedPosition: { x: 300, y: 250 },locked:true, selectable:true, selected:true, grabbable:true },
      { data: { id: 'MAT150', name: 'MAT150', weight: 45, faveColor: '#33334C', faveShape: 'rectangle' }, renderedPosition: { x: 100, y: 100 },locked:true },
      { data: { id: 'PHY150', name: 'PHY150', weight: 45, faveColor: '#33334C', faveShape: 'rectangle' }, renderedPosition: { x: 100, y: 150 },locked:true },
      { data: { id: 'COM101', name: 'COM101', weight: 45, faveColor: '#33334C', faveShape: 'rectangle' }, renderedPosition: { x: 100, y: 200 },locked:true },
      { data: { id: 'PHY330', name: 'PHY330', weight: 45, faveColor: '#33334C', faveShape: 'rectangle' }, renderedPosition: { x: 200, y: 150 },locked:true },
      { data: { id: 'LOG240', name: 'LOG240', weight: 45, faveColor: '#33334C', faveShape: 'rectangle' }, renderedPosition: { x: 100, y: 250 },locked:true },
      { data: { id: 'LOG330', name: 'LOG330', weight: 45, faveColor: '#33334C', faveShape: 'rectangle' }, renderedPosition: { x: 200, y: 250 },locked:true },
    ],
    edges: [
      { data: { source: 'PHY150', target: 'PHY330', faveColor: '#33334C', strength: 20 } },
      { data: { source: 'LOG240', target: 'LOG330', faveColor: '#33334C', strength: 50 } },
      { data: { source: 'LOG330', target: 'LOG515', faveColor: '#33334C', strength: 40 } }
    ]
  },
  
  ready: function(){
    window.cy = this;

    cy.on('click', function(evt){
      console.log( 'clicked ' + evt.cyTarget.id() );
      $('#preview').text('CoursController choisi : ' + evt.cyTarget.id());

      $.get( "/inscription", { name: "John" } );

    });
  }
});



}); // on dom ready


