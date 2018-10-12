package hj.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import hj.dao.GroupDao;
import hj.logic.GroupLogic;

@Controller
@RequestMapping("/group")
public class GroupController {
   Logger logger = Logger.getLogger(GroupController.class);

   private GroupLogic groupLogic = null;

   @Autowired
   private GroupDao groupDao = null;
   
   //�� ��� �޼ҵ�
   @ResponseBody
   @RequestMapping("/groupInsert.hon")
   public String groupInsert(Model mod, @RequestParam Map<String,Object> pMap) {
	  logger.info(pMap);
	  logger.info("nInsert �޼ҵ� ȣ��");
	  int result = 0;
	  result = groupDao.groupInsert(pMap);
	  return String.valueOf(result);
   }
	
   //������ȸ �޼ҵ�
   @ResponseBody
   @RequestMapping(value="/store_sel.hon" , produces="text/html; charset=UTF-8")
   public String select(Model mod,@RequestParam Map<String, Object> pMap) throws IOException {
	  List<Map<String, Object>> list = null;
	  list = groupDao.storeSelect(pMap);
	  Gson gs = new Gson();
	  String json = gs.toJson(list);
	  return json;
   }
}
