import { BrowserRouter, Route, Routes } from "react-router-dom"
import Master from "./components/Master"
import MasterForm from "./components/create/MasterForm"
import MasterAlterFilter from "./components/alter/MasterAlterFilter"
import MasterDisplayFilter from "./components/display/MasterDisplayFilter"
import AlterRegionMaster from './pages/master/region_master/AlterRegionMaster'
import AlterExecutiveMaster from './pages/master/executive_master/AlterExecutiveMaster'
import AlterDistributorMaster from './pages/master/distributor_master/AlterDistributorMaster'
import AlterProductMaster from './pages/master/product_master/AlterProductMaster'
import AlterGodownMaster from './pages/master/godown_master/AlterGodownMaster'
import AlterVoucherTypeMaster from './pages/master/voucher_type_master/AlterVoucherTypeMaster'
import AlterLedgerMaster from './pages/master/ledger_master/AlterLedgerMaster'
import DisplayRegionMaster from './pages/master/region_master/DisplayRegionMaster'
import DisplayExecutiveMaster from './pages/master/executive_master/DisplayExecutiveMaster'
import DisplayDistributorMaster from './pages/master/distributor_master/DisplayDistributorMaster'
import DisplayProductMaster from './pages/master/product_master/DisplayProductMaster'
import DisplayGodownMaster from './pages/master/godown_master/DisplayGodownMaster'
import DisplayVoucherTypeMaster from './pages/master/voucher_type_master/DisplayVoucherTypeMaster'
import DisplayLedgerMaster from './pages/master/ledger_master/DisplayLedgerMaster'
import Home from "./components/Home"
import Voucher from "./pages/transaction/Voucher"
import Purchase from "./pages/transaction/Purchase"
import VoucherCreation from "./pages/transaction/VoucherCreation"
import DayBook from "./pages/transaction/DayBook"
import ReportForAccountry from "./pages/reports/ReportForAccountry"
import ReportWithItems from "./pages/reports/ReportWithItems"
import AlterOrder from "./pages/transaction/AlterOrder"


function App() {
  

  return (
    <>

      <BrowserRouter>
        <Routes>

          {/* Accounts Master */}
          <Route path="/" element={<Home />} />
          <Route path=":type" element = {<Master />} />
          <Route path="/create/:type" element={<MasterForm />} />
          <Route path=":type/filter" element={<MasterAlterFilter />} />
          <Route path="/display/:type" element={<MasterDisplayFilter />} />

          <Route path="alterRegionMaster/:regionMasterId" element = {<AlterRegionMaster />} />
          <Route path="alterExecutiveMaster/:executiveCode" element = {<AlterExecutiveMaster />} />
          <Route path="alterDistributorMaster/:distributorCode" element = {<AlterDistributorMaster />} />
          <Route path="alterProductMaster/:productCode" element = {<AlterProductMaster />} />
          <Route path="alterGodownMaster/:godownCode" element = {<AlterGodownMaster />} />
          <Route path="alterVoucherTypeMaster/:voucherTypeName" element = {<AlterVoucherTypeMaster />} />
          <Route path="alterLedgerMaster/:ledgerCode" element = {<AlterLedgerMaster /> } />

          

          <Route path="displayRegion/:regionMasterId" element = {<DisplayRegionMaster />} />
          <Route path="displayExecutive/:executiveCode" element = {<DisplayExecutiveMaster />} />
          <Route path="displayDistributor/:distributorCode" element={<DisplayDistributorMaster />} />
          <Route path="displayProduct/:productCode" element={<DisplayProductMaster />} />
          <Route path="displayGodown/:godownCode" element = {<DisplayGodownMaster />} />
          <Route path="displayVoucherTypeName/:voucherTypeName" element = {<DisplayVoucherTypeMaster />} />
          <Route path="displayVoucherType/:voucherType" element = {<DisplayVoucherTypeMaster />} />
          <Route path="displayLedger/:ledgerCode" element={<DisplayLedgerMaster />} />

          {/* Transaction */}
          <Route path="vouchers" element={<Voucher />} >
            <Route index element={<Purchase />} />
            <Route path="purchase" element={<Purchase />} />
            <Route path="sales" element={<VoucherCreation />} />
          </Route>
          <Route path="daybook" element={<DayBook />} />
          <Route path="alterOrder/:id" element={<AlterOrder />} ></Route>

          {/* Reports */}
          <Route path="report" element={<ReportForAccountry />} />
          <Route path="reportitems" element={<ReportWithItems />} />
        </Routes>
      </BrowserRouter>
      
      

    </>
  )
}

export default App
