function obtenerSiguienteLunes(fecha) {
    const diaSemana = fecha.getDay(); // Cambiado de getDate a getDay
    const diasHastaLunes = (8 - diaSemana) % 7;
    const fechaLunes = new Date(fecha); // Copiar la fecha original para no modificarla
    fechaLunes.setDate(fecha.getDate() + diasHastaLunes); // Sumar días hasta el próximo lunes
    return fechaLunes;
}

// Función para agregar un número dado de días a una fecha dada
function agregarDias(fecha, dias) {
    const fechaObjeto = new Date(fecha);
    fechaObjeto.setDate(fechaObjeto.getDate() + dias);
    return fechaObjeto; // Devolver el objeto Date sin convertirlo a cadena de texto
}
module.exports = {    
    obtenerSiguienteLunes,
    agregarDias,
}
