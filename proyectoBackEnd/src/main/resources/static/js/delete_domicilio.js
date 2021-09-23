$(document).ready(function(){
    let domicilioId = 0;

    $(document).on("click", "#div_domicilio_table table button.btn_delete",
    function() {
        let btn_id = (event.srcElement.id);
        domicilioId = btn_id.split("_")[2];

        $("div.modal-body")
            .text("Queres eliminar el domicilio con id = " + domicilioId + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/domicilios/' + domicilioId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body")
                    .text("Domicilio eliminado correctamente!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // delete the domicilio row on html page
                let row_id = "tr_" + domicilioId;
                $("#" + row_id).remove();
                $("#div_domicilio_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_domicilio_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});