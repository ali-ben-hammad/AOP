package metier;

public interface IMetier {

    void addCompte(Compte c);
    void deposit(Long code, double amount);
    void withdraw(Long code, double amount);
    Compte getCompte(Long code);

}
