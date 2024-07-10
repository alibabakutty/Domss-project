const Registration = () => {
	return (
		<>
			<div className="flex items-center justify-center h-screen">
				<div className="w-72 bg-emerald-100 h-[400px]">
                    <div className="flex flex-col items-center justify-center h-full">
                        <h1 className="text-2xl font-bold">Welcome to ABC </h1>
                        <p className="text-sm">Please enter your details to register</p>
                        
                    </div>
                </div>
				<div className="w-72 h-[400px] border-2 border-emerald-100 flex justify-center px-3">
					<form action="" className="flex flex-col items-center ">
						<h1 className="text-3xl mt-5 underline underline-offset-1 decoration-emerald-300">
							Register
						</h1>
						<div className="mt-10">
							<code>Register with Your Mobile Number and email.</code>
						</div>
						<div className="mt-5">
							<input
								type="text"
								placeholder="Enter your phone number"
								className="text-[16px] outline-0 border-b-2 focus:border-emerald-300 px-1 placeholder:text-sm"
							/>
						</div>
						<div className="mt-5">
							<input
								type="text"
								placeholder="Enter your Email"
								className="text-[16px] outline-0 border-b-2 focus:border-emerald-300 px-1 placeholder:text-sm"
							/>
						</div>
						<div className="mt-5">
							<input type="button" value={"Register"} className="bg-emerald-400 rounded px-2 py-0.5 text-lg text-white">
								
							</input>
						</div>
					</form>
				</div>
			</div>
		</>
	);
};
export default Registration;
