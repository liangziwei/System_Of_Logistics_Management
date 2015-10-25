package driver.ui_driver.administratorUI_driver;

import constant.Authority;
import constant.UserType;
import businessLogicService.administratorBLService.AdministratorBLService;
import stub.businessLogicImpl_stub.administratorBLImpl_stub.AdministratorBLImpl_Stub;
import vo.administratorVO.AdministratorVO;



public class AdministratorUI_Driver {
	private AdministratorBLService administrator=new AdministratorBLImpl_Stub();
	private AdministratorVO administratorVO;
	public void driver(){
		administratorVO=new AdministratorVO(UserType.BUSINESS,"dogee","C123456","0000",Authority.LOW);
		if(administrator.addUser(new AdministratorVO(UserType.BUSINESS,"dogee","C123456","0000",Authority.LOW))){
			System.out.println("账户信息添加成功");
		}else{
			System.out.println("账户信息添加失败");
		}
		
		administratorVO=administrator.findUser("C123456");	
		System.out.println(administratorVO.getType()+" "+administratorVO.getId()+" "+administratorVO.getName()+administratorVO.getPassword());
		
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
