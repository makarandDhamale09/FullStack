const express = require("express");
const router = express.Router();

const Employee = require("../models/employee.model");

router.get("/", (req, res) => {
  Employee.find()
    .then((data) => res.send(data))
    .catch((err) => console.log(err));
});

model.exports = router;
