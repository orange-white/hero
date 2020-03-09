package com.rsy.service.impl;

import java.util.List;

import com.rsy.dao.HeroDao;
import com.rsy.dao.impl.HeroDaoImpl;
import com.rsy.entity.Hero;
import com.rsy.service.HeroService;

public class HeroServiceImpl implements HeroService {
	
	HeroDao dao = new HeroDaoImpl();

	@Override
	public int addHero(Hero hero) {
		return dao.addHero(hero);
	}

	@Override
	public int delHero(int id) {
		return dao.delHero(id);
	}

	@Override
	public int updHero(Hero hero) {
		return dao.updHero(hero);
	}

	@Override
	public Hero findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Hero> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Hero> findByHonor(String honor, int pageNo, int pageSize) {
		return dao.findByHonor(honor, (pageNo-1)*pageSize, pageSize);
	}

	@Override
	public Hero login(String hero) {
		return dao.login(hero);
	}

	@Override
	public int getCount(String honor) {
		return dao.getCount(honor);
	}
	
}
