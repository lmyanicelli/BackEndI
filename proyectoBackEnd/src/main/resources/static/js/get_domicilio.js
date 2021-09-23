

window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/domicilios';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
  console.log("get_domicilio")
  console.log(data);
    $.each(data, (i, domicilio) => {

      let deleteButton = '<button ' +
                              'id=' +
                              '\"' + 'btn_delete_' + domicilio.id + '\"'+
                              ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                              '>&times</button>';

      let get_More_Info_Btn = '<button' +
                                  ' id=' + '\"' + 'btn_id_' + domicilio.id + '\"' +
                                  ' type="button" onclick="find('+domicilio.id+')" class="btn btn-info btn_id">' +
                                  domicilio.id +
                                  '</button>';
      
      let tr_id = 'tr_' + domicilio.id;
      let domicilioRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + domicilio.calle.toUpperCase() +
                 '</td>' +
                '<td class=\"td_address\">' + domicilio.numero + '</td>' +
                '<td class=\"td_city\">' + domicilio.localidad + '</td>' +
                '<td class=\"td_province\">' + domicilio.provincia + '</td>' +
                '<td>' +  deleteButton + '</td>' +
                '</tr>';                
      $('#domicilioTable tbody').append(domicilioRow);
    });

})
.catch(error => {
             let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
             '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
             '<strong> Error </strong></div>';

             $("#response").empty();
             $("#response").append(errorAlert);
             $("#response").css({"display": "block"});
         })
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/domicilios.html") {
      $(".nav .nav-item a:last").addClass("active");
  }
})
})
      
