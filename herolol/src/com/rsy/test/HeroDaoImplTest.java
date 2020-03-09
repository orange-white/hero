package com.rsy.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rsy.dao.HeroDao;
import com.rsy.dao.impl.HeroDaoImpl;
import com.rsy.entity.Hero;

public class HeroDaoImplTest {

	HeroDao dao = null;
	Hero hero = null;
	@Before
	public void setUp() throws Exception {
		dao = new HeroDaoImpl();
		hero = new Hero();
	}

	
	@Test
	public void testFindAll() {
		List<Hero> heros = new ArrayList<Hero>();
		for (Hero hero : heros) {
			System.out.println(hero);
		}
	}


}
