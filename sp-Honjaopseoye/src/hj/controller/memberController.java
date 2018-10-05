package hj.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hj.dao.MemberDao;

@Controller

@RequestMapping(value = "/member")
public class memberController {
	Logger logger = Logger.getLogger(memberController.class);

	@Autowired
	public MemberDao mDao = null;
	
	@RequestMapping("/Naver") 
	public String check() throws IOException {
	
			return "";
		
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ���̵� ã��(��ȭ��ȣ��) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//������ ��ĥ �ʿ䰡 ���� ������ ���� url�� �ִ� empty ����
	@RequestMapping(value = "/check.hon", method= {RequestMethod.POST, RequestMethod.GET}) //POST, GET ��� ���� �� ����
	public String check(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) throws IOException {
		logger.info("check ȣ�� ����");
		String resultPage = ""; //��� ������ ���� ����
		String result = "";
		List<Map<String, Object>> list = null;
		result = mDao.check(pMap);
		logger.info(result);
		if ("1".equals(result)) { //1�̸� �̸��� ���̵� ����
			logger.info(pMap.get("ins_name").toString());
			logger.info(pMap.get("mem_tel").toString());
			// �ٷ� Dao�� idSearch() �̵�
			list = mDao.idSearch(pMap);
			logger.info("Controller : " + list);
			if (list != null) {// list => �̸��� ���̵� ���翩��
				logger.info("Controller");
				HttpSession mem_session = req.getSession();
				mem_session.setAttribute("idSearch", list);
			}
			resultPage = "/member/login/idFound.jsp"; 
		} else if ("-1".equals(result)) {
			logger.info("result��" + result);
			resultPage = "/member/login/result/result.jsp?result=" + result;
		} else if ("0".equals(result)) {
			resultPage = "/member/login/result/result.jsp?result=" + result;
		}
		logger.info(resultPage);
		if ("-1".equals(result) || "0".equals(result)) {// redirect���� forward���� ������ ���� 
			logger.info("redirect�� ��������");
			return "forward:" + resultPage;
		} else {
			logger.info("forward�� ��������");
			return "forward:" + resultPage;
		}
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ���̵� ã��2(�̸��Ϸ�) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/check2.hon", method= {RequestMethod.POST, RequestMethod.GET})
	public String check2(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) throws IOException {
		logger.info("check2 ȣ�� ����"); 
		String resultPage = "";
		String result = "";
		List<Map<String, Object>> list = null;
		result = mDao.check2(pMap);
		logger.info(result);
		if ("1".equals(result)) {
			logger.info(pMap.get("e_name").toString());
			logger.info(pMap.get("e_mail").toString());
			// �ٷ� Dao�� idSearch() �̵�
			list = mDao.e_idSearch(pMap);
			logger.info("Controller : " + list);
			if (list != null) {// list => �̸��� ���̵�
				logger.info("Controller");
				HttpSession mem_session = req.getSession();
				mem_session.setAttribute("e_idSearch", list);
			}
			resultPage = "/member/login/idFound2.jsp";
		} else if ("-1".equals(result)) {
			logger.info("result��" + result);
			resultPage = "/member/login/result/result.jsp?result=" + result;
		} else if ("0".equals(result)) {
			resultPage = "/member/login/result/result.jsp?result=" + result;
		}
		logger.info(resultPage);
		if ("-1".equals(result) || "0".equals(result)) {// redirect���� forward���� ������ ���� result������ ����
			logger.info("redirect�� ��������");
			return "forward:" + resultPage;
		} else {
			logger.info("forward�� ��������");
			return "forward:" + resultPage;
		}
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ��й�ȣ ã��(��ȭ��ȣ��) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/pwCheck.hon", method= {RequestMethod.POST, RequestMethod.GET})
	public String pwCheck(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) throws IOException {
		logger.info("pwCheck ȣ�� ����");
		String resultPage = "";
		String result = "";
		List<Map<String, Object>> list = null;
		result = mDao.pwCheck(pMap);
		logger.info(result);
		if ("1".equals(result)) {
			logger.info(pMap.get("mem_id").toString());
			logger.info(pMap.get("mem_tel").toString());
			// �ٷ� Dao�� idSearch() �̵�
			result = mDao.proc_pw3(pMap);
			logger.info("Controller : " + result);
			if (result != null) {
				logger.info("Controller");
				HttpSession mem_session = req.getSession();
				mem_session.setAttribute("pwSearch", result);
			}
			resultPage = "/member/login/pwFound.jsp";
		} else if ("-1".equals(result)) {
			logger.info("result��" + result);
			resultPage = "/member/login/result/result.jsp?result=" + result;
		} else if ("0".equals(result)) {
			resultPage = "/member/login/result/result.jsp?result=" + result;
		}
		logger.info(resultPage);
		if ("-1".equals(result) || "0".equals(result)) {// redirect���� forward���� ������ ���� result������ ����
			logger.info("redirect�� ��������");
			return "forward:" + resultPage;
		} else {
			logger.info("forward�� ��������");
			return "forward:" + resultPage;
		}
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ��й�ȣ ã��(�̸��Ϸ�) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/pwCheck2.hon", method= {RequestMethod.POST, RequestMethod.GET})
	public String pwCheck2(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) throws IOException {
		logger.info("pwCheck2 ȣ�� ����");
		String resultPage = "";
		String result = "";
		List<Map<String, Object>> list = null;
		result = mDao.pwCheck2(pMap);
		logger.info(result);
		if ("1".equals(result)) {
			logger.info(pMap.get("e_id").toString());
			logger.info(pMap.get("e_mail").toString());
			// �ٷ� Dao�� idSearch() �̵�
			result = mDao.proc_epw(pMap);
			logger.info("Controller : " + result);
			if (result != null) {
				logger.info("Controller");
				HttpSession mem_session = req.getSession();
				mem_session.setAttribute("e_pwSearch", result);
			}
			resultPage = "/member/login/pwFound2.jsp";
		} else if ("-1".equals(result)) {
			logger.info("result��" + result);
			resultPage = "/member/login/result/result.jsp?result=" + result;
		} else if ("0".equals(result)) {
			resultPage = "/member/login/result/result.jsp?result=" + result;
		}
		logger.info(resultPage);
		if ("-1".equals(result) || "0".equals(result)) {// redirect���� forward���� ������ ���� result������ ����
			logger.info("redirect�� ��������");
			return "forward:" + resultPage;
		} else {
			logger.info("forward�� ��������");
			return "forward:" + resultPage;
		}
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ login @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	@RequestMapping(value = "/login.hon", method= {RequestMethod.POST, RequestMethod.GET})
	public String login(@RequestParam Map<String, Object> pMap, Model mod, HttpServletRequest req) throws IOException {
		logger.info("login ȣ�� ����");
		String resultPage = "";
		String result = "";
		List<Map<String, Object>> list = null;
		result = mDao.login(pMap);
		logger.info(result);
		if ("1".equals(result)) {
			logger.info(pMap.get("mem_id").toString());
			logger.info(pMap.get("mem_pw").toString());
			// �ٷ� Dao�� idSearch() �̵�
			list = mDao.select(pMap);
			logger.info("Controller : " + result);
			if (list != null) {
				logger.info("Controller");
				HttpSession mem_session = req.getSession();
				mem_session.setAttribute("memList", list);
			}
			resultPage = "/member/login/pwFound2.jsp";
		} else if ("-1".equals(result)) {
			logger.info("result��" + result);
			resultPage = "/member/login/result/result.jsp?result=" + result;
		} else if ("0".equals(result)) {
			resultPage = "/member/login/result/result.jsp?result=" + result;
		}
		logger.info(resultPage);
		if ("-1".equals(result) || "0".equals(result)) {// redirect���� forward���� ������ ���� 
			logger.info("redirect�� ��������");
			return "forward:" + resultPage;
		} else {
			logger.info("forward�� ��������");
			return "forward:" + resultPage;
		}
	}
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ notice @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
}
