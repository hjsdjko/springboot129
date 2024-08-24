package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZhiyuanfuwuqiantuiEntity;
import com.cl.entity.view.ZhiyuanfuwuqiantuiView;

import com.cl.service.ZhiyuanfuwuqiantuiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 志愿服务签退
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
@RestController
@RequestMapping("/zhiyuanfuwuqiantui")
public class ZhiyuanfuwuqiantuiController {
    @Autowired
    private ZhiyuanfuwuqiantuiService zhiyuanfuwuqiantuiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			zhiyuanfuwuqiantui.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhiyuanfuwuqiantuiEntity> ew = new EntityWrapper<ZhiyuanfuwuqiantuiEntity>();

		PageUtils page = zhiyuanfuwuqiantuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanfuwuqiantui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui, 
		HttpServletRequest request){
        EntityWrapper<ZhiyuanfuwuqiantuiEntity> ew = new EntityWrapper<ZhiyuanfuwuqiantuiEntity>();

		PageUtils page = zhiyuanfuwuqiantuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhiyuanfuwuqiantui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui){
       	EntityWrapper<ZhiyuanfuwuqiantuiEntity> ew = new EntityWrapper<ZhiyuanfuwuqiantuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhiyuanfuwuqiantui, "zhiyuanfuwuqiantui")); 
        return R.ok().put("data", zhiyuanfuwuqiantuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui){
        EntityWrapper< ZhiyuanfuwuqiantuiEntity> ew = new EntityWrapper< ZhiyuanfuwuqiantuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhiyuanfuwuqiantui, "zhiyuanfuwuqiantui")); 
		ZhiyuanfuwuqiantuiView zhiyuanfuwuqiantuiView =  zhiyuanfuwuqiantuiService.selectView(ew);
		return R.ok("查询志愿服务签退成功").put("data", zhiyuanfuwuqiantuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui = zhiyuanfuwuqiantuiService.selectById(id);
		zhiyuanfuwuqiantui = zhiyuanfuwuqiantuiService.selectView(new EntityWrapper<ZhiyuanfuwuqiantuiEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanfuwuqiantui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui = zhiyuanfuwuqiantuiService.selectById(id);
		zhiyuanfuwuqiantui = zhiyuanfuwuqiantuiService.selectView(new EntityWrapper<ZhiyuanfuwuqiantuiEntity>().eq("id", id));
        return R.ok().put("data", zhiyuanfuwuqiantui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui, HttpServletRequest request){
    	zhiyuanfuwuqiantui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanfuwuqiantui);
        zhiyuanfuwuqiantuiService.insert(zhiyuanfuwuqiantui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui, HttpServletRequest request){
    	zhiyuanfuwuqiantui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhiyuanfuwuqiantui);
        zhiyuanfuwuqiantuiService.insert(zhiyuanfuwuqiantui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhiyuanfuwuqiantuiEntity zhiyuanfuwuqiantui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhiyuanfuwuqiantui);
        zhiyuanfuwuqiantuiService.updateById(zhiyuanfuwuqiantui);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhiyuanfuwuqiantuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
