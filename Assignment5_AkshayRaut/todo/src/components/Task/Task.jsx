import React from "react";
import { IoIosCheckboxOutline } from "react-icons/io"; 
import { MdOutlineCheckBoxOutlineBlank } from "react-icons/md";
import { RiDeleteBin6Line } from "react-icons/ri";
import { SlCalender } from "react-icons/sl";
import "./Task.css";

const Task = ({ ID, data, date, completed, onDelete, onToggleComplete }) => {
  return (
    <div className="task-container">
      <div className="task-left">
        <div className="task-icon" onClick={() => onToggleComplete(ID)}>
          {completed ? (
            <IoIosCheckboxOutline className="checked-icon" style={{ color: "blue" }} />
          ) : (
            <MdOutlineCheckBoxOutlineBlank />
          )}
        </div>
        <div className={`task-details ${completed ? "completed" : ""}`}>
          <h2 className="task-data">{data}</h2>
          <div className="task-date">
            <SlCalender />
            <p>{date}</p>
          </div>
        </div>
      </div>
      <div className="task-delete" onClick={() => onDelete(ID)}>
        <RiDeleteBin6Line />
      </div>
    </div>
  );
};

export default Task;
