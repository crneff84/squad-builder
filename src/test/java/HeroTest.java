import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class HeroTest{

  @After
  public void teardown() {
    Hero.clear();
  }

  @Test
  public void instanciation_testForInstanceBuild() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    assertTrue(testObj instanceof Hero);
  }

  @Test
  public void getName_testHeroForGettingName_String() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    assertEquals("Revan", testObj.getName());
  }

  @Test
  public void getAttack_testHeroForGettingAttack_int() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    assertEquals(12, testObj.getAttack());
  }

  @Test
  public void getDefense_testHeroForGettingDefense_int() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    assertEquals(12, testObj.getDefense());
  }

  @Test
  public void getPersonality_testHeroForGettingPersonality_int() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    assertEquals(12, testObj.getPersonality());
  }

  @Test
  public void getId_testHeroForGettingId_int() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    assertEquals(1, testObj.getId());
  }

  @Test
  public void all_testHeroForReturningInstances_List() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    Hero testObj2 = new Hero("Bastilla", 12, 12, 12);
    assertTrue(Hero.all().contains(testObj));
    assertTrue(Hero.all().contains(testObj2));
  }

  @Test
  public void find_testHeroForFindingInstancesById_Hero() {
    Hero testObj = new Hero("Revan", 12, 12, 12);
    Hero testObj2 = new Hero("Revan", 12, 12, 12);
    assertEquals(testObj, Hero.find(1));
  }
}
