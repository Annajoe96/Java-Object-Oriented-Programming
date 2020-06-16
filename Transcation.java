import java.util.*;

class Account  {
  int balance = 0;
  String pin;
  int tries = 0;

  public Account(int balance, String p){
    this.balance = balance;
    this.pin = p;
  }
  
  //method to check the number of tries used to enter correct pin

  public boolean checkValidity(String code){
    if(tries >= 3){
      System.out.println("Account is locked");
      return false;
    }

    if(code.equals(pin)) {
      tries = 0;
    } else {
      tries++;
      System.out.println("invalid pin");
      return false;
    }

    return true;
  }

  // deposit money 
  public int deposit(int new_money, String p) {
    if(!checkValidity(p)) return 0;

    this.balance += new_money;
    return balance;
  }
  
  // get balance in account
  public int getBalance(String p){
    if(!checkValidity(p)) return 0;
    return balance;
  }
  
  // withdrawing money form account
  public int withdraw(int amount, String p){
    if(!checkValidity(p)) return 0;

    if(amount > this.balance + 100){
      System.out.println("not enough balance");
      return this.balance;
    } else {
      this.balance -= amount;
      return balance;
    }
  }

}

class Savings extends Account {
    public Savings(int balance, String p) {
      super(balance, p);
    }

    public int withdraw(int amount, String p){
      System.out.println("This is a saving account you cant withdraw");
      return -1;
    }
}

class Current extends Account {

  public Current(int balance, String p) {
    super(balance, p);
  }

}

class Transaction{

  public static void main(String[] args){

    Current anna = new Current(7500,"567");
    Current daniel = new Current(10000,"734");
    Savings john = new Savings(5000,"7656");

    daniel.deposit(3000,"sajsb");
    daniel.deposit(3000,"bb");
    daniel.deposit(200,"sajsb");
    john.withdraw(100,"sajsb");
  }

}
