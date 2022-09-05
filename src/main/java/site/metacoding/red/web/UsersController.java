package site.metacoding.red.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.loginDto;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	private final HttpSession session; //스프링이 서버 시작시에 IoC컨테이너에 보관함.
	private final UsersDao usersDao;
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(loginDto loginDto) {
		Users usersPS = usersDao.login(loginDto);
		if(usersPS != null) {
			session.setAttribute("principal", usersPS);
			return "redirect:/";
		}else {
			return "redirect:/loginForm";
		}
	}
	
	@PostMapping("/join")
	public String join(JoinDto joinDto) {
		return "redirect:/joinform";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "users/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "users/joinForm";
	}
}
