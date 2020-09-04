package vn.com.itqnu.onlinetest.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Competition;
import vn.com.itqnu.onlinetest.model.CompetitionModel;
import vn.com.itqnu.onlinetest.repository.CompetitionRepository;
import vn.com.itqnu.onlinetest.service.CompetitionService;

@Service
public class CompetitionServiceImpl implements CompetitionService {

	private CompetitionRepository competitionRepository;

	public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
		this.competitionRepository = competitionRepository;
	}

	@Override
	public Competition createCompetition(CompetitionModel competitionModel) {
		if (competitionModel.getCompetitionName() == null
				|| competitionModel.getCompetitionName().trim().length() == 0) {
			throw new RuntimeException("Competition name is required!");
		}
		Competition competition = new Competition();
		competition.setCompetitionName(competitionModel.getCompetitionName());
		competition.setDetail(competitionModel.getDetail());
		competition.setTimeStart(competitionModel.getTimeStart());
		competition.setTimeEnd(competitionModel.getTimeEnd());

		competition.setCreatedBy("ADMIN");
		competition.setCreatedDate(new Date());
		competition.setModifiedBy("ADMIN");
		competition.setModifiedDate(new Date());

		competitionRepository.save(competition);

		return competition;
	}

	@Override
	public List<Competition> getAllCompetition() {
		return competitionRepository.findAll();
	}

	@Override
	public Competition getCompetitionById(Long idCompetition) {
		Optional<Competition> optional = competitionRepository.findById(idCompetition);
		if (optional != null && optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Competition updateCompetition(CompetitionModel competitionModel) {
		Competition competition = getCompetitionById(competitionModel.getId());
		if (competition == null) {
			throw new RuntimeException("Competition does not exits!");
		}
		competition.setCompetitionName(competitionModel.getCompetitionName());
		competition.setDetail(competitionModel.getDetail());
		competition.setTimeStart(competitionModel.getTimeStart());
		competition.setTimeEnd(competitionModel.getTimeEnd());

		competition.setModifiedBy("ADMIN");
		competition.setModifiedDate(new Date());

		competitionRepository.save(competition);

		return competition;
	}

	@Override
	public void deleteCompetition(Long idCompetition) {
		Competition competition = getCompetitionById(idCompetition);

		if (competition == null) {
			throw new RuntimeException("Competition does not exits!");
		}
		competitionRepository.delete(competition);

	}

}
