import React from "react";
import { useNavigate } from "react-router-dom";

export default function EmployeeList() {
  const navigate = useNavigate();
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
          <tbody className="bg-white">
            <tr>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                <div className="text-small text-gray-500">1</div>
              </td>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                <div className="text-small text-gray-500">Makarand</div>
              </td>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                <div className="text-small text-gray-500">Dhamale</div>
              </td>
              <td className="text-left px-6 py-4 whitespace-nowrap">
                <div className="text-small text-gray-500">
                  makarand.dhamale09@gmail.com
                </div>
              </td>
              <td className="text-center px-6 py-4 whitespace-nowrap font-medium text-sm">
                <a
                  href="#"
                  className="text-indigo-600 hover:text-indigo-800 px-4"
                >
                  Edit
                </a>
                <a
                  href="#"
                  className="text-indigo-600 hover:text-indigo-800 px-4"
                >
                  Delete
                </a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}
