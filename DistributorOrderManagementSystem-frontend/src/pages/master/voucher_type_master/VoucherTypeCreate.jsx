import axios from "axios";
import { useRef, useState } from "react";
import { HiXMark } from "react-icons/hi2";

const VoucherTypeCreate = () => {
	const [voucherType, setVoucherType] = useState({
		name: "",
		type: "",
		status: "",
		startingNumber: "",
		widthOfNumerical: "",
		prefillWithZero: "",
		applicableFrom: "",
		periodicity: "",
		prefix: "",
		suffix: "",
	});
	const inputRefs = useRef([])
	// const [VoucherNo, setVoucherNo] = useState("")

	// const generateVoucherNo = (voucherType)=>{
	// 	let {prefillWithZero, prefix, suffix, startingNumber, widthOfNumerical} = voucherType;
	// 	startingNumber = startingNumber.toString();

	// 	if(prefillWithZero.toLowerCase() === 'yes' && widthOfNumerical){
	// 		startingNumber = startingNumber.padStart(widthOfNumerical, '0')
	// 	}
	// 	const voucherNo = `${prefix}-${startingNumber}${suffix ? "-" + suffix : ""}`;

    // return voucherNo;

	// }

	const changeHandler = (e) => {
		const { name, value } = e.target;
		setVoucherType({ ...voucherType, [name]: value });
	};
	
	// useEffect(()=>{
	// 	setVoucherNo(generateVoucherNo(voucherType))
	// },[voucherType])
	const handleKeyDown = (e, index)=>{
		const key = e.key;
		if(key === 'Enter'){
			if (e.target.value.trim() !== "") {
				const nextField = index + 1;
				if (nextField < inputRefs.current.length) {
					inputRefs.current[nextField].focus();
				}
			} else {
				e.preventDefault();
			}
		}
	}

	const handleSubmit = async (e) =>{
		
		if(e.key === 'Enter'){
			e.preventDefault();
			const userConfirmed = window.confirm("Do you want confirm VoucherTYpe");
			if(userConfirmed){
			await axios.post("http://localhost:9080/generate/saveVoucher", voucherType);
			console.log(voucherType)
			}
		}
	}
	
	return (
		<>
			<div className="flex justify-evenly">
				<div className=" w-[90%] h-screen">
				<form action="" onSubmit={e => e.preventDefault()}>
					<div className="bg-[#88bee6] w-full h-4 flex justify-between">
						<h1 className="text-[11px] pl-2 font-semibold">
							Voucher Type Creation
						</h1>
						<HiXMark
							className="text-[12px] text-base cursor-pointer"
							// onClick={() => navigate("/")}
						/>
					</div>

					<div className="w-1/2  mt-2 px-1">
						<div className=" flex leading-4">
							<label htmlFor="voucherType" className="w-1/5 text-[13px]">
								Name
							</label>
							<span className="mr-1">:</span>
							<input
								type="text"
								id="voucherType"
								autoCapitalize="words"
								autoComplete="off"
								autoFocus
								onChange={changeHandler}
								name="name"
								onKeyDown={(e) => handleKeyDown(e, 0)}
								value={voucherType.name}
								ref={(input) => (inputRefs.current[0] = input)}
								className="w-1/4 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
							/>
						</div>
						<div>
							<div className=" mt-5 border-t text-[13px] text-center font-semibold w-1/2">
								<h1>General</h1>
							</div>
							<div className=" flex leading-4 mt-2">
								<label htmlFor="voucherType" className="w-2/5 text-[14px]">
									Select type of voucher
								</label>
								<span className="mr-1">:</span>
								<input
									type="text"
									ref={(input) => (inputRefs.current[1] = input)}
									id="voucherType"
									autoCapitalize="words"
									autoComplete="off"
									onChange={changeHandler}
									onKeyDown={(e) => handleKeyDown(e, 1)}
									name="type"
									value={voucherType.type}
									className="w-1/4 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
								/>
							</div>
							<div className=" flex leading-4 mt-1">
								<label htmlFor="voucherType" className="w-2/5 text-[14px]">
									Activate this Voucher Type
								</label>
								<span className="mr-1">:</span>
								<input
									ref={(input) => (inputRefs.current[2] = input)}
									type="text"
									id="voucherType"
									autoCapitalize="words"
									onChange={changeHandler}
									name="status"
									onKeyDown={(e) => handleKeyDown(e, 2)}
									value={voucherType.status}
									autoComplete="off"
									className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
								/>
							</div>
							<div>
								<div className="flex leading-4 mt-1">
									<label htmlFor="" className="w-2/5 text-[14px]">
										Starting Number
									</label>
									<span className="mr-1">:</span>
									<input
										ref={(input) => (inputRefs.current[3] = input)}
										type="text"
										onChange={changeHandler}
										autoComplete="off"
										onKeyDown={(e) => handleKeyDown(e, 3)}
										name="startingNumber"
										value={voucherType.startingNumber}
										className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
									/>
								</div>
								<div className="flex leading-4 mt-1">
									<label htmlFor="" className="w-2/5 text-[14px]">
										Width of Numerical part
									</label>
									<span className="mr-1">:</span>
									<input
										ref={(input) => (inputRefs.current[4] = input)}
										type="text"
										onChange={changeHandler}
										autoComplete="off"
										onKeyDown={(e) => handleKeyDown(e, 4)}
										name="widthOfNumerical"
										value={voucherType.widthOfNumerical}
										className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
									/>
								</div>
								<div className="flex leading-4 mt-1">
									<label htmlFor="" className="w-2/5 text-[14px]">
										Prefill with Zero
									</label>
									<span className="mr-1">:</span>
									<input
										ref={(input) => (inputRefs.current[5] = input)}
										type="text"
										onChange={changeHandler}
										autoComplete="off"
										onKeyDown={(e) => handleKeyDown(e, 5)}
										name="prefillWithZero"
										value={voucherType.prefillWithZero}
										className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
									/>
								</div>
								<div className="flex leading-4 mt-1">
									<label htmlFor="" className="w-2/5 text-[14px]">
										Applicable From
									</label>
									<span className="mr-1">:</span>
									<input
										ref={(input) => (inputRefs.current[6] = input)}
										type="text"
										onChange={changeHandler}
										onKeyDown={(e) => handleKeyDown(e, 6)}
										autoComplete="off"
										name="applicableFrom"
										value={voucherType.applicableFrom}
										className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
									/>
								</div>
								<div className="flex leading-4 mt-1">
									<label htmlFor="" className="w-2/5 text-[14px]">
										Periodicity
									</label>
									<span className="mr-1">:</span>
									<input
										ref={(input) => (inputRefs.current[7] = input)}
										onKeyDown={(e) => handleKeyDown(e, 7)}
										type="text"
										onChange={changeHandler}
										autoComplete="off"
										name="periodicity"
										value={voucherType.periodicity}
										className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
									/>
								</div>
								<div className="flex leading-4 mt-1">
									<label htmlFor="" className="w-2/5 text-[14px]">
										Prefix Particular
									</label>
									<span className="mr-1">:</span>
									<input
										ref={(input) => (inputRefs.current[8] = input)}
										type="text"
										onChange={changeHandler}
										onKeyDown={(e) => handleKeyDown(e, 8)}
										autoComplete="off"
										name="prefix"
										autoCapitalize="words"
										value={voucherType.prefix}
										className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
									/>
								</div>
								<div className="flex leading-4 mt-1">
									<label htmlFor="" className="w-2/5 text-[14px]">
										Suffix Particular (optional)
									</label>
									<span className="mr-1">:</span>
									<input
										ref={(input) => (inputRefs.current[9] = input)}
										type="text"
										onChange={changeHandler}
										autoComplete="off"
										name="suffix"
										autoCapitalize="words"
										onKeyDown={handleSubmit}
										value={voucherType.suffix}
										className="w-24 capitalize border border-transparent outline-0 h-[18px] focus:border focus:border-blue-500 focus:bg-amber-100 text-[13px] font-semibold"
									/>
								</div>
							</div>
						</div>
					</div>
					</form>
				</div>
				
				<div className="w-[10%] bg-[#def1fc]"></div>
			</div>
		</>
	);
};
export default VoucherTypeCreate;
