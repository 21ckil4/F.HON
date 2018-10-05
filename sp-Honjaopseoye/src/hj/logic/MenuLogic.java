package hj.logic;

import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hj.dao.MenuDao;

@Service
public class MenuLogic {
	Logger logger = Logger.getLogger(MenuLogic.class);

	@Autowired
	private MenuDao menuDao = null;

	public List<Map<String, Object>> qSelect(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("qSelect ����");
		List<Map<String, Object>> list = null;
		list = menuDao.qSelect(pMap);
		return list;
	}

	/*public int qInsert(HttpServletRequest req, Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("���ǰԽñ� ����");
		int result=0;
		int rno = 0;
		int group = 0;
		//����� ���
		if(pMap.equals("��� �Ķ���� ����")) {
			rno = Integer.parseInt(req.getParameter("qna_no"));
			//�ش� �׷��� depth�� step�� �޾ƿ���
			group = menuDao.getGroup(pMap);//(qna_group,qna_depth,qna_step)
				if(depth) {//���ο� depth�� ���
					logger.info("depth ����");
					menuDao.depth(bMap);
					//������ 1�߰� �ٿ�
				}
				else if(depth!) {//���ο� step�� ���
					logger.info("step ����");
					menuDao.step(bMap);
					//���ܿ� 1�߰� �ٿ�
			}
		}
		result = menuDao.qInsert(pMap);
		return result;
	}*/

	public List<Map<String, Object>> nSelect(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("nSelect ����");
		List<Map<String, Object>> list = null;
		list = menuDao.nSelect(pMap);
		return list;
	}
}
