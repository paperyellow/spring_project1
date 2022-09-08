package site.metacoding.red.domain.boards;

import java.util.List;

import site.metacoding.red.web.dto.response.boards.MainDto;
import site.metacoding.red.web.dto.response.boards.PagingDto;

public interface BoardsDao {
	public PagingDto paging(Integer page, Object object);
	public void insert(Boards boards); 
	public Boards findById(Integer id);
	public List<MainDto> findAll(int startNum);
	public void update(Boards boards); 
	public void delete(Integer id);
	public List<MainDto> findSearch(int startNum, String keyword);
}