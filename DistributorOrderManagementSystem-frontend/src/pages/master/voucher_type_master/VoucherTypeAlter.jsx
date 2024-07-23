import React, { useEffect, useRef, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { listOfVoucherTypeNames, listOfVoucherTypes } from '../../../services/MasterService';

const VoucherTypeAlter = () => {
  const [voucherTypeName, setVoucherTypeName] = useState('');
  const [voucherTypeNames, setVoucherTypeNames] = useState([]);
  const [voucherTypes, setVoucherTypes] = useState([]);
  const [filteredVoucherNames, setFilteredVoucherNames] = useState([]);
  const [filteredVoucherTypes, setFilteredVoucherTypes] = useState([]);
  const [selectedIndex, setSelectedIndex] = useState(0);
  const [showDropdown, setShowDropdown] = useState(false);
  const inputRef = useRef(null);
  const dropdownRef = useRef(null);
  const navigate = useNavigate();

  useEffect(() => {
    inputRef.current.focus();

    listOfVoucherTypeNames()
      .then(response => {

        setVoucherTypeNames(response.data);
        setFilteredVoucherNames(response.data.slice(0, 20));
        setShowDropdown(response.data.length > 20);
      })
      .catch(error => {
        console.error(error);
      });

    listOfVoucherTypes()
      .then(response => {

        setVoucherTypes(response.data);
        setFilteredVoucherTypes(response.data.slice(0, 20));
        setShowDropdown(response.data.length > 20);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  useEffect(() => {

    filterVoucherNames();
  }, [voucherTypeName]);

  useEffect(() => {
    const handleKeyDown = e => {
      const totalItems = showDropdown
        ? filteredVoucherNames.length + filteredVoucherTypes.length + 3 // Create, Back, Dropdown
        : filteredVoucherNames.length + filteredVoucherTypes.length + 2; // Create, Back

      if (e.key === 'ArrowDown') {
        setSelectedIndex(prevIndex => (prevIndex + 1) % totalItems);
        e.preventDefault();
      } else if (e.key === 'ArrowUp') {
        setSelectedIndex(prevIndex => (prevIndex - 1 + totalItems) % totalItems);
        e.preventDefault();
      } else if (e.key === 'Enter') {
        if (selectedIndex === 0) {
          navigate('/create/voucherType');
        } else if (selectedIndex === 1) {
          navigate('/alter');
        } else if (
          showDropdown &&
          selectedIndex === filteredVoucherNames.length + filteredVoucherTypes.length + 2
        ) {
          dropdownRef.current.focus();

    
        } else if (filteredVoucherNames[selectedIndex - 2]) {
          navigate(
            `/alterVoucherTypeMaster/${filteredVoucherNames[selectedIndex - 2].voucherTypeName}`,
          );
        } else if (filteredVoucherTypes[selectedIndex - filteredVoucherNames.length - 2]) {
          navigate(
            `/displayVoucherType/${
              filteredVoucherTypes[selectedIndex - filteredVoucherNames.length - 2].voucherType
            }`,
          );
        }

        e.preventDefault();

      } else if (e.key === 'Escape') {
        navigate('/alter');
      }
    };

    window.addEventListener('keydown', handleKeyDown);

    return () => {
      window.removeEventListener('keydown', handleKeyDown);
    };
  }, [filteredVoucherNames, filteredVoucherTypes, selectedIndex, navigate, showDropdown]);

  const filterVoucherNames = () => {
    if (voucherTypeName === '') {

      setFilteredVoucherNames(voucherTypeNames.slice(0, 20));
      setFilteredVoucherTypes(voucherTypes.slice(0, 20));
      setShowDropdown(voucherTypeNames.length > 20 || voucherTypes.length > 20);
    } else {
      const filteredNames = voucherTypeNames
        .filter(vou => vou.voucherTypeName.toLowerCase().includes(voucherTypeName.toLowerCase()))
        .slice(0, 20);

      const filteredTypes = voucherTypes
        .filter(vou => vou.voucherType.toLowerCase().includes(voucherTypeName.toLowerCase()))
        .slice(0, 20);


      setFilteredVoucherNames(filteredNames);
      setFilteredVoucherTypes(filteredTypes);
      setShowDropdown(filteredNames.length > 20 || filteredTypes.length > 20);
    }
    setSelectedIndex(2); // Reset selection index after filtering
  };

  const handleDropdownChange = e => {
    const selectedVoucherType = e.target.value;
    navigate(`/displayVoucherType/${selectedVoucherType}`);
  };

  return (
    <>
      <div className="flex justify-evenly" onClick={() => inputRef.current.focus()}>
        <div className="w-[80%] flex h-screen">
          <div className="w-[50%] bg-white"></div>

          <div className="w-[65%] bg-slate-100 flex justify-center items-center flex-col">
            <div className="w-[50%] h-16 flex flex-col justify-center items-center border border-black bg-white border-b-0">
              <p className="text-[13px] font-semibold underline underline-offset-4 decoration-gray-400">
                Voucher Type Alter
              </p>
              <input
                type="text"
                id="voucherTypeName"
                name="voucherTypeName"
                value={voucherTypeName}


                onChange={e => {
                  setVoucherTypeName(e.target.value);
                  filterVoucherNames();
                }}
                ref={inputRef}
                className="w-[250px] ml-2 mt-2 h-5 capitalize font-medium pl-1 text-sm focus:bg-yellow-200 focus:border focus:border-blue-500 focus:outline-none"
                autoComplete="off"
              />
            </div>

            <div className="w-[350px] h-[85vh] border border-gray-600 bg-[#def1fc]">
              <h2 className="p-1 bg-[#2a67b1] text-white text-left text-[14px]">
                List of Voucher Types
              </h2>

              <div className="border border-b-gray-500 w-[347px]">
                <Link
                  tabIndex={0}
                  onFocus={() => setSelectedIndex(0)}
                  className={`block text-center text-[14px] focus:bg-[#FEB941] outline-none ${
                    selectedIndex === 0 ? 'bg-[#FEB941]' : ''
                  }`}
                  to={'/create/voucherType'}
                >
                  <p className="ml-[285px] text-[13px]">Create</p>
                </Link>
                <Link
                  tabIndex={0}
                  onFocus={() => setSelectedIndex(1)}
                  className={`block text-center text-[14px] focus:bg-[#FEB941] outline-none ${
                    selectedIndex === 1 ? 'bg-[#FEB941]' : ''
                  }`}
                  to={'/alter'}
                >
                  <p className="ml-[287px] text-[13px]">Back</p>
                </Link>
              </div>

              <table>
                <thead>
                  <tr>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  {filteredVoucherNames.map((vou, index) => (
                    <tr
                      key={vou.voucherTypeName}
                      className={selectedIndex === index + 2 ? 'bg-[#FEB941]' : ''}
                    >
                      <td className="w-[350px]">
                        <Link
                          className="text-[12.5px]"
                          to={`/alterVoucherTypeMaster/${vou.voucherTypeName}`}
                          tabIndex={0}
                          onFocus={() => setSelectedIndex(index + 2)}
                        >
                          <div className="flex text-left pl-2 capitalize">
                            {vou.voucherTypeName}
                          </div>
                        </Link>
                      </td>
                    </tr>
                  ))}

                  {filteredVoucherTypes.map((vou, index) => (
                    <tr
                      key={vou.voucherType}
                      className={
                        selectedIndex === index + filteredVoucherNames.length + 2
                          ? 'bg-[#FEB941]'
                          : ''
                      }
                    >
                      <td className="w-[350px]">
                        <Link
                          className="text-[12.5px]"
                          to={`/displayVoucherType/${vou.voucherType}`}
                          tabIndex={0}
                          onFocus={() => setSelectedIndex(index + filteredVoucherNames.length + 2)}
                        >
                          <div className="flex text-left pl-2 capitalize">{vou.voucherType}</div>
                        </Link>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
              {showDropdown && (
                <div className="mt-2">
                  <label
                    htmlFor="voucherTypeDropDown"
                    className="block text-center text-[14px] mb-1"
                  >
                    Select Other Voucher Types
                  </label>
                  <select
                    name="voucherTypeDropDown"
                    id="voucherTypeDropDown"
                    ref={dropdownRef}
                    className={`w-full border border-gray-600 bg-[#BBE9FF] p-1 text-[13px] focus:bg-yellow-200 focus:border focus:border-blue-500 focus:outline-none`}
                    onChange={handleDropdownChange}
                  >
                    <option value="">-- Select --</option>
                    {voucherTypes.map(vou => (
                      <option key={vou.voucherType} value={vou.voucherType}>
                        {vou.voucherType}
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

export default VoucherTypeAlter;
