package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 15:35
 * @UpdeteTime: 2019-06-18 15:35
 * @Description:
 */
@Controller
@RequestMapping({"/homepage","/"})
public class HomeController {
	/**
	 * 处理对"/"的GET请求
	 * @return
	 */
	@RequestMapping(method =GET)
	public String home(){
		return "home";
	}
}
