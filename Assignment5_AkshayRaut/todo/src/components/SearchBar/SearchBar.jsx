import React from "react";
import { TbXboxXFilled } from "react-icons/tb";
import "./SearchBar.css";

const SearchBar = ({ searchQuery, setSearchQuery, onClearSearch }) => {
  return (
    <div className="search-bar">
        <p className="search-heading">Search</p>
        <input
            type="text"
            placeholder="Search tasks..."
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
        />
        <TbXboxXFilled className="clear-icon" onClick={onClearSearch} />
    </div>
  );
};

export default SearchBar;
