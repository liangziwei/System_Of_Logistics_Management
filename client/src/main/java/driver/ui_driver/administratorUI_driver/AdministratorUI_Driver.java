package driver.ui_driver.administratorUI_driver;

import java.rmi.RemoteException;

import constant.Authority;
import constant.UserType;
import businessLogicService.administratorBLService.AdministratorBLService;
import stub.businessLogicImpl_stub.administratorBLImpl_stub.AdministratorBLImpl_Stub;
import vo.administratorVO.AdministratorVO;



public class AdministratorUI_Driver {
	private AdministratorBLService administrator=new AdministratorBLImpl_Stub();
	private AdministratorVO administratorVO;
	
	public static void main(String[] args) throws RemoteException{
		AdministratorUI_Driver admin=new AdministratorUI_Driver ();
		admin.driver();
	}
	
	public void driver() throws RemoteException{
		administratorVO=new AdministratorVO(UserType.营业厅业务员,"dogee","C123456","0000",Authority.低);
		if(administrator.addUser(new AdministratorVO(UserType.营业厅业务员,"dogee","C123456","0000",Authority.低))){
			System.out.println("账户信息添加成功");
		}else{
			System.out.println("账户信息添加失败");
		}
		
		administratorVO=administrator.findUser("C123456");	
		System.out.println(administratorVO.getType()+" "+administratorVO.getId()+" "+administratorVO.getName()+" "+administratorVO.getPassword());
		
		if(administrator.deleteUser("C123456")){
			System.out.println("账户信息删除成功");
		}else{
			System.out.println("账户信息删除失败");
		}
		if(administrator.modifyUser(administratorVO)){
			System.out.println("账户信息修改成功");
		}else{
			System.out.println("账户信息修改失败");
		}
	}
}
