package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhiyuanfuwuqiantuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanfuwuqiantuiView;


/**
 * 志愿服务签退
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanfuwuqiantuiService extends IService<ZhiyuanfuwuqiantuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanfuwuqiantuiView> selectListView(Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper);
   	
   	ZhiyuanfuwuqiantuiView selectView(@Param("ew") Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanfuwuqiantuiEntity> wrapper);
   	

}

