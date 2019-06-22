package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 16:43
 * @UpdeteTime: 2019-06-18 16:43
 * @Description:
 */
public class HomeControllerTest {
	/**@Test
	public void testHomePage() throws Exception{
		HomeController controller=new HomeController();
		MockMvc mockMvc=
				standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}**/
	@Test
	public void shouldShowRecentSpittles() throws Exception{
		List<Spittle> expectedSpittes=createSpittleList(20);
		SpittleRepository mockRepository=
				mock(SpittleRepository.class);
		when(mockRepository.findSpittles(Long.MAX_VALUE,20))
				.thenReturn(expectedSpittes);
		SpittleController controller=new SpittleController(mockRepository);
		MockMvc mockMvc=standaloneSetup(controller)
				.setSingleView(
						new InternalResourceView("/WEB-INF/views/spittles.jsp")
				).build();
		mockMvc.perform(get("/spittles"))
				.andExpect(view().name("spittles"))
				.andExpect(model().attributeExists("spittleList"))
				.andExpect(model().attribute("spittleList",hasItems(expectedSpittes.toArray())));

	}
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles=new ArrayList<>();
		for (int i=0;i<count;i++)
			spittles.add(new Spittle("Spittle"+i,new Date()));
		return spittles;
	}
}
