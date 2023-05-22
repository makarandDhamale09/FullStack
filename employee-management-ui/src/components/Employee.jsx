import React from "react";

export default function Employee({ employee }) {
  return (
    <tr key={employee.empId}>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-small text-gray-500">{employee.empId}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-small text-gray-500">{employee.firstName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-small text-gray-500">{employee.lastName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-small text-gray-500">{employee.emailId}</div>
      </td>
      <td className="text-center px-6 py-4 whitespace-nowrap font-medium text-sm">
        <a href="#" className="text-indigo-600 hover:text-indigo-800 px-4">
          Edit
        </a>
        <a href="#" className="text-indigo-600 hover:text-indigo-800 px-4">
          Delete
        </a>
      </td>
    </tr>
  );
}
