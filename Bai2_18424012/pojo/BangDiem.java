package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// default package
// Generated Aug 14, 2019 12:44:01 AM by Hibernate Tools 5.4.3.Final

/**
 * BangDiem generated by hbm2java
 */
@Entity
@Table(name = "bangdiem")
public class BangDiem implements java.io.Serializable {
	@Id
	private int id;
	private String malop;
	private String masv;
	private String hoten;
	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	private Float diemgk;
	private Float diemck;
	private Float diemkhac;
	private Float diemtong;

	public BangDiem() {
	}

	public BangDiem(String malop, int id, String masv) {
		this.malop = malop;
		this.masv = masv;
	}

	public BangDiem(String malop, String masv, String hoten, Float diemgk, Float diemck, Float diemkhac, Float diemtong) {
		this.malop = malop;
		this.masv = masv;
		this.hoten = hoten;
		this.diemgk = diemgk;
		this.diemck = diemck;
		this.diemkhac = diemkhac;
		this.diemtong = diemtong;
	}

	public String getMalop() {
		return this.malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getMasv() {
		return this.masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public Float getDiemgk() {
		return this.diemgk;
	}

	public void setDiemgk(Float diemgk) {
		this.diemgk = diemgk;
	}

	public Float getDiemck() {
		return this.diemck;
	}

	public void setDiemck(Float diemck) {
		this.diemck = diemck;
	}

	public Float getDiemkhac() {
		return this.diemkhac;
	}

	public void setDiemkhac(Float diemkhac) {
		this.diemkhac = diemkhac;
	}

	public Float getDiemtong() {
		return this.diemtong;
	}

	public void setDiemtong(Float diemtong) {
		this.diemtong = diemtong;
	}

}
