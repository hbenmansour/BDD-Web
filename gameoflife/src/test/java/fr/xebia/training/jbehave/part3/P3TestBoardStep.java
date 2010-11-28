package fr.xebia.training.jbehave.part3;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import fr.xebia.training.tdd.gameoflife.Board;
import fr.xebia.training.tdd.gameoflife.Coordinate;
import fr.xebia.training.tdd.gameoflife.Universe;

public class P3TestBoardStep {

	private Universe board;
	private int size;
	private Set<Coordinate> initialStates = new HashSet<Coordinate>();
	
	
	@Given("an empty board of size $size") 
	public void givenAGame(int size) {
		this.size = size;
	}
	
	@Given("with a living cell at position $x:$y")
	public void givenACellAtPosition(int x, int y) {
		initialStates.add(new Coordinate(x, y));
	}
	
	
	// FIXME : ajouter une annotation @Given utilisant une classe ExamplesTable
	public void givenInitialPositionTable(ExamplesTable table) {
		// FIXME : ins�rer les initial states en bouclant sur la table d'example
		List<Map<String,String>> rows = table.getRows();
	}
	
	
	
	@When("we play the first round")
	public void whenPlayARound() {
		this.board = new Board(this.size,  getInitialStatesAsArray() );
		board.update();
	}
	
	@Then("no cell is alive")
	public void thenNoCellIsAlive() {
		Assert.assertEquals(0, board.liveCellsCount());
	}
	
	// FIXME : annoter la m�thode avec @Then
	// FIXME : annoter la m�thode avec @Alias pour faire marcher toute les stories
	public void thenThereIsCellsAlive(int nbOfAliveCells) {
		// FIXME : ajouter l'assertion sur le nombre de cellules vivantes
	}

	
	private Coordinate[] getInitialStatesAsArray() {
		Coordinate[] coordinates = new Coordinate[initialStates.size()];
		int i = 0;
		for (Coordinate aCoordinate : initialStates) {
			coordinates[i++] = aCoordinate;
		}
		return coordinates;
	}
	
	// FIXME : annoter la m�thode avec @BeforeStory et r�initialiser le initial state
	public void beforeStory() {
	}

	
}
