const express = require('express');
const bd = require('./models/bd');
const app = express();
const bodyParser = require('body-parser'); 
//app.use(express.json());

//require('./routes/festivo.rutas')(app);
const router = require('./routes/festivo.rutas');

app.use(bodyParser.json());
//console.log(fechas.getStartHolyweek(2023));

bd.conectar();

//fecha = fechas.getNextMonday(fechas.addDays(fechas.getStartHolyweek()))
app.use(router);
const port = 3029;

app.listen(port, () => {
    console.log(`This app is running on port: ${port}`)
});

