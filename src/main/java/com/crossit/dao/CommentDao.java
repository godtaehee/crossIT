package com.crossit.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.crossit.domain.CommentDTO;

@Mapper
public interface CommentDao {

	public int insertComment(CommentDTO params);

	public CommentDTO selectCommentDetail(Long id);

	public int updateComment(CommentDTO params);

	public int deleteComment(Long id);

	public List<CommentDTO> selectCommentList(CommentDTO params);

	public int selectCommentTotalCount(CommentDTO params);

}