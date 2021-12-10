package DAO;

import java.util.List;

import Model.HoaDonModel;

public interface HoaDonDao{
	public List<HoaDonModel> getAll();
	public HoaDonModel getById(int id);
	public int insert(HoaDonModel hoadon);
	public boolean update(HoaDonModel hoadon);
	public boolean delete(int id);
	public List<HoaDonModel> getByIdEmployee(int id);
	
}
