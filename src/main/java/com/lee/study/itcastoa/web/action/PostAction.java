package com.lee.study.itcastoa.web.action;

import java.util.List;

import javax.annotation.Resource;
import com.lee.study.itcastoa.domain.Post;
import com.lee.study.itcastoa.exception.PostException;
import com.lee.study.itcastoa.service.PostService;
import com.lee.study.itcastoa.utils.OAActionSupport;
import com.opensymphony.xwork2.ActionContext;
/**
 * 处理Post请求
 * @author lee
 *	
 * 2013-3-4  上午10:23:45
 */
public class PostAction extends OAActionSupport{
	

	private static final long serialVersionUID = -2159456466670502091L;

	@Resource
	private PostService postService;

	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	//从页面接收到的属性
	private Long pid;
	
	private String pname;
	
	private String description;
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取所有的Department信息
	 * @return
	 */
	public String showAllPost(){
		
		List<Post> posts;
		try {
			posts = postService.showAllPost();
			ActionContext.getContext().put("posts", posts);
		} catch (PostException e) {
			e.printStackTrace();
		}
		
		return showList;
	}
	/**
	 * 处理删除操作
	 * @return
	 */
	public String deletePost(){
		
		try {
			postService.deletePost(pid);
		} catch (PostException e) {
			e.printStackTrace();
		}
		
		return action2action;
	}
	/**
	 * 显示添加页面
	 * @return
	 */
	public String showAddUI(){
		return addUI;
	}
	/**
	 * 保存一个Department
	 * @return
	 */
	public String savePost(){
		
		Post post = new Post();
		post.setPname(pname);
		post.setDescription(description);
		
		try {
			postService.savePost(post);
		} catch (PostException e) {
			e.printStackTrace();
		}
		
		return action2action;
	}
	/**
	 * 显示Department更新页面
	 * @return
	 */
	public String showUpdateUI(){
		Post post = null;
		try {
			post = postService.findPostById(pid);
		} catch (PostException e) {
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().push(post);
		return updateUI;
	}
	/**
	 * 保存更新
	 * @return
	 */
	public String updatePost(){
		
		Post post = new Post();
		post.setPid(pid);
		post.setPname(pname);
		post.setDescription(description);
		
		try {
			postService.updatePostByObject(post);
		} catch (PostException e) {
			e.printStackTrace();
		}
		
		return action2action;
	}
}
