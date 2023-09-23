const express = require("express");
const bodyParser = require("body-parser");

//local imports
const connectDb = require("./db.js");
const employeeRoutes = require("./controller/employee.controller");

const app = express();
app.use(bodyParser.json());
app.use("/api/employees", employeeRoutes);

connectDb()
  .then(() => {
    console.log("db connection successful");
    app.listen(3000, () => console.log("server started at Port 3000"));
  })
  .catch((err) => console.log(err));
