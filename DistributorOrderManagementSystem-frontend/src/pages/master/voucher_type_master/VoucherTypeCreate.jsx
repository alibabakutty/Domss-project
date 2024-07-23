import { HiXMark } from "react-icons/hi2";

const VoucherTypeCreate = () => {
	return (
		<>
			<div className="flex justify-evenly">
				<div className=" w-[90%] h-screen">
					<div className="bg-[#88bee6] w-full h-4 flex justify-between">
						<h1 className="text-[11px] pl-2 font-semibold">Voucher Type Creation</h1>
						<HiXMark
							className="text-[12px] text-base cursor-pointer"
							// onClick={() => navigate("/")}
						/>
					</div>

					<div className="w-1/2  mt-2 px-1">
						<div className=" flex leading-4">
							<label htmlFor="voucherType" className="w-1/3 text-[13px]">
								Voucher Type
							</label>
                            <span className="mr-1">:</span>
							<input
								type="text"
								id="voucherType"
								className="w-1/3 border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
							/>
						</div>
					</div>
				</div>
                <div className="w-[10%] bg-[#def1fc]"></div>
			</div>
		</>
	);
};
export default VoucherTypeCreate;
