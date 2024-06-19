package model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Cocktail
{
    @SerializedName("strDrink")
    private String name;
    @SerializedName("idDrink")
    private int cocktailID;
    @SerializedName("strDrinkThumb")
    private String imageUrl;

    public Cocktail(String name, int cocktailID, String imageUrl) {
        this.name = name;
        this.cocktailID = cocktailID;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCocktailID() {
        return cocktailID;
    }

    public void setCocktailID(int cocktailID) {
        this.cocktailID = cocktailID;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "name='" + name + '\'' +
                ", cocktailID=" + cocktailID +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cocktail cocktail = (Cocktail) o;
        return cocktailID == cocktail.cocktailID && Objects.equals(name, cocktail.name) && Objects.equals(imageUrl, cocktail.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cocktailID, imageUrl);
    }
}
