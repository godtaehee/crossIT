package com.crossit.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.crossit.domain.FileDTO;

@Mapper
public interface FileDao {

	public int insertAttach(List<FileDTO> attachList);

	public FileDTO selectAttachDetail(Long id);

	public int deleteAttach(Long boardId);

	public List<FileDTO> selectAttachList(Long boardId);

	public int selectAttachTotalCount(Long boardId);

	public int undeleteAttach(List<Long> idxs);
}
