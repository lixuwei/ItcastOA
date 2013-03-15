package com.lee.study.itcastoa.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lee.study.itcastoa.domain.Post;
import com.lee.study.itcastoa.domain.User;
import com.lee.study.itcastoa.exception.PostException;

public interface PostService {

	List<Post> showAllPost() throws PostException;

	void deletePost(Long pid) throws PostException;

	void savePost(Post post) throws PostException;

	Post findPostById(Long pid) throws PostException;

	void updatePostByObject(Post post) throws PostException;

	HashSet<Post> findPostSetByIds(Long[] pids) throws PostException;


}
