package Service;

import java.util.List;
import java.util.Map;

import DAO.AnnouncementDAO;
import DAO.FileDAO;
import DTO.AnnouncementDTO;
import DTO.FileDTO;

public class FileUploadServiceImpl implements FileUploadService{
	
	FileDAO dao;
	
	public FileUploadServiceImpl() {
		this.dao = new FileDAO();
	}

	@Override
	public int insertFile(FileDTO dto) {
		return dao.insertFile(dto);
	}

	


}
