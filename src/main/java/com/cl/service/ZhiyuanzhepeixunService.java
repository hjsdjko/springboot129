package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhiyuanzhepeixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanzhepeixunView;


/**
 * 志愿者培训
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanzhepeixunService extends IService<ZhiyuanzhepeixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzhepeixunView> selectListView(Wrapper<ZhiyuanzhepeixunEntity> wrapper);
   	
   	ZhiyuanzhepeixunView selectView(@Param("ew") Wrapper<ZhiyuanzhepeixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzhepeixunEntity> wrapper);
   	

}

