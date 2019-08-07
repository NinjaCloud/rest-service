package hello;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping(value = "/")
	public List<User> saveRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		String sessionID = session.getId();
		String callerIP = request.getRemoteAddr();
//		String host = request.getServerName();

		User user = new User();
		user.setAccessTime(new Date());
		user.setCallerIP(callerIP);
		user.setSessionID(sessionID);
		try {
			InetAddress ip = InetAddress.getLocalHost();
			user.setHost("" + ip);
			userRepository.saveAndFlush(user);
		} catch (Exception exe) {
			// ignore
		}
		return userRepository.findAll();
	}
}
