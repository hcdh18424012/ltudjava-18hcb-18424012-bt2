package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// default package
// Generated Aug 14, 2019 12:44:01 AM by Hibernate Tools 5.4.3.Final

/**
 * ThoiKhoaBieu generated by hbm2java
 */
@Entity
@Table(name = "thoikhoabieu")
public class ThoiKhoaBieu implements java.io.Serializable {
	@Id
	private String malop;
	private String mamon;
	private String tenmon;
	private String phonghoc;

	public ThoiKhoaBieu() {
	}
	public ThoiKhoaBieu(String malop, String mamon, String tenmon, String phonghoc) {
		this.malop = malop;
		this.mamon = mamon;
		this.tenmon = tenmon;
		this.phonghoc = phonghoc;
	}

	public String getTenmon() {
		return this.tenmon;
	}

	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}

	public String getPhonghoc() {
		return this.phonghoc;
	}

	public void setPhonghoc(String phonghoc) {
		this.phonghoc = phonghoc;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getMamon() {
		return mamon;
	}
	public void setMamon(String mamon) {
		this.mamon = mamon;
	}
}
