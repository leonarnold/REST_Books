package de.gbsschulen.rest.country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CountryLanguageService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public CountryLanguageService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("countrylanguages");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public CountryLanguage getCityLanguage(String id, String sprache){
        TypedQuery<CountryLanguage> typedQuery = entityManager.createQuery("Select b from CountryLanguage b where b.countryCode = '"+id+"' and b.language = '"+ sprache +"'", CountryLanguage.class);
        return typedQuery.getSingleResult();
    }
}