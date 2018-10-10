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
		logger.info("nSelect ȣ�� ����");
		List<Map<String, Object>> nList = new ArrayList<Map<String, Object>>();
		nList = sqlSessionTemplate.selectList("nSelect", pMap);
		logger.info("nSelect: " + nList);
		return nList;
	}

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ �����ϱ� �Խ��� ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	public List<Map<String, Object>> qSelect(Map<String, Object> pMap) {
		logger.info("qSelect ȣ�� ����");
		List<Map<String, Object>> qList = new ArrayList<Map<String, Object>>();
		qList = sqlSessionTemplate.selectList("qSelect", pMap);
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
		}
		return result;
	}

/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ �������� �۾��� ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	public int nInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("nInsert ȣ�� ����");
		int result = 0;
		result = sqlSessionTemplate.insert("nInsert", pMap);
		if (result == 1) {
			sqlSessionTemplate.commit();
			logger.info("nInsert: " + result);
		}
		return result;
	}
	
/* [[[[[[[[[[[[[[[[[[[[[[[[[[[[ ������ �Խñ� ]]]]]]]]]]]]]]]]]]]]]]]]]]]] */
	public int step(String pMap) {
		logger.info("step Update");
		int result = 0;
		result = sqlSessionTemplate.update(pMap);
		sqlSessionTemplate.commit();
		return result;	
	}

	public int getGroup(Map<String, Object> pMap) {
		logger.info("group Select");
		int gno = 0;
		gno = sqlSessionTemplate.selectOne("getGroup");
		return gno;
	}

}
