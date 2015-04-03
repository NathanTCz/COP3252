import java.util.*;

public abstract class Enemy {
  // Fields
  private String weapons[] = {"Wooden Club",
                              "Long Sword",
                              "Battle Axe",
                              "Spear",
                              "Warhammer",
                              "Magic Staff"};
  private int weaponDamage[] = {new Random().nextInt(10)+50,  // add back the
                                new Random().nextInt(10)+60,  // minimum damage
                                new Random().nextInt(10)+70,  // minimum damage
                                new Random().nextInt(10)+80,  // so the range is
                                new Random().nextInt(10)+90, // [90, 100)
                                new Random().nextInt(10)+90}; // [90, 100)

  private String name;
  private int health;
  private int weapon;

  // NonAbstract Methods
  public void takeDamage(int d) throws InvalidDamageException {
    int newHealth = getHealth() - d;

    if (newHealth < 0)
      throw new InvalidDamageException();
    else
      setHealth(newHealth);
  }

  public static Enemy getRandomEnemy() {
    int randEnemy = new Random().nextInt(3);

    Enemy enemies[] = {new Ogre(),
                       new Sorcerer(),
                       new Troll()};

    return enemies[ randEnemy ];
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public void setHealth(int h) {
    health = h;
  }

  public int getHealth() {
    return health;
  }

  public void setWeapon(int w) {
    weapon = w;
  }

  public String getWeapon() {
    return weapons[weapon];
  }

  public int getWeaponAsInt() {
    return weapon;
  }

  public int getWeaponDamage() {
    return weaponDamage[weapon];
  }



  // Abstract Methods
  abstract public void fight(Knight opp);
}
