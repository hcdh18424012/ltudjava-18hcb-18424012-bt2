package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lop_sinhvien")
public class Lop_SinhVien implements java.io.Serializable{
	@Id
	private String malop_sv;
	public String getMalop_sv() {
		return malop_sv;
	}
	public void setMalop_sv(String malop_sv) {
		this.malop_sv = malop_sv;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	private String malop;
	private String masv;
	public Lop_SinhVien() {
		// TODO Auto-generated constructor stub
	}
	public Lop_SinhVien(String malop_sv, String malop, String masv) {
		this.malop_sv = malop_sv;
		this.malop = malop;
		this.masv = masv;
	}

}
