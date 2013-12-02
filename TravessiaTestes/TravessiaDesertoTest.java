package com.senac.trabalhoTest;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TravessiaDesertoTest {
	
	TravessiaDeserto jogoTD;

@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		jogoTD = new TravessiaDeserto();
	}

// INICIALIZACAO DO JOGO
	@Before
	public void setUpinitGame() {
	}
	@Test
	public void testInitGame() {
		jogoTD.initGame();
		assertTrue(jogoTD.getPos()==0);
		assertTrue(jogoTD.getFuel()==6);
		assertEquals(jogoTD.getPos(), 0);

	}
	@After
	public void tearDownInitGame() {
		jogoTD = null;
	}
// ***************************************************************************************************
//TESTE DO METODO [AVANCAR]
	
	@Before
	public void setUpAvancar() {
	}
	@Test
	public void testAvancar() {
		jogoTD.initGame();
		
		assertTrue(jogoTD.getFuel()>0);
		int pos = jogoTD.getPos();
		int fuel = jogoTD.getFuel(); 
		
        //NAO PODE AVANCAR
		if (fuel<1) {  				
			jogoTD.avancar();
			assertEquals(pos, jogoTD.getPos());
			assertEquals(fuel, jogoTD.getFuel());
		}
		//NAO PODE AVANCAR
		else if (pos>9) {			
			jogoTD.avancar();
			assertEquals(pos, jogoTD.getPos());
			assertEquals(fuel, jogoTD.getFuel());
		}	
		//AVANCA NORMAL
		else {						
			jogoTD.avancar();
			assertEquals(pos + 1, jogoTD.getPos());
			assertEquals(fuel - 1, jogoTD.getFuel());
		}

	}
	
	@After
	public void tearDownAvancar() {
		jogoTD = null;
	}
// ***************************************************************************************************
//TESTE DO METODO [VOLTAR]

	@Before
	public void setUpVoltar() {
	}
	@Test
	public void testVoltar() {
		jogoTD.initGame();
		jogoTD.avancar();

		assertTrue(jogoTD.getFuel()>0);
		assertTrue(jogoTD.getPos()>0);
		int pos = jogoTD.getPos();

			jogoTD.voltar();
			assertEquals(jogoTD.getPos(), pos-1);
	}
	@After
	public void tearDownVoltar(){
		jogoTD = null;
	}
	
// *************************************************************************************************** 
// TESTE DO METODO [CARREGAR]
	@Before
	public void setUpCarregar() {
		jogoTD = new TravessiaDeserto();
	}
	@Test
	public void testCarregar() {
		jogoTD.initGame();
		jogoTD.avancar();

		assertTrue(jogoTD.getPos() > 0);
		assertTrue(jogoTD.getFuel() > 0);
		jogoTD.carregar();
		}
	@After
	public void tearDownCarregar() {
		jogoTD = null;
	}


// *************************************************************************************************** 
// TESTE DO METODO [DESCARREGAR]

	@Before
	public void setUpDescarregar() {
		jogoTD = new TravessiaDeserto();
	}

	@Test
	public void testDescarregar() {
		jogoTD.initGame();
		jogoTD.avancar();
		
		 assertTrue(jogoTD.getPos() > 0);
		 assertTrue(jogoTD.getFuel() > 0);
		 jogoTD.getFuel();
		 jogoTD.descarregar();
		}
	@After
	public void tearDownDescarregar() {
		jogoTD = null;
	}


	
// *************************************************************************************************** 
// TESTE DO METODO [IS GAME OVER]

	@Before
	public void setUpisGameOver() {

	}
	@Test
	public void testIsGameOver() {
		jogoTD.initGame();
		jogoTD.avancar();

		int[] base = jogoTD.getMap();
		equals(jogoTD.getFuel() == 0);
		assertEquals(base[jogoTD.getPos()], 0);

	}
	@After
	public void tearDownisGameOver() {
		jogoTD = null;
	}	
	
// *************************************************************************************************** 
// TESTE DO METODO [IS WINNER]

	@Before
	public void setUpisWinner() {
	}
	@Test
	public void testIsWinner() {
		jogoTD.initGame();
    	jogoTD.isGameOver();
    	
			if (jogoTD.getPos()==10)
			assertEquals(jogoTD.isWinner(), true);
			else   assertEquals(jogoTD.isWinner(),false);
	}
	@After
	public void tearDownisWinner() {
		jogoTD = null;
	}	
	
// *************************************************************************************************** 
// METODOS DA SOLUÇÃO

   public void doubleMove(){
	   jogoTD.avancar();
	   jogoTD.avancar();
	   jogoTD.descarregar();
	   jogoTD.descarregar();
	   jogoTD.voltar();
	   jogoTD.voltar();
   }
   public void doubleMove2(){
	   jogoTD.avancar();
	   jogoTD.avancar();
	   jogoTD.carregar();
	   jogoTD.carregar();
   }
   public void loop(){
	   for (int i=0; i<7;i++)
		   jogoTD.carregar();
   }
   public void loop2(){
	   for (int i=0; i<7;i++)
		   jogoTD.avancar();
   }

 // SOLUÇÃO [GANHAR JOGO]
   
   public void ganharJogo(){
	      doubleMove();
	      doubleMove();
	      doubleMove();
	      doubleMove();
		  doubleMove2();
		  doubleMove();
	      loop();
          doubleMove2();
	      loop2();

   }
   
}


