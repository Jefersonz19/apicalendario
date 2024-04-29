//module.exports = (app) => {

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

