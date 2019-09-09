package com.example.demo.validate.image;

import com.example.demo.validate.abstracts.AbstractCaptchaProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;

/**
 * @Author: czw
 * @CreateTime: 2019-09-04 09:24
 * @UpdeteTime: 2019-09-04 09:24
 * @Description:
 */
@Component
public class ImageCaptchaProcessor extends AbstractCaptchaProcessor<ImageCaptcha> {
	@Override
	protected void processl(ServletWebRequest request, ImageCaptcha captcha) throws Exception {
		//将流输出回去,ServletWebRequest也是可以保存response的
		ImageIO.write(captcha.getImage(),"JPEG",request.getResponse().getOutputStream());
	}
}
