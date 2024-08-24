package com.cl.entity.view;

import com.cl.entity.ZhiyuanfuwuqiantuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 志愿服务签退
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
@TableName("zhiyuanfuwuqiantui")
public class ZhiyuanfuwuqiantuiView  extends ZhiyuanfuwuqiantuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhiyuanfuwuqiantuiView(){
	}
 
 	public ZhiyuanfuwuqiantuiView(ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantuiEntity){
 	try {
			BeanUtils.copyProperties(this, zhiyuanfuwuqiantuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
