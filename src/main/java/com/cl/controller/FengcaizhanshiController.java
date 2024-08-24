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

import com.cl.entity.FengcaizhanshiEntity;
import com.cl.entity.view.FengcaizhanshiView;

import com.cl.service.FengcaizhanshiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 风采展示
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 22:27:34
 */
@RestController
@RequestMapping("/fengcaizhanshi")
public class FengcaizhanshiController {
    @Autowired
    private FengcaizhanshiService fengcaizhanshiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FengcaizhanshiEntity fengcaizhanshi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhiyuanzhe")) {
			fengcaizhanshi.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FengcaizhanshiEntity> ew = new EntityWrapper<FengcaizhanshiEntity>();

		PageUtils page = fengcaizhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fengcaizhanshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FengcaizhanshiEntity fengcaizhanshi, 
		HttpServletRequest request){
        EntityWrapper<FengcaizhanshiEntity> ew = new EntityWrapper<FengcaizhanshiEntity>();

		PageUtils page = fengcaizhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fengcaizhanshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FengcaizhanshiEntity fengcaizhanshi){
       	EntityWrapper<FengcaizhanshiEntity> ew = new EntityWrapper<FengcaizhanshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fengcaizhanshi, "fengcaizhanshi")); 
        return R.ok().put("data", fengcaizhanshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FengcaizhanshiEntity fengcaizhanshi){
        EntityWrapper< FengcaizhanshiEntity> ew = new EntityWrapper< FengcaizhanshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fengcaizhanshi, "fengcaizhanshi")); 
		FengcaizhanshiView fengcaizhanshiView =  fengcaizhanshiService.selectView(ew);
		return R.ok("查询风采展示成功").put("data", fengcaizhanshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FengcaizhanshiEntity fengcaizhanshi = fengcaizhanshiService.selectById(id);
		fengcaizhanshi = fengcaizhanshiService.selectView(new EntityWrapper<FengcaizhanshiEntity>().eq("id", id));
        return R.ok().put("data", fengcaizhanshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FengcaizhanshiEntity fengcaizhanshi = fengcaizhanshiService.selectById(id);
		fengcaizhanshi = fengcaizhanshiService.selectView(new EntityWrapper<FengcaizhanshiEntity>().eq("id", id));
        return R.ok().put("data", fengcaizhanshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FengcaizhanshiEntity fengcaizhanshi, HttpServletRequest request){
    	fengcaizhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fengcaizhanshi);
        fengcaizhanshiService.insert(fengcaizhanshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FengcaizhanshiEntity fengcaizhanshi, HttpServletRequest request){
    	fengcaizhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fengcaizhanshi);
        fengcaizhanshiService.insert(fengcaizhanshi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FengcaizhanshiEntity fengcaizhanshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fengcaizhanshi);
        fengcaizhanshiService.updateById(fengcaizhanshi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<FengcaizhanshiEntity> list = new ArrayList<FengcaizhanshiEntity>();
        for(Long id : ids) {
            FengcaizhanshiEntity fengcaizhanshi = fengcaizhanshiService.selectById(id);
            fengcaizhanshi.setSfsh(sfsh);
            fengcaizhanshi.setShhf(shhf);
            list.add(fengcaizhanshi);
        }
        fengcaizhanshiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fengcaizhanshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
