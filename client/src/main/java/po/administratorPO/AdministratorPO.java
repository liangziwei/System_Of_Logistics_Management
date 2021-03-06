package po.administratorPO;

import java.io.Serializable;

import vo.administratorVO.AdministratorVO;
import constant.Authority;
import constant.UserType;

public class AdministratorPO implements Serializable{
	
	private static final long serialVersionUID = 4363691605247598871L;

	@SuppressWarnings("unused")
	private boolean isWrong =false;
	private UserType type;
	private String name;
	private String id;
	private String password;
	private Authority limit;
    
	public AdministratorPO(UserType type, String name, String id,
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

	public void setWrong(boolean isWrong) {
		this.isWrong = isWrong;
	}
	public AdministratorVO adminPOToVO(){
		return new AdministratorVO(type,name,id,password,limit);
	}
}
