window.addEventListener('load', function () {
    console.log("update_paciente.js");
    const formulario = document.querySelector('#update_paciente_form');
    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;
        const formData = {
                    id: document.querySelector('#paciente_id').value,
                    nombre: document.querySelector('#nombre').value,
                    apellido: document.querySelector('#apellido').value,
                    dni: document.querySelector('#dni').value,
                    fechaIngreso: document.querySelector('#fechaIngreso').value,
                    domicilio: {
                                id: document.querySelector('#domicilio_id').value,
                                calle: document.querySelector('#calle').value,
                                numero: document.querySelector('#numero').value,
                                localidad: document.querySelector('#localidad').value,
                                provincia: document.querySelector('#provincia').value,
                                },
                };
        console.log("pacienteId: ");
        console.log(pacienteId);
        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
            let paciente = data;
            console.log("fetch:");
            console.log(data);
                    let pacienteString = "{nombre:" + paciente.nombre +
                                                " ,apellido:" + paciente
                                                .apellido
                                                +
                                                ", dni:" + paciente.dni
                                                 +
                                                ", fechaIngreso:" + paciente
                                                .fechaIngreso  +
                                                 "}"
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> Paciente = </strong> ' +
                                            data.toString();
                                        '</div>'

                    // change the updated data for domicilio table record
                    $("#tr_" + pacienteId + " td.td_first_name").text(paciente
                    .nombre
                    .toUpperCase());

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
        
        }).catch(error => {
            let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
            '<strong> Error </strong></div>';

            $("#response").empty();                                    
            $("#response").append(errorAlert);
            $("#response").css({"display": "block"});
        })

    })
    })

          
    

    function find(id) {
        
          const url = '/pacientes'+"/"+id;
          const settings = {
              method: 'GET'
          }
          console.log("Find pacientes _ update_pacientes");
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              console.log("paciente find");
              console.log(paciente);
              $("#paciente_id").val(paciente.id);
              $("#nombre").val(paciente.nombre);
              $("#apellido").val(paciente.apellido);
              $("#dni").val(paciente.dni);
              $("#fechaIngreso").val(paciente.fechaIngreso);
              $("#domicilio_id").val(paciente.domicilio.id);
              $("#calle").val(paciente.domicilio.calle);
              $("#numero").val(paciente.domicilio.numero);
              $("#localidad").val(paciente.domicilio.localidad);
              $("#provincia").val(paciente.domicilio.provincia);
              $("#div_paciente_updating").css({"display": "block"});
          }).catch(error => {
              console.log(error);
              alert("Error -> " + error);
          })
      }
