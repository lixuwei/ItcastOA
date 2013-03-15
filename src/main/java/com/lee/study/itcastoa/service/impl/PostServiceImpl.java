package com.lee.study.itcastoa.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lee.study.itcastoa.dao.PostDao;
import com.lee.study.itcastoa.domain.Post;
import com.lee.study.itcastoa.domain.User;
import com.lee.study.itcastoa.exception.PostException;
import com.lee.study.itcastoa.service.PostService;
import com.lee.study.itcastoa.service.util.OAServiceUtils;

@Service("postService")
public class PostServiceImpl implements PostService{

	@Resource
	private PostDao postDao;
	
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> showAllPost() throws PostException {
		
		String hql = "from Post p";
		try {
			return postDao.findListByHql(hql);
		} catch (Exception e) {
			new PostException("遍历部门出错!!",e);
		}
		return Collections.EMPTY_LIST;
		
	}

	@Override
	public void deletePost(Long pid) throws PostException {
		try {
			Post findPostById = this.findPostById(pid);
			Set<User> users = findPostById.getUsers();
			for (User user : users) {
				Set<Post> posts = user.getPosts();
				for (Post post : posts) {
					if (post.getPid() == pid) {
						posts.remove(post);
					}
				}
			}
			postDao.delete(findPostById);
		} catch (Exception e) {
			new PostException("删除出错！！",e);
		}
	}

	@Override
	public void savePost(Post post) throws PostException {
		try {
			postDao.save(post);			
		} catch (Exception e) {
			new PostException("保存出错", e);
		}
	}

	@Override
	public Post findPostById(Long pid) throws PostException {
		try {
			return postDao.get(pid);			
		} catch (Exception e) {
			new PostException("通过"+pid+"获取对象失败",e);
		}
		return new Post();
	}

	@Override
	public void updatePostByObject(Post post) throws PostException {
		try {
			
		   Post findPostById = findPostById(post.getPid());
		   BeanUtils.copyProperties(post, findPostById);
		   postDao.update(findPostById);
			
		} catch (Exception e) {
			new PostException("更新失败", e);
		}
	}

	@Override
	public HashSet<Post> findPostSetByIds(Long[] pids) throws PostException {
		
		String hql = "from Post p where p.id in("+OAServiceUtils.arrayToStr(pids)+")";
		List<Post> findListByHql = postDao.findListByHql(hql);
		return new HashSet<Post>(findListByHql);
	}

}
