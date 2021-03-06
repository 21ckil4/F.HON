package hj.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class MenuDao {
	Logger logger = Logger.getLogger(MenuDao.class);

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ 관리자 공지사항 ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	
	public List<Map<String, Object>> nSelect(Map<String, Object> pMap) {
		logger.info("rInsert 호출 성공");
		List<Map<String, Object>> nList = new ArrayList<Map<String, Object>>();
		nList = sqlSessionTemplate.selectList("nSelect", pMap);
		sqlSessionTemplate.commit();
		logger.info("nSelect: " + nList);
		return nList;
	}

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ 문의하기 게시판 ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	public List<Map<String, Object>> qSelect(Map<String, Object> pMap) {
		logger.info("qSelect 호출 성공");
		List<Map<String, Object>> qList = new ArrayList<Map<String, Object>>();
		qList = sqlSessionTemplate.selectList("qSelect", pMap);
		sqlSessionTemplate.commit();
		logger.info("qSelect: " + qList);
		return qList;
	}

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ 문의하기 ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	public int qInsert(Map<String, Object> pMap) {
		logger.info("qInsert 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.insert("qInsert", pMap);
		if (result == 1) {
			sqlSessionTemplate.commit();
			logger.info("qInsert: " + result);
			return result;
		}
		return result;
	}

}
