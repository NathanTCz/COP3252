/*
,^.
|||
|||       _T_
|||      [---]
|||   .-.|:|:|.-.
===_ /\|  "'"  |/
 E]_|\/ \--|-|''''|
 O  `'  '=[:]| N  |
        /""""|  C |
       /"""""`.__.'
      []"/"""\"[]
      | \     / |
      | |     | |
    <\\\)     (///>
*/

import java.util.Random;

public class Knight {
  private Random rand = new Random();
  private String weapons[] = {"Long Sword",
                              "Battle Axe",
                              "Spear",
                              "Warhammer"};
  private int weaponDamage[] = {new Random().nextInt(10)+60,  // add back the
                                new Random().nextInt(10)+70,  // minimum damage
                                new Random().nextInt(10)+80,  // so the range is
                                new Random().nextInt(10)+90}; // [60, 70)
  private String armors[] = {"Leather",
                              "Chain Maille"};
  /*the indices of this array match the indices
   * armors (1st dimen.) and then weapons (2nd dimen.)*/
  private int armorCounterDamage[][] = {
    {10, 10, 15, 5},
    {30, 30, 20, 25}
  };
  private String[] names = {"Bob", "Jim", "Joe"};

  private String name;
  private int health;
  private int weapon;
  private int armor;

  public Knight() {
    Random rand = new Random();

    setName( names[rand.nextInt(3)] );
    setHealth(rand.nextInt(100) + 400); // range [400, 500)
    setWeapon( rand.nextInt(4) );
    setArmor( rand.nextInt(2) );
  }

  public Knight(String nm, int w, int a) {
    setName(nm);
    setHealth(rand.nextInt(100) + 400); // range [400, 500)
    setWeapon(w - 1);
    setArmor(a - 1);
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

  public String getArmor() {
    return armors[armor];
  }

  public int getArmorAsInt() {
    return armor;
  }

  public int setArmor(int a) {
    return armor = a;
  }

  public void fight (Knight opp) {
    int damage = opp.getWeaponDamage()
      - armorCounterDamage[ getArmorAsInt() ][ opp.getWeaponAsInt() ];

    int newHealth = getHealth() - damage;
    setHealth(newHealth);

    System.out.printf("%s attacks %s with %d damage. %s's health is now %d\n", opp.getName(), getName(), damage, getName(), newHealth);
  }

  public String toString() {
    return ",^.\n"
    + "|||       _T_            Name:            " + getName() + "\n"
    + "|||      [---]           Health:          " + getHealth() + "\n"
    + "|||   .-.|:|:|.-.        Weapon:          " + getWeapon() + "\n"
    + "===_ /\\|  \"\'\"  |/\\       Armor:           " + getArmor() + "\n"
    + " E]_|\\/ \\--|-|\'\'\'\'|\n"
    + " O  `\'  \'=[:]| N  |\n"
    + "        /\"\"\"\"|  C |\n"
    + "       /\"\"\"\"\"`.__.\'\n"
    + "      []\"/\"\"\"\\\"[]\n"
    + "      | \\     / |\n"
    + "      | |     | |\n"
    + "    <\\\\\\)     (///>\n";

  }
}
