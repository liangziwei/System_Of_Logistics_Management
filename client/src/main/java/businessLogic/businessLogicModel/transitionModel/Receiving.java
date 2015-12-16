package businessLogic.businessLogicModel.transitionModel;

import java.rmi.RemoteException;
import java.util.HashMap;

import businessLogic.businessLogicModel.util.CommonLogic;
import dataService.deliveryDataService.OrderDataService;
import dataService.managerDataService.MakeConstantDataService;
import dataService.transitionDataService.ReceivingDataService;
import dataService.transitionDataService.TransferringDataService;
import network.RMI;
import po.transitionPO.ReceivingPO;
import po.transitionPO.TransferringPO;
import vo.transitionVO.ReceivingVO;

public class Receiving {
	private ReceivingDataService receivingDataService = RMI.<ReceivingDataService> getDataService("receiving");
	private MakeConstantDataService makeConstantDataService = RMI
			.<MakeConstantDataService> getDataService("makeConstant");
	private OrderDataService order = RMI.<OrderDataService> getDataService("order");
	private TransferringDataService transferringDataService = RMI.<TransferringDataService>getDataService("transferring");

	public boolean addReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		// 编辑物流轨迹
		boolean trace = false;
		HashMap<String, String> constant = null;
		try {
			constant = makeConstantDataService.getIDTable();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (receivingVO.gettransferringid().matches("\\d{16}")) {
			String pos1 = receivingVO.gettransitionid().substring(0, 3);
			TransferringPO transferringPO =null;
			try {
				transferringPO = transferringDataService.FindTransferringFormDT(receivingVO.gettransferringid().trim());
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(String del1:(transferringPO.getalldeliveryid())){
				try {
					trace = order.setTrace(del1, pos1 + "中转中心");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// 保存接收单
		if (trace) {
			ReceivingPO receivingPO = ReceivingVOtoReceivingPO(receivingVO);
			boolean result = false;
			try {
				result = receivingDataService.addReceivingFormDT(receivingPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		else {
			return trace;
		}
	}

	public boolean modifyReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		ReceivingPO receivingPO = ReceivingVOtoReceivingPO(receivingVO);
		boolean result = false;
		try {
			result = receivingDataService.modifyReceivingFormDT(receivingPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ReceivingVO findReceivingformBL(String receivingNumber) {
		// TODO Auto-generated method stub
		ReceivingPO receivingPO = null;
		ReceivingVO result = null;
		try {
			receivingPO = receivingDataService.FindReceivingFormDT(receivingNumber);
			if (receivingPO == null) {
				return null;
			} else {
				result = ReceivingPOtoReceivingVO(receivingPO);
				result.setVerifyResult(true);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	private ReceivingPO ReceivingVOtoReceivingPO(ReceivingVO receivingVO) {
		return new ReceivingPO(receivingVO.gettransitionid(), receivingVO.getarrivaldate(),
				receivingVO.gettransferringid(), receivingVO.getdepartureid(), receivingVO.getarrivalid(),
				receivingVO.getstate());
	}

	private ReceivingVO ReceivingPOtoReceivingVO(ReceivingPO receivingPO) {
		return new ReceivingVO(receivingPO.gettransitionid(), receivingPO.getarrivaldate(),
				receivingPO.gettransferringid(), receivingPO.getdepartureid(), receivingPO.getarrivalid(),
				receivingPO.getstate());
	}

	public boolean verifyres(ReceivingVO receivingVO) {

		if (receivingVO.gettransferringid().equals("") || (!receivingVO.gettransferringid().matches("\\d{16}")
				|| (!receivingVO.gettransferringid().matches("\\d{19}")))) {
			receivingVO.seterrorMsg("中转单编号不能为空或输入错误(16位或19位)");
			return false;
		}
		HashMap<String, String> constant = null;
		try {
			constant = makeConstantDataService.getIDTable();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String position = constant.get(receivingVO.gettransitionid().substring(0, 3));
		if (position==null) {
			receivingVO.seterrorMsg("中转中心编号前3位数字应为城市编号");
			return false;
		}
		if (receivingVO.getarrivaldate().equals("")) {
			receivingVO.seterrorMsg("时间不可为空");
			return false;
		}
		if (!CommonLogic.isDate(receivingVO.getarrivaldate())) {
			receivingVO.seterrorMsg("时间输入有误");
			return false;
		}

		// String[] aStrings = receivingVO.getarrivaldate().split("-");
		// String date = "";
		// // for(String x :aStrings){
		// // System.out.println(x+"1");
		// // }
		// if (aStrings[0].equals(" ") || aStrings[1].equals(" ") ||
		// aStrings[2].equals(" ")) {
		// receivingVO.seterrorMsg("到达日期不能为空");
		// return false;
		// }
		// for (int i = 0; i < 3; i++) {
		// aStrings[i] = aStrings[i].trim();
		// if (i == 2) {
		// date += aStrings[i];
		// } else {
		// date = date + aStrings[i] + "-";
		// }
		// }
		// int[] aint = new int[3];
		// for (int i = 0; i < 3; i++) {
		// aint[i] = Integer.parseInt(aStrings[i]);
		//
		// }
		// if (aint[1] < 1 || aint[1] > 12) {
		// receivingVO.seterrorMsg("月份输入错误");
		// return false;
		// }
		// if (aint[2] < 1 || aint[2] > 31) {
		// receivingVO.seterrorMsg("日期输入错误");
		// return false;
		// }
		//
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// try {
		// // 设置lenient为false.
		// // 否则SimpleDateFormat会比较宽松地验证日期，比如2007-02-29会被接受，并转换成2007-03-01
		// format.setLenient(false);
		// format.parse(date);
		// } catch (ParseException e) {
		// // e.printStackTrace();
		// // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
		// receivingVO.seterrorMsg("日期输入有误");
		// return false;
		// }

		if (receivingVO.gettransitionid().equals("") || (!receivingVO.gettransitionid().matches("\\d{4}"))) {
			receivingVO.seterrorMsg("本中转中心编号不能为空或者输入错误(4位)");
			return false;
		}

		if (receivingVO.getdepartureid().equals("")) {
			receivingVO.seterrorMsg("出发地不能为空");
			return false;
		}

		if (receivingVO.getarrivalid().equals("")) {
			receivingVO.seterrorMsg("到达地不能为空");
			return false;
		}
		return true;
	}
}
