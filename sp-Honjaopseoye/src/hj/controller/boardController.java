package hj.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hj.dao.BoardDao;
import hj.util.HangulConversion;


@Controller
@RequestMapping("/board")
public class boardController {
	Logger logger = Logger.getLogger(MemberController.class);

	@Autowired
	private BoardLogic boardLogic = null;

	@Autowired
	private BoardDao boardDao = null;
	
/*������ ����*/
	@ResponseBody
	@RequestMapping("/postList.kjh")
	public String postList(Model mod, @RequestParam Map<String,Object> pMap, HttpServletResponse res) {
		List<Map<String,Object>> boardList = null;
		if(pMap.containsKey(/*"ȥ��|ȥ��|ȥ��"*/)) {
			pMap.put("sb_keyword", HangulConversion.toKor(pMap.get("sb_keyword").toString()));
		}
		try {
			boardList = boardLogic.postList(pMap,res);			
			logger.info("postList ȣ�� ����");
			mod.addAttribute("postList", postList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:boardlist.jsp";
	}
	
/*����Ʈ �̵�*/
	@RequestMapping(value="/write.hon", method = RequestMethod.POST)
	public String write(@RequestParam Map<String,Object> pMap) {
		return "redirect:write.jsp";
	}
	
/*������ �󼼺���*/
}
