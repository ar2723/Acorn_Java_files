package test.dto;

public class DeptDto {
	private int depno;
	private String dname;
	private String loc;
	
	public DeptDto() {}

	public DeptDto(int depno, String dname, String loc) {
		super();
		this.depno = depno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return depno;
	}

	public void setDeptno(int depno) {
		this.depno = depno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
}
