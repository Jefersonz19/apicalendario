/*
const mongoose = require('mongoose');


const festivoSchema = new mongoose.Schema({
    id: Number,
    tipo: String,
    modoCalculo: String,
    festivos: [{
        dia: Number,
        mes: Number,
        nombre: String,
        diasPascua: Number
    }]
});

const Festivo = mongoose.model('Festivo', festivoSchema);

module.exports = Festivo;
*/
const bd = require('./bd');

const Festivo = function () { };

Festivo.listar = async function (respuesta) {
    try {
        const basedatos = bd.obtenerBaseDatos();

        const tiposFestivos = await basedatos.collection('tipos')
            .find()
            .project({
                id: 1,
                tipo: 1,
                modoCalculo: 1,
                festivos: {
                    dia: 1,
                    mes: 1,
                    nombre: 1,
                    diasPascua: 1,
                }
            }) 
            .toArray();

        respuesta(null, tiposFestivos);
    } catch (error) {
        console.log(error)
        respuesta(error, null);
    }
}


Festivo.obtener = async function (req, res) {
    try {
        const { year } = req.params;

        const basedatos = bd.obtenerBaseDatos();

        const tiposFestivos = await basedatos.collection('tipos').find({})
          .toArray();
        
        let listfestivos = [];

        tiposFestivos.forEach(tipo => {
            switch (tipo.id) {
                case 1:
                //for (const festivo of tipo.festivos) {
                tipo.festivos.forEach(festivo => {
                    const fechafestivo = new Date(year, festivo.mes -1, festivo.dia);
                    listafestivos.push({
                        Dia: festivo.dia,
                        Mes: festivo.mes,
                        Nombre: festivo.nombre,
                        //Date: fecha
                    });
                 }); break;
                case 2:
                    //console.log(tipo.tipo)
                    listafestivos.push({
                        Tipo: tipo.id,
                        Nombre: tipo.tipo
                    });
            }
        });
        //listfestivos = listfestivos.sort((a, b) => new Date(a.Fecha) - new Date(b.Fecha));

        //res(null, listfestivos);
        const response =  {
            Festivo: listafestivos
        };
        res.json(response);

    } catch (error) {
        console.error('Error al listar los festivos:', error);
    }
}

/*
Festivo.verificar = async function (req, res) {
    try {
        const { year, mnoth, day } = req.params;
 
        const fecha = new Date(year, month - 1, day);

        if (isNaN(fecha) || fecha.getMonth() + 1 !== parseInt(month) || fecha.getDate() !== parseInt(day)) {
            return res.status(400).json({ error: 'Fecha no válida' });
        }
            const basedatos = bd.obtenerBaseDatos();
            const tiposFestivos = await basedatos.collection('tipos').find({})
                .toArray();
          
            //respuesta(null, tiposFestivos);

            res.json(tiposFestivos)
        } catch (error) {
            console.log(error)
            //respuesta(error, null);
        }

}
*/

module.exports = Festivo;