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

public class Knight {
  private String name;
  private int health;
  private int numBattles;
  private int age;
  private int gold;

  public Knight(String nm, int h, int nb, int a, int g) {
    set_name(nm);
    set_health(h);
    set_numBat(nb);
    set_age(a);
    set_gold(g);
  }

  public void set_name(String n) {
    name = n;
  }

  public String get_name() {
    return name;
  }

  public void set_health(int h) {
    health = h;
  }

  public int get_health() {
    return health;
  }

  public void set_numBat(int nb) {
    numBattles = nb;
  }

  public int get_numBat() {
    return numBattles;
  }

  public void set_age(int a) {
    age = a;
  }

  public int get_age() {
    return age;
  }

  public void set_gold(int g) {
    gold = g;
  }

  public int get_gold() {
    return gold;
  }

  public void printDetails() {
    System.out.printf(",^.\n");
    System.out.printf("|||       _T_            Name:                   %s\n", name);
    System.out.printf("|||      [---]           Health:                 %s\n", health);
    System.out.printf("|||   .-.|:|:|.-.        Number of Battles:      %s\n", numBattles);
    System.out.printf("===_ /\\|  \"\'\"  |/\\       Age:                    %s\n", age);
    System.out.printf(" E]_|\\/ \\--|-|\'\'\'\'|      Gold:                   %s\n", gold);
    System.out.printf(" O  `\'  \'=[:]| N  |      Average Gold Accum.:    %s\n", gold/numBattles);
    System.out.printf("        /\"\"\"\"|  C |\n");
    System.out.printf("       /\"\"\"\"\"`.__.\'\n");
    System.out.printf("      []\"/\"\"\"\\\"[]\n");
    System.out.printf("      | \\     / |\n");
    System.out.printf("      | |     | |\n");
    System.out.printf("    <\\\\\\)     (///>\n");

  }
}
