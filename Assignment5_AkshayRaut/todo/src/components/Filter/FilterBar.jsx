import { useState, useEffect } from "react";
import { TbXboxXFilled } from "react-icons/tb";
import './FilterBar.css';

const FilterBar = ({ filter, setFilter, filterValue, setFilterValue, onClearFilter }) => {
  
  // Function to get today's date in YYYY-MM-DD format
  const getTodayDate = () => new Date().toISOString().split("T")[0];

  useEffect(() => {
    if (filter === "today") {
      setFilterValue(getTodayDate());
    }
  }, [filter]);

  return (
    <div className="filter-bar">
      <select
        onChange={(e) => {
          setFilter(e.target.value);
          setFilterValue(filter);
        }}
        value={filter}
      >
        <option value="all">All</option>
        <option value="completed">Completed</option>
        <option value="pending">Pending</option>
        <option value="byDate">By Date</option>
        <option value="byMonth">By Month</option>
        <option value="byYear">By Year</option>
      </select>

      {/* Dynamic Input Field for Date, Month, and Year */}
      {filter === "byDate" && (
        <input
          type="date"
          value={filterValue || ""}
          onChange={(e) => setFilterValue(e.target.value)}
        />
      )}

      {filter === "byMonth" && (
        <input
          type="month"
          value={filterValue || ""}
          onChange={(e) => setFilterValue(e.target.value)}
        />
      )}

      {filter === "byYear" && (
        <input
          type="number"
          placeholder={filterValue ? "" : "Enter Year"}
          value={filterValue || ""}
          onChange={(e) => setFilterValue(e.target.value)}
        />
      )}

      <TbXboxXFilled className="clear-icon" onClick={onClearFilter}/>
    </div>
  );
};

export default FilterBar;
