// Elaborado por:  Jeferson Zapata   

const express = require('express');
const bd = require('./models/bd');
const app = express();
const bodyParser = require('body-parser'); 
//app.use(express.json());

//require('./routes/festivo.rutas')(app);
const router = require('./routes/festivo.rutas');

app.use(bodyParser.json());

bd.conectar();

app.use(router);
const port = 3029;

app.listen(port, () => {
    console.log(`This app is running on port: ${port}`)
});

