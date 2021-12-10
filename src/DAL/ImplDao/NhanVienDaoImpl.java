package DAL.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BLL.DBConnect;
import DAL.NhanVienDao;
import DTO.NhanVienModel;

public class NhanVienDaoImpl implements NhanVienDao{
	Connection cnn;
	public NhanVienDaoImpl() {
		cnn = new DBConnect().getConnection();
	}
	public NhanVienModel login(String phone, String password) {
		
		String sql = "Select * from nhanvien where SDT = ? and password = ?";
		NhanVienModel nhanvien = null;
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, phone);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nhanvien = new NhanVienModel();
                nhanvien.setName(rs.getString("tenNV"));
                nhanvien.setEmail(rs.getString("email"));
                nhanvien.setAddress(rs.getString("diaChi"));
                nhanvien.setAvatar(rs.getString("avatar"));
                nhanvien.setDob(rs.getDate("ngaySinh"));
                nhanvien.setGender(rs.getString("gioiTinh"));
                nhanvien.setId(rs.getInt("idNV"));
                nhanvien.setPassword(rs.getString("password"));
                nhanvien.setPhone(rs.getString("SDT"));
                nhanvien.setRole(rs.getInt("role"));
                nhanvien.setStatus(rs.getInt("status"));
            }
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return nhanvien; 
	}
	
	public List<NhanVienModel> getAll() {
		String sql = "Select * from nhanvien";
		List<NhanVienModel> list = new ArrayList<NhanVienModel>();
		try {
			Statement ps = cnn.createStatement();
	        ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				NhanVienModel nhanvien = new NhanVienModel();
                nhanvien = new NhanVienModel();
                nhanvien.setId(rs.getInt("idNV"));
                nhanvien.setName(rs.getString("tenNV"));
                nhanvien.setEmail(rs.getString("email"));
                nhanvien.setAddress(rs.getString("diaChi"));
                nhanvien.setAvatar(rs.getString("avatar"));
                nhanvien.setDob(rs.getDate("ngaySinh"));
                nhanvien.setGender(rs.getString("gioiTinh"));
                nhanvien.setPassword(rs.getString("password"));
                nhanvien.setPhone(rs.getString("SDT"));
                nhanvien.setRole(rs.getInt("role"));
                nhanvien.setStatus(rs.getInt("status"));
				list.add(nhanvien);
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return list;
	}
	
	public NhanVienModel getById(int id) {
		String sql = "Select * from nhanvien where idNV=?";
		NhanVienModel nhanvien = null;
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
			if(rs.next()){
                nhanvien = new NhanVienModel();
                nhanvien.setId(rs.getInt("idNV"));
                nhanvien.setName(rs.getString("tenNV"));
                nhanvien.setEmail(rs.getString("email"));
                nhanvien.setAddress(rs.getString("diaChi"));
                nhanvien.setAvatar(rs.getString("avatar"));
                nhanvien.setDob(rs.getDate("ngaySinh"));
                nhanvien.setGender(rs.getString("gioiTinh"));
                nhanvien.setPassword(rs.getString("password"));
                nhanvien.setPhone(rs.getString("SDT"));
                nhanvien.setRole(rs.getInt("role"));
                nhanvien.setStatus(rs.getInt("status"));
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return nhanvien;
	}

	public boolean insert(NhanVienModel nhanvien) {	
		try {
			String sql = 
			"insert into nhanvien(tenNV, gioiTinh, ngaySinh, SDT, diaChi, email, password, avatar, role, status) "
			+ "values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, nhanvien.getName());
			st.setString(2, nhanvien.getGender());
			st.setDate(3, nhanvien.getDob());
			st.setString(4, nhanvien.getPhone());
			st.setString(5, nhanvien.getAddress());
			st.setString(6, nhanvien.getEmail());
			st.setString(7, nhanvien.getPassword());
			st.setString(8, nhanvien.getAvatar());
			st.setInt(9, nhanvien.getRole());
			st.setInt(10, nhanvien.getStatus());
			st.execute();
			System.out.println("Insert Successfully!");
			return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public boolean update(NhanVienModel nhanvien) {	
		try {
			String sql = 
			"update nhanvien set tenNV=? , gioiTinh=?, ngaySinh=?, SDT=?, diaChi=?, email=?, password=?, avatar=?, role=?, status=?"
			+ " where idNV=?";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, nhanvien.getName());
			st.setString(2, nhanvien.getGender());
			st.setDate(3, nhanvien.getDob());
			st.setString(4, nhanvien.getPhone());
			st.setString(5, nhanvien.getAddress());
			st.setString(6, nhanvien.getEmail());
			st.setString(7, nhanvien.getPassword());
			st.setString(8, nhanvien.getAvatar());
			st.setInt(9, nhanvien.getRole());
			st.setInt(10, nhanvien.getStatus());
			st.setInt(11, nhanvien.getId());
			st.execute();
			System.out.println("update Successfully!");
			return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "delete from nhanvien where idNV=?";
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

	public List<NhanVienModel> getByName(String name) {
		String sql = "Select * from nhanvien where tenNV like ?";
		List<NhanVienModel> list = new ArrayList<NhanVienModel>();
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
	        ResultSet rs = ps.executeQuery();
			while(rs.next()){
				NhanVienModel nhanvien = new NhanVienModel();
                nhanvien = new NhanVienModel();
                nhanvien.setId(rs.getInt("idNV"));
                nhanvien.setName(rs.getString("tenNV"));
                nhanvien.setEmail(rs.getString("email"));
                nhanvien.setAddress(rs.getString("diaChi"));
                nhanvien.setAvatar(rs.getString("avatar"));
                nhanvien.setDob(rs.getDate("ngaySinh"));
                nhanvien.setGender(rs.getString("gioiTinh"));
                nhanvien.setPassword(rs.getString("password"));
                nhanvien.setPhone(rs.getString("SDT"));
                nhanvien.setRole(rs.getInt("role"));
                nhanvien.setStatus(rs.getInt("status"));
				list.add(nhanvien);
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return list;
	}
}
