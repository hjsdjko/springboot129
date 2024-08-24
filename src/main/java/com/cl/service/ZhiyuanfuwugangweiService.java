package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhiyuanfuwugangweiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanfuwugangweiView;


/**
 * 志愿服务岗位
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanfuwugangweiService extends IService<ZhiyuanfuwugangweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanfuwugangweiView> selectListView(Wrapper<ZhiyuanfuwugangweiEntity> wrapper);
   	
   	ZhiyuanfuwugangweiView selectView(@Param("ew") Wrapper<ZhiyuanfuwugangweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanfuwugangweiEntity> wrapper);
   	

}

