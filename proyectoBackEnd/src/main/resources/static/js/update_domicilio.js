window.addEventListener('load', function () {
    console.log("update_domicilio.js");
    const formulario = document.querySelector('#update_domicilio_form');
    formulario.addEventListener('submit', function (event) {
        let domicilioId = document.querySelector('#domicilio_id').value;
        const formData = {
            id: document.querySelector('#domicilio_id').value,
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,
        };
        console.log("domicilioId: ");
        console.log(domicilioId);
        const url = '/domicilios';
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
            let domicilio = data;
            console.log("fetch:");
            console.log(data);
                    let domicilioString = "{calle:" + domicilio.calle +
                                                " ,numero:" + domicilio.numero
                                                +
                                                ", localidad:" + domicilio
                                                .localidad
                                                 +
                                                ", provincia:" + domicilio
                                                .provincia  +
                                                 "}"
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> Domicilio = </strong> ' +
                                            data.toString();
                                        '</div>'

                    // change the updated data for domicilio table record
                    $("#tr_" + domicilioId + " td.td_first_name").text(domicilio
                    .calle
                    .toUpperCase());
                   /* $("#tr_" + domicilioId + " td.td_address").text(domicilio
                    .numero
                    .toUpperCase());
                    $("#tr_" + domicilioId + " td.td_address").text(domicilio
                                        .numero
                                        .toUpperCase());*/

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
        
          const url = '/domicilios'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let domicilio = data;
              $("#domicilio_id").val(domicilio.id);
              $("#calle").val(domicilio.calle);
              $("#numero").val(domicilio.numero);
              $("#localidad").val(domicilio.localidad);
              $("#provincia").val(domicilio.provincia);
              $("#div_domicilio_updating").css({"display": "block"});
          }).catch(error => {
              console.log(error);
              alert("Error -> " + error);
          })
      }
