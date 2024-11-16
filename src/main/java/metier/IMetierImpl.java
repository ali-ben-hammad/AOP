package metier;

import java.util.HashMap;
import java.util.Map;

public class IMetierImpl implements IMetier {
    private Map<Long, Compte> comptes = new HashMap<>();

    @Override
    public void addCompte(Compte c) {
        comptes.put(c.getCode(), c);
    }

    @Override
    public void deposit(Long code, double amount) {
        Compte cp = comptes.get(code);
        cp.setSolde(cp.getSolde() + amount);
    }

    @Override
    public void withdraw(Long code, double amount) {
        Compte cp = comptes.get(code);
        cp.setSolde(cp.getSolde() - amount);
    }

    @Override
    public Compte getCompte(Long code) {
        Compte cp = comptes.get(code);
        if (cp == null) {
            throw new RuntimeException("Compte introuvable");
        }
        return cp;
    }
}
