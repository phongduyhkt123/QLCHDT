package DAL;

import java.util.List;

import DTO.KhachHangModel;

public interface KhachHangDao{
	public List<KhachHangModel> getAll();
	public List<KhachHangModel> getByName(String name);
	public KhachHangModel getById(int id);
	public boolean insert(KhachHangModel khachhang);
	public boolean update(KhachHangModel khachhang);
	public boolean delete(int id);
}
