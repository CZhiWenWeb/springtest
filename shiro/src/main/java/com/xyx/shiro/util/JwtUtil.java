package com.xyx.shiro.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xyx.shiro.exception.CustomException;
import com.xyx.shiro.model.common.Constant;
import com.xyx.shiro.util.common.Base64ConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 09:14
 * @UpdeteTime: 2019-08-26 09:14
 * @Description:JAVA-JWT工具类
 */
@Slf4j
@Component
public class JwtUtil {
	/**
	 * 过期时间从配置文件获取
	 */
	private static String accessTokenExpireTime;
	/**
	 * JWT认证加密私钥,Base64加密
	 */
	private static String encryptJWTKey;
	@Value("${accessTokenExpireTime}")
	public void setAccessTokenExpireTime(String accessTokenExpireTime){
		JwtUtil.accessTokenExpireTime=accessTokenExpireTime;
	}
	@Value("${encryptJWTKey}")
	public void setEncryptJWTKey(String encryptJWTKey){
		JwtUtil.encryptJWTKey=encryptJWTKey;
	}

	/**
	 * 校验token是否正确
	 * @param token Token
	 * @return  boolean
	 */
	public static boolean verify(String token){
		try {
			//账号加JWT私钥解密
			String secret=getClaim(token, Constant.ACCOUNT)+Base64ConvertUtil.decode(token);
			Algorithm algorithm=Algorithm.HMAC256(secret);
			JWTVerifier verifier=JWT.require(algorithm)
					.build();
			DecodedJWT jwt=verifier.verify(token);
			return true;
		} catch (UnsupportedEncodingException e) {
			log.error("JWTToken认证解密出现异常："+e.getMessage());
			throw new CustomException("JWTToken认证解密出现异常："+e.getMessage());
		}
	}

	/**
	 * 获得Token中的信息
	 * @param token
	 * @param claim
	 * @return
	 */
	public static String getClaim(String token,String claim){
		try {
			DecodedJWT jwt = JWT.decode(token);
			return jwt.getClaim(claim).asString();
		}catch (JWTDecodeException e){
			log.error("解密Token中的公共信息出现异常："+e.getMessage());
			throw new JWTDecodeException("解密Token中的公共信息出现异常："+e.getMessage());
		}
	}

	/**
	 * 生成签名
	 * @param account   账号
	 * @param currentTimeMillis
	 * @return  返回加密的Token
	 */
	public static String sign(String account,String currentTimeMillis){
		//	账号加JWT私钥加密
			try {
				String secret=account+ Base64ConvertUtil.decode(encryptJWTKey);
			//	过期时间
				Date date=new Date(System.currentTimeMillis()+Long.parseLong(accessTokenExpireTime));
				Algorithm algorithm=Algorithm.HMAC256(secret);
			//	附带account账号信息
				return JWT.create()
						.withClaim("account",account)
						.withClaim("currentTimeMillis",currentTimeMillis)
						.withExpiresAt(date)
						.sign(algorithm);
			} catch (UnsupportedEncodingException e) {
				log.error("JWTToken加密出现异常："+e.getMessage());
				throw new CustomException("JWTToken加密出现异常："+e.getMessage());
			}
	}
}
