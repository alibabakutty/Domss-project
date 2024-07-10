import { useEffect, useRef, useState } from "react";
import { FaArrowRight } from "react-icons/fa";
import { TbMailCheck } from "react-icons/tb";
import PropTypes from "prop-types";
const OtpVerify = ({ otpLength = 6 }) => {
	const [otpFields, setOtpFields] = useState(new Array(otpLength).fill(""));
	const ref = useRef([]);
	const handleKeyDown = (e, index) => {
		const key = e.key;
        if(key === "ArrowLeft"){
            if(index > 0)
            ref.current[index - 1].focus()
        }
        if(key === "ArrowRight"){
            if(index < otpLength - 1)
                ref.current[index + 1].focus()
        }

        const copyOfFields = [...otpFields];
		if (key === "Backspace") {
			
                copyOfFields[index] = ""
                setOtpFields(copyOfFields);
                if(index > 0)
                    ref.current[index-1].focus()
			
		}
		if (isNaN(key)) {
			return;
		}
		
		if (index + 1 < otpFields.length) ref.current[index + 1].focus();
		copyOfFields[index] = key;
		setOtpFields(copyOfFields);
	};

    useEffect(()=>{
        ref.current[0].focus();
    },[])

	return (
		<>
			<div className="w-screen flex justify-center items-center h-screen">
				<form
					action=""
					className="w-72 h-96 border-2 border-emerald-400 flex flex-col items-center justify-evenly rounded"
				>
					<div>
						<TbMailCheck className="text-7xl text-emerald-400" />
					</div>
					<div>
						<code>
							Please check Your email and
							<br /> phone number
						</code>
					</div>
					<div className="flex gap-2 mt-3">
						{otpFields.map((value, index) => (
							<input
								key={index}
								ref={(el) => (ref.current[index] = el)}
								type="text"
								className="w-8 h-8 border-2 rounded-md text font-semibold
                text-center text-emerald-400 focus:outline-none focus:border-emerald-400"
								onKeyDown={(e) => handleKeyDown(e, index)}
								value={value}
								
							/>
						))}
					</div>
					<div>
						<button className="text-emerald-400 rounded font-semibold">
							Re-Send code
						</button>
					</div>
					<div className="mt-5">
						<button className="px-2 py-0.5 bg-emerald-400 text-white font-semibold rounded flex items-center gap-2">
							<code>Verify </code>
							<FaArrowRight />
						</button>
					</div>
				</form>
			</div>
		</>
	);
};
export default OtpVerify;
OtpVerify.propTypes = {
	otpLength: PropTypes.number,
};
