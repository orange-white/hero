package com.rsy.service;

import java.util.List;

import com.rsy.entity.Hero;

public interface HeroService {
	/**
	 * 增加
	 * @param hero
	 * @return
	 */
	int addHero(Hero hero);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delHero(int id);
	/**
	 * 编辑
	 * @param hero
	 * @return
	 */
	int updHero(Hero hero);
	/**
	 * 查看
	 * @param id
	 * @return
	 */
	Hero findById(int id);
	/**
	 * 查询所有
	 * @return
	 */
	List<Hero> findAll();
	/**
	 * 分页查询
	 * @param honor
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Hero> findByHonor(String honor,int pageNo,int pageSize);
	/**
	 * 登录
	 * @param hero
	 * @return
	 */
	Hero login(String hero);
	/**
	 * 获取总数
	 * @param honor
	 * @return
	 */
	int getCount(String honor);
}
