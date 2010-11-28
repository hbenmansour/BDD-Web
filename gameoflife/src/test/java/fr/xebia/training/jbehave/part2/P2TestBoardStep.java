package fr.xebia.training.jbehave.part2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import fr.xebia.training.tdd.gameoflife.Board;
import fr.xebia.training.tdd.gameoflife.Coordinate;
import fr.xebia.training.tdd.gameoflife.Universe;

public class P2TestBoardStep {

	private Universe board;
	private int size;
	// Notez que les initial states ont �t� refactor�s pour en faire un field
	// La board est maintenant cr��e lorsque l'on joue le premier round
	private Set<Coordinate> initialStates = new HashSet<Coordinate>();
	
	
	@Given("an empty board of size $size") 
	public void givenAGame(int size) {
		this.size = size;
	}
	
	// FIXME : annoter la m�thode pour en faire un step de type Given
	public void givenACellAtPosition(int x, int y) {
		// FIXME : impl�menter la m�thode pour ajouter une coordonn�e dans les �tats initiaux
	}
	
	
	@When("we play a round")
	public void whenPlayARound() {
		this.board = new Board(this.size,  getInitialStatesAsArray() );
		board.update();
	}
	
	@Then("no cell is alive")
	public void thenNoCellIsAlive() {
		Assert.assertEquals(0, board.liveCellsCount());
	}
	
	private Coordinate[] getInitialStatesAsArray() {
		Coordinate[] coordinates = new Coordinate[initialStates.size()];
		int i = 0;
		for (Coordinate aCoordinate : initialStates) {
			coordinates[i++] = aCoordinate;
		}
		return coordinates;
	}
	
}
