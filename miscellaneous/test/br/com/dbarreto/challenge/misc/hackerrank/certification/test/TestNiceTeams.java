package br.com.dbarreto.challenge.misc.hackerrank.certification.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.hackerrank.certification.NiceTeams;

public class TestNiceTeams {
	
	private NiceTeams problem = new NiceTeams();

	@Test
	public void testCase001() {
		assertEquals(0, problem.maxTeams(Arrays.asList(1,1,1,1), 1));
	}
	
	@Test
	public void testCase002() {
		assertEquals(2, problem.maxTeams(Arrays.asList(3,4,5,2,1,1), 3));
	}
	
	@Test
	public void testCase003() {
		assertEquals(0, problem.maxTeams(Arrays.asList(76747402,403380408,801605449,417846906,274385224,738031431,21677517,54770001,396389085,410040373,66487560,557886252,273596334,364059083), 866259468));
	}
	
	@Test
	public void testCase004() {
		assertEquals(5, problem.maxTeams(Arrays.asList(25107191,123232501,151290765,183012194,473251358,579542802,689345248,709552565,803612259,862726097,994391793), 440987423));
	}
	
	@Test
	public void testCase005() {
		assertEquals(8, problem.maxTeams(Arrays.asList(58938146,219080001,290589043,306989605,318554335,345194195,376420327,509674780,802573599,939226418), 22586934));
	}
	
	@Test
	public void testCase006() {
		assertEquals(5, problem.maxTeams(Arrays.asList(709552565, 473251358, 803612259, 579542802, 183012194, 689345248, 151290765, 123232501, 994391793, 25107191, 862726097), 440987423));
	}
}
