const express = require("express");
const router = express.Router();

const Employee = require("../models/employee.model");

router.get("/", (req, res) => {
  Employee.find()
    .then((data) => res.send(data))
    .catch((err) => console.log(err));
});

router.get("/hello", (req, res) => {
  res.send("Hello World!!!");
});

router.post("/", (req, res) => {
  Employee.create(req.body)
    .then((data) => res.send(data))
    .catch((err) => console.log(err));
});

module.exports = router;
