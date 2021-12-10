package DAL.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BLL.DBConnect;
import DAL.HoaDonChiTietDao;
import DTO.HoaDonChiTietModel;

public class HoaDonChiTietDaoImpl implements HoaDonChiTietDao{
	Connection cnn;
	public HoaDonChiTietDaoImpl() {
		cnn = new DBConnect().getConnection();
	}
	
	public List<HoaDonChiTietModel> getAll() {
		String sql = "Select * from hoadonchitiet";
		List<HoaDonChiTietModel> list = new ArrayList<HoaDonChiTietModel>();
		try {
			Statement ps = (PreparedStatement) cnn.createStatement();
	        ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				HoaDonChiTietModel hdct = new HoaDonChiTietModel();
				hdct.setIdHD(rs.getInt("idHD"));
				hdct.setIdSP(rs.getInt("idSP"));
				hdct.setPrice(rs.getDouble("donGia"));
				hdct.setQuantity(rs.getInt("soLuong"));
				list.add(hdct);
			}
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return list;
	}

	public boolean insert(HoaDonChiTietModel hdct) {	
		try {
			String sql = "insert into hoadonchitiet(idHD, idSP, donGia, soLuong) values(?,?,?,?)";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, hdct.getIdHD());
			st.setInt(2, hdct.getIdSP());
			st.setDouble(3, hdct.getPrice());
			st.setInt(4, hdct.getQuantity());
			st.execute();
			System.out.println("Insert Successfully!");
			return true;
		}catch(Exception ex) {
			System.out.println("ERROR:"+ex.getMessage());
		}
		return false;
	}
	
	public boolean update(HoaDonChiTietModel hdct) {	
		return false;
	}
//	
//	public boolean delete(int id) {
//		return false;
//	}
	
	public HoaDonChiTietModel getById(int id) {
		return null;
	}
}
