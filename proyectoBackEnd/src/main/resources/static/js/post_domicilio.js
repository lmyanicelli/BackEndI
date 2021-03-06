
window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_domicilio');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        const formData = {
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,
        };

        const url = '/domicilios/registrar';

        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Domicilio agregado </div>'
                 $("#response").append(successAlert);
                 $("#response").css({"display": "block"});
 
                 resetUploadForm();
             
            })
            .catch(error => {  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong> Error intente nuevamente</strong> </div>'
                     $("#response").append(errorAlert);
                     $("#response").css({"display": "block"});
                     resetUploadForm();})
    });

    function resetUploadForm(){
        $("#calle").val("");
        $("#numero").val("");
        $("#localidad").val("");
        $("#provincia").val("");
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/domicilios.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});
