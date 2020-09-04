package vn.com.itqnu.onlinetest.service;

import java.util.List;

import vn.com.itqnu.onlinetest.entity.Competition;
import vn.com.itqnu.onlinetest.model.CompetitionModel;

public interface CompetitionService {

	Competition createCompetition(CompetitionModel competitionModel);

	List<Competition> getAllCompetition();

	Competition getCompetitionById(Long idCompetition);

	Competition updateCompetition(CompetitionModel competitionModel);

	void deleteCompetition(Long idCompetition);
}
