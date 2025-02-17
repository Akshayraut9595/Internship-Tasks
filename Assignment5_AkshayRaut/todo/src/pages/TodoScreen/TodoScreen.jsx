import React, { useState } from "react";
import { FaPlus } from "react-icons/fa";
import { PiDotsThreeOutlineFill } from "react-icons/pi";
import Task from "../../components/Task/Task";
import SearchBar from "../../components/SearchBar/SearchBar";
import FilterBar from "../../components/Filter/FilterBar";
import "./TodoScreen.css";

const TodoScreen = () => {
  const [tasks, setTasks] = useState([]);
  const [taskData, setTaskData] = useState("");
  const [taskDate, setTaskDate] = useState(getTodayDate());
  const [showDropdown, setShowDropdown] = useState(false);
  const [showSearch, setShowSearch] = useState(false);
  const [searchQuery, setSearchQuery] = useState("");
  const [showFilter, setShowFilter] = useState(false);
  const [filter, setFilter] = useState("byDate");
  const [filterValue, setFilterValue] = useState(getTodayDate());
  const [showPopup, setShowPopup] = useState(false);
  const [popupMessage, setPopupMessage] = useState('');

  function getTodayDate() {
    return new Date().toISOString().split("T")[0];
  }

  const handleAdd = () => {
    if (taskData.trim() && taskDate) {
      const newTask = {
        ID: Date.now(),
        date: taskDate,
        data: taskData,
        completed: false,
      };
      setTasks([...tasks, newTask]);
      setTaskData("");
      setTaskDate(getTodayDate());
      showMessage('Task Added Successfully!');
    }
  };

  const handleDeleteTask = (taskId) => {
    setTasks(tasks.filter((task) => task.ID !== taskId));
    showMessage('Task Deleted Successfully!');
  };

  const handleToggleComplete = (taskId) => {
    setTasks(
      tasks.map((task) =>
        task.ID === taskId ? { ...task, completed: !task.completed } : task
      )
    );
  };

  const handleSearch = () => {
    setShowSearch(true);
    setShowDropdown(false);
    setShowFilter(false);
  };

  const handleClearSearch = () => {
    setSearchQuery("");
    setShowSearch(false);
  };

  const handleFilter = () => {
    setShowFilter(true);
    setShowSearch(false);
  };

  const handleClearFilter = () => {
    setShowFilter(false);
    setFilter("byDate");
    setFilterValue(getTodayDate());
  };

  const handleDeleteAll = () => {
    setTasks([]);
    showMessage('All Tasks Deleted!');
  }

  const filterTasks = () => {
    return tasks.filter((task) => {
      const taskDate = new Date(task.date);
      const filterDate = new Date(filterValue);

      switch (filter) {
        case "completed":
          return task.completed;
        case "pending":
          return !task.completed;
        case "byDate":
          return taskDate.toDateString() === filterDate.toDateString();
        case "byMonth":
          return (
            taskDate.getFullYear() === filterDate.getFullYear() &&
            taskDate.getMonth() === filterDate.getMonth()
          );
        case "byYear":
          return taskDate.getFullYear() === parseInt(filterValue, 10);
        default:
          return true;
      }
    });
  };

  const showMessage = (message) => {
    setPopupMessage(message);
    setShowPopup(true);
  };

  const closePopup = () => {
    setShowPopup(false);
  };

  return (
    <div className="screen-container">
      {showPopup && (
        <div className="popup">
          <div className="popup-content">
            <p>{popupMessage}</p>
            <button onClick={closePopup}>OK</button>
          </div>
        </div>
      )}
      <div className="header-container">
        <h1>All Tasks</h1>
        <div className="dots-icon" onClick={() => setShowDropdown(!showDropdown)}>
          <PiDotsThreeOutlineFill />
          {showDropdown && (
            <div className="dropdown-menu">
              <li onClick={handleSearch}>Search</li>
              <li onClick={handleFilter}>Filter</li>
              <li onClick={handleDeleteAll}>Delete All</li>
            </div>
          )}
        </div>
      </div>

      <div className="bar">
        {showSearch && (
          <SearchBar
            searchQuery={searchQuery}
            setSearchQuery={setSearchQuery}
            onClearSearch={handleClearSearch}
          />
        )}

        {showFilter && (
          <FilterBar
            filter={filter}
            setFilter={setFilter}
            filterValue={filterValue}
            setFilterValue={setFilterValue}
            onClearFilter={handleClearFilter}
          />
        )}
      </div>

      <div className="tasks-list">
        {filterTasks()
          .filter((task) => task.data.toLowerCase().includes(searchQuery.toLowerCase()))
          .map((task) => (
            <Task
              key={task.ID}
              ID={task.ID}
              data={task.data}
              date={task.date}
              completed={task.completed}
              onDelete={handleDeleteTask}
              onToggleComplete={handleToggleComplete}
            />
          ))}
      </div>

      <div className="add-task">
        <FaPlus className="plusIcon" onClick={handleAdd} />
        <input
          type="text"
          placeholder="Add a task"
          value={taskData}
          onChange={(e) => setTaskData(e.target.value)}
        />
        <input
          type="date"
          value={taskDate}
          onChange={(e) => setTaskDate(e.target.value)}
        />
      </div>
    </div>
  );
};

export default TodoScreen;
