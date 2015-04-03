public class Troll extends Enemy {

  public Troll() {
    setName("Troll");
    setHealth(100);
    setWeapon(0); // Wooden Club
  }
  @Override public void fight(Knight opp) {
    int damage = opp.getWeaponDamage();

    try {
      takeDamage(damage);
    }
    catch(InvalidDamageException e) {
      setHealth(0);
    }

    System.out.printf("%s attacks the %s with %d damage. The %s's health is now %d\n", opp.getName(), getName(), damage, getName(), getHealth());
  }

  @Override public String toString() {
    return "a Giant " + getName();
  }
}
