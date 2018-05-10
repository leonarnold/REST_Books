package de.gbsschulen.rest.country;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.xml.bind.annotation.XmlRootElement;
        import java.util.Objects;

@XmlRootElement
@Entity
public class CountryLanguage {

    @Id
    private String countryCode, language;
    private String isOfficial ;
    private float percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(String countryCode, String language, String isOfficial, float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguage that = (CountryLanguage) o;
        return Float.compare(that.percentage, percentage) == 0 &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(language, that.language) &&
                Objects.equals(isOfficial, that.isOfficial);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryCode, language, isOfficial, percentage);
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "countryCode='" + countryCode + '\'' +
                ", language='" + language + '\'' +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}