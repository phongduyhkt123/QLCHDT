package DAL.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BLL.DBConnect;
import DAL.SanPhamDao;
import DTO.SanPhamModel;

public class SanPhamDaoImpl implements SanPhamDao{
	Connection cnn;
	public SanPhamDaoImpl() {
		cnn = new DBConnect().getConnection();
	}
	
	public List<SanPhamModel> getAll() {
		String sql = "Select * from sanpham";
		List<SanPhamModel> list = new ArrayList<SanPhamModel>();
		try {
			Statement ps =  cnn.createStatement();
	        ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				SanPhamModel sanpham = new SanPhamModel();
				sanpham.setId(rs.getInt("idSP"));
				sanpham.setName(rs.getString("tenSP"));
				sanpham.setPrice(rs.getDouble("donGia"));
				sanpham.setQuantity(rs.getInt("soLuong"));
				list.add(sanpham);
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return list;
	}

	public boolean insert(SanPhamModel sanpham) {	
		try {
			String sql = "insert into sanpham(tenSP, donGia, soLuong) values(?,?,?)";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, sanpham.getName());
			st.setDouble(2, sanpham.getPrice());
			st.setInt(3, sanpham.getQuantity());
			st.execute();
			System.out.println("Insert Successfully!");
			return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public boolean update(SanPhamModel sanpham) {	
		try {
			String sql = "update sanpham set tenSP=?, donGia=?, soLuong=? where idSP=?";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, sanpham.getName());
			st.setDouble(2, sanpham.getPrice());
			st.setInt(3, sanpham.getQuantity());
			st.setInt(4, sanpham.getId());
			st.execute();
			System.out.println("update Successfully!");
			return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "delete from sanpham where idSP=?";
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
	
	public SanPhamModel getById(int id) {
		String sql = "Select * from sanpham where idSP=?";
		SanPhamModel sanpham = null;
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sanpham = new SanPhamModel();
				sanpham.setId(rs.getInt("idSP"));
				sanpham.setName(rs.getString("tenSP"));
				sanpham.setPrice(rs.getDouble("donGia"));
				sanpham.setQuantity(rs.getInt("soLuong"));
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return sanpham;
	}
	
	public List<SanPhamModel> getByName(String name) {
		String sql = "Select * from sanpham where tenSP like ?";
		List<SanPhamModel> list = new ArrayList<SanPhamModel>();
		try {
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
	        ResultSet rs = ps.executeQuery();
			while(rs.next()){
				SanPhamModel sanpham = new SanPhamModel();
				sanpham = new SanPhamModel();
				sanpham.setId(rs.getInt("idSP"));
				sanpham.setName(rs.getString("tenSP"));
				sanpham.setQuantity(rs.getInt("soLuong"));
				sanpham.setPrice(rs.getDouble("donGia"));
				list.add(sanpham);
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return list;
	}
}
