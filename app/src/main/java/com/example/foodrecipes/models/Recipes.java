package com.example.foodrecipes.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.foodrecipes.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Recipes implements Serializable, Parcelable {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("ingredients")
    @Expose
    private String[] ingredients;

    @SerializedName("recipe_id")
    @Expose
    private String recipe_id;

    @SerializedName("image_url")
    @Expose
    private String image_url;

    @SerializedName("social_rank")
    @Expose
    private float social_rank;


    public Recipes() {
    }

    public Recipes(String title, String publisher, String[] ingredients, String recipe_id, String image_url, float social_rank) {
        this.title = title;
        this.publisher = publisher;
        this.ingredients = ingredients;
        this.recipe_id = recipe_id;
        this.image_url = image_url;
        this.social_rank = social_rank;
    }

    protected Recipes(Parcel in) {
        title = in.readString();
        publisher = in.readString();
        ingredients = in.createStringArray();
        recipe_id = in.readString();
        image_url = in.readString();
        social_rank = in.readFloat();
    }

    public static final Creator<Recipes> CREATOR = new Creator<Recipes>() {
        @Override
        public Recipes createFromParcel(Parcel in) {
            return new Recipes(in);
        }

        @Override
        public Recipes[] newArray(int size) {
            return new Recipes[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public float getSocial_rank() {
        return social_rank;
    }

    public void setSocial_rank(float social_rank) {
        this.social_rank = social_rank;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(publisher);
        dest.writeStringArray(ingredients);
        dest.writeString(recipe_id);
        dest.writeString(image_url);
        dest.writeFloat(social_rank);
    }

    @BindingAdapter({"loadImage"})
    public static void imageUrl(ImageView view, String url) {
        Picasso.get().load(url).placeholder(R.drawable.recipe_place_holder).into(view);
    }

    @BindingAdapter({"loadCategoryImage"})
    public static void categoryImageUrl(ImageView view, String url) {
        Uri path = Uri.parse("android.resource://com.codingwithmitch.foodrecipes/drawable/");
        Picasso.get().load(path + url).placeholder(R.drawable.recipe_place_holder).into(view);
    }
}
