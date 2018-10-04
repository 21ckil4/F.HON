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

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ ������ �������� ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	
	public List<Map<String, Object>> nSelect(Map<String, Object> pMap) {
		logger.info("rInsert ȣ�� ����");
		List<Map<String, Object>> nList = new ArrayList<Map<String, Object>>();
		nList = sqlSessionTemplate.selectList("nSelect", pMap);
		sqlSessionTemplate.commit();
		logger.info("nSelect: " + nList);
		return nList;
	}

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ �����ϱ� �Խ��� ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	public List<Map<String, Object>> qSelect(Map<String, Object> pMap) {
		logger.info("qSelect ȣ�� ����");
		List<Map<String, Object>> qList = new ArrayList<Map<String, Object>>();
		qList = sqlSessionTemplate.selectList("qSelect", pMap);
		sqlSessionTemplate.commit();
		logger.info("qSelect: " + qList);
		return qList;
	}

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ �����ϱ� ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	public int qInsert(Map<String, Object> pMap) {
		logger.info("qInsert ȣ�� ����");
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
