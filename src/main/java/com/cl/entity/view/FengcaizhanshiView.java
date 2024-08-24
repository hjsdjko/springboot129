package com.cl.entity.view;

import com.cl.entity.FengcaizhanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 风采展示
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
@TableName("fengcaizhanshi")
public class FengcaizhanshiView  extends FengcaizhanshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FengcaizhanshiView(){
	}
 
 	public FengcaizhanshiView(FengcaizhanshiEntity fengcaizhanshiEntity){
 	try {
			BeanUtils.copyProperties(this, fengcaizhanshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
