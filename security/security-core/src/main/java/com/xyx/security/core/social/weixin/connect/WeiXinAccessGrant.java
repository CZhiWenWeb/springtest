package com.xyx.security.core.social.weixin.connect;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.social.oauth2.AccessGrant;

/**
 * @Author: czw
 * @CreateTime: 2019-08-31 16:30
 * @UpdeteTime: 2019-08-31 16:30
 * @Description:这个对象是 用 code换取token的返回值.
 *  * 微信需要扩展下,增加openId.
 */
@Getter
@Setter
@ToString
public class WeiXinAccessGrant extends AccessGrant {
	//openId
	private String openId;
	public WeiXinAccessGrant(String openId, String accessToken, String scope, String refreshToken, Long expiresIn) {
		super(accessToken, scope, refreshToken, expiresIn);
		this.openId=openId;
	}
}
