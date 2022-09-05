package site.metacoding.red.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.board.WriteDto;

@RequiredArgsConstructor
@Controller
public class BoardsController {

	private final HttpSession session;
	private final BoardsDao boardsDao;
	
	@PostMapping("/boards")
	public String writeBoards(WriteDto writeDto) {
		Users principal = (Users)session.getAttribute("principal");
		Boards boards = new Boards();
		boards.setTitle(writeDto.getTitle());
		boards.setContent(writeDto.getContent());
		boards.setUserId(principal.getId());
		boardsDao.insert(boards);
		return "redirect:/";
	}

	@GetMapping({ "/", "/boards" })
	public String getBoardList() {
		return "boards/main";
	}

	@GetMapping("/boards/{id}")
	public String getBoardList(@PathVariable Integer id) {
		return "boards/detail";
	}

	@GetMapping("/boards/writeForm")
	public String writeForm() {
		Users principal = (Users) session.getAttribute("principal");
		// 오브젝트 타입으로 넣었으니 users 타입으로 다운캐스팅
		if (principal == null) {
			return "redirect:/loginForm";
		} else {
			return "boards/writeForm";
		}

	}
}
