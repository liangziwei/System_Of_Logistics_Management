package businessLogic.businessLogicModel.repositoryModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import constant.AreaCodeType;
import dataService.repositoryDataService.ManageRepositoryDataService;
import network.RMI;
import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;

public class ManageRepository {
	// MockCheckRepository check = new MockCheckRepository();
	// MockGetRepository get = new MockGetRepository();
	// MockSeeRepository see = new MockSeeRepository();
	private ManageRepositoryDataService manageRepositoryDataService = RMI
			.<ManageRepositoryDataService> getDataService("manage");
	// private List<RepositoryVO> repositoryVOs;
	// private List<RepositoryInfoVO> repositoryVOs2;
	// private List<DeliveryInfoVO> deliveryInfoVOs;

	public List<RepositoryInfoVO> SeeRepositoryBL(String time) {
		// TODO Auto-generated method stub
		// List<RepositoryInfoPO> repositoryPOs = see.SeeRepositoryDT(time);
		// repositoryVOs2 = new ArrayList<RepositoryInfoVO>();
		// for(int i=0;i<(repositoryPOs.size());i++){
		// repositoryVOs2.add(this.RepositoryInfoPOtoRepositoryInfoVO(repositoryPOs.get(i)));
		// }
		List<RepositoryInfoPO> listPO = new ArrayList<RepositoryInfoPO>();
		List<RepositoryInfoVO> listVO = new ArrayList<RepositoryInfoVO>();
		try {
			listPO = manageRepositoryDataService.SeeRepositoryDT(time);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < (listPO.size()); i++) {
			listVO.add(this.RepositoryInfoPOtoRepositoryInfoVO(listPO.get(i)));
		}
		return listVO;
	}

	public List<DeliveryInfoVO> CheckRepositoryBL() {
		// TODO Auto-generated method stub
		// List<DeliveryInfoPO> deliveryInfoPOs = check.CheckRepositoryDT();
		// deliveryInfoVOs = new ArrayList<DeliveryInfoVO>();
		// for(int i=0;i<(deliveryInfoPOs.size());i++){
		// deliveryInfoVOs.add(this.DeliveryInfoPOtoDeliveryInfoVO(deliveryInfoPOs.get(i)));
		// }
		List<DeliveryInfoPO> listPO2 = new ArrayList<DeliveryInfoPO>();
		List<DeliveryInfoVO> listVO2 = new ArrayList<DeliveryInfoVO>();
		try {
			listPO2 = manageRepositoryDataService.CheckRepositoryDT();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < (listPO2.size()); i++) {
			DeliveryInfoVO deliveryInfoVO = this.DeliveryInfoPOtoDeliveryInfoVO(listPO2.get(i));
			listVO2.add(deliveryInfoVO);
		}
		return listVO2;
	}

	public boolean SetWarnValueBL(AreaCodeType ID, int allNum, double WarnNum) {
		// TODO Auto-generated method stub
		boolean set = false;
		try {
			set = manageRepositoryDataService.UpdataRepositoryWarnDT(allNum, WarnNum, ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	public double GetWarnNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		double warnnnum = 0.0;
		try {
			warnnnum = manageRepositoryDataService.GetWarnNumDT(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return warnnnum;
	}

	public int GetRepositoryNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		int num = 0;
		try {
			num = manageRepositoryDataService.GetRepositoryNumDT(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	public int GetRepositoryExistBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		int exist = 0;
		try {
			exist = manageRepositoryDataService.GetRepositoryExistDT(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}

	public List<RepositoryVO> GetRepositoryInfoBL() {
		// TODO Auto-generated method stub
		List<RepositoryPO> repositoryPOs = new ArrayList<RepositoryPO>();
		List<RepositoryVO> repositoryVOs = new ArrayList<RepositoryVO>();
		try {
			repositoryPOs = manageRepositoryDataService.GetRepositoryInfoDT();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < (repositoryPOs.size()); i++) {
			RepositoryVO repositoryvo = this.RepositoryPOtoRepositoryVO(repositoryPOs.get(i));
			repositoryVOs.add(repositoryvo);
		}
		return repositoryVOs;
	}

	public boolean verify(String warn, String all) {
		// TODO Auto-generated method stub
		if (warn.equals("") || all.equals("")) {
			return false;
		}
		if ((Double.parseDouble(warn)) > 1 || (Double.parseDouble(warn)) < 0) {
			return false;
		}
		return true;
	}

	private RepositoryVO RepositoryPOtoRepositoryVO(RepositoryPO repositoryPO) {
		return new RepositoryVO(repositoryPO.getdeliveryid(), repositoryPO.getinrepositorydate(),
				repositoryPO.getarrivalid(), repositoryPO.getareaCode(), repositoryPO.getrowid(),
				repositoryPO.getshelfid(), repositoryPO.getposid());
	}

	private RepositoryInfoVO RepositoryInfoPOtoRepositoryInfoVO(RepositoryInfoPO repositoryInfoPO) {
		RepositoryInfoVO repositoryInfoVO = new RepositoryInfoVO(repositoryInfoPO.getdeliveryid(),
				repositoryInfoPO.getareaCode(), repositoryInfoPO.getrowid(), repositoryInfoPO.getshelfid(),
				repositoryInfoPO.getposid(), repositoryInfoPO.getbeinrepository());
		repositoryInfoVO.setmoney(repositoryInfoPO.getmoney());
		return repositoryInfoVO;
	}

	private DeliveryInfoVO DeliveryInfoPOtoDeliveryInfoVO(DeliveryInfoPO deliveryInfoPO) {
		return new DeliveryInfoVO(deliveryInfoPO.getdeliveryid(), deliveryInfoPO.getinrepositorydate(),
				deliveryInfoPO.getarrivalid(), deliveryInfoPO.getareaCode(), deliveryInfoPO.getrowid(),
				deliveryInfoPO.getshelfid(), deliveryInfoPO.getposid());
	}

	public void Excel(String fileSave, List<DeliveryInfoVO> list) {
		// TODO Auto-generated method stub
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("库存信息");
		sheet.setDefaultColumnWidth(20);// 设置统一单元格宽度
		sheet.setDefaultRowHeight((short) 25);// 设置统一单元格高度
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(25);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		HSSFFont font = wb.createFont();// 设置字体样式
		font.setFontHeightInPoints((short) 10);// 设置字体大小
		font.setFontName("宋体");// 设置字体
		font.setItalic(true);// 是否加粗
		style.setFont(font);// 将字体格式加到style中
		style.setWrapText(true);// 能否换行
		style.setBorderBottom((short) 1);// 设置下划线，参数是黑线的宽度
		style.setBorderLeft((short) 1);// 左边框
		style.setBorderRight((short) 1);// 右边框
		style.setBorderTop((short) 1);// 下边框

		HSSFCell cell1 = row.createCell(0); // --->创建一个单元格
		cell1.setCellValue("快递编号");
		cell1.setCellStyle(style);
		HSSFCell cell2 = row.createCell(1);
		cell2.setCellValue("入库日期");
		cell2.setCellStyle(style);
		HSSFCell cell3 = row.createCell(2);
		cell3.setCellValue("目的地");
		cell3.setCellStyle(style);
		HSSFCell cell4 = row.createCell(3);
		cell4.setCellValue("区号");
		cell4.setCellStyle(style);
		HSSFCell cell5 = row.createCell(4);
		cell5.setCellValue("排号");
		cell5.setCellStyle(style);
		HSSFCell cell6 = row.createCell(5);
		cell6.setCellValue("架号");
		cell6.setCellStyle(style);
		HSSFCell cell7 = row.createCell(6);
		cell7.setCellValue("位号");
		cell7.setCellStyle(style);

		for (int i = 0; i < list.size(); i++) {
			HSSFRow rowN = sheet.createRow(i + 1);
			HSSFCell cell1i = rowN.createCell(0); // --->创建一个单元格
			cell1i.setCellStyle(style);
			cell1i.setCellValue(list.get(i).getdeliveryid());
			HSSFCell cell2i = rowN.createCell(1); // --->创建一个单元格
			cell2i.setCellStyle(style);
			cell2i.setCellValue(list.get(i).getinrepositorydate());
			HSSFCell cell3i = rowN.createCell(2); // --->创建一个单元格
			cell3i.setCellStyle(style);
			cell3i.setCellValue(list.get(i).getarrivalid());
			HSSFCell cell4i = rowN.createCell(3); // --->创建一个单元格
			cell4i.setCellStyle(style);
			cell4i.setCellValue(list.get(i).getareaCode().toString());
			HSSFCell cell5i = rowN.createCell(4); // --->创建一个单元格
			cell5i.setCellStyle(style);
			cell5i.setCellValue(list.get(i).getrowid());
			HSSFCell cell6i = rowN.createCell(5); // --->创建一个单元格
			cell6i.setCellStyle(style);
			cell6i.setCellValue(list.get(i).getshelfid());
			HSSFCell cell7i = rowN.createCell(6); // --->创建一个单元格
			cell7i.setCellStyle(style);
			cell7i.setCellValue(list.get(i).getposid());
		}
		// 保存
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(fileSave);
			wb.write(fileOut);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//
	// public void plExcel(String fileSave, List<DeliveryInfoVO> list) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// public void traExcel(String fileSave, List<DeliveryInfoVO> list) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// public void truExcel(String fileSave, List<DeliveryInfoVO> list) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// public void moExcel(String fileSave, List<DeliveryInfoVO> list) {
	// // TODO Auto-generated method stub
	//
	// }
}
