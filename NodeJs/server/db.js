const mongoose = require("mongoose");

const dbUri =
  "mongodb+srv://admin:1234@cluster0.gjcmjlg.mongodb.net/employee_db?retryWrites=true&w=majority&appName=AtlasApp";

module.exports = () => {
  return mongoose.connect(dbUri);
};
