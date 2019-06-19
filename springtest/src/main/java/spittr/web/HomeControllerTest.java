package spittr.web;

import org.junit.Test;

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
	}

}
