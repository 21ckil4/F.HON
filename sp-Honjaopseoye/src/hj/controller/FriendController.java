package hj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hj.dao.FriendDao;
import hj.dao.MemberDao;
import hj.logic.testLogic;

@Controller
@RequestMapping()
public class FriendController {
		Logger logger = Logger.getLogger(FriendController.class);
		
		@Autowired
		private FriendDao friendDao = null;

	/*���������� �̵� �׽�Ʈ*/
		@RequestMapping("/empty.hon")
		public String empty(Model mod, @RequestParam Map<String,Object> pMap, HttpServletResponse res) {
			List<Map<String,Object>> emptyList = null;
			logger.info("empty�޼ҵ� ȣ��");
			//tLogic.test(pMap);
			/*try {
				mDao.check(pMap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			return "redirect:main.jsp";
		}
		
	
		
}
