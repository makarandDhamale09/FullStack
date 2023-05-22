import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import Employee from "./Employee";

export default function EmployeeList() {
  const navigate = useNavigate();
  const [employees, setemployee] = useState(null);
  const [loading, setloading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      setloading(true);
      try {
        const response = await EmployeeService.getEmployees();
        setemployee(response.data);
      } catch (error) {
        console.log(error);
      }
      setloading(false);
    };
    fetchData();
  }, []);

  return (
    <div className="container mx-6 my-6">
      <div className="h-12">
        <button
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold"
          onClick={() => navigate("/addEmployee")}
        >
          Add Employee
        </button>
      </div>
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wide py-3 px-6">
                Emp Id
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wide py-3 px-6">
                First Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wide py-3 px-6">
                Last Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wide py-3 px-6">
                Email Id
              </th>
              <th className="text-center font-medium text-gray-500 uppercase tracking-wide  py-3 px-4">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {employees.map((employee) => (
                <Employee employee={employee} key={employee.empId} />
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
}
