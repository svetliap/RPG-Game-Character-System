import java.util.*;

public class Main{
  public static class Character{
    private String name;
    private int health;
    private int mana;
    private int level;

    public Character(String u,int v,int p,int t){
      this.name=u;
      this.health=v;
      this.mana=p;
      this.level=t;
    }

    public void attack(Character receiver){
      System.out.printf("%s attacks %s\n",getName(),receiver.getName());
      receiver.lessLevel();
    }

    public void lessLevel(){
      this.level--;
    }

    public void defend(){
      System.out.printf("%s defends.\n",getName());
    }

    public void castSpell(Character receiver){
      System.out.printf("%s casts a spell on %s\n",getName(),receiver.getName());
      receiver.lessMana();
    }

    public void lessMana(){
      this.mana-=10;
    }

    public void levelUp(){
      this.level++;
      System.out.printf("%s levels up to level %d\n",getName(),this.level);
    }

    public String getName(){
      return this.name;
    }

    public void receiveDamage(int damage){
      this.health-=damage;
      if(this.health<0)this.health=0;
    }

    public int getHealth(){
      return this.health;
    }
  }

  public static class Warrior extends Character{
    private int strength;
    private int armor;

    public Warrior(String u,int v,int p,int t,int s,int a){
      super(u,v,p,t);
      this.strength=s;
      this.armor=a;
    }

    public void physicalAttack(Character receiver){
      System.out.printf("%s performs a physical attack on %s\n",getName(),receiver.getName());
      receiver.receiveDamage(15);
    }
  }

  public static class Mage extends Character{
    private int intelligence;
    private int spellPower;

    public Mage(String u,int v,int p,int t,int i,int sp){
      super(u,v,p,t);
      this.intelligence=i;
      this.spellPower=sp;
    }

    public void magicAttack(Character receiver){
      System.out.printf("%s performs a magic attack on %s\n",getName(),receiver.getName());
      receiver.receiveDamage(20);
    }
  }

  public static class Rogue extends Character{
    private int agility;
    private int dexterity;

    public Rogue(String u,int v,int p,int t,int ag,int d){
      super(u,v,p,t);
      this.agility=ag;
      this.dexterity=d;
    }

    public void stealthAttack(Character receiver){
      System.out.printf("%s performs a stealth attack on %s\n",getName(),receiver.getName());
      receiver.receiveDamage(25);
    }
  }

  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);

    Warrior warrior=new Warrior("Thor",100,50,1,10,5);
    Mage mage=new Mage("Merlin",80,100,1,8,15);
    Rogue rogue=new Rogue("Shadow",70,60,1,12,7);

    System.out.printf("Battle starts!\n");
    System.out.printf("Enter command (1 for Mage to cast spell on Warrior, 2 for Warrior to attack Rogue):\n");

    int command=scanner.nextInt();
    switch(command){
      case 1:
        mage.castSpell(warrior);
        break;
      case 2:
        warrior.physicalAttack(rogue);
        break;
      default:
        System.out.printf("Invalid command.\n");
    }

    System.out.printf("Enter command (3 for Rogue to stealth attack Mage, 4 for all to defend):\n");
    command=scanner.nextInt();
    switch(command){
      case 3:
        rogue.stealthAttack(mage);
        break;
      case 4:
        warrior.defend();
        mage.defend();
        rogue.defend();
        break;
      default:
        System.out.printf("Invalid command.\n");
    }
  }
}
