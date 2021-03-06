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
  public String name;
  public int health;
  public int numBattles;
  public int age;
  public int gold;

  public Knight(String nm, int h, int nb, int a, int g) {
    name = nm;
    health = h;
    numBattles = nb;
    age = a;
    gold = g;
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
