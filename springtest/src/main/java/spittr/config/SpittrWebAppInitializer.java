package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: czw
 * @CreateTime: 2019-06-18 14:46
 * @UpdeteTime: 2019-06-18 14:46
 * @Description:
 */
public class SpittrWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	/**
	 * 将DispatcherServlet映射到“/”
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
