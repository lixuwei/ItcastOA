package com.lee.study.itcastoa.web.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.lee.study.itcastoa.domain.Department;
import com.lee.study.itcastoa.domain.Post;
import com.lee.study.itcastoa.domain.User;
import com.lee.study.itcastoa.exception.DepartmentException;
import com.lee.study.itcastoa.exception.PostException;
import com.lee.study.itcastoa.exception.UserException;
import com.lee.study.itcastoa.service.DepartmentService;
import com.lee.study.itcastoa.service.PostService;
import com.lee.study.itcastoa.service.UserService;
import com.lee.study.itcastoa.utils.OAActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends OAActionSupport{

	
	private static final long serialVersionUID = -2880736550325163515L;

	@Resource
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Resource
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@Resource
	private PostService postService;
	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	private Long uid;
	private String uname;
	private String email;
	private String phone;
	
	private Long did;
	
	private Long[] pids;
	
	
	
	
	
	
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public Long[] getPids() {
		return pids;
	}
	public void setPids(Long[] pids) {
		this.pids = pids;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 显示用户列表
	 * @return
	 */
	public String showAllUser(){
		
		try {
			//List<User> users = userService.getAllUser();
			Collection<User> users = userService.getAllUsers();
			ActionContext.getContext().put("users", users);
		} catch (UserException e) {
			e.printStackTrace();
		}
		
		return showList;
	}
	
	
	public String deleteUser(){
		
		try {
			userService.deleteUserById(uid);
		} catch (UserException e) {
			e.printStackTrace();
		}
		return action2action;
	}
	
	public String updateUI() {

		try {
			User user = this.userService.getUserByID(uid);
			// 把user压入到栈顶，就能回显用户的一般信息
			ActionContext.getContext().getValueStack().push(user);
			// 因为当前请求的action在对象栈中，所以action中的属性就在对象栈中，所以只需要给属性赋值就可以
			this.did = user.getDepartment().getDid();
			Set<Post> posts = user.getPosts();
			this.pids = new Long[posts.size()];
			int index = 0;
			for (Post post : posts) {
				this.pids[index] = post.getPid();
				index++;
			}
			
			List<Department> departments = new ArrayList<Department>();

			try {
				departments = departmentService.showAllDepartment();
			} catch (DepartmentException e) {
				e.printStackTrace();
			}

			List<Post> uPosts = new ArrayList<Post>();
			try {
				uPosts = postService.showAllPost();
			} catch (PostException e) {
				e.printStackTrace();
			}
			
			ActionContext.getContext().put("departmentList", departments);
			ActionContext.getContext().put("postList", uPosts);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateUI;
	}

	public String addUI(){
		
		List<Department> departments = new ArrayList<Department>();

		try {
			departments = departmentService.showAllDepartment();
		} catch (DepartmentException e) {
			e.printStackTrace();
		}

		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postService.showAllPost();
		} catch (PostException e) {
			e.printStackTrace();
		}
		
		ActionContext.getContext().put("departmentList", departments);
		ActionContext.getContext().put("postList", posts);
		
		return addUI;
	}
	
	public String addUser(){
		Department department = null;
		try {
			 department = departmentService.findDepartmentById(did);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		HashSet<Post> posts = new HashSet<Post>();
		try {
			posts = postService.findPostSetByIds(pids);
		} catch (PostException e) {
			e.printStackTrace();
		}
		
		User user  = new User();
		user.setUname(uname);
		user.setPhone(phone);
		user.setEmail(email);
		
		user.setDepartment(department);
		user.setPosts(posts);
		
		try {
			userService.addUser(user);
		} catch (UserException e) {
			e.printStackTrace();
		}
		
		return action2action;
	}
	
	public String updateUser(){
		
		
		User user = new User();
		try {
			user = userService.getUserByID(uid);
		} catch (UserException e1) {
			e1.printStackTrace();
		}
		
		Department department = null;
		try {
			 department = departmentService.findDepartmentById(did);
		} catch (DepartmentException e) {
			e.printStackTrace();
		}
		HashSet<Post> posts = new HashSet<Post>();
		try {
			posts = postService.findPostSetByIds(pids);
		} catch (PostException e) {
			e.printStackTrace();
		}
		
		
		user.setUname(uname);
		user.setPhone(phone);
		user.setEmail(email);
		
		user.setDepartment(department);
		user.setPosts(posts);
		
		try {
			userService.addUser(user);
		} catch (UserException e) {
			e.printStackTrace();
		}
		
		
		return action2action;
	}
}
