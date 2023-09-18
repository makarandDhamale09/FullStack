"use client";
import React, { useEffect, useState } from "react";
import User from "./User";

const UserList = () => {
  const USER_API_BASE_URL = "http://localhost:8080/api/v1/user/allUsers";
  const [users, setUsers] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await fetch(USER_API_BASE_URL, {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
          },
        });
        const users = await response.json();
        setUsers(users);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  return (
    <div className="container mx-auto my-8">
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-center font-medium text-gray-500 uppercase tracking-wide py-3">
                Sr No.
              </th>
              <th className="text-center font-medium text-gray-500 uppercase tracking-wide py-3">
                First Name
              </th>
              <th className="text-center font-medium text-gray-500 uppercase tracking-wide py-3">
                Last Name
              </th>
              <th className="text-center font-medium text-gray-500 uppercase tracking-wide py-3">
                Email Id
              </th>
              <th className="text-center font-medium text-gray-500 uppercase tracking-wide py-3">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody>
              {users?.map((user) => (
                <User user={user} key={user.id} />
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};

export default UserList;
