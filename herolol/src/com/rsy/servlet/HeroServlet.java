package com.rsy.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.rsy.entity.Hero;
import com.rsy.service.HeroService;
import com.rsy.service.impl.HeroServiceImpl;
import com.rsy.utils.BaseServlet;
import com.rsy.utils.Constants;
import com.rsy.utils.StringUtils;

@SuppressWarnings("serial")
public class HeroServlet extends BaseServlet {

	HeroService biz = new HeroServiceImpl();
	
	public void login(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//获取参数
		String name = arg0.getParameter("hero");
		String honor = arg0.getParameter("honor");
		Hero hero = biz.login(name);
		if (hero != null) {
			if (honor.equals(hero.getHonor())) {
				arg0.getSession().setAttribute(Constants.SESSION_HERO, hero);
				arg1.sendRedirect("HeroServlet?method=list");
				
			} else {
				arg0.getSession().setAttribute("msg","称号不对哦。。。");
				arg1.sendRedirect("login.jsp");
			}
		} else {
			arg0.getSession().setAttribute("msg","名字错啦。。。");
			arg1.sendRedirect("login.jsp");
		}
	}

	
	public void logout(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.getSession().invalidate();
		arg1.sendRedirect("login.jsp");
	}


	
	public void list(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//获取参数
		String honor = arg0.getParameter("honor");
		String pageNoStr = arg0.getParameter("pageNo");
		String pageSizeStr = arg0.getParameter("pageSize");
		
		//非空判断
		int pageNo = StringUtils.isEmpty(pageNoStr) ? 1 : Integer.parseInt(pageNoStr);
		int pageSize = StringUtils.isEmpty(pageSizeStr) ? 5 : Integer.parseInt(pageSizeStr);
		
		//查询总数
		int count = biz.getCount(honor);
		//计算总页数
		int pageTotal = count % pageSize == 0 ? (count/pageSize) : (count/pageSize) + 1;
		//首页
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (pageNo > pageTotal) {
			pageNo = pageTotal;
		}
		
		//查询
		List<Hero> heros = biz.findByHonor(honor, pageNo, pageSize);
		
		arg0.setAttribute("heros", heros);
		arg0.setAttribute("pageNo", pageNo);
		arg0.setAttribute("pageTotal", pageTotal);
		arg0.setAttribute("count",count);
		arg0.setAttribute("honor", honor);
		
		//跳转
		arg0.getRequestDispatcher("/rsy/list.jsp").forward(arg0, arg1);
	}


	
	public void regist(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		List<String> strList = new ArrayList<String>();
		strList.add(".jpg");
		strList.add(".png");
		strList.add("gif");
		
		//获取参数
		String head = null;
		String name = null;
		String honor = null;
		String local1 = null;
		String local2 = null;
		String local3 = null;
		String story = null;
		String skin = null;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(1024*2048);
		try {
			List<FileItem> fiList = sfu.parseRequest(arg0);
			for (FileItem fi : fiList) {
				//获得表单文本域名字
				String fieldName = fi.getFieldName();
				//判断是文件类型吗
				boolean isComm = fi.isFormField();
				//获得原始文件名
				String oriFileName = fi.getName();
				if (isComm && fieldName != null && !"".equals(fieldName)) {
					String content = fi.getString();
					content = new String(content.getBytes("ISO-8859-1"),"UTF-8");
					if (fieldName.equals("hero")) {
						name =content;
					}else if (fieldName.equals("honor")) {
						honor = content;
					}else if (fieldName.equals("local1")) {
						local1 = content;
					}else if (fieldName.equals("local2")) {
						local2 = content;
					}else if (fieldName.equals("local3")) {
						local3 = content;
					}else if (fieldName.equals("story")) {
						story = content;
					}	
				} 
				if (!isComm && fieldName !=null && !"".equals(fieldName)) {
					//获得上传位置
					String realPath = arg0.getSession().getServletContext().getRealPath(Constants.UPLOAD_PATH);
					if (oriFileName != null && !"".equals(oriFileName)) {
						String str = oriFileName.substring(oriFileName.lastIndexOf("."));
						if (strList.contains(str)) {
							String uFileName = UUID.randomUUID().toString();
							String relativePath = Constants.UPLOAD_PATH+ uFileName + str;
							head = relativePath;
							File file = new File(realPath,uFileName + str);
							fi.write(file);
						} else {
							arg1.getWriter().print("上传格式错误。。。");						
							return;
						}
								
					}
				}
				
			}
			Hero hero = new Hero();
			hero.setHead(head);
			hero.setHero(name);
			hero.setHonor(honor);
			hero.setLocal1(local1);
			hero.setLocal2(local2);
			hero.setLocal3(local3);
			hero.setStory(story);
			hero.setSkin(skin);
			
			if (biz.addHero(hero)>0) {
				arg1.sendRedirect("regSuccess.jsp");
			} else {
				arg1.sendRedirect("regist.jsp");
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException){
				arg1.getWriter().write("文件过大，请上传2M以内");
			}
		}
		
	}


	
	public void toUpdate(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String id = arg0.getParameter("id");
		Hero h = biz.findById(Integer.parseInt(id));
		if (h != null) {
			arg0.setAttribute("h", h);
			arg0.getRequestDispatcher("/rsy/update.jsp").forward(arg0, arg1);
		} else {
			arg1.getWriter().print("<script type='text/javascript'>alert('出错了！')</script>");
			arg1.sendRedirect("HeroServlet?method=list");
		}
	}


	
	public void doUpdate(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		List<String> strList = new ArrayList<String>();
		strList.add(".jpg");
		strList.add(".png");
		strList.add("gif");
		
		//获取参数
		String head = null;
		String name = null;
		String honor = null;
		String local1 = null;
		String local2 = null;
		String local3 = null;
		String story = null;
		String skin = null;
		String id = arg0.getParameter("id");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setFileSizeMax(1024*2048);
		try {
			List<FileItem> fiList = sfu.parseRequest(arg0);
			for (FileItem fi : fiList) {
				//获得表单文本域名字
				String fieldName = fi.getFieldName();
				//判断是文件类型吗
				boolean isComm = fi.isFormField();
				//获得原始文件名
				String oriFileName = fi.getName();
				if (isComm && fieldName != null && !"".equals(fieldName)) {
					String content = fi.getString();
					content = new String(content.getBytes("ISO-8859-1"),"UTF-8");
					if (fieldName.equals("hero")) {
						name =content;
					}else if (fieldName.equals("honor")) {
						honor = content;
					}else if (fieldName.equals("local1")) {
						local1 = content;
					}else if (fieldName.equals("local2")) {
						local2 = content;
					}else if (fieldName.equals("local3")) {
						local3 = content;
					}else if (fieldName.equals("story")) {
						story = content;
					}	
				} 
				if (!isComm && fieldName !=null && !"".equals(fieldName)) {
					//获得上传位置
					String realPath = arg0.getSession().getServletContext().getRealPath(Constants.UPLOAD_PATH);
					if (oriFileName != null && !"".equals(oriFileName)) {
						String str = oriFileName.substring(oriFileName.lastIndexOf("."));
						if (strList.contains(str)) {
							String uFileName = UUID.randomUUID().toString();
							String relativePath = Constants.UPLOAD_PATH+ uFileName + str;
							head = relativePath;
							File file = new File(realPath,uFileName + str);
							fi.write(file);
						} else {
							arg1.getWriter().print("上传格式错误。。。");						
							return;
						}
								
					}
				}
				
			}
			Hero hero = new Hero();
			hero.setId(hero.getId());
			hero.setHead(head);
			hero.setHero(name);
			hero.setHonor(honor);
			hero.setLocal1(local1);
			hero.setLocal2(local2);
			hero.setLocal3(local3);
			hero.setStory(story);
			hero.setSkin(skin);
			hero.setId(Integer.parseInt(id));
			
			if (biz.updHero(hero)>0) {
				arg1.sendRedirect("HeroServlet?method=list");
			} else {
				arg1.sendRedirect("HeroServlet?method=toUpdate&hero.getId");
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException){
				arg1.getWriter().write("文件过大，请上传2M以内");
			}
		}
		
	}


	
	public void delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		String id = arg0.getParameter("id");
		
		if(biz.delHero(Integer.parseInt(id))>0){
			arg1.sendRedirect("HeroServlet?method=list");
		}else{
			arg1.getWriter().print("<script type='text/javascript'>alert('出错了！')</script>");
			arg1.sendRedirect("HeroServlet?method=list");
		}
	}


	
	public void toShow(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		String id = arg0.getParameter("id");
		Hero h = biz.findById(Integer.parseInt(id));
		
		if(h != null){
			arg0.setAttribute("h", h);
			arg0.getRequestDispatcher("/rsy/show.jsp").forward(arg0, arg1);
		}else{
			arg1.getWriter().print("<script type='text/javascript'>alert('出错了！')</script>");
			arg1.sendRedirect("HeroServlet?method=list");
		}
	}
	
	
	
	
	
		
	
}
