import java.util.List;
import java.util.ArrayList;

public class Squad {
  private String mSquadName;
  private int mSquadAttack;
  private int mSquadDefense;
  private int mSquadPersonality;
  private int mId;
  private int mHeroCount;
  private Hero[] mHeroList;
  private static List<Squad> instances = new ArrayList<Squad>();

  public Squad (String squadName){
    mSquadName = squadName;
    mHeroCount = 0;
    instances.add(this);
    mId = instances.size();
    mHeroList = new Hero[3];
    for (int i = 0; i < 3; i++) {
      mHeroList[i] = new Hero("", 0, 0, 0);
    }
  }

  public String getName() {
    return mSquadName;
  }

  public int getAttack() {
    return mSquadAttack;
  }

  public int getDefense() {
    return mSquadDefense;
  }

  public int getPersonality() {
    return mSquadPersonality;
  }

  public int getId() {
    return mId;
  }

  public Hero[] getHeroes() {
    return mHeroList;
  }

  public int getHeroCount() {
    return mHeroCount;
  }

  public boolean addHero(Hero _hero) {
    if (mHeroCount < 3 && _hero.getName() != "") {
      mHeroList[mHeroCount] = _hero;
      mHeroCount++;
      mSquadAttack += _hero.getAttack();
      mSquadDefense += _hero.getDefense();
      mSquadPersonality += _hero.getPersonality();
      return true;
    } else {
      return false;
    }
  }

  public Hero findHero(int _heroIndex) {
    try {
      return mHeroList[_heroIndex-1];
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public static List<Squad> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Squad find(int _id) {
    return instances.get(_id - 1);
  }

}
