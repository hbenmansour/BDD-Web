package fr.xebia.training.jbehave.part5.finished;

import java.util.List;

import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.web.runner.wicket.WebRunnerApplication;

public class GameOfLifeWebRunner extends WebRunnerApplication {

	@Override
	protected List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), new P5FTestBoardStep()).createCandidateSteps();
	}
	
}
