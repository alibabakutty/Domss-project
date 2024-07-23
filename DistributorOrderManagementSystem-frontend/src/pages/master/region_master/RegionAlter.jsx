import React, { useEffect, useRef, useState } from 'react';
import { listOfRegions } from '../../../services/MasterService';
import { Link, useNavigate } from 'react-router-dom';


const RegionAlter = () => {
  const [regionMasterId, setRegionMasterId] = useState("");

  const [region, setRegion] = useState([]);
  const [filteredRegions, setFilteredRegions] = useState([]);
  const [selectedIndex, setSelectedIndex] = useState(0);
  const [showDropdown, setShowDropdown] = useState(false);
  const inputRef = useRef(null);
  const dropdownRef = useRef(null);
  const navigate = useNavigate();

  useEffect(() => {
    inputRef.current.focus();

    listOfRegions()
      .then(response => {
        setRegion(response.data);
        setFilteredRegions(response.data.slice(0, 20)); // Initially show the first 20 regions
        setShowDropdown(response.data.length > 20);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  useEffect(() => {
    filterRegions();
  }, [regionMasterId]);

  useEffect(() => {

    const handleKeyDown = (e) => {
      const totalItems = showDropdown
        ? filteredRegions.length + 3 // Create, Back, Dropdown
        : filteredRegions.length + 2; // Create, Back

      if (e.key === 'ArrowDown') {
        setSelectedIndex(prevIndex => (prevIndex + 1) % totalItems);
        e.preventDefault();

      } else if (e.key === "ArrowUp") {
        setSelectedIndex((prevIndex) => (prevIndex - 1 + totalItems) % totalItems);

        e.preventDefault();
      } else if (e.key === 'Enter') {
        if (selectedIndex === 0) {
          navigate('/create/region');
          e.preventDefault();
        } else if (selectedIndex === 1) {
          navigate('/alter');
          e.preventDefault();

        } else if (showDropdown && selectedIndex === filteredRegions.length + 2) {
          dropdownRef.current.focus();
        } else if (filteredRegions[selectedIndex - 2]) {
          navigate(`/alterRegionMaster/${filteredRegions[selectedIndex - 2].regionMasterId}`);

        }
      } else if (e.key === 'Escape') {
        navigate('/alter');
      }
    };

    window.addEventListener('keydown', handleKeyDown);

    return () => {
      window.removeEventListener('keydown', handleKeyDown);
    };
  }, [filteredRegions, selectedIndex, navigate, showDropdown]);

  const filterRegions = () => {
    let filtered = [];


    if (regionMasterId === "") {
      filtered = region.slice(0, 20); // Reset to show the first 20 elements
    } else {
      filtered = region.filter((reg) =>
        reg.regionMasterId.toLowerCase().includes(regionMasterId.toLowerCase())
      ).slice(0, 20); // Limit to 20 elements

    }

    setFilteredRegions(filtered);
    setShowDropdown(region.length > 20); // Show dropdown if more than 20 regions
    setSelectedIndex(2); // Reset selected index to the first element in the filtered list
  };

  const handleDropdownChange = e => {
    const selectedRegionId = e.target.value;
    navigate(`/alterRegionMaster/${selectedRegionId}`);
  };

  return (
    <>
      <div className="flex justify-evenly" onClick={() => inputRef.current.focus()}>
        <div className="w-[80%] flex h-screen">
          <div className="w-[50%] bg-white"></div>

          <div className="w-[65%] bg-slate-100 flex justify-center items-center flex-col">
            <div className="w-[50%] h-16 flex flex-col justify-center items-center border border-black bg-white border-b-0">
              <p className="text-[13px] font-semibold underline underline-offset-4 decoration-gray-400">
                Region Alter
              </p>
              <input
                type="text"
                id="regionMasterId"
                name="regionMasterId"
                value={regionMasterId}
                onChange={e => setRegionMasterId(e.target.value)}
                ref={inputRef}
                className="w-[250px] ml-2 mt-2 h-5 capitalize font-medium pl-1 text-sm focus:bg-yellow-200 focus:border focus:border-blue-500 focus:outline-none"
                autoComplete="off"
              />
            </div>

            <div className="w-[350px] h-[85vh] border border-gray-600 bg-[#def1fc]">

              <h2 className="p-1 bg-[#2a67b1] text-white text-left text-[13px]">
                List of Regions
              </h2>
              <div className="border border-b-gray-500 w-[347px]">
                <Link
                  className={`block text-center text-[13px] focus:bg-[#FEB941] outline-none ${
                    selectedIndex === 0 ? "bg-[#FEB941]" : ""
                  }`}
                  to={"/create/region"}
                >
                  <p className="ml-[285px] text-[13px]">Create</p>
                </Link>
                <Link
                  className={`block text-center text-[13px] focus:bg-[#FEB941] outline-none ${
                    selectedIndex === 1 ? "bg-[#FEB941]" : ""
                  }`}
                  to={"/alter"}
                >
                  <p className="ml-[270px] text-[13px] px-[30px]">Back</p>
                </Link>
              </div>
              <table className="w-full">

                <thead>
                  <tr>
                    <th></th>
                  </tr>
                </thead>

                <tbody>
                  {filteredRegions.map((reg, index) => (
                    <tr
                      key={reg.regionMasterId}

                      className={selectedIndex === index + 2 ? "bg-[#FEB941]" : ""}
                    >
                      <Link
                        to={`/alterRegionMaster/${reg.regionMasterId}`}
                        className="block text-left pl-2 text-[13px] focus:bg-[#FEB941] outline-none"
                      ><td className="text-[12.5px]">
                        {reg.regionMasterId} - {reg.regionName}

                      </td>
                      </Link>
                    </tr>
                  ))}
                </tbody>
              </table>
              {showDropdown && (
                <div className="mt-2">
                  <label
                    htmlFor="regionDropdown"
                    className="block text-center text-[14px] mb-1"
                  >
                  </label>
                  <select
                    id="regionDropdown"
                    ref={dropdownRef}
                    className="w-full border border-gray-600 bg-[#BBE9FF] p-1 text-[13px] focus:bg-yellow-200 focus:border focus:border-blue-500 focus:outline-none"
                    onChange={handleDropdownChange}
                  >

                    <option value="">Select Other Regions</option>
                    {region.slice(20).map((reg) => (

                      <option
                        key={reg.regionMasterId}
                        value={reg.regionMasterId}
                      >
                        {reg.regionMasterId} - {reg.regionName}
                      </option>
                    ))}
                  </select>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default RegionAlter;
