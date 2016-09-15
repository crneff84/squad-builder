import java.util.List;
import java.util.ArrayList;

public class Hero {
  private String mName;
  private int mAttack;
  private int mDefense;
  private int mPersonality;
  private int mHealth = 12;
  private int mId;
  private static List<Hero> instances = new ArrayList<Hero>();

  public Hero(String _name, int _attack, int _defense, int _personality) {
    mName = _name;
    mAttack = _attack;
    mDefense = _defense;
    mPersonality = _personality;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public int getAttack() {
    return mAttack;
  }

  public int getDefense() {
    return mDefense;
  }

  public int getPersonality() {
    return mPersonality;
  }

  public int getId() {
    return mId;
  }

  public int getHealth() {
    return mHealth;
  }

  public void setHealth(int _healthChange) {
    mHealth += _healthChange;
  }

  public static List<Hero> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Hero find(int _id) {
    return instances.get(_id - 1);
  }

}
