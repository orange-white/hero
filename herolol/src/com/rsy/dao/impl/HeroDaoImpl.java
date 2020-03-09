package com.rsy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rsy.dao.HeroDao;
import com.rsy.entity.Hero;
import com.rsy.utils.BaseDao;


public class HeroDaoImpl extends BaseDao implements HeroDao {

	@Override
	public int addHero(Hero hero) {
		String sql = "insert into hero(head,hero,honor,local1,local2,local3,story,skin) values(?,?,?,?,?,?,?,?)";
		Object[] obj = { hero.getHead(),hero.getHero(),hero.getHonor(),hero.getLocal1()
				,hero.getLocal2(),hero.getLocal3(),hero.getStory(),hero.getSkin() };
		int res = update(sql,obj);
		close();
		return res;
	}

	@Override
	public int delHero(int id) {
		String sql = "delete from hero where id=?";
		Object[] obj = { id };
		int res = update(sql,obj);
		close();
		return res;
	}

	@Override
	public int updHero(Hero hero) {
		String sql = "update hero set head=?,hero=?,honor=?,local1=?,local2=?,local3=?,story=?,skin=? where id=?";
		Object[] obj = { hero.getHead(),hero.getHero(),hero.getHonor(),hero.getLocal1(),hero.getLocal2()
				,hero.getLocal3(),hero.getStory(),hero.getSkin(),hero.getId()};
		int res = update(sql,obj);
		close();
		return res;
	}

	@Override
	public Hero findById(int id) {
		String sql = "select * from hero where id=?";
		Object[] obj = { id };
		ResultSet rs = query(sql,obj);
		Hero hero = null;
		try {
			while (rs.next()) {
				hero = new Hero();
				hero.setId(rs.getInt("id"));
				hero.setHead(rs.getString("head"));
				hero.setHero(rs.getString("hero"));
				hero.setHonor(rs.getString("honor"));
				hero.setLocal1(rs.getString("local1"));
				hero.setLocal2(rs.getString("local2"));
				hero.setLocal3(rs.getString("local3"));
				hero.setStory(rs.getString("story"));
				hero.setSkin(rs.getString("skin"));
			}
			return hero;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return hero;
	}

	@Override
	public List<Hero> findAll() {
		List<Hero> heros = new ArrayList<Hero>();
		String sql = "select * from hero";
		Object[] obj = {};
		ResultSet rs = query(sql,obj);
		Hero hero = null;
		try {
			while (rs.next()) {
				hero = new Hero();
				hero.setId(rs.getInt("id"));
				hero.setHead(rs.getString("head"));
				hero.setHero(rs.getString("hero"));
				hero.setHonor(rs.getString("honor"));
				hero.setLocal1(rs.getString("local1"));
				hero.setLocal2(rs.getString("local2"));
				hero.setLocal3(rs.getString("local3"));
				hero.setStory(rs.getString("story"));
				hero.setSkin(rs.getString("skin"));
				heros.add(hero);
			}
			return heros;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return heros;
	}

	@Override
	public List<Hero> findByHonor(String honor, int pageNo, int pageSize) {
		List<Hero> heros = new ArrayList<Hero>();
		String sql = "select * from hero where 1=1";
		ResultSet rs = null;
		Hero hero = null;
		if (honor != null) {
			sql += " and honor like concat('%',?,'%') limit ?,?";
			Object[] obj = { honor,pageNo,pageSize };
			rs = query(sql,obj);
		} else {
			sql += " limit ?,?";
			Object[] obj = { pageNo,pageSize };
			rs = query(sql,obj);
		}
		try {
			while (rs.next()) {
				hero = new Hero();
				hero.setId(rs.getInt("id"));
				hero.setHead(rs.getString("head"));
				hero.setHero(rs.getString("hero"));
				hero.setHonor(rs.getString("honor"));
				hero.setLocal1(rs.getString("local1"));
				hero.setLocal2(rs.getString("local2"));
				hero.setLocal3(rs.getString("local3"));
				hero.setStory(rs.getString("story"));
				hero.setSkin(rs.getString("skin"));
				heros.add(hero);
			}
			return heros;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return heros;
	}

	@Override
	public Hero login(String heroname) {
		String sql = "select * from hero where hero=?";
		Object[] obj = { heroname };
		ResultSet rs = query(sql,obj);
		Hero hero = null;
		try {
			while (rs.next()) {
				hero = new Hero();
				hero.setId(rs.getInt("id"));
				hero.setHead(rs.getString("head"));
				hero.setHero(rs.getString("hero"));
				hero.setHonor(rs.getString("honor"));
				hero.setLocal1(rs.getString("local1"));
				hero.setLocal2(rs.getString("local2"));
				hero.setLocal3(rs.getString("local3"));
				hero.setStory(rs.getString("story"));
				hero.setSkin(rs.getString("skin"));	
			}
			return hero;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return hero;
	}
	
	@Override
	public int getCount(String honor) {
		String sql = "select count(1) from hero where 1=1";
		ResultSet rs = null;
		int count = 0;
		if (honor != null) {
			sql += " and honor like concat('%',?,'%') ";
			Object[] obj = { honor };
			rs = query(sql,obj);
		} else {
			Object[] obj = {};
			rs = query(sql,obj);
		}
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return count;
	}
	
	
}
