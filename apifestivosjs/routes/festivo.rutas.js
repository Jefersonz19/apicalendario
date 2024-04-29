//module.exports = (app) => {
    //Importar el controlador
    const express = require('express');
    const controlFestivo = require('../controllers/festivo.controller');
    const router = express.Router();
    const { check } = require('express-validator');

    router.get('/festivos/tiposfestivos', controlFestivo.listar);
    router.get('/festivos/obtener/:year', controlFestivo.obtener);
    router.get('/festivos/obtenerSemanaSanta/:year', controlFestivo.obtenerSemanaSanta);

    router.get('/festivos/verificar/:year/:month/:day',   [
        check('year').isInt(),
        check('month').isInt(),
        check('day').isInt(), 
    ], controlFestivo.verificar);

    module.exports = router;

/*
    router.get('/festivos/verificar', async (req, res) => {
    try {
      const { fecha } = req.query;
      
      // Verificar si se proporcionó una fecha en la consulta
      if (!fecha) {
        return res.status(400).json({ error: 'Se requiere proporcionar una fecha.' });
      } 

      const resultado = await controlFestivo.verificar(new Date(fecha));

      res.json({ resultado });

    } catch (error) {

      console.error('Error al procesar la solicitud:', error);
      res.status(500).json({ error: 'Ocurrió un error al procesar la solicitud.' });
    }
  });
*/
