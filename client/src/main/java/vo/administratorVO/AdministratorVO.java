package vo.administratorVO;

import po.administratorPO.AdministratorPO;
import constant.Authority;
import constant.UserType;

public class AdministratorVO {

	private boolean isWrong =false;
	
	private UserType type;
	private String name;
	private String id;
	private String password;
	private Authority limit=Authority.低;
	
	public AdministratorVO(UserType type, String name, String id,
			String password, Authority limit) {
		super();
		this.type = type;
		this.name = name;
		this.id = id;
		this.password = password;
		this.limit = limit;
	}
	
	
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Authority getLimit() {
		return limit;
	}
	public void setLimit(Authority limit) {
		this.limit = limit;
	}


	public boolean isWrong() {
		return isWrong;
	}

	public AdministratorPO adminVOToPO(){
		return new AdministratorPO(type,name,id,password,limit);
	}
}
