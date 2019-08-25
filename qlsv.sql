drop database if exists QLSV;

create database if not exists QLSV;
use QLSV;

drop table if exists user_pass;

create table if not exists user_pass(
	id int AUTO_INCREMENT UNIQUE,
	username VARCHAR(30) not null PRIMARY KEY,
	password VARCHAR(30) not null
);
drop table if exists lop_sinhvien;
drop table if exists sinhvien;
create table if not exists sinhvien(
	id int auto_increment unique,
	masv VARCHAR(10) not null,
	hoten VARCHAR(30) CHARACTER set utf8,
	gioitinh VARCHAR(10) CHARACTER set utf8,
	cmnd VARCHAR(30),
	PRIMARY KEY (masv)
);

drop table if exists lop;

create table if not exists lop(
	id int auto_increment unique,
	malop VARCHAR(20) not null,
	tenlop VARCHAR(50) CHARACTER set utf8,
	namhocbatdau DATE,
	namhocketthuc DATE,
	PRIMARY KEY (malop)
);

create table if not exists lop_sinhvien(
	id int auto_increment unique,
	malop_sv VARCHAR(30) not null,
	malop VARCHAR(20) not null,
	masv VARCHAR(10) not null,
	PRIMARY KEY(malop_sv)
);
drop table if exists thoikhoabieu;

create table if not exists thoikhoabieu(
	id int auto_increment unique,
	malop VARCHAR(20) not null,
	mamon varchar(20) not null,
	tenmon varchar(50) CHARACTER set utf8,
	phonghoc VARCHAR(10),
	PRIMARY KEY (malop, mamon)
);

drop table if exists bangdiem;

create table if not exists bangdiem(
	id int auto_increment unique,
	malop VARCHAR(20) not null,
	masv VARCHAR(10) not null,
	hoten VARCHAR(50),
	diemgk float,
	diemck float,
	diemkhac float,
	diemtong float,
	PRIMARY KEY (malop, masv)
);

drop table if exists phuckhao;

create table if not exists phuckhao(
	id int auto_increment UNIQUE,
	malop VARCHAR(20) not null,
	ngaybatdau DATE,
	ngayketthuc DATE
);

DROP TRIGGER IF EXISTS tg_phuckhao;
DELIMITER //
CREATE TRIGGER tg_phuckhao
BEFORE INSERT ON phuckhao FOR EACH ROW
BEGIN
    IF (NEW.ngaybatdau IS NULL) THEN -- change the isnull check for the default used
        SET NEW.ngaybatdau = now();
		
    END IF;
	if(new.ngayketthuc is null) then
		SET NEW.ngayketthuc = DATE_ADD(now(),INTERVAL 10 DAY);
	end if;
END//
DELIMITER ;
-- select DATE_ADD(now(),INTERVAL 10 DAy);
drop table if exists sv_phuckhao;

create table if not exists sv_phuckhao(
	id int auto_increment UNIQUE,
	masv VARCHAR(10),
	malop VARCHAR(20),
	trangthai VARCHAR(50) CHARACTER set utf8 DEFAULT 'Chưa Duyệt',
	PRIMARY KEY (masv, malop)
);
DROP TRIGGER IF EXISTS tg_sinhvien;
DELIMITER //
CREATE TRIGGER tg_sinhvien
BEFORE INSERT ON sinhvien FOR EACH ROW
BEGIN
    INSERT INTO user_pass(username, password)
	values (new.masv, new.masv);
END;
DELIMITER;
insert into sinhvien(masv, hoten, gioitinh, cmnd)
	values ("18424001","Trần Minh Châu",1,"123456789");
insert into lop(malop) 
	values ("18HCB");
insert into lop_sinhvien(malop, masv)
	values ("18HCB", "18424001");
insert into user_pass(username, password) values
	("giaovu","giaovu"),
	("18424001","1");
	
insert into phuckhao(malop, ngaybatdau, ngayketthuc)
values ("18424001",null,null);
insert into sv_phuckhao(masv, malop)
values ("18424001","18HCB");

