package com.czw.code.validate.code.image;

import com.czw.code.validate.code.abstracts.AbstractCaptchaProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2019-09-23 11:21
 * @UpdeteTime: 2019-09-23 11:21
 * @Description:
 */
@Component
public class ImageCaptchaProcessor extends AbstractCaptchaProcessor<ImageCaptcha> {
	@Override
	protected void endProcess(ServletWebRequest request, ImageCaptcha captcha) throws IOException {
		//将流输出回去,ServletWebRequest也是可以保存response的
		ImageIO.write(captcha.getImage(), "JPEG", request.getResponse().getOutputStream());
	}
}
