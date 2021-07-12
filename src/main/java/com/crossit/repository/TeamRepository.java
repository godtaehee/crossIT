package com.crossit.repository;

import com.crossit.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TeamRepository extends JpaRepository<Team, Long> {

//	boolean existsByEmail(String email);
//
//	boolean existsByNickname(String nickname);
//
//	Team findByEmail(String email);
//
//	Team findByNickname(String nickname);

}
