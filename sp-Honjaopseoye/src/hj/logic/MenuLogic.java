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

	/*1. �Խñ� ����� ������ ���(qna_no�� �������� �߰�)
	 *2. �Խñ��� ��۴ޱ⸦ ������ ���(qView���� ����) 
	a. depth - if(��۴ޱ⸦ �������� �����ִ� depth���� 1�� �߰��ǰ�)
	 	- else{ �����϶� �׳� 0��}
	b. step �� ��������� ���� ��������. 
		1. �߰� �ɶ� ��� ��ġ�ϴ��� �Ǵ��ؾ���.
		2. �߰� �� ��ġ �ٷ� ������ step+1�� ���� �ο�
		3. �߰��� �ۺ��� �Ʒ��� ��ġ�ϴ� �۵��� ��� step�� 1�� �߰���.
	c. group - if(ù���̸� �׷��ȣ�� ���� �׷��ȣ���� ���� ū ��ȣ�� +1�ȴ�.)
		- else if( ù���� �ƴҰ��(����� ���)�� �׷��ȣ�� �״�� �ο��޴´�.*/
	public int qInsert(HttpServletRequest req, Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("���ǰԽñ� ����");
		int result = 0;
		int depth = -1;
		int group = 0;
		String step = null;
		//����� ��� �������� depth,group,step���� �޾ƿ´�.
		depth = Integer.parseInt(req.getParameter("depth"));
		group = Integer.parseInt(req.getParameter("group"));
		step  = req.getParameter("step");
		if(depth>=-1) {//����� ���
			//���� �۵鿡 step���� 1�߰��ϴ� ������
			menuDao.step(step);
			pMap.put("qna_group", group);

		} else {//������ ���
			//�� �׷��ȣ ä�� ������
			group = menuDao.getGroup(pMap);
			group = group + 1;
			pMap.put("qna_group", group);
			
		}
			//�� ���
			depth = depth + 1;//depth 1�߰�
			pMap.put("qna_depth", depth);
			pMap.put("qna_step", step);
			result = menuDao.qInsert(pMap);
		return result;
	}

	public List<Map<String, Object>> nSelect(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		logger.info("nSelect ����");
		List<Map<String, Object>> list = null;
		list = menuDao.nSelect(pMap);
		return list;
	}
}
