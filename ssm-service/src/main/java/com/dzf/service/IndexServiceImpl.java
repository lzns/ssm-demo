package com.dzf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzf.dao.IndexDao;
import com.dzf.entity.Author;
import com.dzf.entity.Index;
import com.dzf.entity.Note;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class IndexServiceImpl<T> implements IndexService {

	@Autowired
	private IndexDao indexDao;

	@Override
	public Index helloService(String str) {
		if (null == str && str.length() == 0) {
			return null;
		}
		return indexDao.queryByName(str);
	}

	/**
	 * 使用注解事务
	 */
	@Transactional
	@Override
	public Integer adPerson(Index index) {
		if (index == null) {
			return -1;
		}
		return indexDao.insert(index);
	}

	@Override
	public List<Index> getList(String name, Integer age) {
		if (name == null || age == null) {
			return null;
		}
		return indexDao.getList(name, age);
	}

	@Transactional
	@Override
	public Long getPkByInsert(String name, String state, Integer age) {
		if (name == null || state == null || age == null) {
			return null;
		}
		return indexDao.getPkByInsert(name, state, age);
	}

	@Override
	public Map<String, Object> queryForPage(Integer[] ids) {
		if (ids == null || ids.length <= 0) {
			return null;
		}
		List<Index> list2 = indexDao.queryForPage(ids);
		// 设置当前的页码和条数
		PageHelper.startPage(1, 5);
		PageInfo<Index> pageInfo = new PageInfo<Index>(list2);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", pageInfo.getList());
		map.put("rows", pageInfo.getTotal());
		return map;
	}

	@Override
	public List<Note> queryNoteAndAuthor() {
		return indexDao.queryNoteAndAuthor();

	}

	@Override
	public Author queryAuthorAndNotes(Integer id) {
		if (id == null || id <= 0) {
			return null;
		}
		return indexDao.queryAuthorAndNotes(id);
	}

	/**
	 * 需要添加事务
	 */
	@Transactional
	@Override
	public Integer getPkByInsert2(Index index) {
		if (index == null) {
			return null;
		}
		indexDao.getPkByInsert2(index);
		return index.getId();
	}

	/**
	 * 需要添加事务
	 */
	@Transactional
	@Override
	public Integer insertAuthor(Author author) {
		if (author == null) {
			return null;
		}
		indexDao.insertAuthor(author);
		return author.getId();
	}

	@Override
	public Map<String,Object> getNotes(String title) {
		//使用分页
//		PageHelper.startPage(1, 3);
		List<Note> notes = indexDao.getNotes(title);
		System.out.println(notes);
		PageInfo<Note> page = new PageInfo<Note>(notes);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", page.getList());
		map.put("pageNo", page.getPageNum());
		map.put("pageSize", page.getPageSize());
		map.put("rows",page.getTotal());
//		map.put("list",notes);
		return map;
	}
}
