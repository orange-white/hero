package com.rsy.service;

import java.util.List;

import com.rsy.entity.Hero;

public interface HeroService {
	/**
	 * ����
	 * @param hero
	 * @return
	 */
	int addHero(Hero hero);
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	int delHero(int id);
	/**
	 * �༭
	 * @param hero
	 * @return
	 */
	int updHero(Hero hero);
	/**
	 * �鿴
	 * @param id
	 * @return
	 */
	Hero findById(int id);
	/**
	 * ��ѯ����
	 * @return
	 */
	List<Hero> findAll();
	/**
	 * ��ҳ��ѯ
	 * @param honor
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Hero> findByHonor(String honor,int pageNo,int pageSize);
	/**
	 * ��¼
	 * @param hero
	 * @return
	 */
	Hero login(String hero);
	/**
	 * ��ȡ����
	 * @param honor
	 * @return
	 */
	int getCount(String honor);
}
