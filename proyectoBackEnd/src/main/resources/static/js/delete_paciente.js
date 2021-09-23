$(document).ready(function(){
    let pacienteId = 0;

    $(document).on("click", "#div_paciente_table table button.btn_delete",
    function() {
        let btn_id = (event.srcElement.id);
        pacienteId = btn_id.split("_")[2];

        $("div.modal-body")
            .text("Queres eliminar el paciente con id = " + pacienteId + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/pacientes/' + pacienteId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body")
                    .text("Paciente eliminado correctamente!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the paciente row on html page
                let row_id = "tr_" + pacienteId;
                $("#" + row_id).remove();
                $("#div_paciente_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_paciente_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});