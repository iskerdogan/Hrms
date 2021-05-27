package javaCamp.Hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name="employers")
public class Employers extends User{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employers_id")
	private int employersId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	public Employers() {
		
	}
	
	public Employers(int userId, String email, String password, String passwordRepeat,int employersId, String companyName, String webAdress, String phoneNumber) {
		super(userId,email,password,passwordRepeat);
		this.employersId = employersId;
		this.companyName = companyName;
		this.webAdress = webAdress;
		this.phoneNumber = phoneNumber;
	}

	public int getEmployersId() {
		return employersId;
	}

	public void setEmployersId(int employersId) {
		this.employersId = employersId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebAdress() {
		return webAdress;
	}

	public void setWebAdress(String webAdress) {
		this.webAdress = webAdress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
