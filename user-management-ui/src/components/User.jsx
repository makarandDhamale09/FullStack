import React from "react";

const User = ({ user, deleteUser, editUser }) => {
  return (
    <tr key={user.id}>
      <td className="text-center px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500 ">{user.id}</div>
      </td>
      <td className="text-center px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500 ">{user.firstName}</div>
      </td>
      <td className="text-center px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500 ">{user.lastName}</div>
      </td>
      <td className="text-center px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500 ">{user.emailId}</div>
      </td>
      <td className="text-center px-6 py-4 whitespace-nowrap">
        <a
          href="#"
          onClick={(e, id) => editUser(e, user.id)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer px-4"
        >
          Edit
        </a>
        <a
          href="#"
          onClick={(e, id) => deleteUser(e, user.id)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer"
        >
          Delete
        </a>
      </td>
    </tr>
  );
};

export default User;
