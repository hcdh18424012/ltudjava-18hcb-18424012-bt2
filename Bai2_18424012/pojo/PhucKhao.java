package pojo;
// default package
// Generated Aug 14, 2019 12:44:01 AM by Hibernate Tools 5.4.3.Final

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PhucKhao generated by hbm2java
 */
@Entity
@Table(name = "phuckhao")
public class PhucKhao implements java.io.Serializable {
	@Id
	private String malop;
	private Date ngaybatdau;
	private Date ngayketthuc;

	public PhucKhao() {
	}

	public PhucKhao(String malop, Date ngaybatdau, Date ngayketthuc) {
		this.malop = malop;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
	}

	public String getMalop() {
		return this.malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public Date getNgaybatdau() {
		return this.ngaybatdau;
	}

	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}

	public Date getNgayketthuc() {
		return this.ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PhucKhao))
			return false;
		PhucKhao castOther = (PhucKhao) other;

		return ((this.getMalop() == castOther.getMalop()) || (this.getMalop() != null
						&& castOther.getMalop() != null && this.getMalop().equals(castOther.getMalop())))
				&& ((this.getNgaybatdau() == castOther.getNgaybatdau()) || (this.getNgaybatdau() != null
						&& castOther.getNgaybatdau() != null && this.getNgaybatdau().equals(castOther.getNgaybatdau())))
				&& ((this.getNgayketthuc() == castOther.getNgayketthuc())
						|| (this.getNgayketthuc() != null && castOther.getNgayketthuc() != null
								&& this.getNgayketthuc().equals(castOther.getNgayketthuc())));
	}

	public int hashCode() {
		int result = 17;
		result = 37 * result + (getMalop() == null ? 0 : this.getMalop().hashCode());
		result = 37 * result + (getNgaybatdau() == null ? 0 : this.getNgaybatdau().hashCode());
		result = 37 * result + (getNgayketthuc() == null ? 0 : this.getNgayketthuc().hashCode());
		return result;
	}

}
