package DAL;

import java.util.List;

import DTO.SanPhamModel;

public interface SanPhamDao{
	public List<SanPhamModel> getAll();
	public List<SanPhamModel> getByName(String name);
	public SanPhamModel getById(int id);
	public boolean insert(SanPhamModel sanpham);
	public boolean update(SanPhamModel sanpham);
	public boolean delete(int id);
}
