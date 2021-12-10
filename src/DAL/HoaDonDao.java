package DAL;

import java.util.List;

import DTO.HoaDonModel;

public interface HoaDonDao{
	public List<HoaDonModel> getAll();
	public HoaDonModel getById(int id);
	public boolean insert(HoaDonModel hoadon);
	public boolean update(HoaDonModel hoadon);
	public boolean delete(int id);
}
