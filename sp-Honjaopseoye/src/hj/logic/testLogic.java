package hj.logic;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hj.dao.MemberDao;

@Service
public class testLogic {
	Logger logger = Logger.getLogger(testLogic.class);
	@Autowired
	private MemberDao memberDao = null;//xml������ ���� name�Ӽ��� �߰����� �����Ƿ� Ŭ���� �̸��� ��Ÿǥ����� �ؼ��ؾ� ��.
	public void test(Map<String, Object> pMap) {
		logger.info("testȣ�� ����");
		try {
			memberDao.check(pMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
