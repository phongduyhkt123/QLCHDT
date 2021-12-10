package DAL.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BLL.DBConnect;
import DAL.KhachHangDao;
import DTO.KhachHangModel;
import DTO.NhanVienModel;

public class KhachHangDaoImpl implements KhachHangDao{
	Connection cnn;
	public KhachHangDaoImpl() {
		cnn = new DBConnect().getConnection();
	}
	
	public List<KhachHangModel> getAll() {
		String sql = "Select * from khachhang";
		List<KhachHangModel> list = new ArrayList<KhachHangModel>();
		try {
			Statement ps =cnn.createStatement();
	        ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				KhachHangModel khachhang = new KhachHangModel();
				khachhang.setId(rs.getInt("idKH"));
				khachhang.setName(rs.getString("tenKH"));
				khachhang.setAddress(rs.getString("diaChi"));
				khachhang.setDob(rs.getDate("ngaySinh"));
				khachhang.setGender(rs.getString("gioiTinh"));
				khachhang.setPhone(rs.getString("SDT"));
				list.add(khachhang);
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return list;
	}
	
	public KhachHangModel getById(int id) {
		String sql = "Select * from khachhang where idKH=?";
        KhachHangModel khachhang = null;
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
			if(rs.next()){
				khachhang = new KhachHangModel();
				khachhang.setId(rs.getInt("idKH"));
				khachhang.setName(rs.getString("tenKH"));
				khachhang.setAddress(rs.getString("diaChi"));
				khachhang.setDob(rs.getDate("ngaySinh"));
				khachhang.setGender(rs.getString("gioiTinh"));
				khachhang.setPhone(rs.getString("SDT"));
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return khachhang;
	}

	public boolean insert(KhachHangModel khachhang) {	
		try {
			String sql = "insert into khachhang(tenKH, gioiTinh, ngaySinh, SDT, diaChi) values(?,?,?,?,?)";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, khachhang.getName());
			st.setString(2, khachhang.getGender());
			st.setDate(3, khachhang.getDob());
			st.setString(4, khachhang.getPhone());
			st.setString(5, khachhang.getAddress());
			st.execute();
			System.out.println("Insert Successfully!");
			return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public boolean update(KhachHangModel khachhang) {	
		try {
			String sql = "update khachhang set tenNV=? , gioiTinh=?, ngaySinh=?, SDT=?, diaChi=? where idKH=?";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, khachhang.getName());
			st.setString(2, khachhang.getGender());
			st.setDate(3, khachhang.getDob());
			st.setString(4, khachhang.getPhone());
			st.setString(5, khachhang.getAddress());
			st.setInt(6, khachhang.getId());
			st.execute();
			System.out.println("update Successfully!");
			return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "delete from khachhang where idKH=?";
		try {
		PreparedStatement st = cnn.prepareStatement(sql);
		st.setInt(1, id);
		st.execute();
		
		System.out.println("Delete Successfully!");
		return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public List<KhachHangModel> getByName(String name) {
		String sql = "Select * from khachhang where tenKH like ?";
		List<KhachHangModel> list = new ArrayList<KhachHangModel>();
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
	        ResultSet rs = ps.executeQuery();
			while(rs.next()){
				KhachHangModel khachhang = new KhachHangModel();
                khachhang = new KhachHangModel();
                khachhang.setId(rs.getInt("idKH"));
                khachhang.setName(rs.getString("tenKH"));
                khachhang.setAddress(rs.getString("diaChi"));
                khachhang.setDob(rs.getDate("ngaySinh"));
                khachhang.setGender(rs.getString("gioiTinh"));
                khachhang.setPhone(rs.getString("SDT"));
				list.add(khachhang);
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return list;
	}
}
