package vn.com.itqnu.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

	Competition findByCompetitionName(String competitionName);
}
