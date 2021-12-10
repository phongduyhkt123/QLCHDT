package DAL;

import java.util.List;

import DTO.HoaDonChiTietModel;

public interface HoaDonChiTietDao{
	public List<HoaDonChiTietModel> getAll();
	public boolean insert(HoaDonChiTietModel hdct);
	public boolean update(HoaDonChiTietModel hdct);

}
