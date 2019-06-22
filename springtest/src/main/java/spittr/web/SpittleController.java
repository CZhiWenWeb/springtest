package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.data.SpittleRepository;

/**
 * @Author: czw
 * @CreateTime: 2019-06-20 08:57
 * @UpdeteTime: 2019-06-20 08:57
 * @Description:
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	@Autowired
	public SpittleController(SpittleRepository spittleRepository){
		this.spittleRepository=spittleRepository;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model){
		model.addAttribute("spittleList",spittleRepository.findSpittles(Long.MAX_VALUE,20));
		return "spittles";
	}
	//原始写法

	/**
	 * 当处理器返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断出
	 * spittleList;，而逻辑视图的名称将会根据请求路径推断得出spittles,按照我们
	 * 配置InternalResourceViewResolver的方式，试图将会是/WEB-INF/spittles.jsp
	* @return
	 */
	//@RequestMapping(method = RequestMethod.GET)
	//public List<Spittle> spittles(){
	//	return spittleRepository.findSpittles(Long.MAX_VALUE,20);
	//}
}
