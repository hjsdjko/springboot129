package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhiyuanzheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanzheView;


/**
 * 志愿者
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:33
 */
public interface ZhiyuanzheService extends IService<ZhiyuanzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzheView> selectListView(Wrapper<ZhiyuanzheEntity> wrapper);
   	
   	ZhiyuanzheView selectView(@Param("ew") Wrapper<ZhiyuanzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzheEntity> wrapper);
   	

}

