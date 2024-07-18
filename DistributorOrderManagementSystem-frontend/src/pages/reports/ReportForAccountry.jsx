// import axios from "axios";
// import jsPDF from "jspdf";
// import 'jspdf-autotable';
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";


const ReportForAccountry = () => {
	const navigate = useNavigate();

	useEffect(() => {
		const handleKeyDown = (e) => {
			if (e.key === "Escape") {
				navigate("/");
			} 
		};
		window.addEventListener("keydown", handleKeyDown);
		return () => {
			window.removeEventListener("keydown", handleKeyDown);
		};
	}, [navigate]);

	
	
    // const exportToPDF = () => {
	// 		const doc = new jsPDF();
	// 		doc.text("Accountry Report", 20, 10);
	// 		doc.autoTable({
	// 			head: [
	// 				[
	// 					"Voucher Type",
	// 					"Voucher No",
	// 					"Voucher Date",
	// 					"Distributor Name",
	// 					"Distributor Code",
	// 					"Voucher Amount",
	// 				],
	// 			],
	// 			body: data.map((item) => Object.values(item)),
	// 		});
	// 		doc.save("Accountry_Report.pdf");
	// 	};

	// const exportToExcel = () => {
	// 	const ws = XLSX.utils.json_to_sheet(data);
	// 	const wb = XLSX.utils.book_new();
	// 	XLSX.utils.book_append_sheet(wb, ws, "Report");
	// 	XLSX.writeFile(wb, "Accountry_Report.xlsx");
	// };
	return (
		<>
			<div className="h-screen overflow-y-scroll relative px-3">
				<div className="w-full">
					<div className=" flex justify-center w-full items-center">
						<h1 className="text-3xl">Accountry Report</h1>
					</div>

					<div className="flex flex-col text-[14px]">
						<div>From Date : 01/06/2024,</div>
						<div className="flex flex-row items-center">
							To Date : 30/06/2024.
						</div>
					</div>
                    {/* <button onClick={exportToPDF}>Go PDF</button> */}
				</div>
				<table className="table-fixed w-full">
					<thead className="sticky top-0 bg-white">
						<tr className="h-[17px] leading-4 border border-white">
							<th className=" w-40 border border-collapse border-slate-300 text-[13px]">
								Voucher Type
							</th>
							<th className=" w-40 border border-collapse border-slate-300 text-[13px]">
								Voucher No
							</th>
							<th className=" w-24 border border-collapse border-slate-300 text-[13px]">
								Voucher Date
							</th>
							<th className=" w-[450px] border border-collapse border-slate-300 text-[13px]">
								Distributor Name
							</th>
							<th className=" w-20 border border-collapse border-slate-300 text-[13px]">
								Distributor Code
							</th>
							<th className=" w-[150px] border border-collapse border-slate-300 text-[13px]">
								Voucher Amount
							</th>
						</tr>
					</thead>
					<tbody>
						{[...Array(10)].map((item, index) => (
							<tr className="h-[18px] leading-4" key={index}>
								<td className="w-full align-top text-[14px] border border-collapse border-slate-300 text-center">
									voucherType
								</td>
								<td className="w-full align-top text-[14px] border border-collapse border-slate-300 text-center">
									voucherNo
								</td>
								<td className="w-full align-top text-[14px] border border-collapse border-slate-300 text-center">
									voucherDate
								</td>
								<td className="w-full align-top text-[14px] border border-collapse border-slate-300">
									distributorName
								</td>
								<td className="w-full align-top text-[14px] border border-collapse border-slate-300 text-center">
									distributorCode
								</td>
								<td className="w-full align-top text-[14px] border border-collapse border-slate-300 text-right">
									voucherAmount
								</td>
							</tr>
						))}
					</tbody>
				</table>
			</div>
		</>
	);
};
export default ReportForAccountry;