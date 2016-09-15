import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class SquadTest{
  @After
  public void tearDown() {
    Squad.clear();
  }

  @Test
  public void instanciation_testForInstanceBuild() {
    Squad testObj = new Squad("KOTOR");
    assertTrue(testObj instanceof Squad);
  }

  @Test
  public void getName_returnNameOfSquad_String() {
    Squad testObj = new Squad("KOTOR");
    assertEquals("KOTOR", testObj.getName());
  }

  @Test
  public void getAttack_returnsAttackScoreOfSquad_int() {
    Squad testObj = new Squad("KOTOR");
    assertEquals(0, testObj.getAttack());
    Hero revan = new Hero("revan", 12,12,12);
    testObj.addHero(revan);
    assertEquals(12, testObj.getAttack());
  }

  @Test
  public void getDefense_returnsDefenseScoreOfSquad_int() {
    Squad testObj = new Squad("KOTOR");
    assertEquals(0, testObj.getDefense());
    Hero revan = new Hero("revan", 12,12,12);
    testObj.addHero(revan);
    assertEquals(12, testObj.getDefense());
  }

  @Test
  public void getPersonality_returnsPersonalityScoreOfSquad_int() {
    Squad testObj = new Squad("KOTOR");
    assertEquals(0, testObj.getPersonality());
    Hero revan = new Hero("revan", 12,12,12);
    testObj.addHero(revan);
    assertEquals(12, testObj.getPersonality());
  }

  @Test
  public void getId_returnsIdOfSquad_int() {
    Squad testObj = new Squad("KOTOR");
    assertEquals(1, testObj.getId());
  }

  @Test
  public void all_returnsAllSquadInstances_List() {
    Squad testObj = new Squad("KOTOR");
    Squad testObj2 = new Squad("KOTOR");
    assertEquals(testObj, Squad.all().get(0));
    assertTrue(Squad.all().contains(testObj2));
  }

  @Test
  public void find_returnsSquadInstancesById_Squad() {
    Squad testObj = new Squad("KOTOR");
    Squad testObj2 = new Squad("KOTOR");
    assertEquals(testObj, Squad.find(testObj.getId()));
    assertEquals(testObj2, Squad.find(2));
  }

  @Test
  public void findHero_addsHeroObjectToSquad_boolean() {
    Squad testObj = new Squad("KOTOR");
    Hero revan = new Hero("revan", 12,12,12);
    Hero bastilla = new Hero("bastilla", 12,12,12);
    testObj.addHero(revan);
    testObj.addHero(bastilla);
    assertEquals("getAttack test", 24, testObj.getAttack());
    assertEquals("findHero test1", revan, testObj.findHero(1));
    assertEquals("findHero test2", bastilla.getAttack(), testObj.findHero(bastilla.getId()).getAttack());
  }

}
