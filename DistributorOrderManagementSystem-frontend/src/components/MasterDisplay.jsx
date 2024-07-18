import { useParams } from "react-router-dom"
import DisplayDistributorMaster from "../pages/master/distributor_master/DisplayDistributorMaster";
import DisplayExecutiveMaster from "../pages/master/executive_master/DisplayExecutiveMaster";
import DisplayGodownMaster from "../pages/master/godown_master/DisplayGodownMaster";
import DisplayLedgerMaster from "../pages/master/ledger_master/DisplayLedgerMaster";
import DisplayProductMaster from "../pages/master/product_master/DisplayProductMaster";
import DisplayRegionMaster from "../pages/master/region_master/DisplayRegionMaster";
import DisplayVoucherTypeMaster from "../pages/master/voucher_type_master/DisplayVoucherTypeMaster";

const MasterDisplay = () => {
    const {type} = useParams();
    const renderComponent = ()=>{
        switch(type){
            case 'distributor':
                return <DisplayDistributorMaster/>
            case 'executive':
                return <DisplayExecutiveMaster/>
            case 'godown':
                return <DisplayGodownMaster/>
            case 'ledger':
                return <DisplayLedgerMaster/>
            case 'product':
                return <DisplayProductMaster/>
            case 'region':
                return <DisplayRegionMaster/>
            case 'voucherType':
                return <DisplayVoucherTypeMaster/>
            default:
                return "Not Found 404..."
        }
    }
  return (
    <>
        {renderComponent()}
    </>
  )
}
export default MasterDisplay