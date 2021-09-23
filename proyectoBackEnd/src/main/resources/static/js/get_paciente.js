

window.addEventListener('load', function () {

(function(){
  event.preventDefault();
  const url = '/pacientes';
  const settings = {
    method: 'GET'
}
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
  console.log("get_paciente");
  console.log(data);
    $.each(data, (i, paciente) => {
    console.log("forEachPaciente")
      console.log(paciente);

      let deleteButton = '<button ' +
                                    'id=' +
                                    '\"' + 'btn_delete_' + paciente.id + '\"'+
                                    ' type="button" class="btn btn-danger btn_delete" data-toggle="modal"  data-target="#delete-modal"' +
                                    '>&times</button>';

      let get_More_Info_Btn = '<button' +
                                   ' id=' + '\"' + 'btn_id_' + paciente.id
                                    + '\"' +
                                    ' type="button" onclick="find('+paciente
                                    .id+')" class="btn btn-info btn_id">' +
                                        paciente.id +
                                        '</button>';
      
      let tr_id = 'tr_' + paciente.id;
      let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                '<td>' + get_More_Info_Btn + '</td>' +
                '<td class=\"td_first_name\">' + paciente.nombre.toUpperCase() +
                 '</td>' +
                '<td class=\"td_last_name\">' + paciente.apellido + '</td>' +
                '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                '<td class=\"td_date\">' + paciente.fechaIngreso + '</td>' +
                '<td class=\"td_direction\">' + paciente.domicilio.calle  + ' '
                + paciente.domicilio.numero + ', ' + paciente.domicilio
                .localidad + ', ' + paciente.domicilio.provincia +
                '</td>' +
                '<td>' +  deleteButton + '</td>' +
                '</tr>';                
      $('#pacienteTable tbody').append(pacienteRow);
    });

})
.catch(error => {
console.log("Error get_pacientes");
console.log(error);
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
  if (pathname == "/pacientes.html") {
      $(".nav .nav-item a:last").addClass("active");
  }
})
})
      
