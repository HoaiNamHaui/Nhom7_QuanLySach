/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSDL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class DataIO {
    public static ArrayList<Sach> dsSach = new ArrayList<>();
    public static ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
    public static ArrayList<NguoiMua> dsNguoiMua = new ArrayList<>();
    public static ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
    
    
    public static void loadSach(){
        FileReader freader = null;
	BufferedReader buffer = null;
		
	File file = new File("src\\sach.txt");
		
	try {
		freader = new FileReader(file);
		buffer = new BufferedReader(freader);
		String line;
		while((line = buffer.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String parts[] = line.split(";");
			String maSach = parts[0];
                        String tenSach = parts[1];
                        String nhaXuatBan = parts[2];
                        String tacGia = parts[3];
                        int soLuongCon = Integer.parseInt(parts[4]);
                        int donGia = Integer.parseInt(parts[5]);
                        String tinhTrang = parts[5];
			Sach sach = new Sach(maSach,tenSach,nhaXuatBan,tacGia,soLuongCon,donGia,tinhTrang);
                        dsSach.add(sach);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(buffer != null)	buffer.close();
				if(freader != null) freader.close();
			} catch (Exception e2) {
			}
		}
    }
    
    
    public static void loadNguoiMua(){
        FileReader freader = null;
	BufferedReader buffer = null;
		
	File file = new File("src\\nguoimua.txt");
		
	try {
		freader = new FileReader(file);
		buffer = new BufferedReader(freader);
		String line;
		while((line = buffer.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String parts[] = line.split(";");
			String maNguoiMua = parts[0];
                        String tenNguoiMua = parts[1];
                        String taiKhoan = parts[2];
                        String soDienThoai = parts[3];
                        String diaChi = parts[4];
                        String email = parts[5];
			
                        NguoiMua nguoiMua = new NguoiMua(maNguoiMua,tenNguoiMua,taiKhoan,soDienThoai,diaChi,email);
                        dsNguoiMua.add(nguoiMua);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(buffer != null)	buffer.close();
				if(freader != null) freader.close();
			} catch (Exception e2) {
			}
		}
    }
    
    public static void loadHoaDon(){
        FileReader freader = null;
	BufferedReader buffer = null;
		
	File file = new File("src\\hoadon.txt");
		
	try {
		freader = new FileReader(file);
		buffer = new BufferedReader(freader);
		String line;
		while((line = buffer.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String parts[] = line.split(";");
			String maHoaDon = parts[0];
                        String maNguoiMua = parts[1];
                        String maSach = parts[2];
                        String ngayMua = parts[3];
                        int soLuongMua = Integer.parseInt(parts[4]);
                        int thanhTien = Integer.parseInt(parts[5]);
                        
                        HoaDon hoaDon = new HoaDon(maHoaDon,maNguoiMua,maSach,ngayMua,soLuongMua,thanhTien);
			dsHoaDon.add(hoaDon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(buffer != null)	buffer.close();
				if(freader != null) freader.close();
			} catch (Exception e2) {
			}
		}
    }
    
    public static void loadNhanVien(){
        FileReader freader = null;
	BufferedReader buffer = null;
		
	File file = new File("src\\nhanvien.txt");
		
	try {
		freader = new FileReader(file);
		buffer = new BufferedReader(freader);
		String line;
		while((line = buffer.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String parts[] = line.split(";");
			String maNhanVien = parts[0];
                        String tenNhanVien = parts[1];
                        String ngayVaoLam = parts[2];
                        int soNgayNghi = Integer.parseInt(parts[3]);
                        
			
                        NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, ngayVaoLam, soNgayNghi);
                        dsNhanVien.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(buffer != null)	buffer.close();
				if(freader != null) freader.close();
			} catch (Exception e2) {
			}
		}
    }
    
    public static void loadData(){
        loadSach();
        loadHoaDon();
        loadNguoiMua();
    }
}
