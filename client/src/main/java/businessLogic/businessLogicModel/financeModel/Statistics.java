package businessLogic.businessLogicModel.financeModel;
 
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

import dataService.financeDataService.StatisticsDataService;
import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;
import stub.dataImpl_stub.financeDataImpl_stub.StatisticsDataImpl_Stub;
import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;

public class Statistics {

//	private StatisticsDataService statisticsData = RMI.<StatisticsDataService>getDataService("statistics");
	private StatisticsDataService statisticsData =new StatisticsDataImpl_Stub();
	public CostBenefitVO getCostBenefit(String startDate, String endDate) {
		//计算总成本
		double cost = this.calculateCost(startDate, endDate);
		//计算总收入
		double income = this.calculateIncome(startDate, endDate);
		//计算总利润
		double profit = income - cost;
		return new CostBenefitVO(income, cost, profit);
	}
	
	public List<ReceivableVO> getReceivableList(String startDate,String endDate) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		try{
			List<ReceivablePO> po = statisticsData.getReceivableList(startDate, endDate);
			int size = po.size();
			for(int i=0;i<size;i++){
				ReceivablePO temp = po.get(i);
				receivablevo.add(receivablePOToreceivableVO(temp));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return receivablevo;
	}
	private ReceivableVO receivablePOToreceivableVO(ReceivablePO receivablePO){
		return new ReceivableVO(receivablePO.getDate(),receivablePO.getMoney(),
				receivablePO.getCourier(),receivablePO.getDeliveryid(),receivablePO.getBusinessID());
	}
	
	private double calculateCost(String startDate, String endDate) {
		List<PaymentPO> pay = null;
		try {
			pay = statisticsData.getPaymentList();
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0.0;
		}
		double cost = 0.0;
		int size = pay.size();
		for(int i = 0; i < size; i++) {
			cost += pay.get(i).getPayAmount();
		}
		return cost;
	}
	
	private double calculateIncome(String startDate, String endDate) {
		List<ReceivablePO> rec = null;
		try {
			rec = this.statisticsData.getReceivableList(startDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0.0;
		}
		int size = rec.size();
		double income = 0.0;
		for(int i = 0; i < size; i++) {
			income += rec.get(i).getMoney();
		}
		return income;
	}
	
	public void outExcel(String fileSave, List<ReceivableVO> list) {
		HSSFWorkbook wb = new HSSFWorkbook();//创建了一个excel文件
		HSSFSheet sheet = wb.createSheet("经营情况表");//创建了一个工作簿
		sheet.setDefaultColumnWidth(20);//设置统一单元格宽度
		sheet.setDefaultRowHeight((short)25);//设置统一单元格高度
		//样式
		HSSFCellStyle style = wb.createCellStyle();//样式对象
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直
		HSSFFont font = wb.createFont();//设置字体样式
		font.setFontHeightInPoints((short)10);//设置字体大小
		font.setFontName("宋体");//设置字体
		font.setItalic(true);//是否加粗
		style.setFont(font);//将字体格式加到style中
		style.setWrapText(true);//能否换行
		style.setBorderBottom((short)1);//设置下划线，参数是黑线的宽度
		style.setBorderLeft((short)1);//左边框
		style.setBorderRight((short)1);//右边框
		style.setBorderTop((short)1);//下边框
		
		//表格第一行
		HSSFRow row1 = sheet.createRow(0);//创建一行
		row1.setHeightInPoints(25);  
        HSSFCell cell1 = row1.createCell(0);   //--->创建一个单元格  
        cell1.setCellStyle(style); 
        cell1.setCellValue("收款日期");         
        HSSFCell cell2 = row1.createCell(1);   //--->创建一个单元格          
        cell2.setCellStyle(style);  
        cell2.setCellValue("收款金额");  
        HSSFCell cell3 = row1.createCell(2);   //--->创建一个单元格          
        cell3.setCellStyle(style);  
        cell3.setCellValue("收款快递员");  
        HSSFCell cell4 = row1.createCell(3);   //--->创建一个单元格          
        cell4.setCellStyle(style);  
        cell4.setCellValue("营业厅编号");  
        HSSFCell cell5 = row1.createCell(4);   //--->创建一个单元格          
        cell5.setCellStyle(style);  
        cell5.setCellValue("对应的所有快递订单条形码号");  
                
        for(int i=0;i<list.size();i++) {
        	HSSFRow rowN = sheet.createRow(i+1);
        	 HSSFCell cell1i = rowN.createCell(0);   //--->创建一个单元格  
             cell1i.setCellStyle(style); 
             cell1i.setCellValue(list.get(i).getDate());         
             HSSFCell cell2i = rowN.createCell(1);   //--->创建一个单元格          
             cell2i.setCellStyle(style);  
             cell2i.setCellValue(list.get(i).getMoney());  
             HSSFCell cell3i = rowN.createCell(2);   //--->创建一个单元格          
             cell3i.setCellStyle(style);  
             cell3i.setCellValue(list.get(i).getCourier());  
             HSSFCell cell4i = rowN.createCell(3);   //--->创建一个单元格          
             cell4i.setCellStyle(style);  
             cell4i.setCellValue(list.get(i).getBusinessID());  
             HSSFCell cell5i = rowN.createCell(4);   //--->创建一个单元格          
             cell5i.setCellStyle(style); 
             String deliveryid = "";
             for(String a:list.get(i).getDeliveryid()){
            	 deliveryid+=a+"\n";
             }
             cell5i.setCellValue(deliveryid);  
        }//外循环
        FileOutputStream fileOut = null;  
        try{              
            fileOut = new FileOutputStream(fileSave);  
            wb.write(fileOut);  
            //fileOut.close();  
//            System.out.print("OK");  
            wb.close();
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        finally{  
            if(fileOut != null){  
                try {  
                    fileOut.close();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
        }
	}
}
