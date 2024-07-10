import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

const ReportWithItems = () => {
	const navigation = useNavigate();
	const [report, setReport] = useState([]);
	const [selectedIndex, setSelectedIndex] = useState(0);
	const [selectedCell, setSelectedCell] = useState({
		rowIndex: 0,
		colIndex: 0,
	});
	const dataRef = useRef({});

	useEffect(() => {
		// Focus on the first cell when the component mounts
		if (report.length > 0 && dataRef.current["0-0"]) {
			dataRef.current["0-0"].focus();
		}
	}, [report.length]);

	useEffect(() => {
		const handleKeyDown = (e) => {
			if (e.key === "Escape") {
				navigation("/");
			}
		};

		window.addEventListener("keydown", handleKeyDown);
		return () => {
			window.removeEventListener("keydown", handleKeyDown);
		};
	}, [navigation]);

	useEffect(() => {
		loadReport();
	}, []);

	const loadReport = async () => {
		const response = await axios.get(
			"http://localhost:8080/orders/getInformation"
		);
		// console.log(response.data);
		setReport(response.data);
	};

	const convertDateFormat = (dateString) => {
		const formattedDate = dateString.replace(/[./]/g, "-");
		const parts = formattedDate.split("-");
		if (parts.length === 3) {
			const [year, month, day] = parts;
			return `${day}/${month}/${year}`;
		} else {
			return dateString;
		}
	};

	const convertDateTime = (dateTimeString) => {
		// Replace "." or "/" to "-" date part
		const formattedDateTime = dateTimeString.replace(/[./]/g, "-");

		// Split date and time parts
		const [datePart, timePart] = formattedDateTime.split("T");
		const [year, month, day] = datePart.split("-");

		let [hours, minutes] = timePart.split(":");
		hours = parseInt(hours, 10);
		minutes = parseInt(minutes, 10);

		return `${day.padStart(2, "0")}/${month.padStart(2, "0")}/${year}  ${String(
			hours
		).padStart(2, "0")}:${String(minutes).padStart(2, "0")}`;
	};

	const handleKeyPress = (e, rowIndex, colIndex) => {
		let nextRowIndex = rowIndex;
		let nextColIndex = colIndex;

		if (e.key === "ArrowUp") {
			nextRowIndex = rowIndex > 0 ? rowIndex - 1 : rowIndex;
		} else if (e.key === "ArrowDown") {
			nextRowIndex = rowIndex < report.length - 1 ? rowIndex + 1 : rowIndex;
		} else if (e.key === "ArrowRight") {
			nextColIndex =
				colIndex < Object.keys(report[rowIndex]).length - 1
					? colIndex + 1
					: colIndex;
		} else if (e.key === "ArrowLeft") {
			nextColIndex = colIndex > 0 ? colIndex - 1 : colIndex;
		} else if (e.key === "Enter") {
			navigation(`/alterOrder/${report[selectedIndex].orderId}`);
		}

		const nextCell = dataRef.current[`${nextRowIndex}-${nextColIndex}`];
		if (nextCell) {
			nextCell.focus();
		}
		setSelectedIndex(nextRowIndex);
		setSelectedCell({ rowIndex: nextRowIndex, colIndex: nextColIndex });
	};

	return (
		<>
			<div className="">
				<div className="flex justify-center items-center ">
					<h1 className="text-3xl">Company Name</h1>
				</div>

				<div className="h-10 flex justify-between text-[14px]">
					<div><h1 className="text-xl">
                    List of All Sale Vouchers
                    </h1></div>
					<div className="flex flex-row items-center">
						01-06-2024  To 30-06-2024.
					</div>
				</div>
			</div>

			<div className="overflow-x-auto w-full h-[87vh]">
				<table className="w-full bg-white table-fixed snap-x ">
					<thead className="divide-y divide-gray-600 ">
						<tr className="h-[17px] leading-4 border border-slate-300">
							<th className="border border-collapse border-slate-300 w-28 text-[13px]">
								Voucher Type
							</th>
							<th className={"border border-collapse border-slate-300 w-28 text-[13px]"}>
								Voucher NO.
							</th>
							<th className="border border-collapse border-slate-300 w-28 text-[13px]">
								Voucher Date
							</th>
							<th className="border border-collapse border-slate-300 w-28 text-[13px]">
								Distributor Code
							</th>
							<th className="border border-collapse border-slate-300 w-[300px] text-[13px]">
								Distributor Name
							</th>
							<th className="border border-collapse border-slate-300 w-36 text-[13px]">
								Stock Category
							</th>
							<th className="border border-collapse border-slate-300 w-24 text-[13px]">
								Product Code
							</th>
							<th className="border border-collapse border-slate-300 w-[350px] text-[13px]">
								Product Name
							</th>
							<th className="border border-collapse border-slate-300 w-36 text-[13px]">
								Ordered Quantity
							</th>
							<th className="border border-collapse border-slate-300 w-12 text-[13px]">
								UOM
							</th>
							<th className="border border-collapse border-slate-300 w-32 text-[13px]">
								Approved Quantity
							</th>
							<th className="border border-collapse border-slate-300 w-16 text-[13px]">
								Rate
							</th>
							<th className="border border-collapse border-slate-300 w-16 text-[13px]">
								Discount
							</th>
							<th className="border border-collapse border-slate-300 w-24 text-[13px]">
								Amount
							</th>
							<th className="border border-collapse border-slate-300 w-40 text-[13px]">
								Created By
							</th>
							<th className="border border-collapse border-slate-300 w-36 text-[13px]">
								Created Date & Time
							</th>
							<th className="border border-collapse border-slate-300 w-48 text-[13px]">
								Approved By
							</th>
							<th className="border border-collapse border-slate-300 w-36 text-[13px]">
								Approved Date & Time
							</th>
							<th className="border border-collapse border-slate-300 w-[250px] text-[13px]">
								Order Summary
							</th>
						</tr>
					</thead>
					<tbody className="">
						{report.map((item, rowIndex) => (
							
							
							<tr key={rowIndex} 
                            className={` h-[18px] leading-3 whitespace-nowrap ${selectedIndex === rowIndex ? "bg-amber-100" : ""}  `}>
								{
									Object.keys(item).map((key, colIndex) => (
									<td
									key={colIndex}
									tabIndex="0"
									onKeyDown={e => handleKeyPress(e, rowIndex, colIndex)}
									ref={(el) =>
										(dataRef.current[`${rowIndex}-${colIndex}`] = el)
									}
									className={`outline-0 border-r px-1 text-[13px] ${
										key === "orderQty" ||
										key === "approvedQuantity" ||
										key === "rate"
											? "text-right"
											: key === "uom"
											? "text-center"
											: "text-left"
									} ${
										selectedCell.rowIndex === rowIndex &&
										selectedCell.colIndex === colIndex
											? "bg-amber-300"
											: ""
									} snap-start
                                    `}
         
									>
									{key === 'voucherDate'
										? convertDateFormat(item[key])
										: (key === 'createdDateTime' || key === 'approvedDateTime')
										? convertDateTime(item[key])
										: item[key]}
									</td>
								))}
							</tr>
						))}
					</tbody>
				</table>
			</div>
		</>
	);
};
export default ReportWithItems;
{/* <tr key={index} className="h-[18px] leading-4 text-sm">
								<td className="sticky left-0 bg-white w-28 truncate border border-gray-200">
									{item.voucherType}
								</td>
								<td className="truncate border border-gray-200">
									{item.voucherNo}
								</td>
								<td className="truncate border border-gray-200">
									{item.voucherDate}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.distributorCode}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.distributorName}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.category}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.code}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.description}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.orderQty}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.uom}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.approvedQuantity}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.rate}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.discount}
								</td>
								<td className="truncate border w-full border-gray-200">
									{item.amount}
								</td>
								<td className="px-6  truncate border w-full border-gray-200">
									{item.createdBy}
								</td>
								<td className="px-6  truncate border w-full border-gray-200">
									{convertDateTime(item.createdDateTime)}
								</td>
								<td className="px-6  truncate border w-full border-gray-200">
									{item.approvedBy}
								</td>
								<td className="px-6  truncate border w-full border-gray-200">
									{convertDateTime(item.approvedDateTime)}
								</td>
								<td className="px-6  truncate border w-full border-gray-200">
									{item.narration}
								</td>
							</tr> */}

							