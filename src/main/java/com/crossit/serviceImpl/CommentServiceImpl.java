package com.crossit.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossit.dao.CommentDao;
import com.crossit.domain.CommentDTO;
import com.crossit.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentMapper;

	@Override
	public boolean registerComment(CommentDTO params) {
		int queryResult = 0;

		if (params.getId() == null) {
			queryResult = commentMapper.insertComment(params);
		} else {
			queryResult = commentMapper.updateComment(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean deleteComment(Long id) {
		int queryResult = 0;

		CommentDTO comment = commentMapper.selectCommentDetail(id);

		if (comment != null && "N".equals(comment.getDeleteYn())) {
			queryResult = commentMapper.deleteComment(id);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<CommentDTO> getCommentList(CommentDTO params) {
		List<CommentDTO> commentList = Collections.emptyList();

		int commentTotalCount = commentMapper.selectCommentTotalCount(params);
		if (commentTotalCount > 0) {
			commentList = commentMapper.selectCommentList(params);
		}

		return commentList;
	}

}