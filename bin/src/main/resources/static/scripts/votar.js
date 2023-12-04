function votar(button, dni) {
    // Obtener la fila actual
    var row = button.closest('tr');

    // Obtener los elementos input de clase 'mesa' en la fila
    var inputs = row.getElementsByClassName('mesa');

    // Calcular la suma de los valores de los inputs
    var suma = 0;
    for (var i = 0; i < inputs.length; i++) {
        suma += parseInt(inputs[i].value) || 0;
    }

    // Actualizar el span de la fila con la suma
    var totalSpan = row.querySelector('.total');

    // Llama a la API para insertar el voto
    $.ajax({
        type: "POST",
        url: "/api/votos/insertarv",
        data: {
            dni: dni,
            cantidadVotos: suma
        },
        success: function () {
            // Actualiza la cantidad de votos en la interfaz
            totalSpan.textContent = suma;

            // Desactivar inputs y botón, y mostrar el nuevo diseño
            for (var i = 0; i < inputs.length; i++) {
                inputs[i].disabled = true;
            }
            button.disabled = true;

            // Asegúrate de que estás obteniendo el botón de la fila actual
            var lightButton = row.querySelector('.btn-success');
            lightButton.disabled = true;
        },
        error: function () {
            alert("Error al votar. Inténtelo de nuevo.");
        }
    });
}
