package hj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hj.dao.MenuDao;
import hj.logic.MenuLogic;

@Controller
@RequestMapping("/notice")
public class MenuController {
	Logger logger = Logger.getLogger(MenuController.class);

	@Autowired
	private MenuLogic menuLogic = null;

	@Autowired
	private MenuDao menuDao = null;

	/* �������� */
	@ResponseBody
	@RequestMapping("/nSelect.hon")
	public String nSelect(Model mod
			, @RequestParam Map<String, Object> pMap) {
		logger.info("nSelect �޼ҵ� ȣ��");
		List<Map<String, Object>> list = null;
		list = menuLogic.nSelect(pMap);
		mod.addAttribute(list);
		return "redirect:jsp";
	}

	/* �������� �۾��� */
	@RequestMapping("/nInsert.hon")
	public String nInsert(Model mod
			, @RequestParam Map<String,Object> pMap
			, HttpServletResponse res) {
		logger.info("nInsert �޼ҵ� ȣ��");
		int result = 0;
		result = menuDao.nInsert(pMap);
		return "redirect:../notice/notice.jsp";
	}

	/* �����ϱ� */
	@RequestMapping("/qInsert.hon")
	public String qInsert(Model mod
			, @RequestParam Map<String,Object> pMap
			, HttpServletRequest req) {
		logger.info("qInsert �޼ҵ� ȣ��");
		int result = 0;
		//result = menuLogic.qInsert(req, pMap);
		return "forward:/notice/qna/qnaRead.jsp";
	}

	/* ���� �Խ��� */
	@ResponseBody
	@RequestMapping(value="/qSelect.hon", method= {RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> qSelect(Model mod
			, @RequestParam Map<String, Object> pMap
			, HttpServletResponse res){
			logger.info("qSelect �޼ҵ� ȣ��");
			List<Map<String,Object>> list = null;
			list = menuLogic.qSelect(pMap);
			mod.addAttribute("list", list);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("data", list);
			return map;
	}

}
