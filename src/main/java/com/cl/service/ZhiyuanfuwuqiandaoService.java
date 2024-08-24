package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhiyuanfuwuqiandaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhiyuanfuwuqiandaoView;


/**
 * 志愿服务签到
 *
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
public interface ZhiyuanfuwuqiandaoService extends IService<ZhiyuanfuwuqiandaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanfuwuqiandaoView> selectListView(Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper);
   	
   	ZhiyuanfuwuqiandaoView selectView(@Param("ew") Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanfuwuqiandaoEntity> wrapper);
   	

}

